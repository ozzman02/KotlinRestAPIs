package com.kotlin.spring.repository

import com.kotlin.spring.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> {
}