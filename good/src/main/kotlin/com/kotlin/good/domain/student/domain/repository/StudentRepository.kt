package com.kotlin.good.domain.student.domain.repository

import com.kotlin.good.domain.student.domain.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository : CrudRepository<Student, UUID> {
}