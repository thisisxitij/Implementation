// difference between Sequence and Collection based data structures

fun main() {
// lest take list first
    val numberList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

// applying map transformational function to the list
    val stringNumberList: List<String> = numberList.map {// map will invoked and executed when compiler reach this line this ic called eager ( elements of the Collection Type Data Structures are evaluated instantly )
        println("Converting $it to String")
        it.toString()

    }

    val subPartOfStringNumber = stringNumberList.take(5)

    println(stringNumberList) // printing string representation of List
    println(stringNumberList)

    // lets take same example with sequence DataStructure
    val numberSequence: Sequence<Int> = sequenceOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    // using map on sequence Type
    // sequence holds the information about its elements and the functions that are invoked upon it
    val stringNumberSequence: Sequence<String> = numberSequence.map{  // compiler wont invoke map now when it reaches to this point
        println("converting $it to string")
        it.toString()
    }

    // sequence evaluates its elements when they are accessed and evaluates only the elements that are accessed
    // this is called lazy behavior or we can say elements of sequence Data Structure evaluated lazily

    val subPartOfStringNumberSequence: Sequence<String> = stringNumberSequence.take(5) // still holding information about elements and take() function
    println(subPartOfStringNumberSequence.toList()) // now  sequence will start evaluating but only for first 5 elements because we have passed 5 to the take method of sequence

    // converting whole sequence to the list will evaluate every elements because we are asking it to return whole Sequence converted into the List Type
    val stringNumberListTwo : List<String> = stringNumberSequence.toList() // at this point all the elements are evaluated and added to the new instance of the list and returned
    println(stringNumberListTwo)

    // Also elements of sequence will be evaluated when we iterate or traverse through them.
    // They are evaluated in the order they are accessed.

    // for eg
    for (elements in stringNumberSequence) println(elements)

    // The main thing is elements get evaluated when they are accessed
    val aStringNumber  = stringNumberSequence.first()  // first element will get evaluated will get evaluated because behind the seen we are iterating one time over Sequence Type
    println(aStringNumber)


    // converting List to Sequence

    // by using asSequence
    val numberSequenceTwo: Sequence<Int> = numberList.asSequence()

    // we can use sequence type Data Structure with algorithms

}










