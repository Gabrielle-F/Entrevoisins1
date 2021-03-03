package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class FavoritesNeighbourEvent {

    public Neighbour mFavorite;

    public FavoritesNeighbourEvent(Neighbour favorite) {this.mFavorite = favorite; }
}
