import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/** inlining higher order function */

// Usage of higher order function can lead to runtime performance.
// memory allocation of function passed as lambda and their virtual calls can lead to runtime overhead.


fun main() {
    performHavingLock(ReentrantLock()) {
        println("Wait for it to execute !")
    }
    performHavingLockTwo(ReentrantLock()) {
        println("wait for it to execute !")
    }

    higherOrderFunOne(
            { println("im lambda One") }, // a function passed as lambda
            {println("im lambda two")} // another function  passed as lambda

    )

}

/** Check what happened under the hood in file -> UnderTheHood.class */
// with inline
inline fun performHavingLock(lock: Lock, task : () -> Unit) {
    lock.lock()

    try {
        task()
    }
    finally{
        lock.unlock()
    }
}

// without inline
fun performHavingLockTwo(lock: Lock, task : () -> Unit) {
    lock.lock()

    try {
        task()
    }
    finally{
        lock.unlock()
    }
}

// we can also decide which lambda function to inline in inline function
inline fun higherOrderFunOne(lambdaOne: () -> Unit, noinline lambdaTwo: () -> Unit) {

    lambdaOne() // will be inlined !
    lambdaTwo() // will not be inlined !
}



