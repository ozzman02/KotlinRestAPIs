package playground.classes

class Item() {
    var name: String = ""
    constructor(_name: String): this() {
        name = _name
    }
}

fun main() {
    val item = Item(_name = "Iphone")
    println("Item name is ${item.name}")
    item.name = "IPhone13"
    println("Item name is ${item.name}")
}