package com.openclassrooms.entrevoisins.utils;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourGenerator;

import org.junit.runner.RunWith;

import java.util.List;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class InstrumentedTests {

    public List<Neighbour> neighbours;


    public void setup() {
        neighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
    }

}
