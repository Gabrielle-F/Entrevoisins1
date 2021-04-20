package com.openclassrooms.entrevoisins.add_neighbour_and_neighbour_details;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.junit.Assert.assertNotNull;


//Testing AddNeighbourActivity
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AddNeighbourActivityTests {

    public ListNeighbourActivity mActivity;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setup() {
        mActivity = mActivityTestRule.getActivity();
        assertNotNull(mActivity);
    }

    //When the user click on the add_neighbour button it show the AddNeighbourActivity
    @Test
    public void clickOnAddNeighbourButton_shouldShowAddNeighbourActivity() {
        onView(ViewMatchers.withId(R.id.add_neighbour))
                .perform(click());
        onView(ViewMatchers.withId(R.id.add_neighbour_layout))
                .check(matches(isDisplayed()));
    }
}


