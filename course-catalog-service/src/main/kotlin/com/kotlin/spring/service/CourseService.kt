package com.kotlin.spring.service

import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.entity.Course
import com.kotlin.spring.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object: KLogging()

    @Transactional
    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        val courseEntity = courseDTO.let { Course(null, it.name, it.category) }
        val savedCourse = courseRepository.save(courseEntity)
        logger.info { "Saved course is: $savedCourse" }
        return savedCourse.let { CourseDTO(it.id, it.name, it.category) }
    }

    @Transactional
    fun retrieveAllCourses(): List<CourseDTO> {
        return  courseRepository.findAll().map { CourseDTO(it.id, it.name, it.category) }
    }

}