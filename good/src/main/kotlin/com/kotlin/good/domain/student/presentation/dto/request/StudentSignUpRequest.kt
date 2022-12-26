package com.kotlin.good.domain.student.presentation.dto.request

import com.kotlin.good.global.enum.Major
import com.kotlin.good.global.enum.Sex
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class StudentSignUpRequest(

    @field:NotBlank
    val gcn: String,

    @field:NotNull
    val major: Major,

    @field:NotBlank
    val email: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val address: String,

    @field:NotNull
    val sex: Sex

)
