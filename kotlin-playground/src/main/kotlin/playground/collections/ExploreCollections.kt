package playground.collections

fun main() {
    val names = listOf("Alex", "Ben", "Chloe")
    println("Names are $names")

    val namesMutableList = mutableListOf("Alex", "Ben", "Chloe")
    namesMutableList.add("Adam")
    println("Names are $namesMutableList")

    val set = setOf("Alex", "Ben", "Chloe")
    println("Names in set are $set")

    val mutableSet = mutableSetOf("Alex", "Ben", "Chloe")
    mutableSet.add("Adam")
    println("Names in set are $mutableSet")

    val nameAgeMap = mapOf("Dilip" to 34, "Scooby" to 4)
    println("Map content $nameAgeMap")

    val mutableNameAgeMap = mutableMapOf("Dilip" to 34, "Scooby" to 4)
    //mutableNameAgeMap.put("Test", 56)
    mutableNameAgeMap["Test"] = 56
    println("Map content $mutableNameAgeMap")
}