package com.lysenko.fragment

import com.lysenko.Test.Calculator
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {



    fun divsable(divider:Int):Matcher<Int?>{
        return IsDivisable(divider)
    }

    var calculator = Calculator()

    @Test
    fun addition_isCorrect() {
        assertThat(4, divsable(2))

    }

    @Before
    @Throws(Exception::class)
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    @Throws(Exception::class)
    fun addition() {
        assertEquals(3, calculator.add(1, 2))
    }
}

class IsDivisable(val divider: Int) : TypeSafeMatcher<Int?>() {
    override fun describeTo(description: Description?) {
        description!!.appendText("Divisable by $divider")
    }

    override fun matchesSafely(item: Int?): Boolean {
        if (divider == 0 || item == null) {
            return false
        } else {
            return item % divider == 0
        }
    }


}


