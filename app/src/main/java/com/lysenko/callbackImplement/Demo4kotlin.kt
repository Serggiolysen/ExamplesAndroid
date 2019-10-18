package com.lysenko.callbackImplement

fun main() {
    Class2().funClass2()
}

interface Result {
    fun onSuccess(s: String)
}

object Class1 {
    fun some(result: Result) {
        result.onSuccess("Class1 some")
    }
}

class Class2 : Result {
    fun funClass2() {
        Class1.some(this)
    }

    override fun onSuccess(s: String) {
        print("Class2 onSuccess + " + s)
    }
}