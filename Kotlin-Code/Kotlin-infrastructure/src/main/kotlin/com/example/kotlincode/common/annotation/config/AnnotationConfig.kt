package com.example.kotlincode.common.annotation.config

import com.example.kotlincode.common.annotation.ReadOnlyUseCase
import com.example.kotlincode.common.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
        basePackages = ["com.example.kotlincode"],
        includeFilters = [
            Filter(
                    type = FilterType.ANNOTATION,
                    classes = [
                        UseCase::class,
                        ReadOnlyUseCase::class,
                    ]
            )
        ]
)
class AnnotationConfig {
}