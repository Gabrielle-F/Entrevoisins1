package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class ClickNeighbourEvent {

    public boolean mFavorite;
    public Neighbour mNeighbour;

    public ClickNeighbourEvent(Neighbour pNeighbour, boolean pFavorite) {
        mFavorite = pFavorite;
        mNeighbour = pNeighbour;
    }
}
