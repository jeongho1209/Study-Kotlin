package com.kotlin.good.domain.student.presentation

import com.kotlin.good.domain.student.presentation.dto.request.StudentSignUpRequest
import com.kotlin.good.domain.student.service.StudentSignUpService
import com.kotlin.good.domain.user.presentation.dto.response.TokenResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/student")
@RestController
class StudentController(
    private val studentSignUpService: StudentSignUpService
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun signUp(@RequestBody @Valid request: StudentSignUpRequest) : TokenResponse {
        return studentSignUpService.execute(request)
    }

}