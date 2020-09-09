import java.time.LocalDate

/** Destructuring declaration */

// destructuring declaration is available for data classes (kotlin standard library library provides this feature for many common types as well)
// basically the types which have componentN() function or method , we  can use destructuring declaration on them.
// we can define the destructuring mechanism manually fro the custom class or the classes that don't have this mechanism

data class User(val login: String, val email: String, val birth: LocalDate)

fun getUser() = User("kotlin", "kotlin@koltlin.com", LocalDate.of(2016,2,15))

fun destructuringDeclaration() {
    // this is called destructuring declaration
    val (name, mail, birthday) = getUser() // de structuring declaration works for only local variables.
    // no of variables must match number of data (variable or prop or component) inside the data class object
    // or
    val kotlin = User("Kotlin", "Kotlin@kotlin.com", LocalDate.of(2016,2,15))
    val (nameTwo, mailTwo, birthdayTwo) = kotlin

    println("$name was released on $birthday, Contact: $mail")
}
fun main() {

    destructuringDeclaration()

}