/**
 * Destructuring declaration for custom types or classes
 */

// Destructuring Declaration in kotlin are position based
// which means kotlin compiler decides which class property is linked to which variable based on the order of the properties
fun examplePositionBased() {
    data class Person(val name: String, val age: Int)
    val (name, age) = Person("kotlin", 4)
}

// In order to get destructuring declaration mechanism in custom class or external library
// we need to implement componentN Functions
// where N refers to the component number with the "operator" keyword in order to allow using them in destructuring declaration

// lets create custom class
class SongPlayer(name: String, playing: Boolean = false ){ // can use proper Song type
    var trackName: String = name
    var isPlaying: Boolean = playing

    // ComponentN Function
    operator fun component1(): String  = trackName
    operator fun component2(): Boolean = isPlaying

}

// for classed for which we don't have access to modify it
// we can use extension function to implement componentFunction function
enum class Color(hex: Int){ RED(0XFF0000), GREEN(0X32FA67), YELLOW(0XFFDA1A), BLUE(0X1AACFF)}
class Liquid(color: Color, quantity: Int) {
    val mColor: Color = color
    val mQuantity: Int = quantity
}

// lets say we access to modify this Liquid class and we want componentN functions implemented then we are going to use extension function.
operator fun Liquid.component1(): Color = mColor
operator fun Liquid.component2(): Int = mQuantity

fun main() {
    // now that we have implemented componentN functions to the above classes lets use destructuring declaration

    val player: SongPlayer = SongPlayer("Demons by  Imagine and Dragons", playing = true )
    val (songName, playing) = player
    println("$songName is currently ${if (!playing) "not playing !" else "playing !"}")

    // if we don't want a particular value we can avoid it by using '_'
    val (_, isPlaying) = player
    println("Song is ${if(!isPlaying) "not playing !" else "playing !"}")


    // same goes for the other class that we have considered as external library or the class which we can't modify
    val (liquidColor, quantity) = Liquid(Color.BLUE, 10)
    println("Liquid color: $liquidColor\nQuantity: $quantity Liters")

}



