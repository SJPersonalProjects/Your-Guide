package com.example.yourguide.kpk_province;

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

public class KPKActivity extends AppCompatActivity implements ImageGenerator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kpk);

        ImageView previewImage = findViewById(R.id.kpk_province_preview_image);
        previewImage.setImageResource(randomImageGenerator()); //previews the random generated images.

        //ArrayList that holds the data for "Popular City" in the Khyber Pakhtunkhwa Province.
        ArrayList<Province> popularCitiesList = new ArrayList<>();
        popularCitiesList.add(new Province(R.drawable.peshawar_city, R.string.kpk_city_one_title,
                R.string.kpk_city_one_description, R.string.kpk_city_one_rating, getResources().getString(R.string.kpk_city_one_review)));
        popularCitiesList.add(new Province(R.drawable.mardan_city, R.string.kpk_city_two_title,
                R.string.kpk_city_two_description, R.string.kpk_city_two_rating, getResources().getString(R.string.kpk_city_two_review)));
        popularCitiesList.add(new Province(R.drawable.mingora_city, R.string.kpk_city_three_title,
                R.string.kpk_city_three_description, R.string.kpk_city_three_rating, getResources().getString(R.string.kpk_city_three_review)));
        popularCitiesList.add(new Province(R.drawable.kohat_city, R.string.kpk_city_four_title,
                R.string.kpk_city_four_description, R.string.kpk_city_four_rating, getResources().getString(R.string.kpk_city_four_review)));
        popularCitiesList.add(new Province(R.drawable.abbottabad_city, R.string.kpk_city_five_title,
                R.string.kpk_city_five_description, R.string.kpk_city_five_rating, getResources().getString(R.string.kpk_city_five_review)));

        RecyclerView popularCitiesRecyclerView = findViewById(R.id.kpk_province_popular_city);
        popularCitiesRecyclerView.setVerticalScrollBarEnabled(false);
        popularCitiesRecyclerView.setHorizontalScrollBarEnabled(false);
        popularCitiesRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager citiesLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter citiesAdapter = new ProvinceAdapter(popularCitiesList);

        popularCitiesRecyclerView.setLayoutManager(citiesLayoutManager);
        popularCitiesRecyclerView.setAdapter(citiesAdapter);

        citiesAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent popularCitiesIntent = new Intent(KPKActivity.this, PopularCityActivity.class);
                popularCitiesIntent.putExtra("city_thumbnail",
                        popularCitiesList.get(position).getCardImage()); //Passing in the popular city card thumbnail image.
                popularCitiesIntent.putExtra("city_name",
                        getResources().getString(popularCitiesList.get(position).getCardTitle())); //Passing in the popular city card title.
                popularCitiesIntent.putExtra("city_rating",
                        getResources().getString(popularCitiesList.get(position).getCardRating())); //Passing in the popular city card rating.
                popularCitiesIntent.putExtra("city_review",
                        popularCitiesList.get(position).getCardReview()); //Passing in the popular city card review.
                startActivity(popularCitiesIntent); //Launch the popular city activity containing desired data.
            }
        });

        //ArrayList that holds the data for "Top Restaurant" in the Khyber Pakhtunkhwa Province.
        ArrayList<Province> topRestaurants = new ArrayList<>();
        topRestaurants.add(new Province(R.drawable.chief_burger_restaurant, R.string.kpk_restaurant_one_title,
                R.string.kpk_restaurant_one_description, R.string.kpk_restaurant_one_rating,
                getResources().getString(R.string.kpk_restaurant_one_review)));
        topRestaurants.add(new Province(R.drawable.cafe_crunch_restaurant, R.string.kpk_restaurant_two_title,
                R.string.kpk_restaurant_two_description, R.string.kpk_restaurant_two_rating,
                getResources().getString(R.string.kpk_restaurant_two_review)));
        topRestaurants.add(new Province(R.drawable.pinetree_restaurant, R.string.kpk_restaurant_three_title,
                R.string.kpk_restaurant_three_description, R.string.kpk_restaurant_three_rating,
                getResources().getString(R.string.kpk_restaurant_three_review)));
        topRestaurants.add(new Province(R.drawable.bukhara_rooftop_restaurant, R.string.kpk_restaurant_four_title,
                R.string.kpk_restaurant_four_description, R.string.kpk_restaurant_four_rating,
                getResources().getString(R.string.kpk_restaurant_four_review)));
        topRestaurants.add(new Province(R.drawable.swat_marina_restaurant, R.string.kpk_restaurant_five_title,
                R.string.kpk_restaurant_five_description, R.string.kpk_restaurant_five_rating,
                getResources().getString(R.string.kpk_restaurant_five_review)));

        RecyclerView restaurantsRecyclerView = findViewById(R.id.kpk_province_top_restaurant);
        restaurantsRecyclerView.setVerticalScrollBarEnabled(false);
        restaurantsRecyclerView.setHorizontalScrollBarEnabled(false);
        restaurantsRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager restaurantsLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter restaurantsAdapter = new ProvinceAdapter(topRestaurants);

        restaurantsRecyclerView.setLayoutManager(restaurantsLayoutManager);
        restaurantsRecyclerView.setAdapter(restaurantsAdapter);

        restaurantsAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent topRestaurantsIntent = new Intent(KPKActivity.this, TopRestaurantActivity.class);
                topRestaurantsIntent.putExtra("restaurant_thumbnail_image",
                        topRestaurants.get(position).getCardImage()); //Passing in the top restaurant card thumbnail image.
                topRestaurantsIntent.putExtra("restaurant_name",
                        topRestaurants.get(position).getCardTitle()); //Passing in the top restaurant card title.
                topRestaurantsIntent.putExtra("restaurant_rating",
                        topRestaurants.get(position).getCardRating()); //Passing in the top restaurant card rating.
                topRestaurantsIntent.putExtra("restaurant_review",
                        topRestaurants.get(position).getCardReview()); //Passing in the top restaurant card review.
                startActivity(topRestaurantsIntent); //Launch the top restaurant activity containing desired data.
            }
        });

        //ArrayList that holds the data for "Historical Place" in the Khyber Pakhtunkhwa Province.
        ArrayList<Province> historicalPlaceList = new ArrayList<>();
        historicalPlaceList.add(new Province(R.drawable.chitral_fort, R.string.kpk_historical_place_one_title,
                R.string.kpk_historical_place_one_description, R.string.kpk_historical_place_one_rating,
                getResources().getString(R.string.kpk_historical_place_one_review)));
        historicalPlaceList.add(new Province(R.drawable.takhti_bahi, R.string.kpk_historical_place_two_title,
                R.string.kpk_historical_place_two_description, R.string.kpk_historical_place_two_rating,
                getResources().getString(R.string.kpk_historical_place_two_review)));
        historicalPlaceList.add(new Province(R.drawable.mahabat_khan_mosque, R.string.kpk_historical_place_three_title,
                R.string.kpk_historical_place_three_description, R.string.kpk_historical_place_three_rating,
                getResources().getString(R.string.kpk_historical_place_three_review)));
        historicalPlaceList.add(new Province(R.drawable.jamrud_fort, R.string.kpk_historical_place_four_title,
                R.string.kpk_historical_place_four_description, R.string.kpk_historical_place_four_rating,
                getResources().getString(R.string.kpk_historical_place_four_review)));
        historicalPlaceList.add(new Province(R.drawable.st_johns_church, R.string.kpk_historical_place_five_title,
                R.string.kpk_historical_place_five_description, R.string.kpk_historical_place_five_rating,
                getResources().getString(R.string.kpk_historical_place_five_review)));

        RecyclerView historicalPlaceRecyclerView = findViewById(R.id.kpk_province_historical_place);
        historicalPlaceRecyclerView.setVerticalScrollBarEnabled(false);
        historicalPlaceRecyclerView.setHorizontalScrollBarEnabled(false);
        historicalPlaceRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager historicalPlaceLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        ProvinceAdapter historicalPlaceAdapter = new ProvinceAdapter(historicalPlaceList);

        historicalPlaceRecyclerView.setLayoutManager(historicalPlaceLayoutManager);
        historicalPlaceRecyclerView.setAdapter(historicalPlaceAdapter);

        historicalPlaceAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent historicalPlaceIntent = new Intent(KPKActivity.this, HistoricalPlaceActivity.class);
                historicalPlaceIntent.putExtra("historical_place_thumbnail_image",
                        historicalPlaceList.get(position).getCardImage()); //Passing in the historical place card thumbnail image.
                historicalPlaceIntent.putExtra("historical_place_title",
                        getResources().getString(historicalPlaceList.get(position).getCardTitle())); //Passing in the historical place card title.
                historicalPlaceIntent.putExtra("historical_place_rating",
                        getResources().getString(historicalPlaceList.get(position).getCardRating())); //Passing in the historical place card rating.
                historicalPlaceIntent.putExtra("historical_place_review",
                        historicalPlaceList.get(position).getCardReview()); //Passing in the historical place card review.
                startActivity(historicalPlaceIntent); //Launch the historical place activity containing desired data.
            }
        });
    }

    /**
     * Generates random images and returns their ID.
     * @return image resource ID.
     */
    @Override
    public int randomImageGenerator() {
        Random random = new Random();

        return switch(random.nextInt(6)) {
            case 0 -> R.drawable.peshawar_city;
            case 1 -> R.drawable.mardan_city;
            case 2 -> R.drawable.mingora_city;
            case 3 -> R.drawable.kohat_city;
            case 4 -> R.drawable.kpk_province_header;
            default -> R.drawable.abbottabad_city;
        };
    }
}