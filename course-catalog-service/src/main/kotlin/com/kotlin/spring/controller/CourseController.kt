package com.kotlin.spring.controller

import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/courses")
class CourseController(val courseService: CourseService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addCourse(@RequestBody courseDTO: CourseDTO): CourseDTO {
        return courseService.addCourse(courseDTO)
    }

    @GetMapping
    fun retrieveAllCourses(): List<CourseDTO> = courseService.retrieveAllCourses()

}