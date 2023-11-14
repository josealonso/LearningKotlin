// Visibility/Task1.kt
package constrainingVisibilityExercise1

class Alien(val name: String, val species: String, var planet: String) {
    fun movePlanet(destPlanet: String): Unit {
        this.planet = destPlanet    // Correct!!
//        this.planet = destPlanet
    }

    override fun toString(): String {
        return "Alien $name, $species: $planet"
    }
}

fun main() {
    val alien1 = Alien("Arthricia", "Cat Person", "PurgePlanet")
    println(alien1)
    alien1.movePlanet("Earth C-137")
    println(alien1)

    val alien2 = Alien("Dale", "Giant", "Gearworld")
    println(alien2)
    alien2.movePlanet("Parblesnops")
    println(alien2)
}
/* Expected output:
Alien Arthricia, Cat Person: PurgePlanet
Alien Arthricia, Cat Person: Earth C-137
Alien Dale, Giant: Gearworld
Alien Dale, Giant: Parblesnops
*/