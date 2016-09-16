package com.example.lawrencemuller.kotlinapitest

import android.util.Log


/**
 * Created by Jonathan Muller on 9/16/16.
 */
class KotlinExamples(val word: String) : KotlinInterfaceExample {

    val anyObject : Any = "Any is the kotlin version of Object, all classes use Any as a superclass"

    // This initializes code in the class. This is used like a constructor block
    init {
        variables()
        smartCasting()
        streamsAndLambdas()
        ranges()
        usingExtensionMethod()
        usingMethodWithDefaults()
    }

    fun variables() {

        // Implicit types
        var myValue = word

        // Explicit types
        var myOtherValue : String = word
    }

    // Classes can only be extended if the open keyword is used
    open class A {
        fun methodA(): String {
            return "Method A"
        }
    }

    class B : A() {
        fun methodB(): String {
            return "Method B"
        }
    }

    class C : A() {
        fun methodC(): String {
            return "Method C"
        }
    }

    // Casting is much easier
    fun smartCasting() {
        // Create instance of class A from class B
        val a : A = B()

        // Only have access to class A methods since casted as A
        a.methodA()

        // After doing instance check A is cast to B automatically
        if (a is B) {
            a.methodB()
            a.methodA()
        }
    }

    fun switchStatement() {
        val a = A()
        when (a) {
            is C -> a.methodC()
            is B -> a.methodB()
            else -> a.methodA()
        }
    }

    // Streams and Lambdas are native
    fun streamsAndLambdas() {
        arrayListOf(1, 2, 3, 4, 5, 6, 7)
                .filter { it % 2 == 0 }
                .map { it.toString() }
                .reversed()
                .forEach { Log.d("Stream Print", it) }
    }

    fun ranges() {

        for (i in 1..5)
            Log.d("Range", i.toString())

        for (i in 10 downTo 5)
            Log.d("Range DownTo", i.toString())

        for (i in 20 downTo 1 step 2)
            Log.d("Range DownTo Step", i.toString())
    }

    fun Int.myIntMethod() {
        Log.d("Extension", "My int method!")
    }

    fun usingExtensionMethod() {

        9.myIntMethod()

        val num: Int = 2
        num.myIntMethod()
    }

    fun smallMethod () = Log.d("Small", "Small Method")

    fun smallReturnMethod (word: String) : String = word + " <- my input being used"

    fun methodWithDefaults(name : String, favNumber: Int, isHungry: Boolean = false) {
        var newString = name.plus(favNumber)
        smallMethod()
        val myString = smallReturnMethod("YOLO")
    }

    fun usingMethodWithDefaults() {
        methodWithDefaults("Ben", 34)
        methodWithDefaults("Thomas", 239, true)
        methodWithDefaults(favNumber = 23, isHungry = true, name = "Sara")
    }

    // Interface method implementation
    override fun method() {
        // Default interface method is usable without implementing it
        if (false)
            defaultMethod()
    }
}

interface KotlinInterfaceExample {

    fun method()

    fun defaultMethod() {
        method()
    }
}