package playground.interfaces

import playground.classes.Course

interface Repository {

    fun getAll(): Any

}

interface CourseRepository {

    val isCoursePersisted: Boolean

    fun getById(id: Int): Course

    fun save(course: Course): Int {
        println("Course: $course")
        return course.id
    }

}

class SqlCourseRepository: CourseRepository, Repository {

    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
        return Course(id, "Reactive Programming in Modern Java using Project Reactor", "Dilip")

    }

    override fun getAll(): Any {
        return 1
    }

    override fun save(course: Course): Int {
        isCoursePersisted = true
        return super.save(course)
    }
}

class NoSqlCourseRepository: CourseRepository {

    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
        return Course(id, "MongoDB Fundamentals", "Dilip")
    }

    override fun save(course: Course): Int {
        println("NoSQL Course: $course")
        return course.id
    }

}

interface A {
    fun doSomething() {
        println("doSomething in A")
    }
}

interface B {
    fun doSomething() {
        println("doSomething in B")
    }
}

// Resolving conflicting calls
class AB: A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("doSomething in AB")
    }
}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    val course = sqlCourseRepository.getById(1)
    println("Course is $course")
    val courseId = sqlCourseRepository.save(course)
    println("Course persisted value is ${sqlCourseRepository.isCoursePersisted}")
    println("Course id is $courseId")

    println()

    val noSqlCourseRepository = NoSqlCourseRepository()
    val noSqlCourse = noSqlCourseRepository.getById(2)
    println("Course is $noSqlCourse")
    val noSqlCourseId = noSqlCourseRepository.save(noSqlCourse)
    println("Course id is $noSqlCourseId")

    println()

    val ab = AB()
    ab.doSomething()
}