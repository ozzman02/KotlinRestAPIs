package playground.scopefunctions

import playground.classes.Course
import playground.classes.CourseCategory

fun main() {

    exploreApply()
    exploreAlso()
    exploreLet()
    exploreWith()
    exploreRun()

}

fun exploreApply() {

    val course = Course(1, "Design Thinking in Kotlin", "Dilip")
        .apply { courseCategory = CourseCategory.DESIGN }

    println("Course: $course")
}

fun exploreAlso() {

    Course(1, "Design Thinking in Kotlin", "Dilip")
        .apply { courseCategory = CourseCategory.DESIGN }
        .also { println("Course: $it") }

}

fun exploreLet() {

    val numbers = mutableListOf(1, 2, 3, 4, 5)

    val result = numbers
        .map { it * 2 }
        .filter { it > 5 }
        .let {
            println(it) // filtered list
            it.sum() // sum will be assigned to result
        }

    println(result)

    var name: String? = null

    name = "dilip"

    val result1 = name?.let {
        println(it)
        it.uppercase()
    }

    println(result1)
}

fun exploreWith() {

    val numbers = mutableListOf(1, 2, 3, 4, 5)

    val result = with(numbers) {
        println("Size is $size")  // println("Size is ${numbers.size}")
        val list = numbers.plus(6) // plus(6)
        list.sum() // sum()
    }

    println("With result is $result")
}

fun exploreRun() {

    var numbers: MutableList<Int>? = null

    val result = numbers.run {
        numbers = mutableListOf(1, 2, 3)
        numbers?.sum()
    }

    println("Run result is $result")

    val length = run {
        val name = "Dilip"
        println(name)
        name.length
    }

    println("Run length is $length")

}