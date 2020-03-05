package com.lysenko.callbackImplement

fun main() {
    Class2().funClass2()
}

interface Result {
    fun onSuccess(s: String)
}

class Class2 : Result {
    fun funClass2() {
        val class1 = Class1(this)
        class1.some()
    }

    override fun onSuccess(s: String) {
        print("Class2 onSuccess + " + s)
    }
}

class Class1(val result: Result) {

    fun some() {
        result.onSuccess("Class1 some")
    }
}
