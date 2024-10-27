package com.kotlin.spring.repository

import com.kotlin.spring.entity.Instructor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InstructorRepository: CrudRepository<Instructor, Int> {
}