package playground.classes

class Item() {

    var name: String = ""

    var price: Double = 0.0

        get() {
            println("Inside Getter")
            return field
        }

        set(value) {
            println("Inside Setter")
            if (value > 0.0) {
                field = value
            } else {
                throw IllegalArgumentException("Negative price not allowed!")
            }
        }



    constructor(_name: String): this() {
        name = _name
    }
}

fun main() {
    val item = Item(_name = "Iphone")
    println("Item name is ${item.name}")
    item.name = "IPhone13"
    println("Item name is ${item.name}")

    item.price = -10.0
    println(item.price)
}