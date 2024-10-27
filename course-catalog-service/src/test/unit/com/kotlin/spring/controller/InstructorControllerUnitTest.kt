package com.kotlin.spring.controller

import com.kotlin.spring.dto.CourseDTO
import com.kotlin.spring.dto.InstructorDTO
import com.kotlin.spring.service.InstructorService
import com.kotlin.spring.util.courseDTO
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@WebMvcTest(controllers = [InstructorController::class])
@AutoConfigureWebTestClient
class InstructorControllerUnitTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var instructorServiceMockk: InstructorService

    @Test
    fun createCourseTest() {
        val instructorDTO = InstructorDTO(null, "Dilip Sundarraj")
        every { instructorServiceMockk.createInstructor(any()) } returns InstructorDTO(id = 1, name = "Dilip Sundarraj")
        val savedInstructorDTO = webTestClient
            .post()
            .uri("/v1/instructors")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(InstructorDTO::class.java)
            .returnResult()
            .responseBody
        assertTrue { savedInstructorDTO!!.id != null }
    }

    @Test
    fun addInstructorValidationTest() {
        val instructorDTO = InstructorDTO(null, "")
        every { instructorServiceMockk.createInstructor(any()) } returns InstructorDTO(id = 1, name = "Dilip Sundarraj")
        val response = webTestClient
            .post()
            .uri("/v1/instructors")
            .bodyValue(instructorDTO)
            .exchange()
            .expectStatus().isBadRequest
            .expectBody(String::class.java)
            .returnResult()
            .responseBody
        assertEquals("instructorDTO.name must not be blank", response)
    }
}