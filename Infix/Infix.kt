/**
 * Infix notation for function.
 */

// To bring our code closer to the natural language
// kotlin provides the infix notation for functions

fun main() {
    val awesome = "i " concat "love " concat "kotlin."
    println(awesome)

    // or we can use Pair's to() function which is also marked as infix
    val pair: Pair<String, String> = "Fav Lang" to "Kotlin"

    // or we can use use it simplify Map data structure entries
    val map: Map<Int, String> = mapOf(1 to "Kotlin", 2 to "python", 3 to "java") // taking vararg of Pairs


    // so awesome infix ! :-)
}

// creating a infix notation extension function for String Type
// in order to enable notation for function
// we add infix keyword before the fun keyword
// Note Function must be a member of a class or extension function
// function must have single value parameter (should not have default value parameter or vararg parameter)

infix fun String.concat(string: String): String  = this + string

// that's it now we can use this function without brackets