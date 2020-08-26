// we also have extension properties

// extension property that will hold the last index of the list
val <T> List<T>.lastIndex: Int
        get() = size -1// extension properties has no backing field so we have to define getter method


fun main() {
    val numberList = listOf(1, 2, 3, 4, 5, 6, 7)

    // traversing list using while
    var index = 0
    while (index <= numberList.lastIndex) {
        println(numberList[index])
        index++
    }
}
