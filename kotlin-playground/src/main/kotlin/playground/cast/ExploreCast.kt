package playground.cast

import playground.classes.Course

fun main() {
    val course = Course(1, "Reactive Programming in Modern Java using Project Reactor", "Dilip")
    println(course)
    checkType(course)
    checkType("DILIP")
    castNumber(1.0)
    //castNumber(1)

    val number = 1
    val doubleNumber = number.toDouble()
    println("Doble number is $doubleNumber")
}

fun checkType(type: Any) {
    when (type) {
        is Course -> println(type)
        is String -> println(type.lowercase())
    }
}

fun castNumber(any: Any) {
    when (any) {
        any as Double -> println("Value is double")
    }
}