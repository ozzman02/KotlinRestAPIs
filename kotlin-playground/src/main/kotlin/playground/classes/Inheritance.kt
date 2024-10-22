package playground.classes

open class User(val name: String) {

    open var isLoggedIn: Boolean = false

    open fun login() {
        println("Inside User Login")
    }

}

class Student(name: String): User(name) {

    override var isLoggedIn: Boolean = false

    companion object {
        const val noOfEnrolledCourses = 10
        fun country() = "USA"
    }

    override fun login() {
        println("Inside Student Login")
        super.login()
    }
}

class Instructor(name: String): User(name) {

    override var isLoggedIn: Boolean = false

    override fun login() {
        println("Inside Instructor Login")
    }
}

fun main() {
    val student = Student("Alex")
    println("Name is: ${student.name}")
    student.login()
    student.isLoggedIn = true
    println("Logged in value is: ${student.isLoggedIn}")
    println("Country is: ${Student.country()}")
    println("NoOfEnrolledCourses is: ${Student.noOfEnrolledCourses}")

    println()

    val instructor = Instructor("Dilip")
    println("Name is: ${instructor.name}")
    instructor.login()
    instructor.isLoggedIn = true
    println("Logged in value is: ${instructor.isLoggedIn}")
}