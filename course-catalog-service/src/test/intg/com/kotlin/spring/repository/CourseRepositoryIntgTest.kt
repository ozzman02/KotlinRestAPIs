package com.kotlin.spring.repository

import com.kotlin.spring.util.courseEntityList
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.util.stream.Stream
import kotlin.test.assertEquals

@DataJpaTest
@ActiveProfiles("test")
class CourseRepositoryIntgTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    companion object {
        @JvmStatic
        fun courseAndSize(): Stream<Arguments> {
            return Stream.of(Arguments.arguments("SpringBoot", 2), Arguments.arguments("Wiremock", 1))
        }
    }

    @BeforeEach
    fun setUp() {
        courseRepository.deleteAll()
        courseRepository.saveAll(courseEntityList())
    }

    @Test
    fun findByNameContainingTest() {
        assertEquals(2, courseRepository.findByNameContaining("SpringBoot").size)
    }

    @Test
    fun findCoursesByNameTest() {
        assertEquals(2, courseRepository.findCoursesByName("SpringBoot").size)
    }

    @ParameterizedTest
    @MethodSource("courseAndSize")
    fun findCoursesByNameV2Test(name: String, expectedSize: Int) {
        assertEquals(expectedSize, courseRepository.findCoursesByName(name).size)
    }

}