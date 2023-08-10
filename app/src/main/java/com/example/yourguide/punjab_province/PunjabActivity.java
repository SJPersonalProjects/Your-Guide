package com.example.yourguide.punjab_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.yourguide.Province;
import com.example.yourguide.ProvinceAdapter;
import com.example.yourguide.R;

import java.util.ArrayList;

public class PunjabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjab);

        //ArrayList to hold the top popular cities in Punjab Province...
        ArrayList<Province> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new Province(R.drawable.lahore_city, R.string.punjab_city_one_title,
                R.string.punjab_city_one_description, R.string.punjab_city_one_rating, getResources().getString(R.string.punjab_city_one_review)));
        popularCitiesList.add(new Province(R.drawable.faisalabad_city, R.string.punjab_city_two_title,
                R.string.punjab_city_two_description, R.string.punjab_city_two_rating, getResources().getString(R.string.punjab_city_two_review)));
        popularCitiesList.add(new Province(R.drawable.rawalpindi_city, R.string.punjab_city_three_title,
                R.string.punjab_city_three_description, R.string.punjab_city_three_rating, getResources().getString(R.string.punjab_city_three_review)));
        popularCitiesList.add(new Province(R.drawable.multan_city, R.string.punjab_city_four_title,
                R.string.punjab_city_four_description, R.string.punjab_city_four_rating, getResources().getString(R.string.punjab_city_four_review)));
        popularCitiesList.add(new Province(R.drawable.gujranwala_city, R.string.punjab_city_five_title,
                R.string.punjab_city_five_description, R.string.punjab_city_five_rating, getResources().getString(R.string.punjab_city_five_review)));

        RecyclerView punjabProvinceRecyclerView = findViewById(R.id.punjab_province_recycler_view);
        punjabProvinceRecyclerView.setVerticalScrollBarEnabled(false);
        punjabProvinceRecyclerView.setHorizontalScrollBarEnabled(false);
        punjabProvinceRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager citiesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        ProvinceAdapter adapter = new ProvinceAdapter(popularCitiesList);

        punjabProvinceRecyclerView.setLayoutManager(citiesLayoutManager);
        punjabProvinceRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast to show the click event message of cards in Punjab Activity.
                Toast.makeText(PunjabActivity.this, popularCitiesList.get(position).getCardTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        //ArrayList to hold the top restaurants in Punjab Province.
        ArrayList<Province> topRestaurantList = new ArrayList<>();
        topRestaurantList.add(new Province(R.drawable.monal_restaurant, R.string.punjab_restaurant_one_title,
                R.string.punjab_restaurant_one_description, R.string.punjab_restaurant_one_rating, getResources().getString(R.string.punjab_restaurant_one_review)));
        topRestaurantList.add(new Province(R.drawable.haveli_restaurant, R.string.punjab_restaurant_two_title,
                R.string.punjab_restaurant_two_description, R.string.punjab_restaurant_two_rating, getResources().getString(R.string.punjab_restaurant_two_review)));
        topRestaurantList.add(new Province(R.drawable.andaaz_restaurant, R.string.punjab_restaurant_three_title,
                R.string.punjab_restaurant_three_description, R.string.punjab_restaurant_three_rating, getResources().getString(R.string.punjab_restaurant_three_review)));
        topRestaurantList.add(new Province(R.drawable.spice_bazaar_restaurant, R.string.punjab_restaurant_four_title, R.string.punjab_restaurant_four_description,
                R.string.punjab_restaurant_four_rating, getResources().getString(R.string.punjab_restaurant_four_review)));
        topRestaurantList.add(new Province(R.drawable.dera_restaurant, R.string.punjab_restaurant_five_title,
                R.string.punjab_restaurant_five_description, R.string.punjab_restaurant_five_rating, getResources().getString(R.string.punjab_restaurant_five_review)));

        RecyclerView restaurantsRecyclerView = (RecyclerView) findViewById(R.id.top_restaurant_recycler_view);
        restaurantsRecyclerView.setVerticalScrollBarEnabled(false);
        restaurantsRecyclerView.setHorizontalScrollBarEnabled(false);
        restaurantsRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager restaurantsLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter restaurantsAdapter = new ProvinceAdapter(topRestaurantList);

        restaurantsRecyclerView.setLayoutManager(restaurantsLayoutManager);
        restaurantsRecyclerView.setAdapter(restaurantsAdapter);

        //ArrayList to hold the historical places in Punjab province.
        ArrayList<Province> historicalPlacesList = new ArrayList<>();
        historicalPlacesList.add(new Province(R.drawable.badshahi_mosque,
                R.string.punjab_historical_place_one_title, R.string.punjab_historical_place_one_description,
                R.string.punjab_historical_place_one_rating, getResources().getString(R.string.punjab_historical_place_one_review)));
        historicalPlacesList.add(new Province(R.drawable.wagah_border, R.string.punjab_historical_place_two_title,
                R.string.punjab_historical_place_two_description, R.string.punjab_historical_place_two_rating,
                getResources().getString(R.string.punjab_historical_place_two_review)));
        historicalPlacesList.add(new Province(R.drawable.lahore_fort, R.string.punjab_historical_place_three_title,
                R.string.punjab_historical_place_three_description, R.string.punjab_historical_place_three_rating,
                getResources().getString(R.string.punjab_historical_place_three_review)));
        historicalPlacesList.add(new Province(R.drawable.wazir_khan_mosque, R.string.punjab_historical_place_four_title,
                R.string.punjab_historical_place_four_description, R.string.punjab_historical_place_four_rating,
                getResources().getString(R.string.punjab_historical_place_four_review)));
        historicalPlacesList.add(new Province(R.drawable.walled_city, R.string.punjab_historical_place_five_title,
                R.string.punjab_historical_place_five_description, R.string.punjab_historical_place_five_rating,
                getResources().getString(R.string.punjab_historical_place_five_review)));

        RecyclerView historicalPlacesRecyclerView = (RecyclerView) findViewById(R.id.province_historical_places);
        historicalPlacesRecyclerView.setVerticalScrollBarEnabled(false);
        historicalPlacesRecyclerView.setHorizontalScrollBarEnabled(false);
        historicalPlacesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager historicalPlacesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter historicalPlacesAdapter = new ProvinceAdapter(historicalPlacesList);

        historicalPlacesRecyclerView.setLayoutManager(historicalPlacesLayoutManager);
        historicalPlacesRecyclerView.setAdapter(historicalPlacesAdapter);
    }
}