package playground.interfaces

import playground.classes.Course

interface Repository {

    fun getAll(): Any

}

interface CourseRepository {

    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("Course: $course")
        return course.id
    }

}

class SqlCourseRepository: CourseRepository, Repository {
    override fun getById(id: Int): Course {
        return Course(id, "Reactive Programming in Modern Java using Project Reactor", "Dilip")

    }

    override fun getAll(): Any {
        return 1
    }
}

class NoSqlCourseRepository: CourseRepository {

    override fun getById(id: Int): Course {
        return Course(id, "MongoDB Fundamentals", "Dilip")
    }

    override fun save(course: Course): Int {
        println("NoSQL Course: $course")
        return course.id
    }

}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    println("Course is $course")
    val courseId = sqlCourseRepository.save(course)
    println("Course id is $courseId")

    println()

    val noSqlCourseRepository = NoSqlCourseRepository()
    val noSqlCourse = noSqlCourseRepository.getById(2)
    println("Course is $noSqlCourse")
    val noSqlCourseId = noSqlCourseRepository.save(noSqlCourse)
    println("Course id is $noSqlCourseId")
}