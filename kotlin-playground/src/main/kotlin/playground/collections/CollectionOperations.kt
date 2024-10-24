package playground.collections

import playground.dataset.Course
import playground.dataset.CourseCategory
import playground.dataset.KAFKA
import playground.dataset.courseList

fun main() {

    val courseList = courseList()
    val devPredicate = { c: Course -> c.category == CourseCategory.DEVELOPMENT }
    val designPredicate = { c: Course -> c.category == CourseCategory.DESIGN }
    val list = listOf(listOf(1,2,3), listOf(4,5,6))

    val mapResult = list.map { outerList ->
        outerList.map {
            it.toDouble()
        }
    }

    val flatMapResult = list.flatMap { outerList ->
        outerList.map {
            it.toDouble()
        }
    }

    exploreFilter(courseList, devPredicate)
    println()
    exploreFilter(courseList, designPredicate)
    println()
    exploreMap(courseList, designPredicate)
    println()
    println("MapResult: $mapResult")
    println()
    println("FlatMapResult: $flatMapResult")
    println()
    val courses = exploreFlatMap(courseList, KAFKA)
    println("Courses: $courses")
    println()
    exploreHashMap()
}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val developmentCourses = courseList
        //.filter { it.category == CourseCategory.DEVELOPMENT }
        .filter { predicate.invoke(it) }
        .forEach { println("Courses: $it") }
}

fun exploreMap(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val courses = courseList
        .filter(predicate)
        .map { "${it.name} - ${it.category}" }
        .forEach { println(it) }

}

fun exploreFlatMap(courseList: MutableList<Course>, kafka: String): List<String> {
    val kafkaCourses = courseList.flatMap { course ->
        val courseName = course.name
        course.topicsCovered
            .filter { it == kafka }
            .map { courseName }
    }
    return kafkaCourses
}

fun exploreHashMap() {
    val nameAgeMutableMap = mutableMapOf("Dilip" to 33, "Scooby" to 5)
    nameAgeMutableMap.forEach { (k, v) ->  println("Key: $k - Value: $v") }

    val value = nameAgeMutableMap.getOrElse("Dilip1") {"abc"}
    println("Value is $value")
    println("Contains abc key: ${nameAgeMutableMap.containsKey("abc")}")

    val filterMap = nameAgeMutableMap
        .filterKeys { it.length > 5 }
        .map { it.key.uppercase() }
    println("FilterMap: $filterMap")

    val maxAge = nameAgeMutableMap.maxByOrNull { it.value }
    println("Max age is $maxAge")
}
