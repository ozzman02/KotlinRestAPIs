package playground.collections

/* Higher Order Function */
fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

fun main() {
    val addLambda = { x: Int -> x + x }
    val result = addLambda(3)
    println("Result is $result")

    val multiplyLambda = { x: Int, y: Int ->
        println("x is $x and y is $y")
        x * y }
    val result2 = multiplyLambda(2, 3)
    println("Result is $result2")

    val result3 = calculate(2, 3) { a, b -> a * b }
    println("Result is $result3")

    val result4 = calculate(2, 3) { a, b -> a + b }
    println("Result is $result4")
}