package playground.classes

data class Employee(val id: Int, val name: String) {
}

fun main() {
    val employee = Employee(1, "Juan Caballero")
    println(employee)

    val employee2 = Employee(2, "Eduardo Caballero")
    println(employee2)

    println("Checking equality: ${employee == employee2}")

    val employee3 = employee.copy(id = 3, name = "Janette Jackson")
    println(employee3)
}