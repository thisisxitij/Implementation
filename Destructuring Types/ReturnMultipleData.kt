import java.security.DomainCombiner

// kotlin doest provides any feature to return multiple values
// but we can use data class or other data holding classes like pair and triple to return multiple data
// and on the receiving end by using Destructuring declaration we get that data into different variables

// lets start

// domain
const val DOMAIN: String = "@kotlin.com"

// list of registered users (map would be better in this case but its ok for illustration
val registeredUsersEmail: MutableList<String> = mutableListOf()
val registeredUsernameList: MutableList<String> = mutableListOf()

// data class to return in order to return multiple data
data class UserData(val username: String, val email: String)


fun main() {
    println("Please enter your name:  ")
    val input: String? = readLine()
    if (input != null) {
        val (username, email) = registerUser(input)
        println("Your Generated Data !")
        println("Your username: $username\nYour Email: $email")
    }


}


// function to return our data class
fun registerUser(name: String): UserData{
    println("Registering new user...")
    val newEmailAddress = emailGenerator(name) // getting a new email
    val newUsername = usernameGenerator(name)
    registeredUsersEmail.add(newEmailAddress)
    registeredUsernameList.add(newUsername)
    println("Registered !")
    // returning the newly generated username and email address
    return UserData(newUsername, newEmailAddress)
}

// or we can use available types that implements componentN functions to return multiple values
// that will eliminate the need of creating a data class in first place
fun registerUserTwo(name: String): Pair<String, String>{ // pair and triple is also a data class thus can be used in destructuring declaration
    println("Registering new user...")
    val newEmailAddress = emailGenerator(name) // getting a new email
    val newUsername = usernameGenerator(name)
    registeredUsersEmail.add(newEmailAddress)
    registeredUsernameList.add(newUsername)
    println("Registered !")
    // returning the newly generated username and email address
    return Pair(newUsername, newEmailAddress)
}

// generate new email
fun emailGenerator(name: String): String {
    var newEmailAddress: String = ""
    var emailAvailable: Boolean = false

    var number: Int = 1 // can use random number here
    while(!emailAvailable) {
        val newEmail = "$name$number" + DOMAIN
        if (newEmail !in registeredUsersEmail) {
            newEmailAddress = newEmail
            emailAvailable = true
        }
        number ++ // can use random number here
    }
    return newEmailAddress
}

// generate new username
fun usernameGenerator(name: String): String {
    var newUsername : String =  ""
    var usernameAvailable: Boolean = false

    var number = 1
    while(!usernameAvailable) {
        val username = "$name$number" // this can also be done using above declared variables (newUsername)
        if (username !in registeredUsernameList) {
            newUsername= username
            usernameAvailable = true
        }
        number ++
    }

    return newUsername
}