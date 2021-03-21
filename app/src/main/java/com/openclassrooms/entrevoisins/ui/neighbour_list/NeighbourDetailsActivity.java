package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class NeighbourDetailsActivity extends AppCompatActivity {

    ToggleButton mAddFavorite;
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

        mElementsAboutMe = findViewById(R.id.detail_elements_aboutme);
        mElementsAboutMe.setText(mNeighbour.getAboutMe());

        mApiService = DI.getNeighbourApiService();

        mButton.setOnClickListener(view -> finish());

        mAddFavorite.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if(isChecked) {
                addNeighbourToFavorites(mNeighbour);
            }
            else {
                deleteFavoriteNeighbour(mNeighbour);
            }
        });
    }

    public void addNeighbourToFavorites(Neighbour neighbour) {
        mApiService.addNeighbourToFavorites(neighbour);
    }

    public void deleteFavoriteNeighbour(Neighbour neighbour) {
        mApiService.deleteFavoriteNeighbour(neighbour);
    }


}