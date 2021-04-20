package com.openclassrooms.entrevoisins.ui.neighbour_list;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.ClickNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;


public class NeighbourFragment extends Fragment {

    private NeighbourApiService mApiService;
    private RecyclerView mRecyclerView;
    private boolean mFavorite;


    /**
     * Create and return a new instance
     *
     * @return @{@link NeighbourFragment}
     */
    public static NeighbourFragment newInstance(boolean favorite) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("favorite", favorite);

        NeighbourFragment fragment = new NeighbourFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    public void readBundle() {
        if (getArguments() != null) {
            mFavorite = getArguments().getBoolean("favorite", false);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbour_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        readBundle();
        return view;
    }

    /**
     * Init the List of neighbours
     */
    private void initList() {
        readBundle();
        List<Neighbour> mNeighbours;
        if (mFavorite) {
            mNeighbours = mApiService.getFavoritesNeighbour();
        } else mNeighbours = mApiService.getNeighbours();
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter
                (mNeighbours, mFavorite));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     *
     * @param event delete event received
     */
    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourEvent event) {
        if (event.mFavorite == mFavorite) {
            if (mFavorite) mApiService.deleteFavoriteNeighbour(event.mNeighbour);
            else mApiService.deleteNeighbour(event.mNeighbour);
        }
        initList();
    }

    @Subscribe
    public void onClickNeighbour(ClickNeighbourEvent event) {
        Log.d("gab", "click");
        if (event.mFavorite == mFavorite) {
            showNeighbourDetails(event.mNeighbour, mFavorite);
        }
    }

    private void showNeighbourDetails(Neighbour neighbour, boolean pFavorite) {
        Intent intent = new Intent(getActivity(), NeighbourDetailsActivity.class);
        intent.putExtra("Neighbour", neighbour);
        intent.putExtra("Favorite", pFavorite);
        startActivity(intent);
    }

}
