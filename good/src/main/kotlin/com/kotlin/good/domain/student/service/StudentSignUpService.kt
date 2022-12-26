package com.kotlin.good.domain.student.service

import com.kotlin.good.domain.student.domain.Student
import com.kotlin.good.domain.student.domain.repository.StudentRepository
import com.kotlin.good.domain.student.presentation.dto.request.StudentSignUpRequest
import com.kotlin.good.domain.user.domain.User
import com.kotlin.good.domain.user.domain.repository.UserRepository
import com.kotlin.good.domain.user.error.exception.UserExist
import com.kotlin.good.domain.user.presentation.dto.response.TokenResponse
import com.kotlin.good.global.enum.Authority
import com.kotlin.good.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentSignUpService(
    private val studentRepository: StudentRepository,
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider
) {

    fun execute(request: StudentSignUpRequest): TokenResponse {
        if (userRepository.existsByEmail(request.email)) {
            throw UserExist.EXCEPTION
        }

        val user = userRepository.save(
            User(
                id = UUID.randomUUID(),
                email = request.email,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                address = request.address,
                authority = Authority.STUDENT,
                sex = request.sex,
                introduce = null
            )
        )

        val userId = user.id

        studentRepository.save(
            Student(
                userId = userId,
                gcn = request.gcn,
                major = request.major,
                user = user
            )
        )

        return jwtTokenProvider.getToken(request.email)
    }

}