package com.openclassrooms.entrevoisins.add_neighbour_and_neighbour_details;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.assertNotNull;

//Testing NeighbourDetailsActivity
@RunWith(AndroidJUnit4.class)
@LargeTest
public class NeighbourDetailsTests {

    public ListNeighbourActivity mActivity;
    public NeighbourApiService mApiService;

    @Rule
    public ActivityTestRule<ListNeighbourActivity> mActivityTestRule =
            new ActivityTestRule<>(ListNeighbourActivity.class);

    @Before
    public void setup() {
        mActivity = mActivityTestRule.getActivity();
        assertNotNull(mActivity);
        mApiService = DI.getNewInstanceApiService();
    }

    //We assert that the star button can be clicked
    @Test
    public void starButtonIsClickable() {
        onView(ViewMatchers.withId(R.id.detail_button_add_favorite)).check(matches(ViewMatchers.isClickable()));
    }

    //We assert that the arrow button can be clicked
    @Test
    public void backButtonIsClickable() {
        onView(ViewMatchers.withId(R.layout.activity_neighbour_details));
        onView(ViewMatchers.withId(R.id.detail_button)).check(matches(ViewMatchers.isClickable()));
    }

    //When the user click on a neighbour it show the details page
    @Test
    public void myNeighboursList_clickOnNeighbour_shouldShowNeighbourDetails() {
        onView(allOf(ViewMatchers.withId(R.id.list_neighbours), hasFocus()))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(ViewMatchers.withId(R.id.neighbour_details))
                .check(matches(isDisplayed()));
        onView(ViewMatchers.withId(R.id.detail_name))
                .check(matches(withText(mApiService.getNeighbours().get(0).getName())));
    }
}
