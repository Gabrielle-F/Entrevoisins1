package com.openclassrooms.entrevoisins.utils;

import android.content.Intent;
import android.support.design.snackbar.ContentViewCallback;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class InstrumentedTests {

    @Before
    public void setup() {
    }

    @Test
    public void checkIfAddingUserToFavoriteListIsWorking() {
onView(withId(R.id.detail_button_add_favorite)).perform(click());
    }

    @Test
    public void checkIfGetFavoritesNeighbourIsWorking() {

    }

    @Test
    public void checkIfRemoveFavoriteNeighbourIsWorking() {

    }
}
