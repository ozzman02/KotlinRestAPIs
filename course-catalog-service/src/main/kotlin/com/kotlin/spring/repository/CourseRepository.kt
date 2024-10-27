package com.kotlin.spring.repository

import com.kotlin.spring.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> {

    fun findByNameContaining(courseName: String): List<Course>

    @Query(value = "SELECT * FROM courses WHERE name LIKE %?1%", nativeQuery = true)
    fun findCoursesByName(courseName: String): List<Course>

}