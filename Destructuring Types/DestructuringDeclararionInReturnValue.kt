/** Destructuring declaration in return values of function */


fun emailDetails(email :String): List<String> = email.split("@")

fun main() {

    // here emailDetails returns list and then destructuring declaration is working on the list (means list can be used in destructuring declarations.
    val (login, domain) = emailDetails("kotlin@kotlin.com")
    println("""
        Login: $login
        Domain: $domain
    """.trimIndent())

    // we can also use destructuring declaration in lambda functions
    val liquids: List<Liquid> = listOf(Liquid(Color.GREEN, 10), Liquid(Color.RED, 20), Liquid(Color.BLUE, 10))

    // without destructuring declaration
    val redLiquids = liquids.filter{
        // we can access liquid instance here by it or specifying a name
        it.mColor == Color.RED
    }

    // with destructuring declaration
    val blueLiquids = liquids.filter { (color, _) -> // here de structuring the instance of liquid (it) that is passed to the lambda )
        color == Color.RED

    }

    println(redLiquids.toString())
    println(blueLiquids.toString())

    // destructuring declaration in iteration
    destructuringDeclarationInIteration()

}

// using destructuring declaration in iteration
fun destructuringDeclarationInIteration() {
    val someLanguagesList: List<String> = listOf("Kotlin", "java", "python")
    // i have done this many times
     for ( (index , element) in someLanguagesList.withIndex()) {// with index is returning a data class called IndexValue with two properties (index and value )
                                                                    // then destructuring declaration is working and assigning the properties to the variables in order
         println("$element at $index")
     }

    // same example above by using maps
    val languageUses: Map<String, String> = mapOf("Kotlin" to "Android", "python" to "Machine learning", "jave" to "Software Development")
    for ((language, use) in languageUses ) println("$language is used in $use")



}
