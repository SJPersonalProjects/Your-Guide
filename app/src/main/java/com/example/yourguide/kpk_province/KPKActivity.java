package com.example.yourguide.kpk_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yourguide.Province;
import com.example.yourguide.ProvinceAdapter;
import com.example.yourguide.R;

import java.util.ArrayList;

public class KPKActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpkactivity);

        ArrayList<Province> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_city_one_title,
                R.string.kpk_city_one_description, R.string.kpk_city_one_rating, R.string.kpk_city_one_review));
        popularCitiesList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_city_two_title,
                R.string.kpk_city_two_description, R.string.kpk_city_two_rating, R.string.kpk_city_two_review));
        popularCitiesList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_city_three_title,
                R.string.kpk_city_three_description, R.string.kpk_city_three_rating, R.string.kpk_city_three_review));
        popularCitiesList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_city_four_title,
                R.string.kpk_city_four_description, R.string.kpk_city_four_rating, R.string.kpk_city_four_review));
        popularCitiesList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_city_five_title,
                R.string.kpk_city_five_description, R.string.kpk_city_five_rating, R.string.kpk_city_five_review));

        RecyclerView popularCitiesRecyclerView = findViewById(R.id.kpk_province_popular_city);
        popularCitiesRecyclerView.setVerticalScrollBarEnabled(false);
        popularCitiesRecyclerView.setHorizontalScrollBarEnabled(false);
        popularCitiesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager citiesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter citiesAdapter = new ProvinceAdapter(popularCitiesList);

        popularCitiesRecyclerView.setLayoutManager(citiesLayoutManager);
        popularCitiesRecyclerView.setAdapter(citiesAdapter);


        ArrayList<Province> topRestaurants = new ArrayList<>();
        topRestaurants.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_restaurant_one_title,
                R.string.kpk_restaurant_one_description, R.string.kpk_restaurant_one_rating,
                R.string.kpk_restaurant_one_review));
        topRestaurants.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_restaurant_two_title,
                R.string.kpk_restaurant_two_description, R.string.kpk_restaurant_two_rating,
                R.string.kpk_restaurant_two_review));
        topRestaurants.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_restaurant_three_title,
                R.string.kpk_restaurant_three_description, R.string.kpk_restaurant_three_rating,
                R.string.kpk_restaurant_three_review));
        topRestaurants.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_restaurant_four_title,
                R.string.kpk_restaurant_four_description, R.string.kpk_restaurant_four_rating,
                R.string.kpk_restaurant_four_review));
        topRestaurants.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_restaurant_five_title,
                R.string.kpk_restaurant_five_description, R.string.kpk_restaurant_five_rating,
                R.string.kpk_restaurant_five_review));

        RecyclerView restaurantsRecyclerView = findViewById(R.id.kpk_province_top_restaurant);
        restaurantsRecyclerView.setVerticalScrollBarEnabled(false);
        restaurantsRecyclerView.setHorizontalScrollBarEnabled(false);
        restaurantsRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager restaurantsLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter restaurantsAdapter = new ProvinceAdapter(topRestaurants);

        restaurantsRecyclerView.setLayoutManager(restaurantsLayoutManager);
        restaurantsRecyclerView.setAdapter(restaurantsAdapter);


        ArrayList<Province> historicalPlaceList = new ArrayList<>();
        historicalPlaceList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_historical_place_one_title,
                R.string.kpk_historical_place_one_description, R.string.kpk_historical_place_one_rating,
                R.string.kpk_historical_place_one_review));
        historicalPlaceList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_historical_place_two_title,
                R.string.kpk_historical_place_two_description, R.string.kpk_historical_place_two_rating,
                R.string.kpk_historical_place_two_review));
        historicalPlaceList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_historical_place_three_title,
                R.string.kpk_historical_place_three_description, R.string.kpk_historical_place_three_rating,
                R.string.kpk_historical_place_three_review));
        historicalPlaceList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_historical_place_four_title,
                R.string.kpk_historical_place_four_description, R.string.kpk_historical_place_four_rating,
                R.string.kpk_historical_place_four_review));
        historicalPlaceList.add(new Province(R.drawable.ic_launcher_background, R.string.kpk_historical_place_five_title,
                R.string.kpk_historical_place_five_description, R.string.kpk_historical_place_five_rating,
                R.string.kpk_historical_place_five_review));

        RecyclerView historicalPlaceRecyclerView = findViewById(R.id.kpk_province_historical_place);
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