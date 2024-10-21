package playground.basics

fun main() {

    val range = 1..10
    for (i in range) {
        println("i: $i")
    }

    println()

    val reversedRange = 10 downTo 1
    for (i in reversedRange) {
        println("i: $i")
    }

    println()

    for (i in reversedRange step 2) {
        println("i: $i")
    }

    println()

    exploreWhile()

    println()

    exploreDoWhile()

}

fun exploreDoWhile() {
    var i = 0
    do {
        println("Value of i is: $i")
        i++
    } while (i < 5)
}

fun exploreWhile() {
    var x = 1
    while (x < 5) {
        println("Value of x is: $x")
        x++
    }
}