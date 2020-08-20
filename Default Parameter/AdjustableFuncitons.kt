/** Adjustable Functions with default Parameters */
// Lets take a example if want to search for a element in a list by using a function..
// if the element is present it will return true if not then false
// but some times we also want that function to return that element index also

// lets start it
// Some time we want the index of the element if it is present.
fun checkElementPresent(value: Int, list: List<Int>, withIndex: Boolean) {
    val found  =  list.contains(value)
    if (withIndex) {
        if (found) println("Element is present at ${list.indexOf(value)} Index")
        else println("Element not Found !")
    }else {
        if (found) println("Element is present !")
        else println("Element not Found !")
    }

}

// And some times we just want to Know that the value is present or not !
fun checkElementPresent(value: Int, list: List<Int>) {
    val found  = list.contains(value)
    if (found) println("Element is present !")
    else println("Element not found !")
}

// And in many cases we need to overload our function many times for Different scenarios
// like this one above


// or we can create separate function to get element index if the value is present
//  which wold be better option instead of overloading the function ( Explained in main() )
fun checkAndGetIndex(value: Int, list: List<Int>) {
    val found = list.contains(value)
    if (found) println("Element is present at ${list.indexOf(value)}")
    else println("Element Not Found!")
}


// To overcome this we can use default value or default value parameters
fun checkElement(value: Int, list: List<Int>, withIndex: Boolean = false ) { // here we made our withIndex value optional by providing it default value
    val found = list.contains(value)
    if (withIndex) {
        if(found) println("Element is Present at ${list.indexOf(value)}")
        else println("Element not found !")
    }else {
        if (found) println("Element is Present!")
        else println("Element not Found !")
    }
}
// That's it no need to overload the function for Different scenarios

fun main() {
    val listToBeSearched  = listOf(1, 20, 40, 50, 20, 1000, 30, 300)

    // with overloaded methods
    checkElementPresent(30, listToBeSearched) // only interested in the presence of element
    checkElementPresent(50, listToBeSearched, true ) // if a person wants withIndex Value to be true then he will never  set it to false means there is no reason to set this value to be true
    // or we as a programmer can declare different function with different name to check the value is present and get its index if it is present
    // and this would be a better option instead of overloading function but still we have to write more code for different scenarios
    checkAndGetIndex(300, listToBeSearched)

    // To overcome all of these little problems
    // we simply use a function with default values and that's it no need to override a function or create different function for different scenarios
    checkElement(1000, listToBeSearched) // here the value for withIndex is false by default
    checkElement(1000, listToBeSearched, true ) // here we overridden the value of withIndex
    // awesome job done with just one function with default parameter value

    // but there is more note the position of our default value parameter its the last parameter in function declaration
    // what if we place the parameter with the default value as first parameter
    // lets simulate this by creating decorateMyName function  with a default value parameter below main() function

    /** if we want to use default value of name parameter which is "kotlin" in this case and just give value to the toCapital argument */
    //Error decorateMyName(true) // what happens here is if have our default value parameter as first parameter compiler is going to think
    // we have passed this value for for our first default value parameter which is of different type
    // or maybe in some case the type of the default parameter value and parameter after it, is same
    // and it will override the value of the default value parameter which we  don't want and result in unexpected execution

    /** thus if we have default value parameter in function it is better to place them after or rightmost of the positional arguments */

    // well in this case for passing value for our named positional argument that is after the default value parameter
    // we can use named Arguments

    decorateMyName(toCapital = true)
    // or
    decorateMyName(toCapital = false)

    // If we want to override the value of default value parameter
    decorateMyName("Google", true) // we can simple pass them
    // or by using named arguments
    decorateMyName(name = "Jet-Brains", toCapital = true)



}

// just for demonstration
fun decorateMyName(name: String = "Kotlin", toCapital: Boolean) {
    border("_-`-_")
    println()
    if (toCapital) {
        border(" ", 20)
        println(name.toUpperCase())
    }
    else{
        border(" ", 20)
        println(name)
    }
    border("_-`-_")
    println()
}

fun border(decoration: String, times: Int = 10) {
    repeat(times) {
        print(decoration)
    }

}