package com.brafik.tiptime

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.matchers.JUnitMatchers.containsString
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calc_20_percent_tip() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("10.00"))))
    }

    @Test
    fun calc_18_percent_tip() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.eighteen_percent_option)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("9.00"))))
    }
    @Test
    fun calc_15_percent_tip() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.fifteen_percent_option)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("8.00"))))
    }

    @Test
    fun disround_up() {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00"))
        onView(withId(R.id.fifteen_percent_option)).perform(click())
        onView(withId(R.id.round_up_switch)).perform(click())
        onView(withId(R.id.calculate_button)).perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("7.50"))))
    }
}