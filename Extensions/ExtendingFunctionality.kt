// Extending functionalities of classes

// adding swap extension function to Array<T> class
fun <T> Array<T>.swap(a: T, b: T) {

    // if element is not present -1 will be returned
    val positionA = indexOf(a)
    val positionB = indexOf(b)

    if (positionA < 0 || positionB < 0){
        throw IllegalArgumentException("Please enter elements that are present in the Array ")
    }

    this[positionA] = b
    this[positionB] = a

}

fun main() {

    val testArray = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    testArray.swap(1, 7)
    println(testArray.joinToString(", ", "[", "]"))

    val testArrayTwo = arrayOf('a', 'b', 'c','d', 'e')
    testArrayTwo.swap('e', 'a')
    println(testArrayTwo.joinToString(", ", "[", "]"))

}