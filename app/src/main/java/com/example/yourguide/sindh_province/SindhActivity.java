package com.example.yourguide.sindh_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.yourguide.ImageGenerator;
import com.example.yourguide.Province;
import com.example.yourguide.ProvinceAdapter;
import com.example.yourguide.R;
import com.example.yourguide.province_cards_categories.HistoricalPlaceActivity;
import com.example.yourguide.province_cards_categories.PopularCityActivity;
import com.example.yourguide.province_cards_categories.TopRestaurantActivity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SindhActivity extends AppCompatActivity implements ImageGenerator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sindh);

        //Initializing the custom toolbar
        Toolbar customToolbar = findViewById(R.id.rounded_custom_toolbar);
        //Set the custom toolbar as the support action bar.
        setSupportActionBar(customToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        // Set a custom click listener for the back button
        ImageView backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(view -> {
            // Handle the back button click (e.g., navigate back)
            onBackPressed();
        });

        ImageView previewImage = findViewById(R.id.sindh_province_preview_image);
        previewImage.setImageResource(randomImageGenerator()); //displays random generated images.

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

        //This listener is triggered when the user clicks any of the popular cities in the Sindh province.
        citiesAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent popularCityIntent = new Intent(SindhActivity.this, PopularCityActivity.class);
                popularCityIntent.putExtra("city_thumbnail",
                        popularCitiesList.get(position).getCardImage()); //Passing city image.
                popularCityIntent.putExtra("city_name",
                        getResources().getString(popularCitiesList.get(position).getCardTitle())); //Passing city name.
                popularCityIntent.putExtra("city_rating",
                        getResources().getString(popularCitiesList.get(position).getCardRating())); //Passing city rating.
                popularCityIntent.putExtra("city_review",
                        popularCitiesList.get(position).getCardReview()); //Passing city review.
                startActivity(popularCityIntent); //Start the activity.

            }
        });


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

        //This listener is triggered when the user clicks any of the top restaurants in the Sindh province.
        restaurantsAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent topRestaurantsIntent = new Intent(SindhActivity.this, TopRestaurantActivity.class);
                topRestaurantsIntent.putExtra("restaurant_thumbnail_image",
                        topRestaurantsList.get(position).getCardImage()); //Passing in the restaurant thumbnail image.
                topRestaurantsIntent.putExtra("restaurant_name",
                        topRestaurantsList.get(position).getCardTitle()); //Passing in the restaurant name.
                topRestaurantsIntent.putExtra("restaurant_rating",
                        topRestaurantsList.get(position).getCardRating()); //Passing in the restaurant rating.
                topRestaurantsIntent.putExtra("restaurant_review",
                        topRestaurantsList.get(position).getCardReview()); //Passing in the restaurant review.
                startActivity(topRestaurantsIntent);
            }
        });


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

        //This listener is triggered when the user clicks any of the historical places in the Sindh province.
        historicalPlaceAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent historicalPlaceIntent = new Intent(SindhActivity.this, HistoricalPlaceActivity.class);
                historicalPlaceIntent.putExtra("historical_place_thumbnail_image",
                        historicalPlaceList.get(position).getCardImage()); //Passing historical place image.
                historicalPlaceIntent.putExtra("historical_place_title",
                        getResources().getString(historicalPlaceList.get(position).getCardTitle())); //Passing historical place title.
                historicalPlaceIntent.putExtra("historical_place_rating",
                        getResources().getString(historicalPlaceList.get(position).getCardRating())); //Passing historical place rating.
                historicalPlaceIntent.putExtra("historical_place_review",
                        historicalPlaceList.get(position).getCardReview()); //Passing historical place review.
                startActivity(historicalPlaceIntent);
            }
        });
    }

    /**
     * Generates random images and return their IDs.
     * @return image resource ID.
     */
    @Override
    public int randomImageGenerator() {
        Random random = new Random();

        return switch(random.nextInt(6)) {
            case 0 -> R.drawable.karachi_city;
            case 1 -> R.drawable.hyderabad_city;
            case 2 -> R.drawable.sukkur_city;
            case 3 -> R.drawable.thatta_city;
            case 4 -> R.drawable.sindh_province_header;
            default -> R.drawable.shikarpur_city;
        };
    }
}