package playground.nulls

/*
    - Use the safe call operator (?) to invoke functions safely on it

        val length = nameNullable?.length

    - Use elvis operator (?:) when returning a default value if null

        val length = nameNullable?.length ?: 0

    - Not null assertions (!!). Making sure the value is not null after some updates

        val movie = saveMovie(Movie(null, "Avengers"))
        println(movie.id!!)
*/



data class Movie(val id: Int?, val name: String) {}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(id = 1)
}

fun printName(name: String) {
    println("Name is: $name")
}

fun printName1(name: String?) {
    println("Name is: $name")
}

fun main() {
    var nameNullable: String? = null
    println("Value is ${nameNullable?.length}") // safe operator is ?

    //nameNullable = "Dilip"
    println("Value is $nameNullable")
    println("Length is ${nameNullable?.length?.toLong() ?: 0}") // elvis operator is ?:

    val movie = Movie(null, "Avengers")
    val savedMovie = saveMovie(movie)

    println(savedMovie.id!!) // non null assertions
    println("Saved Movie: $savedMovie")

    // scope function run
    nameNullable?.run { printName(this) }

    printName1(nameNullable)


}