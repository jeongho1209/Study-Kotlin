package com.kotlin.good.domain.student.service

import com.kotlin.good.domain.student.domain.Student
import com.kotlin.good.domain.student.domain.repository.StudentRepository
import com.kotlin.good.domain.student.presentation.dto.request.StudentSignUpRequest
import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.global.enum.Authority
import com.kotlin.good.global.enum.Major
import com.kotlin.good.global.enum.Sex
import com.kotlin.good.global.security.jwt.JwtTokenProvider
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
class StudentSignUpServiceTest {

    private val studentRepository: StudentRepository = mockk()
    private val userRepository: UserRepository = mockk()
    private val passwordEncoder: PasswordEncoder = mockk()
    private val jwtTokenProvider: JwtTokenProvider = mockk()

    private val studentSignUpService = StudentSignUpService(
        studentRepository = studentRepository,
        userRepository = userRepository,
        passwordEncoder = passwordEncoder,
        jwtTokenProvider = jwtTokenProvider,
    )

    private val userId = UUID.randomUUID()

    private val userStub by lazy {
        User(
            id = userId,
            email = "email",
            password = "password",
            name = "name",
            address = "address",
            authority = Authority.STUDENT,
            sex = Sex.MALE,
            introduce = null,
        )
    }

    private val studentStub by lazy {
        Student(
            userId = userId,
            gcn = "0000",
            major = Major.BACKEND,
            user = userStub,
        )
    }

    private val requestStub by lazy {
        StudentSignUpRequest(
            gcn = "0000",
            major = Major.BACKEND,
            email = "email",
            password = "password",
            name = "name",
            address = "address",
            sex = Sex.MALE,
        )
    }

    @Test
    fun `학생 회원가입 성공`() {
        every { userRepository.existsByEmail(userStub.email) } returns false

        assertDoesNotThrow {
            studentSignUpService.execute(requestStub)
        }
    }
}