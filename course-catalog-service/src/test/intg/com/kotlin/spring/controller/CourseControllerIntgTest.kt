package com.kotlin.spring.controller

import com.kotlin.spring.db.PostgreSQLContainerInitializer
import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.entity.Course
import com.kotlin.spring.repository.CourseRepository
import com.kotlin.spring.repository.InstructorRepository
import com.kotlin.spring.util.courseEntityList
import com.kotlin.spring.util.instructorEntity
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.util.UriComponentsBuilder
import kotlin.test.assertEquals
import kotlin.test.assertTrue


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class CourseControllerIntgTest: PostgreSQLContainerInitializer() {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @Autowired
    lateinit var instructorRepository: InstructorRepository


    @BeforeEach
    fun setUp() {
        courseRepository.deleteAll()
        instructorRepository.deleteAll()
        courseRepository.saveAll(courseEntityList(instructorRepository.save(instructorEntity())))
    }

    @Test
    fun addCourseTest() {
        val courseDTO = CourseDTO(null, "Build Restful APIs using SpringBoot and Kotlin", "Development", 1)
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
    fun retrieveAllCoursesByNameTest() {
        val uri = UriComponentsBuilder.fromUriString("/v1/courses")
            .queryParam("courseName", "SpringBoot")
            .toUriString()

        val courseDTOList = webTestClient
            .get()
            .uri(uri)
            .exchange()
            .expectStatus().isOk
            .expectBodyList(CourseDTO::class.java)
            .returnResult()
            .responseBody
        assertEquals(2, courseDTOList!!.size)
    }

    @Test
    fun updateCourseTest() {
        val instructor = instructorRepository.findAll().first()
        val course = Course(null,"Build RestFul APis using SpringBoot and Kotlin", "Development", instructor)
        courseRepository.save(course)
        val courseDTOToUpdate = CourseDTO(null,"Build RestFul APis using SpringBoot and Kotlin1", "Development", course.instructor!!.id)
        val updatedCourseDTO = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", course.id)
            .bodyValue(courseDTOToUpdate)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java)
            .returnResult()
            .responseBody
        assertEquals("Build RestFul APis using SpringBoot and Kotlin1", updatedCourseDTO!!.name)
    }

    @Test
    fun deleteCourseTest() {
        val course = Course(null,"Build RestFul APis using SpringBoot and Kotlin", "Development", instructorRepository.findAll().first())
        courseRepository.save(course)
        webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", course.id)
            .exchange()
            .expectStatus().isNoContent
    }

}