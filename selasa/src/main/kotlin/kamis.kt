abstract class Location(val name: String)
class City (name: String): Location(name)

fun main() {
    val Location = Location("Batam") //error
    val city = City("Batam")
}