// we can use in with flow control statements like if else and when

val someNames  = listOf("kotlin", "google", "jet brains", "android", "intellij")

fun main() {
    // using in with collections
    // it in will call the contains() method of collection.
    if("google" in someNames) println("google is present in someNames ") // in calls contains method if it is used with control flow statements.
    else println("google is not present in someNames")

    //as opposite to in we also have !in (not in )
    // calls contains() method of collection.
    if ("test" !in someNames)println("test is not present in the someName")
    else println("test is present in the someName")

    // using in with Ranges or types that implement ClosedRange interface
    val intRange = 1..10

    // using in with range
    // calls contains() method of ClosedRange if it is not Overridden in Particular Range Class .
    if (5 in intRange) println("5 is present in the intRange")
    else println("5 is not present in the intRange")

    // using !in
    if (5 !in intRange) println("5 is not present in intRange")
    else println("5 is present in the intRange")


    // using in and !in with "With expression"

    val value  = 49
    when(value) {
        in 1..10 -> println("present in first set !")
        in 11..20 -> println("present in second set !")
        in 21..30 -> println("present in third set !")
        !in 1..30  -> println(" No Present in any set !") // could have used else but used !in (not in)  just illustrate !
    }

}
