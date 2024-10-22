package playground.classes

class Person(val name: String = "", val age: Int = 0) {

    var email: String = ""

    var nameLength: Int = 0

    init {
        println("Inside Init Block")
        nameLength = name.length
    }

    constructor(
        _email: String,
        _name: String = "",
        _age: Int = 0): this(_name, _age) {
            email = _email

    }

    fun action() {
        println("Person Walks")
    }
}

fun main() {
    val person = Person("Oscar", 42)
    person.action()
    println("Name: ${person.name} and the age is ${person.age}")

    val person1 = Person()
    person1.action()
    println("Name: ${person1.name} and the age is ${person1.age}")

    val person2 = Person(_email = "osantamaria@gmail.com", _name = "Carlos", _age = 10)
    person2.action()
    println("Name: ${person2.name} and the age is ${person2.age} and email is ${person2.email}. Name length: ${person2.nameLength}")
}