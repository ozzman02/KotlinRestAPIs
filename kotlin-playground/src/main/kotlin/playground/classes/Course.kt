@file:JvmName("CourseUtils")
package playground.classes

import com.kotlin.playground.CourseJava

data class Course
    @JvmOverloads constructor(
        val id: Int,
        val name: String,
        val author: String,
        var courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
    ) {

    @JvmField var noOfCourses = 10

    companion object {
        @JvmStatic fun printName2(name: String = "default") = println("Name: $name")
    }
}

enum class CourseCategory {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

@JvmOverloads
@JvmName(name = "printName1")
fun printName(name: String = "default") = println("Name: $name")

fun main() {
    val course = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    println(course)

    val course1 = Course(2, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    println(course1)

    println("Checking Object Equality: ${course == course1}")

    val course3 = course1.copy(id = 3, author = "Dilip1")
    println(course3)

    val marketingCourse = Course(4, "Facebook Marketing", "Dilip", CourseCategory.MARKETING)
    println(marketingCourse)

    println()

    val courseJava = CourseJava(2, "Facebook Marketing", "Dilip")
    println("CourseJava: $courseJava")
    courseJava.id = 3
    courseJava.name = "Test"
    println("CourseJava: $courseJava")

}