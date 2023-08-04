package com.example.yourguide.punjab_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yourguide.R;

import java.io.DataOutputStream;
import java.util.ArrayList;

public class PunjabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjab);

        //ArrayList to hold the top popular cities in Punjab Province...
        ArrayList<PunjabProvinceCard> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new PunjabProvinceCard(R.drawable.lahore_city, R.string.lahore_city_title,
                R.string.lahore_city_description, R.string.lahore_city_rating, R.string.lahore_city_review));
        popularCitiesList.add(new PunjabProvinceCard(R.drawable.faisalabad_city, R.string.faisalabad_city_title,
                R.string.faisalabad_city_description, R.string.faisalabad_city_rating, R.string.faisalabad_city_review));
        popularCitiesList.add(new PunjabProvinceCard(R.drawable.rawalpindi_city, R.string.rawalpindi_city_title,
                R.string.rawalpindi_city_description, R.string.rawalpindi_city_rating, R.string.rawalpindi_city_review));
        popularCitiesList.add(new PunjabProvinceCard(R.drawable.multan_city, R.string.multan_city_title,
                R.string.multan_city_description, R.string.multan_city_rating, R.string.multan_city_review));
        popularCitiesList.add(new PunjabProvinceCard(R.drawable.gujranwala_city, R.string.gujranwala_city_title,
                R.string.gujranwala_city_description, R.string.gujranwala_city_rating, R.string.gujranwala_city_review));

        RecyclerView punjabProvinceRecyclerView = (RecyclerView) findViewById(R.id.punjab_province_recycler_view);
        punjabProvinceRecyclerView.setVerticalScrollBarEnabled(false);
        punjabProvinceRecyclerView.setHorizontalScrollBarEnabled(false);
        punjabProvinceRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager citiesLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        PunjabProvinceCardAdapter adapter = new PunjabProvinceCardAdapter(popularCitiesList);

        punjabProvinceRecyclerView.setLayoutManager(citiesLayoutManager);
        punjabProvinceRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PunjabProvinceCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast to show the click event message of cards in Punjab Activity.
                Toast.makeText(PunjabActivity.this, popularCitiesList.get(position).getCardTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        //ArrayList to hold the top restaurants in Punjab Province.
        ArrayList<PunjabProvinceCard> topRestaurantList = new ArrayList<>();
        topRestaurantList.add(new PunjabProvinceCard(R.drawable.monal_restaurant, R.string.monal_restaurant_title,
                R.string.monal_restaurant_description, R.string.monal_restaurant_rating, R.string.monal_restaurant_review));
        topRestaurantList.add(new PunjabProvinceCard(R.drawable.haveli_restaurant, R.string.haveli_restaurant_title,
                R.string.haveli_restaurant_description, R.string.haveli_restaurant_rating, R.string.haveli_restaurant_review));
        topRestaurantList.add(new PunjabProvinceCard(R.drawable.andaaz_restaurant, R.string.andaaz_restaurant_title,
                R.string.andaaz_restaurant_description, R.string.andaaz_restaurant_rating, R.string.andaaz_restaurant_review));
        topRestaurantList.add(new PunjabProvinceCard(R.drawable.spice_bazaar, R.string.spice_bazar_title, R.string.spice_bazar_description,
                R.string.spice_bazar_rating, R.string.spice_bazar_review));
        topRestaurantList.add(new PunjabProvinceCard(R.drawable.dera_restaurant, R.string.dera_restaurant_title,
                R.string.dera_restaurant_description, R.string.dera_restaurant_rating, R.string.dera_restaurant_review));

        RecyclerView restaurantsRecyclerView = (RecyclerView) findViewById(R.id.top_restaurant_recycler_view);
        restaurantsRecyclerView.setVerticalScrollBarEnabled(false);
        restaurantsRecyclerView.setHorizontalScrollBarEnabled(false);
        restaurantsRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager restaurantsLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        PunjabProvinceCardAdapter restaurantsAdapter = new PunjabProvinceCardAdapter(topRestaurantList);

        restaurantsRecyclerView.setLayoutManager(restaurantsLayoutManager);
        restaurantsRecyclerView.setAdapter(restaurantsAdapter);

    }
}