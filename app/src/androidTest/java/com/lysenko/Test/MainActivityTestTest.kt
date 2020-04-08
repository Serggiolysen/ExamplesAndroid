package com.lysenko.Test

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.lysenko.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTestTest{

    @Test
    fun isActivityInView() {
        val activityScenario = ActivityScenario.launch(MainActivityTest::class.java)
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun visibility_next_button() {
        val activityScenario = ActivityScenario.launch(MainActivityTest::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun isTitleTextDispayed() {
        val activityScenario = ActivityScenario.launch(MainActivityTest::class.java)
        onView(withId(R.id.activity_main_title)).check(matches(withText(R.string.text_mainactivity)))

    }
}