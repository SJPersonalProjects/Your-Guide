package com.example.yourguide.punjab_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.yourguide.Province;
import com.example.yourguide.PunjabProvinceCardAdapter;
import com.example.yourguide.R;

import java.util.ArrayList;

public class PunjabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjab);

        //ArrayList to hold the top popular cities in Punjab Province...
        ArrayList<Province> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new Province(R.drawable.lahore_city, R.string.lahore_city_title,
                R.string.lahore_city_description, R.string.lahore_city_rating, R.string.lahore_city_review));
        popularCitiesList.add(new Province(R.drawable.faisalabad_city, R.string.faisalabad_city_title,
                R.string.faisalabad_city_description, R.string.faisalabad_city_rating, R.string.faisalabad_city_review));
        popularCitiesList.add(new Province(R.drawable.rawalpindi_city, R.string.rawalpindi_city_title,
                R.string.rawalpindi_city_description, R.string.rawalpindi_city_rating, R.string.rawalpindi_city_review));
        popularCitiesList.add(new Province(R.drawable.multan_city, R.string.multan_city_title,
                R.string.multan_city_description, R.string.multan_city_rating, R.string.multan_city_review));
        popularCitiesList.add(new Province(R.drawable.gujranwala_city, R.string.gujranwala_city_title,
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
        ArrayList<Province> topRestaurantList = new ArrayList<>();
        topRestaurantList.add(new Province(R.drawable.monal_restaurant, R.string.monal_restaurant_title,
                R.string.monal_restaurant_description, R.string.monal_restaurant_rating, R.string.monal_restaurant_review));
        topRestaurantList.add(new Province(R.drawable.haveli_restaurant, R.string.haveli_restaurant_title,
                R.string.haveli_restaurant_description, R.string.haveli_restaurant_rating, R.string.haveli_restaurant_review));
        topRestaurantList.add(new Province(R.drawable.andaaz_restaurant, R.string.andaaz_restaurant_title,
                R.string.andaaz_restaurant_description, R.string.andaaz_restaurant_rating, R.string.andaaz_restaurant_review));
        topRestaurantList.add(new Province(R.drawable.spice_bazaar, R.string.spice_bazar_title, R.string.spice_bazar_description,
                R.string.spice_bazar_rating, R.string.spice_bazar_review));
        topRestaurantList.add(new Province(R.drawable.dera_restaurant, R.string.dera_restaurant_title,
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

        //ArrayList to hold the historical places in Punjab province.
        ArrayList<Province> historicalPlacesList = new ArrayList<>();
        historicalPlacesList.add(new Province(R.drawable.badshahi_mosque,
                R.string.badshahi_mosque_historical_place_title, R.string.badshahi_mosque_historical_place_description,
                R.string.badshahi_mosque_historical_place_rating, R.string.badshahi_mosque_historical_place_review));
        historicalPlacesList.add(new Province(R.drawable.wagah_border, R.string.wagah_border_historical_place_title,
                R.string.wagah_border_historical_place_description, R.string.wagah_border_historical_place_rating,
                R.string.wagah_border_historical_place_review));
        historicalPlacesList.add(new Province(R.drawable.lahore_fort, R.string.lahore_fort_historical_place_title,
                R.string.lahore_fort_historical_place_description, R.string.lahore_fort_historical_place_rating,
                R.string.lahore_fort_historical_place_review));
        historicalPlacesList.add(new Province(R.drawable.masjid_wazir_khan, R.string.wazir_mosque_historical_place_title,
                R.string.wazir_mosque_historical_place_description, R.string.wazir_mosque_historical_place_rating,
                R.string.wazir_mosque_historical_place_review));
        historicalPlacesList.add(new Province(R.drawable.walled_city, R.string.walled_city_historical_place_title,
                R.string.walled_city_historical_place_description, R.string.walled_city_historical_place_rating,
                R.string.walled_city_historical_place_review));

        RecyclerView historicalPlacesRecyclerView = (RecyclerView) findViewById(R.id.province_historical_places);
        historicalPlacesRecyclerView.setVerticalScrollBarEnabled(false);
        historicalPlacesRecyclerView.setHorizontalScrollBarEnabled(false);
        historicalPlacesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager historicalPlacesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        PunjabProvinceCardAdapter historicalPlacesAdapter = new PunjabProvinceCardAdapter(historicalPlacesList);

        historicalPlacesRecyclerView.setLayoutManager(historicalPlacesLayoutManager);
        historicalPlacesRecyclerView.setAdapter(historicalPlacesAdapter);
    }
}