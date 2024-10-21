package playground.basics

fun main() {

    for(i in 1..5) {
        println("i in $i")
        if (i == 3) break
    }

    println()

    label()

    println()

    for(i in 1..5) {
        println("i in return $i")
        if (i == 3) return // returns from the main function
    }

    println()
    println("End of the program!")
}

fun label() {
    loop@ for(i in 1..5) {
        println("i in label $i")
        // if (i == 3) break@loop
        innerLoop@ for (j in 1..5) {
            println("j in label $j")
            // if (j == 2) break@innerLoop
            if (j == 2) continue@loop
        }
    }
}