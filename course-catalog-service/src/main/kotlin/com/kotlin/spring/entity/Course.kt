package com.kotlin.spring.entity

import jakarta.persistence.*

@Entity
@Table(name = "Courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    var name: String,
    var category: String
)