package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event fired when a user deletes a Neighbour
 */
public class DeleteNeighbourEvent {

    /**
     * Neighbour to delete
     */
    public Neighbour mNeighbour;
    public boolean mFavorite;

    /**
     * Constructor.
     * @param pNeighbour
     */
    public DeleteNeighbourEvent(Neighbour pNeighbour, boolean pFavorite) {
        mNeighbour = pNeighbour;
        mFavorite = pFavorite;

    }
}
