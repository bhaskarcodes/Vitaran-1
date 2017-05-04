package com.example.vitaran;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Anudeep on 01-05-2017.
 */
@RunWith(AndroidJUnit4.class)
public class TestClass {

    // Common setup for all test classes

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    // End of Common setup for all test classes

    // Test methods

    @Test
    public void simpleTestMethod() {
        // Checking the existence of Views
        onView(withId(R.id.emptyScroll)).check(matches(isDisplayed()));
        //onView(withId(R.id.email_login_form)).check(matches(isDisplayed()));
        // Checking View's Text
/*
        // Entering value in EditText
        onView(withId(R.id.FName)).perform(typeText("Pikachu"), closeSoftKeyboard());
        onView(withId(R.id.LName)).perform(typeText("Raichu"), closeSoftKeyboard());
        onView(withId(R.id.donor_email_id)).perform(typeText("iambrock@gmail.com"), closeSoftKeyboard());
        onView(withId(R.id.donor_address)).perform(typeText("Tokyo"), closeSoftKeyboard());
        onView(withId(R.id.donor_contact)).perform(typeText("9944665577"), closeSoftKeyboard());
        onView(withId(R.id.donor_password)).perform(typeText("123456"), closeSoftKeyboard());
        onView(withId(R.id.donor_pass_rematch)).perform(typeText("123456"), closeSoftKeyboard());
*/
        // Perform Button Click
        //onView(withId(R.id.register_donor)).perform(click());
    }

    // End of test methods
}

// Custom Matcher Class

//public class CustomMatchers {

//}