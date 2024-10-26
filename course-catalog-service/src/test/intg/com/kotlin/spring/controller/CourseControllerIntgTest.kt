package com.kotlin.spring.controller

import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.entity.Course
import com.kotlin.spring.repository.CourseRepository
import com.kotlin.spring.util.courseEntityList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIntgTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setUp() {
        courseRepository.deleteAll()
        courseRepository.saveAll(courseEntityList())

    }

    @Test
    fun addCourseTest() {
        val courseDTO = CourseDTO(null, "Build Restful APIs using SpringBoot and Kotlin", "Dilip Sundarraj")
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
    fun retrieveAllCoursesTest() {
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
        val course = Course(null,"Build RestFul APis using SpringBoot and Kotlin", "Development")
        courseRepository.save(course)
        val courseToUpdate = Course(null,"Build RestFul APis using SpringBoot and Kotlin1", "Development")
        val updatedCourseDTO = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", course.id)
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
        val course = Course(null,"Build RestFul APis using SpringBoot and Kotlin", "Development")
        courseRepository.save(course)
        webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", course.id)
            .exchange()
            .expectStatus().isNoContent
    }

}