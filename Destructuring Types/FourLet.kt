// Im making a data container which can be used in destructuring declaration and also in Destructuring Declaration in iteration  (for loop)

// lets create iterator for our FourLet
// for simple iteration (with only value or element)
open class FourLetIterator<T> (private val fourLet: FourLet<T>): Iterator<T> {

    private var elementNumber: Int = 0
    override fun hasNext(): Boolean =  elementNumber < 4

    override fun next(): T  {
        val element =  when (elementNumber) {
            0 -> fourLet.one
            1 -> fourLet.two
            2 -> fourLet.three
            else  -> fourLet.four
        }
        elementNumber++
        return element
    }

}
// todo can we do this with single iterator ?

// Iterator for iteration with element and index
open class FourLetWithIndexIterator<T>(private val fourLet: FourLet<T>): Iterator<Pair<Int, T>>{

    private var index: Int = 0
    override fun hasNext() =  index < 4

    override fun next(): Pair<Int, T > {
        val elementWithIndex = when(index) {
            0 -> Pair(index, fourLet.one)
            1 -> Pair(index,  fourLet.two)
            2 -> Pair(index,  fourLet.three)
            else  -> Pair(index, fourLet.four)
        }

        index++
        return elementWithIndex
    }

}

// lets create a data structure
class FourLet<T> (value1: T, value2: T, value3: T, value4: T) :Iterable<T> {     // todo infix function for ease

    val one: T = value1
    val two: T = value2
    val three: T = value3
    val four: T = value4


    // iterator for simple iteration
    override fun iterator(): Iterator<T>  =  FourLetIterator(this)

    // iterator for destructuring declaration iteration
    fun withIndex(): Iterator<Pair<Int, T>> = FourLetWithIndexIterator(this)

    operator fun component1(): T= one
    operator fun component2(): T = two
    operator fun component3(): T= three
    operator fun component4(): T = four

}

fun main() {

    // FourLet instance
    val fourLet: FourLet<Int> = FourLet(1, 2, 3, 4)

    // simple destructuring declaration
    val (one, two, three, four) = fourLet
    println("""
        Element One: $one 
        Element Two: $two 
        Element Three: $three
        Element Four: $four
    """.trimIndent())

    println("===============================================")
    // destructuring declaration in iteration
    for ( (index, element) in fourLet.withIndex())  println("Element: $element at $index")


    // since the FourLet is generic we can store any type.

}

// todo improvement lookup !