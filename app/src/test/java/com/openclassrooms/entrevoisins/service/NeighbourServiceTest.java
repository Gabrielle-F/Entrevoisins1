package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    public NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();

    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbourList = service.getNeighbours();
        List<Neighbour> neighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertEquals(neighbourList, neighbours);
    }

    @Test
    public void getFavoritesNeighboursWithSuccess() {
        List<Neighbour> favoriteNeighboursList = service.getFavoritesNeighbour();
        List<Neighbour> favoritesNeighbours = DummyNeighbourGenerator.FAVORITES_NEIGHBOURS;
        assertEquals(favoriteNeighboursList, favoritesNeighbours);
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addNeighbourWithSuccess() {
        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.createNeighbour(neighbourToAdd);
        assertTrue(service.getNeighbours().contains(neighbourToAdd));
    }
}
