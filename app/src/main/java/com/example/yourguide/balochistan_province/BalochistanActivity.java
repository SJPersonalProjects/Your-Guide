package com.example.yourguide.balochistan_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.yourguide.Province;
import com.example.yourguide.ProvinceAdapter;
import com.example.yourguide.R;

import java.util.ArrayList;

public class BalochistanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balochistan);

        ArrayList<Province> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new Province(R.drawable.quetta_city, R.string.balochistan_city_one_title,
                R.string.balochistan_city_one_description, R.string.balochistan_city_one_rating,
                getResources().getString(R.string.balochistan_city_one_review)));
        popularCitiesList.add(new Province(R.drawable.gwadar_city, R.string.balochistan_city_two_title,
                R.string.balochistan_city_two_description, R.string.balochistan_city_two_rating,
                getResources().getString(R.string.balochistan_city_two_review)));
        popularCitiesList.add(new Province(R.drawable.chaman_city, R.string.balochistan_city_three_title,
                R.string.balochistan_city_three_description, R.string.balochistan_city_three_rating,
                getResources().getString(R.string.balochistan_city_three_review)));
        popularCitiesList.add(new Province(R.drawable.sibi_city, R.string.balochistan_city_four_title,
                R.string.balochistan_city_four_description, R.string.balochistan_city_four_rating,
                getResources().getString(R.string.balochistan_city_four_review)));
        popularCitiesList.add(new Province(R.drawable.hub_city, R.string.balochistan_city_five_title,
                R.string.balochistan_city_five_description, R.string.balochistan_city_five_rating,
                getResources().getString(R.string.balochistan_city_five_review)));

        RecyclerView citiesRecyclerView = findViewById(R.id.balochistan_province_popular_city);
        citiesRecyclerView.setVerticalScrollBarEnabled(false);
        citiesRecyclerView.setHorizontalScrollBarEnabled(false);
        citiesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager citiesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter citiesAdapter = new ProvinceAdapter(popularCitiesList);

        citiesRecyclerView.setLayoutManager(citiesLayoutManager);
        citiesRecyclerView.setAdapter(citiesAdapter);


        ArrayList<Province> topRestaurantsList = new ArrayList<>();
        topRestaurantsList.add(new Province(R.drawable.lehri_sajji_house_restaurant, R.string.balochistan_restaurant_one_title,
                R.string.balochistan_restaurant_one_description, R.string.balochistan_restaurant_one_rating,
                getResources().getString(R.string.balochistan_restaurant_one_review)));
        topRestaurantsList.add(new Province(R.drawable.usmania_tandoori_restaurant, R.string.balochistan_restaurant_two_title,
                R.string.balochistan_restaurant_two_description, R.string.balochistan_restaurant_two_rating,
                getResources().getString(R.string.balochistan_restaurant_two_review)));
        topRestaurantsList.add(new Province(R.drawable.saigon_restaurant, R.string.balochistan_restaurant_three_title,
                R.string.balochistan_restaurant_three_description, R.string.balochistan_restaurant_three_rating,
                getResources().getString(R.string.balochistan_restaurant_three_review)));
        topRestaurantsList.add(new Province(R.drawable.gulshan_karahi_restaurant, R.string.balochistan_restaurant_four_title,
                R.string.balochistan_restaurant_four_description, R.string.balochistan_restaurant_four_rating,
                getResources().getString(R.string.balochistan_restaurant_four_review)));
        topRestaurantsList.add(new Province(R.drawable.mehfil_restaurant, R.string.balochistan_restaurant_five_title,
                R.string.balochistan_restaurant_five_description, R.string.balochistan_restaurant_five_rating,
                getResources().getString(R.string.balochistan_restaurant_five_review)));

        RecyclerView restaurantsRecyclerView = findViewById(R.id.balochistan_province_top_restaurants);
        restaurantsRecyclerView.setVerticalScrollBarEnabled(false);
        restaurantsRecyclerView.setHorizontalScrollBarEnabled(false);
        restaurantsRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager restaurantsLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter restaurantsAdapter = new ProvinceAdapter(topRestaurantsList);

        restaurantsRecyclerView.setLayoutManager(restaurantsLayoutManager);
        restaurantsRecyclerView.setAdapter(restaurantsAdapter);


        ArrayList<Province> historicalPlaceList = new ArrayList<>();
        historicalPlaceList.add(new Province(R.drawable.quaide_azam_residency, R.string.balochistan_historical_place_one_title,
                R.string.balochistan_historical_place_one_description, R.string.balochistan_historical_place_one_rating,
                getResources().getString(R.string.balochistan_historical_place_one_review)));
        historicalPlaceList.add(new Province(R.drawable.princes_of_hope, R.string.balochistan_historical_place_two_title,
                R.string.balochistan_historical_place_two_description, R.string.balochistan_historical_place_two_rating,
                getResources().getString(R.string.balochistan_historical_place_two_review)));
        historicalPlaceList.add(new Province(R.drawable.kalat, R.string.balochistan_historical_place_three_title,
                R.string.balochistan_historical_place_three_description, R.string.balochistan_historical_place_three_rating,
                getResources().getString(R.string.balochistan_historical_place_three_review)));
        historicalPlaceList.add(new Province(R.drawable.gadani_beach, R.string.balochistan_historical_place_four_title,
                R.string.balochistan_historical_place_four_description, R.string.balochistan_historical_place_four_rating,
                getResources().getString(R.string.balochistan_historical_place_four_review)));
        historicalPlaceList.add(new Province(R.drawable.moola_chotok, R.string.balochistan_historical_place_five_title,
                R.string.balochistan_historical_place_five_description, R.string.balochistan_historical_place_five_rating,
                getResources().getString(R.string.balochistan_historical_place_five_review)));

        RecyclerView historicalPlaceRecyclerView = findViewById(R.id.balochistan_province_historical_place);
        historicalPlaceRecyclerView.setVerticalScrollBarEnabled(false);
        historicalPlaceRecyclerView.setHorizontalScrollBarEnabled(false);
        historicalPlaceRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager historicalPlaceLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter historicalPlaceAdapter = new ProvinceAdapter(historicalPlaceList);

        historicalPlaceRecyclerView.setLayoutManager(historicalPlaceLayoutManager);
        historicalPlaceRecyclerView.setAdapter(historicalPlaceAdapter);
    }
}