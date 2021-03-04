package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    public NeighbourServiceTest(java.lang.Object neighbour, java.lang.Object object) {
    }

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    @Test
    public void addNeighbourToFavoritesWithSuccess() {
    Neighbour neighbourToAdd = service.getFavoritesNeighbour().get(0);
    service.addNeighbourToFavorites(neighbourToAdd);
    assertFalse(service.getNeighbours().contains(neighbourToAdd));
    }

    @Test
    public void deleteFavoriteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getFavoritesNeighbour().get(0);
        service.deleteFavoriteNeighbour(neighbourToDelete);
        assertFalse(service.getFavoritesNeighbour().contains(neighbourToDelete));
    }

    @Test
    public void getFavoritesNeighboursWithSuccess(){
        List<Neighbour> neighbours = service.getFavoritesNeighbour();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.FAVORITES_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

}
