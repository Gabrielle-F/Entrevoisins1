package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class NeighbourDetails extends AppCompatActivity {

    ImageButton mAddFavorite;
    ImageButton mButton;
    ImageView mAvatar;
    TextView mName;
    TextView mElementsName;
    TextView mElementsAddress;
    TextView mElementsNumber;
    TextView mElementsLink;
    TextView mElementsAboutMe;

    public NeighbourDetails(Activity activity) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neighbour_details);

        mAddFavorite = findViewById(R.id.detail_button_add_favorite);
        mButton = findViewById(R.id.detail_button);
        mAvatar = findViewById(R.id.detail_avatar);
        mName = findViewById(R.id.detail_name);
        mElementsName = findViewById(R.id.detail_elements_name);
        mElementsAddress = findViewById(R.id.detail_elements_address);
        mElementsNumber = findViewById(R.id.detail_elements_number);
        mElementsLink = findViewById(R.id.detail_elements_link);
        mElementsAboutMe = findViewById(R.id.detail_elements_aboutme);

        mAddFavorite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        }
        public static void addNeighbourToFavorites(Neighbour neighbour) { DI.getNeighbourApiService(); }

        public static void deleteFavoriteNeighbour(Neighbour neighbour) { DI.getNeighbourApiService(); }

        static NeighbourApiService getFavoritesNeighbours() { return DI.getNeighbourApiService(); }
    }