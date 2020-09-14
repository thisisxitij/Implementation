import kotlin.jvm.functions.Function0;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/* This is for Illustration only  */
public class UnderTheHood {

    public static void main(String[] array ) {
        // when calling inline function
        // content of higher order function is directly placed at calling sight
        Lock lock = new ReentrantLock();
        lock.lock();
        try{
            // as well as  content of the function passed as the lambda is also placed directly at call sight inside the function it is passed to.
            String var1 = "Wait for the execution !";
            System.out.println(var1);

        }finally {
            lock.unlock();
        }

        // while calling inline function
        // new instance of Function0 is created  and then call invoke() method on it
        // and if  we use higher functions lot of places in our code, each time we call the higher order function
        // a new instance of FunctionN is created which lead to runtime and memory overhead

        // so its better to inline the higher order functions
        // we can avoid it when we know we are going to use our higher order function just in one or two places.

        // inlining lambdas  may cause generated code to grow
        // thus we need to do it in a reasonable way
        // that is not inlining large functions.
        // and it will surely pay off in performance.


    }

    // Bytecode  ->  with inline
    static void performHavingLock(Lock lock, Function0 task) {
        lock.lock();
        try{
            task.invoke();
        }finally{
            lock.unlock();
        }
    }

    // Bytecode -> without inline
    static void performHavingLockTwo(Lock lock, Function0 task) {
        lock.lock();
        try {
            task.invoke(); // create instance Function0 and call invoke function
        }finally {
            lock.unlock();
        }
    }
}
