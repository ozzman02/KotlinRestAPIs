package playground.classes

object Authenticate {

    @JvmStatic
    fun authenticate(userName: String, password: String) {
        println("User authenticated for username: $userName")
    }
}

fun main() {
    Authenticate.authenticate("dilip", "password")
}
