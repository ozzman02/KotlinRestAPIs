package playground.functions

import java.time.LocalDate

fun main() {
    printName("Oscar")
    printNameV2("Humberto")
    println("Result is ${addition(1, 2)}")
    println("Result is ${additionV2(3, 5)}")
    printPersonDetails("Oscar", "osantamaria@gmail.com", LocalDate.of(1982, 7, 10))
    printPersonDetails("Eduardo")
    printPersonDetails(dob = LocalDate.of(1982, 1, 3), email = "csanta@gmail.com", name = "Carlos")
}

fun printName(name: String): Unit {
    println("Name is $name")
}

fun printNameV2(name: String) = println("Name is $name")


fun addition(param1: Int, param2: Int): Int {
    return param1 + param2
}

fun additionV2(param1: Int, param2: Int) = param1 + param2

fun printPersonDetails(name: String, email: String = "", dob: LocalDate = LocalDate.now()) {
    println("Name is $name and the email is $email and dob is $dob")
}