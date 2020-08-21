/** Interfaces containing default implementations*/


// creating EmailValidator Interface
interface EmailValidator{
    val input : String

    // default implementation for methods
    // Can be Overridden in Implementing class
    fun isEmailValid() = input.contains("@")
    fun getUserLogin(): String = if (isEmailValid()) input.substringBefore("@") else ""
}

// class that implements our interface
class RegistrationForm(override var input: String = ""): EmailValidator{ // note we can change val to var  while overriding a property but not vice versa


    fun updateEmail(email: String) { onInputTextUpdate(email)}

    private fun onInputTextUpdate(newInput: String) {
        this.input = newInput
        if (!isEmailValid()) println("You Have Entered Wrong Email Address !") // can override isEmailValid() method and apply RegEx for proper Email Address checking instead of using default implementation
        else println("Thanks ${getUserLogin()} for registering!") // store email in database and print this msg
    }
}

fun main (){
    val formOne  = RegistrationForm()
    formOne.updateEmail("this is not email") // wrong email address

    formOne.updateEmail("kotlin@gmail.com") // passing correct email containing '@'


}
