package com.example.yourguide.sindh_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yourguide.Province;
import com.example.yourguide.ProvinceAdapter;
import com.example.yourguide.R;

import java.util.ArrayList;

public class SindhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sindh);

        ArrayList<Province> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new Province(R.drawable.karachi_city, R.string.sindh_city_one_title,
                R.string.sindh_city_one_description, R.string.sindh_city_one_rating, getResources().getString(R.string.sindh_city_one_review)));
        popularCitiesList.add(new Province(R.drawable.hyderabad_city, R.string.sindh_city_two_title,
                R.string.sindh_city_two_description, R.string.sindh_city_two_rating, getResources().getString(R.string.sindh_city_two_review)));
        popularCitiesList.add(new Province(R.drawable.sukkur_city, R.string.sindh_city_three_title,
                R.string.sindh_city_three_description, R.string.sindh_city_three_rating, getResources().getString(R.string.sindh_city_three_review)));
        popularCitiesList.add(new Province(R.drawable.thatta_city, R.string.sindh_city_four_title,
                R.string.sindh_city_four_description, R.string.sindh_city_four_rating, getResources().getString(R.string.sindh_city_four_review)));
        popularCitiesList.add(new Province(R.drawable.shikarpur_city, R.string.sindh_city_five_title,
                R.string.sindh_city_five_description, R.string.sindh_city_five_rating, getResources().getString(R.string.sindh_city_five_review)));

        RecyclerView citiesRecyclerView = findViewById(R.id.sindh_province_popular_city);
        citiesRecyclerView.setVerticalScrollBarEnabled(false);
        citiesRecyclerView.setHorizontalScrollBarEnabled(false);
        citiesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager citiesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter citiesAdapter = new ProvinceAdapter(popularCitiesList);

        citiesRecyclerView.setLayoutManager(citiesLayoutManager);
        citiesRecyclerView.setAdapter(citiesAdapter);


        ArrayList<Province> topRestaurantsList = new ArrayList<>();
        topRestaurantsList.add(new Province(R.drawable.royal_taj_restaurant, R.string.sindh_restaurant_one_title,
                R.string.sindh_restaurant_one_description, R.string.sindh_restaurant_one_rating, getResources().getString(R.string.sindh_restaurant_one_review)));
        topRestaurantsList.add(new Province(R.drawable.ridan_restaurant, R.string.sindh_restaurant_two_title,
                R.string.sindh_restaurant_two_description, R.string.sindh_restaurant_two_rating, getResources().getString(R.string.sindh_restaurant_two_review)));
        topRestaurantsList.add(new Province(R.drawable.lalqila_restaurant, R.string.sindh_restaurant_three_title,
                R.string.sindh_restaurant_three_description, R.string.sindh_restaurant_three_rating, getResources().getString(R.string.sindh_restaurant_three_review)));
        topRestaurantsList.add(new Province(R.drawable.chefs_table_restaurant, R.string.sindh_restaurant_four_title,
                R.string.sindh_restaurant_four_description, R.string.sindh_restaurant_four_rating, getResources().getString(R.string.sindh_restaurant_four_review)));
        topRestaurantsList.add(new Province(R.drawable.kababjees_restaurant, R.string.sindh_restaurant_five_title,
                R.string.sindh_restaurant_five_description, R.string.sindh_restaurant_five_rating, getResources().getString(R.string.sindh_restaurant_five_review)));

        RecyclerView restaurantsRecyclerView = findViewById(R.id.sindh_province_top_restaurant);
        restaurantsRecyclerView.setVerticalScrollBarEnabled(false);
        restaurantsRecyclerView.setHorizontalScrollBarEnabled(false);
        restaurantsRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager restaurantsLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter restaurantsAdapter = new ProvinceAdapter(topRestaurantsList);

        restaurantsRecyclerView.setLayoutManager(restaurantsLayoutManager);
        restaurantsRecyclerView.setAdapter(restaurantsAdapter);


        ArrayList<Province> historicalPlaceList = new ArrayList<>();
        historicalPlaceList.add(new Province(R.drawable.mohenjo_daro, R.string.sindh_historical_place_one_title,
                R.string.sindh_historical_place_one_description, R.string.sindh_historical_place_one_rating,
                getResources().getString(R.string.sindh_historical_place_one_review)));
        historicalPlaceList.add(new Province(R.drawable.makli_hill, R.string.sindh_historical_place_two_title,
                R.string.sindh_historical_place_two_description, R.string.sindh_historical_place_two_rating,
                getResources().getString(R.string.sindh_historical_place_two_review)));
        historicalPlaceList.add(new Province(R.drawable.shahjahan_mosque, R.string.sindh_historical_place_three_title,
                R.string.sindh_historical_place_three_description, R.string.sindh_historical_place_three_rating,
                getResources().getString(R.string.sindh_historical_place_three_review)));
        historicalPlaceList.add(new Province(R.drawable.ranikot_fort, R.string.sindh_historical_place_four_title,
                R.string.sindh_historical_place_four_description, R.string.sindh_historical_place_four_rating,
                getResources().getString(R.string.sindh_historical_place_four_review)));
        historicalPlaceList.add(new Province(R.drawable.tooba_mosque, R.string.sindh_historical_place_five_title,
                R.string.sindh_historical_place_five_description, R.string.sindh_historical_place_five_rating,
                getResources().getString(R.string.sindh_historical_place_five_review)));

        RecyclerView historicalPlaceRecyclerView = findViewById(R.id.sindh_province_historical_place);
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