package playground.classes

open class User(val name: String) {

    fun login() {
        println("Inside User Login")
    }

}

class Student(name: String): User(name)

class Instructor(name: String): User(name)

fun main() {
    val student = Student("Alex")
    println("Name is: ${student.name}")
    student.login()

    val instructor = Instructor("Dilip")
    println("Name is: ${instructor.name}")
    instructor.login()
}