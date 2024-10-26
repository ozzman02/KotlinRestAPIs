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

    @PutMapping("/{courseId}")
    fun updateCourse(@RequestBody courseDTO: CourseDTO, @PathVariable("courseId") courseId: Int): CourseDTO {
        return courseService.updateCourse(courseId, courseDTO)
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable("courseId") courseId: Int) = courseService.deleteCourse(courseId)

}