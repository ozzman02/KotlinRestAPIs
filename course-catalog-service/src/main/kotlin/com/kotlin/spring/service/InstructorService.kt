package com.kotlin.spring.service

import com.kotlin.spring.dto.InstructorDTO
import com.kotlin.spring.entity.Instructor
import com.kotlin.spring.repository.InstructorRepository
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class InstructorService(val instructorRepository: InstructorRepository) {

    companion object: KLogging()

    @Transactional
    fun createInstructor(instructorDTO: InstructorDTO): InstructorDTO {
        val instructorEntity = instructorDTO.let { Instructor(it.id, it.name) }
        instructorRepository.save(instructorEntity)
        logger.info { "Saved instructor is: $instructorEntity" }
        return instructorEntity.let { InstructorDTO(it.id, it.name) }
    }

}