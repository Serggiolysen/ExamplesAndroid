package com.lysenko._codeChallange

fun main() {
    print(isAnagram2("lllkkkjjj66", "jjjkkklll"))
}

fun isAnagram(s: String, s2: String): Boolean {
    val list1 = s.toLowerCase().toCharArray().toMutableList()
    val list2 = s2.toLowerCase().toCharArray().toMutableList()
    val set1 = mutableSetOf<Char>()
    val set2 = mutableSetOf<Char>()
    if (s.length == s2.length) {
        set1.addAll(list1)
        set2.addAll(list1)
        set2.addAll(list2)
    }
    return set1.size == set2.size
}

fun isAnagram2(s: String, s2: String): Boolean {
    var sum = 0
    val list3 = mutableListOf<Int>()
    s.toLowerCase().toCharArray().toMutableList().forEach { list3.add(it.toByte().toInt()) }
    s2.toLowerCase().toCharArray().toMutableList().forEach { list3.add(it.toByte().toInt() * -1) }
    list3.forEach { sum += it }
    return sum == 0
}

fun isAnagram3(s: String, s2: String): Boolean {
    if (s.length != s2.length) return false

    val list1 = s.toLowerCase()
    val list2 = s2.toLowerCase()
    var foundChar: Boolean

    list1.forEach { char1 ->
        foundChar = false

        list2.forEach list2@{ char2 ->
            if (char1 == char2) {
                foundChar = true
                return@list2
            }
        }

        if (!foundChar) return false

    }

    return true
}


