package com.kotlin.good.domain.user.service

import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.domain.user.error.exception.UserNotFound
import com.kotlin.good.domain.user.presentation.dto.request.UserSignInRequest
import com.kotlin.good.domain.user.presentation.dto.response.TokenResponse
import com.kotlin.good.global.enum.Authority
import com.kotlin.good.global.enum.Sex
import com.kotlin.good.global.security.jwt.JwtTokenProvider
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.kotlin.given
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime
import java.util.UUID

@ExtendWith(SpringExtension::class)
class UserServiceTest {

    @MockBean
    private lateinit var userRepository: UserRepository

    @MockBean
    private lateinit var passwordEncoder: PasswordEncoder

    @MockBean
    private lateinit var jwtTokenProvider: JwtTokenProvider

    private lateinit var userService: UserService

    @BeforeEach
    fun setUp() {
        userService = UserService(
            userRepository = userRepository,
            passwordEncoder = passwordEncoder,
            jwtTokenProvider = jwtTokenProvider,
        )
    }

    private val userStub by lazy {
        User(
            id = UUID.randomUUID(),
            email = "test",
            password = "testpassword",
            name = "te",
            address = "address",
            authority = Authority.STUDENT,
            sex = Sex.MALE,
            introduce = null,
        )
    }

    private val requestStub by lazy {
        UserSignInRequest(
            email = "test1",
            password = "testpassword1"
        )
    }

    private val tokenStub by lazy {
        TokenResponse(
            accessToken = "access",
            refreshToken = "refresh",
            accessTokenExp = LocalDateTime.now().plusSeconds(10L)
        )
    }

    @Test
    fun `로그인 성공`() {
        val email = "test"
        given(userRepository.findByEmail(email))
            .willReturn(userStub)

        given(passwordEncoder.matches(requestStub.password, userStub.password))
            .willReturn(true)

        given(jwtTokenProvider.getToken(email))
            .willReturn(tokenStub)
    }

    @Test
    fun `유저를 찾지 못함`() {
        val email = "test1"
        given(userRepository.findByEmail(email))
            .willReturn(null)

        assertThrows<UserNotFound> {
            userService.execute(requestStub)
        }
    }
}
