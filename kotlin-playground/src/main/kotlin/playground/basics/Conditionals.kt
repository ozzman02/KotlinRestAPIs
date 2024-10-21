package playground.basics

fun main() {

    var name = "Alex"
    name = "Marcela"

    // If, else block is an expression

    val result = if (name.length == 4) {
        println("Name has 4 characters")
        name // return type of the if block
    } else {
        println("Name does not have 4 characters")
        name // return type of the else block
    }
    println("result: $result") // kotlin.Unit

    // 1 -> GOLD, 2 -> SILVER, 3 -> BRONZE
    var position = 1
    var medal = if (position == 1) {
        "GOLD"
    } else if (position == 2) {
        "SILVER"
    } else if (position == 3) {
        "BRONZE"
    } else {
        "NO MEDAL"
    }
    println(medal)

    position = 3

    medal = when (position) {
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> "BRONZE"
        else -> "NO MEDAL"
    }
    println(medal)


}