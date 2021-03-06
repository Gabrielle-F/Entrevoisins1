package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class NeighbourDetailsActivity extends AppCompatActivity {

    FloatingActionButton mAddFavorite;
    ImageButton mButton;
    ImageView mAvatar;
    TextView mName;
    TextView mElementsName;
    TextView mElementsAddress;
    TextView mElementsNumber;
    TextView mElementsLink;
    TextView mElementsAboutMe;

    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);
        mNeighbour = (Neighbour) getIntent().getSerializableExtra("Neighbour");

        mAddFavorite = findViewById(R.id.detail_button_add_favorite);
        mButton = findViewById(R.id.detail_button);

        mAvatar = findViewById(R.id.detail_avatar);
        Glide.with(this)
                .load(mNeighbour.getAvatarUrl())
                .into(mAvatar);

        mName = findViewById(R.id.detail_name);
        mName.setText(mNeighbour.getName());

        mElementsName = findViewById(R.id.detail_elements_name);
        mElementsName.setText(mNeighbour.getName());

        mElementsAddress = findViewById(R.id.detail_elements_address);
        mElementsAddress.setText(mNeighbour.getAddress());

        mElementsNumber = findViewById(R.id.detail_elements_number);
        mElementsNumber.setText(mNeighbour.getPhoneNumber());

        mElementsLink = findViewById(R.id.detail_elements_link);
        mElementsLink.setText(mNeighbour.getFacebook());

        mElementsAboutMe = findViewById(R.id.detail_elements_aboutme);
        mElementsAboutMe.setText(mNeighbour.getAboutMe());

        mApiService = DI.getNeighbourApiService();

        mButton.setOnClickListener(view -> finish());

        mAddFavorite.setOnClickListener(view -> {
            {
                if (mApiService.getFavoritesNeighbour().contains(mNeighbour)) {
                    mAddFavorite.setActivated(false);
                    mApiService.deleteFavoriteNeighbour(mNeighbour);
                } else {
                    mAddFavorite.setActivated(true);
                    mApiService.addNeighbourToFavorites(mNeighbour);
                }
            }
        });
    }

}