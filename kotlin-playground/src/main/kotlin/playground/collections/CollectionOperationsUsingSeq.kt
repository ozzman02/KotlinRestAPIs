package playground.collections

import playground.dataset.Course
import playground.dataset.CourseCategory
import playground.dataset.courseList

fun main() {

    val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPMENT }

    val nameListUsingSequence = listOf("alex", "ben", "chloe")
        .asSequence()
        .filter { it.length >= 4 }
        .map { it.uppercase() }
        .toList()

    println("nameListUsingSequence: $nameListUsingSequence")

    exploreFilterUsingSequence(courseList(), devPredicate)

    val range = 1..1000_000_000

    range
        .asSequence()
        .map { it.toDouble() }
        .take(40)
        .forEach { println("Value is: $it") }

    println()

    collectionNullability()


}

fun exploreFilterUsingSequence(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    courseList
        .asSequence()
        .filter { predicate.invoke(it) }
        .forEach { println("Courses: $it") }
}

fun collectionNullability() {
    var list: MutableList<String>? = null
    list = mutableListOf()
    list.add("Dilip")
    list.forEach { println("Value is $it") }

    println()

    val list1: List<String?> = listOf("Adam", null, "Alexis")
    list1.forEach { println("Value length is: ${it?.length}") }

}