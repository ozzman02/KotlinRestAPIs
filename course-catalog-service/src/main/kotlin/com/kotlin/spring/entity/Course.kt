package com.kotlin.spring.entity

import jakarta.persistence.*

@Entity
@Table(name = "Courses")
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,

    var name: String,

    var category: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id", nullable = false)
    var instructor: Instructor? = null

) {
    override fun toString(): String {
        return "Course(id=$id, name=$name, category=$category, instructor=${instructor!!.id})"
    }
}