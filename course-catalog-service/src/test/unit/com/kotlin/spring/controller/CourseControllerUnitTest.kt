package com.kotlin.spring.controller

import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.entity.Course
import com.kotlin.spring.service.CourseService
import com.kotlin.spring.util.courseDTO
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureWebTestClient
class CourseControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMockk: CourseService

    @Test
    fun addCourseTest() {
        val courseDTO = CourseDTO(null, "Build Restful APIs using SpringBoot and Kotlin", "Development", 1)
        every { courseServiceMockk.addCourse(any()) } returns courseDTO(id = 1)
        val savedCourseDTO = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody
        assertTrue { savedCourseDTO!!.id != null }
    }

    @Test
    fun addCourseValidationTest() {
        val courseDTO = CourseDTO(null, "", "", 1)
        every { courseServiceMockk.addCourse(any()) } returns courseDTO(id = 1)
        val response = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isBadRequest
            .expectBody(String::class.java)
            .returnResult()
            .responseBody
        assertEquals("courseDTO.category must not be blank, courseDTO.name must not be blank", response)
    }

    @Test
    fun addCourseRuntimeExceptionTest() {
        val courseDTO = CourseDTO(null, "Build Restful APIs using SpringBoot and Kotlin", "Development", 1)
        val errorMessage = "Unexpected Error Occurred"
        every { courseServiceMockk.addCourse(any()) } throws RuntimeException(errorMessage)
        val response = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().is5xxServerError
            .expectBody(String::class.java)
            .returnResult()
            .responseBody
        assertEquals(errorMessage, response)
    }

    @Test
    fun retrieveAllCoursesTest() {

        every { courseServiceMockk.retrieveAllCourses(any()) }
            .returnsMany(listOf(
                courseDTO(id = 1),
                courseDTO(id = 2, name = "Build Reactive Microservices using Spring WebFlux/SpringBoot"),
                courseDTO(id = 3, name = "Wiremock for Java Developers")
            ))

        val courseDTOList = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody
        assertEquals(3, courseDTOList!!.size)
    }

    @Test
    fun updateCourseTest() {
        every { courseServiceMockk.updateCourse(any(), any()) } returns
                courseDTO(id = 1, name = "Build RestFul APis using SpringBoot and Kotlin1")

        val courseToUpdate = CourseDTO(null,"Build RestFul APis using SpringBoot and Kotlin1", "Development", 1)

        val updatedCourseDTO = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", 1)
            .bodyValue(courseToUpdate)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody

        assertEquals("Build RestFul APis using SpringBoot and Kotlin1", updatedCourseDTO!!.name)
    }

    @Test
    fun deleteCourseTest() {
        every { courseServiceMockk.deleteCourse(any()) } just runs
        webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", 1)
            .exchange()
            .expectStatus().isNoContent
    }

}