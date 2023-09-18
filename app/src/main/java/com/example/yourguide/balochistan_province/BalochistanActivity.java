package com.example.yourguide.balochistan_province;

import androidx.appcompat.app.AppCompatActivity;
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
import java.util.Random;

public class BalochistanActivity extends AppCompatActivity implements ImageGenerator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balochistan);

        //Image to display at the top of the balochistan activity.
        ImageView previewImage = findViewById(R.id.balochistan_province_preview_image);
        previewImage.setImageResource(randomImageGenerator()); //Generates and sets the random image.

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

        //This listener gets triggered when the user clicks any of the popular cities in the balochistan province.
        citiesAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent popularCitiesIntent = new Intent(BalochistanActivity.this, PopularCityActivity.class);
                popularCitiesIntent.putExtra("city_thumbnail",
                        popularCitiesList.get(position).getCardImage()); //Passing in the popular city thumbnail image.
                popularCitiesIntent.putExtra("city_name",
                        getResources().getString(popularCitiesList.get(position).getCardTitle())); //Passing in the city name.
                popularCitiesIntent.putExtra("city_rating",
                        getResources().getString(popularCitiesList.get(position).getCardRating())); //Passing in the city rating.
                popularCitiesIntent.putExtra("city_review",
                        popularCitiesList.get(position).getCardReview()); //Passing in the city review.
                startActivity(popularCitiesIntent); //Launch the PopularCityActivity containing desired data.
            }
        });


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

        //This listener gets triggered when the user clicks any of the top restaurants in the balochistan province.
        restaurantsAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent topRestaurantIntent = new Intent(BalochistanActivity.this, TopRestaurantActivity.class);
                topRestaurantIntent.putExtra("restaurant_thumbnail_image",
                        topRestaurantsList.get(position).getCardImage()); //Passing in the restaurant thumbnail image.
                topRestaurantIntent.putExtra("restaurant_name",
                        topRestaurantsList.get(position).getCardTitle()); //Passing in the restaurant title.
                topRestaurantIntent.putExtra("restaurant_rating",
                        topRestaurantsList.get(position).getCardRating()); //Passing in the restaurant ratings.
                topRestaurantIntent.putExtra("restaurant_review",
                        topRestaurantsList.get(position).getCardReview()); //Passing in the restaurant reviews.
                startActivity(topRestaurantIntent); //Launch the restaurants activity containing the desired data.
            }
        });


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

        //This listener gets triggered when the user clicks any of the historical places in Balochistan province.
        historicalPlaceAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent historicalPlaceIntent = new Intent(BalochistanActivity.this, HistoricalPlaceActivity.class);
                historicalPlaceIntent.putExtra("historical_place_thumbnail_image",
                        historicalPlaceList.get(position).getCardImage()); //Passing in the historical place image.
                historicalPlaceIntent.putExtra("historical_place_title",
                        getResources().getString(historicalPlaceList.get(position).getCardTitle())); //Passing in the historical place title.
                historicalPlaceIntent.putExtra("historical_place_rating",
                        getResources().getString(historicalPlaceList.get(position).getCardRating())); //Passing in the historical place ratings.
                historicalPlaceIntent.putExtra("historical_place_review",
                        historicalPlaceList.get(position).getCardReview()); //Passing in the historical places reviews.
                startActivity(historicalPlaceIntent); //Launch the historical place activity containing desired data.
            }
        });
    }

    /**
     * Generates random image and returns their ID.
     * @return image resource ID.
     */
    @Override
    public int randomImageGenerator() {
        Random random = new Random();

        return switch(random.nextInt(6)) {
            case 0 -> R.drawable.quetta_city;
            case 1 -> R.drawable.gwadar_city;
            case 2 -> R.drawable.chaman_city;
            case 3 -> R.drawable.sibi_city;
            case 4 -> R.drawable.balochistan_province_header;
            default -> R.drawable.hub_city;
        };
    }
}