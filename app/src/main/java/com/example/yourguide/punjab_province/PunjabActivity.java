package com.example.yourguide.punjab_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.yourguide.Province;
import com.example.yourguide.ProvinceAdapter;
import com.example.yourguide.R;
import com.example.yourguide.province_cards_categories.HistoricalPlaceActivity;
import com.example.yourguide.province_cards_categories.PopularCityActivity;
import com.example.yourguide.province_cards_categories.TopRestaurantActivity;

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

        //This interface is triggered when any of the cities is clicked by the user.
        adapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Intent to start another activity and passing data to display more information about cities.
                Intent lahoreCityIntent = new Intent(PunjabActivity.this, PopularCityActivity.class);
                lahoreCityIntent.putExtra("city_thumbnail", popularCitiesList
                        .get(position).getCardImage()); //passing city image
                lahoreCityIntent.putExtra("city_name", getResources()
                        .getString(popularCitiesList.get(position).getCardTitle())); //passing city name
                lahoreCityIntent.putExtra("city_rating", getResources()
                        .getString(popularCitiesList.get(position).getCardRating())); //passing city rating
                lahoreCityIntent.putExtra("city_review", popularCitiesList //passing city review
                        .get(position).getCardReview());
                startActivity(lahoreCityIntent); //Start LahoreCityActivity.
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

        //This listener gets triggered when the restaurants cards is clicked in PunjabActivity.
        restaurantsAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Intent to start another activity and passing some data along with intent to display it as details.
                Intent restaurantsIntent = new Intent(PunjabActivity.this, TopRestaurantActivity.class);
                restaurantsIntent.putExtra("restaurant_thumbnail_image",
                        topRestaurantList.get(position).getCardImage()); //Passing image for preview.
                restaurantsIntent.putExtra("restaurant_name",
                        topRestaurantList.get(position).getCardTitle()); //Passing restaurant name.
                restaurantsIntent.putExtra("restaurant_rating",
                        topRestaurantList.get(position).getCardRating()); //Passing restaurant rating.
                restaurantsIntent.putExtra("restaurant_review",
                        topRestaurantList.get(position).getCardReview()); //Passing restaurant review.
                startActivity(restaurantsIntent); //start TopRestaurantActivity.

                Toast.makeText(PunjabActivity.this,
                        getResources().getString(topRestaurantList.get(position).getCardTitle()) +
                                " is clicked", Toast.LENGTH_SHORT).show();
            }
        });


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

        //This listener gets triggered when the historical places card is clicked in PunjabActivity.
        historicalPlacesAdapter.setOnItemClickListener(new ProvinceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(PunjabActivity.this,
                        getResources().getString(historicalPlacesList.get(position).getCardTitle()) + " is clicked", Toast.LENGTH_SHORT).show();
                Intent historicalPlace = new Intent(PunjabActivity.this, HistoricalPlaceActivity.class);
                startActivity(historicalPlace); //Start the activity by displaying data on device.
            }
        });
    }
}