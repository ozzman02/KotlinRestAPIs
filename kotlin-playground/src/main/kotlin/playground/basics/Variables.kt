package playground.basics

import playground.toplevel.courseName
import playground.toplevel.topLevelFunction

fun main() {
    val name: String = "Oscar"
    println(name)

    var age: Int = 41
    age = 42
    println(age)

    val salary = 42000L
    println(salary)

    val course = "Kotlin Spring"
    println("course: $course and the course length is ${course.length}")

    val multiline = "ABC \n DEF"
    println(multiline)

    val multiline1 = """
        ABC
        DEF
    """.trimIndent()
    println(multiline1)

    println(topLevelFunction())
    println("Course name is $courseName")
}