package org.smartregister.path;

import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.smartregister.path.activity.LoginActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by vkaruri on 10/05/2018.
 */

public class PathUITests {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testSuccessfulLogin_validCredentials() {

        onView(withId(R.id.login_userNameText))
                .perform(typeText("biddemo"));
        onView(withId(R.id.login_passwordText))
                .perform(typeText("Linda123"));
        onView(withId(R.id.login_loginButton)).perform(click());

        SystemClock.sleep(5000);
        onView(withId(R.id.edt_search)).check(matches(isDisplayed()));
    }

    @Test
    public void testFailedLogin_invalidCredentials() {

        onView(withId(R.id.login_userNameText))
                .perform(typeText("biddemo"));
        onView(withId(R.id.login_passwordText))
                .perform(typeText(""));
        onView(withId(R.id.login_loginButton)).perform(click());

        SystemClock.sleep(1000);
        onView(withText(R.string.unauthorized)).check(matches(isDisplayed()));
    }

    @Test
    public void testVaccineCardOpensWhenPatientIsTapped() {

        // ensure you have a child named Bonoko otherwise this fails
        onView(withText("Bonoko")).perform(click());
        onView(withId(R.id.profile_image_iv)).check(matches(isDisplayed()));
    }
}
