import java.time.LocalDate

// Building Custom Progression

// "in" keyword basically need an iterator to iterate upon
class DateIterator( startDate: LocalDate, val endDate: LocalDate, val stepDays:Long):
        Iterator<LocalDate> {


    private var currentDate = startDate

    // "in"  will call hasNext() first and if it is true it will then call next()
    override fun hasNext(): Boolean = currentDate <= endDate // if the condition is always true we will stuck in the loop and next will be called infinite time unless there is some error, exception or if  light went off Lol !

    // Called by "in"  if hasNext() has returned true
    override fun next(): LocalDate {
        val next = currentDate
        currentDate = currentDate.plusDays(stepDays)
        return next // this value will be returned to the variable that uis on the left side of the in (Eg. number in numberList)
    }

}


class DateProgression( override val start: LocalDate,  override val endInclusive: LocalDate, val step: Long = 1):
        Iterable<LocalDate>, ClosedRange<LocalDate>{


    // "in" will check if the instance of class implements Interface Iterable
    // if it does it will call iterator first to get iterator and then call its hasNext() and next() methods.
     override fun iterator(): Iterator<LocalDate> = DateIterator(start, endInclusive, step)

    // if user some one used step infix Function we will return him the Progression class it self with specified step that will be used in has next() method of iterator
    infix fun step(days: Long): DateProgression = DateProgression(start, endInclusive , days)

}


// To use ".." rangeTo operator we have to declare rangeTo operator Extension function on  LocalDate
// That  is returning progression class so that "in" can get iterator of particular type which is DateIterator<LocalDate> :
operator fun LocalDate.rangeTo(other: LocalDate)  = DateProgression(this, other)

fun main() {

    // getting instance of LocalDate
    val startDate = LocalDate.of(2020, 8, 9)
    val endDate  = LocalDate.of(2020, 12, 31)

    // Getting instance of DateProgression by using rangeTo Operator (..)
    val dates  = startDate..endDate

    for (date in dates) println(date)

    // we can also do this like
    for (date in startDate..endDate) println(date)

    val checkDate  = LocalDate.of(2026, 10, 10 )
    println(checkDate in dates) //  this will call the  Contains()  method  of ClosedRange Interface

    /**
     * If our Progression class have'nt implemented the ClosedRange Interface and only  Implemented Iterable interface
     * Then "in" will call the Contains() a extension function of Iterable declared in  _collection.kt file
     * */



}
