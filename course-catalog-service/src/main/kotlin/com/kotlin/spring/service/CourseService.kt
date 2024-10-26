package com.kotlin.spring.service

import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.entity.Course
import com.kotlin.spring.exception.CourseNotFoundException
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

    @Transactional
    fun updateCourse(courseId: Int, courseDTO: CourseDTO): CourseDTO {
        val existingCourse = courseRepository.findById(courseId)
        return if (existingCourse.isPresent) {
            existingCourse.get().let {
                it.name = courseDTO.name
                it.category = courseDTO.category
                courseRepository.save(it)
                CourseDTO(it.id, it.name, it.category)
            }
        } else {
            throw CourseNotFoundException("Course with id $courseId not found")
        }
    }

    @Transactional
    fun deleteCourse(courseId: Int) {
        val existingCourse = courseRepository.findById(courseId)
        return if (existingCourse.isPresent) {
            existingCourse.get().let {
                courseRepository.deleteById(courseId)
            }
        } else {
            throw CourseNotFoundException("Course with id $courseId not found")
        }
    }

}