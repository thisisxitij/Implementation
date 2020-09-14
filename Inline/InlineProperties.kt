
// we can also inline properties getter or setter or both (getter and setter)
// but remember if we do so then we don't have backing field (inline properties don't have baking filed)
// setting property setter ( set() method ) inline
val propOne: Int
   inline get() = 10

// setting property getter ( get() method ) inline
var propTwo: Int
    get() = 100
    inline set(value){ println(value)}  // no matter what value you set of the property it is always going to return value of getter

// setting property setter (set()) and getter ( get() ) both inline (annotating an entire property inline)
inline var propThree: Int
    get() = 1000
    set(value) { }

