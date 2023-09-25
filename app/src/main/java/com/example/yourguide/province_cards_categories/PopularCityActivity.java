package com.example.yourguide.province_cards_categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourguide.Formatter;
import com.example.yourguide.Map;
import com.example.yourguide.MapActivity;
import com.example.yourguide.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PopularCityActivity extends AppCompatActivity implements Formatter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_city);

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

        //Finding views by their IDs to use their reference and set values.
        ImageView cityPreviewImage = findViewById(R.id.city_preview_image); //Image at the top.

        TextView cityNameTextView = findViewById(R.id.city_name); //City name.

        TextView citySubNameTextView = findViewById(R.id.city_sub_heading); //City name sub heading.
        citySubNameTextView.setText(subHeadingFormatter()); //Here the default method is implemented.

        TextView cityAddressTextView = findViewById(R.id.city_address); //City address.

        TextView cityDescriptionTextView = findViewById(R.id.city_description); //City description.

        TextView cityRatingTextView = findViewById(R.id.city_rating); //City rating.

        TextView cityReviewTextView = findViewById(R.id.city_review); //City review.

        ImageView popularCityIconOne = findViewById(R.id.icon_one); //City icon one.
        popularCityIconOne.setImageResource(R.drawable.car);
        TextView popularCityIconOneTitle = findViewById(R.id.icon_one_title); //City icon text one.
        popularCityIconOneTitle.setText(R.string.popular_city_icon_text_one);

        ImageView popularCityIconTwo = findViewById(R.id.icon_two); //City icon two.
        popularCityIconTwo.setImageResource(R.drawable.airplane);
        TextView popularCityIconTwoTitle = findViewById(R.id.icon_two_title); //City icon text two.
        popularCityIconTwoTitle.setText(R.string.popular_city_icon_text_two);

        ImageView popularCityIconThree = findViewById(R.id.icon_three); //City icon three.
        popularCityIconThree.setImageResource(R.drawable.cafe);
        TextView popularCityIconThreeTitle = findViewById(R.id.icon_three_title); //City icon text three.
        popularCityIconThreeTitle.setText(R.string.popular_city_icon_text_three);

        ImageView popularCityIconFour = findViewById(R.id.icon_four); //City icon four.
        popularCityIconFour.setImageResource(R.drawable.hotel);
        TextView popularCityIconFourTitle = findViewById(R.id.icon_four_title); //City icon text four.
        popularCityIconFourTitle.setText(R.string.popular_city_icon_text_four);




        Bundle extras = getIntent().getExtras();
        String cityName = "";
        //Checks if extras is empty.
        if(extras != null) {
            int cityImage = extras.getInt("city_thumbnail");
            cityName = extras.getString("city_name");
            String cityRating = extras.getString("city_rating");
            String cityReview = extras.getString("city_review");

            cityNameTextView.setText(cityName);
            //city description is set using the name of the city.
            cityDescriptionTextView.setText(getDescription(cityName));
            cityAddressTextView.setText(getLocation(cityName));
            cityRatingTextView.setText(cityRating);
            cityReviewTextView.setText(reviewFormatter(cityReview)); //Here's the default method implementation.
            cityPreviewImage.setImageResource(cityImage);
        }

        LinearLayout carLinearLayout = findViewById(R.id.car_linear_layout);
        /*
            This listener gets triggered when car icon in the PopularCityActivity
            is clicked.
         */
        carLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopularCityActivity.this,
                        "No car is available for booking right now", Toast.LENGTH_SHORT).show();
            }
        });

        /*
            This listener gets triggered when the travel icon in the PopularCityActivity
            is clicked.
         */
        LinearLayout travelLinearLayout = findViewById(R.id.travel_linear_layout);
        travelLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopularCityActivity.this, "No packages available for traveling right now", Toast.LENGTH_SHORT).show();
            }
        });

        /*
            This listener gets triggered when the food icon in the PopularCityActivity
            is clicked.
         */
        LinearLayout foodLinearLayout = findViewById(R.id.food_linear_layout);
        foodLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopularCityActivity.this, "No reservations on restaurants are available right now",
                        Toast.LENGTH_SHORT).show();
            }
        });

        /*
            This listener gets triggered when the hotel icon in the PopularCityActivity
            is clicked.
         */
        LinearLayout hotelLinearLayout = findViewById(R.id.hotel_linear_layout);
        hotelLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PopularCityActivity.this, "No reservations on hotels are available right now",
                        Toast.LENGTH_SHORT).show();
            }
        });

        List<Map> popularCityCoordinatesList = new ArrayList<>();
        //Adding punjab province city coordinates.
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.punjab_city_one_latitude),
                getResources().getString(R.string.punjab_city_one_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.punjab_city_two_latitude),
                getResources().getString(R.string.punjab_city_two_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.punjab_city_three_latitude),
                getResources().getString(R.string.punjab_city_three_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.punjab_city_four_latitude),
                getResources().getString(R.string.punjab_city_four_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.punjab_city_five_latitude),
                getResources().getString(R.string.punjab_city_five_longitude)));
        //Adding sindh province city coordinates.
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.sindh_city_one_latitude),
                getResources().getString(R.string.sindh_city_one_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.sindh_city_two_latitude),
                getResources().getString(R.string.sindh_city_two_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.sindh_city_three_latitude),
                getResources().getString(R.string.sindh_city_three_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.sindh_city_four_latitude),
                getResources().getString(R.string.sindh_city_four_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.sindh_city_five_latitude),
                getResources().getString(R.string.sindh_city_five_longitude)));
        //Adding balochistan province city coordinates.
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_city_one_latitude),
                getResources().getString(R.string.balochistan_city_one_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_city_two_latitude),
                getResources().getString(R.string.balochistan_city_two_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_city_three_latitude),
                getResources().getString(R.string.balochistan_city_three_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_city_four_latitude),
                getResources().getString(R.string.balochistan_city_four_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_city_five_latitude),
                getResources().getString(R.string.balochistan_city_five_longitude)));
        //Adding kpk province city coordinates.
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.kpk_city_one_latitude),
                getResources().getString(R.string.kpk_city_one_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.kpk_city_two_latitude),
                getResources().getString(R.string.kpk_city_two_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.kpk_city_three_latitude),
                getResources().getString(R.string.kpk_city_three_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.kpk_city_four_latitude),
                getResources().getString(R.string.kpk_city_four_longitude)));
        popularCityCoordinatesList.add(new Map(getResources().getString(R.string.kpk_city_five_latitude),
                getResources().getString(R.string.kpk_city_five_longitude)));

        //Finding the button with its id.
        Button seeTheLocationButton = (Button) findViewById(R.id.city_see_the_location_button);
        /*
            This listener is triggered when "see the location" button is clicked
            in the popular city activity from any province.
         */
        String finalCityName = cityName;
        seeTheLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String latitudeAndLongitude = getLatitudeLongitude(finalCityName, popularCityCoordinatesList);
                //Checks if string is null. Make show toast, otherwise run intent.
                if(latitudeAndLongitude == null) {
                    Toast.makeText(PopularCityActivity.this, "coordinates not found", Toast.LENGTH_SHORT).show();
                }else {
                    String[] coordinatesArray = latitudeAndLongitude.split(",");
                    String latitude = coordinatesArray[0].trim();
                    String longitude = coordinatesArray[1].trim();

                    Intent mapsIntent = new Intent(PopularCityActivity.this, MapActivity.class);
                    mapsIntent.putExtra("latitude", latitude);
                    mapsIntent.putExtra("longitude", longitude);
                    startActivity(mapsIntent);
                }
            }
        });
    }


    @Override
    public String getLatitudeLongitude(String cityName, List<Map> popularCityCoordinates) {
        return switch(cityName) {
            //Punjab province city latitude and longitude.
            case "Lahore" -> popularCityCoordinates.get(0).getLatitude() + ", " +
                    popularCityCoordinates.get(0).getLongitude();
            case "Faisalabad" -> popularCityCoordinates.get(1).getLatitude() + ", " +
                    popularCityCoordinates.get(1).getLongitude();
            case "Rawalpindi" -> popularCityCoordinates.get(2).getLatitude() + ", " +
                    popularCityCoordinates.get(2).getLongitude();
            case "Multan" -> popularCityCoordinates.get(3).getLatitude() + ", " +
                    popularCityCoordinates.get(3).getLongitude();
            case "Gujranwala" -> popularCityCoordinates.get(4).getLatitude() + ", " +
                    popularCityCoordinates.get(4).getLongitude();

            //Sindh province city latitude and longitude.
            case "Karachi" -> popularCityCoordinates.get(5).getLatitude() + ", " +
                    popularCityCoordinates.get(5).getLongitude();
            case "Hyderabad" -> popularCityCoordinates.get(6).getLatitude() + ", " +
                    popularCityCoordinates.get(6).getLongitude();
            case "Sukkur" -> popularCityCoordinates.get(7).getLatitude() + ", " +
                    popularCityCoordinates.get(7).getLongitude();
            case "Thatta" -> popularCityCoordinates.get(8).getLatitude() + ", " +
                    popularCityCoordinates.get(8).getLongitude();
            case "Shikarpur" -> popularCityCoordinates.get(9).getLatitude() + ", " +
                    popularCityCoordinates.get(9).getLongitude();

            //Balochistan province city latitude and longitude.
            case "Quetta" -> popularCityCoordinates.get(10).getLatitude() + ", " +
                    popularCityCoordinates.get(10).getLongitude();
            case "Gwadar" -> popularCityCoordinates.get(11).getLatitude() + ", " +
                    popularCityCoordinates.get(11).getLongitude();
            case "Chaman" -> popularCityCoordinates.get(12).getLatitude() + ", " +
                    popularCityCoordinates.get(12).getLongitude();
            case "Sibi" -> popularCityCoordinates.get(13).getLatitude() + ", " +
                    popularCityCoordinates.get(13).getLongitude();
            case "Hub" -> popularCityCoordinates.get(14).getLatitude() + ", " +
                    popularCityCoordinates.get(14).getLongitude();

            //KPK province city latitude and longitude.
            case "Peshawar" -> popularCityCoordinates.get(15).getLatitude() + ", " +
                    popularCityCoordinates.get(15).getLongitude();
            case "Mardan" -> popularCityCoordinates.get(16).getLatitude() + ", " +
                    popularCityCoordinates.get(16).getLongitude();
            case "Mingora" -> popularCityCoordinates.get(17).getLatitude() + ", " +
                    popularCityCoordinates.get(17).getLongitude();
            case "Kohat" -> popularCityCoordinates.get(18).getLatitude() + ", " +
                    popularCityCoordinates.get(18).getLongitude();
            case "Abbottabad" -> popularCityCoordinates.get(19).getLatitude() + ", " +
                    popularCityCoordinates.get(19).getLongitude();

            default -> null;
        };
    }


    /**
     * Gets location based on the city name clicked by the user.
     * @param name is the name of the city clicked by the user available in the list.
     * @return address
     */
    @Override
    public String getLocation(String name) {
        return switch (name) {
            //Punjab province popular city cards addresses.
            case "Lahore" -> getResources().getString(R.string.punjab_city_one_address);
            case "Faisalabad" -> getResources().getString(R.string.punjab_city_two_address);
            case "Rawalpindi" -> getResources().getString(R.string.punjab_city_three_address);
            case "Multan" -> getResources().getString(R.string.punjab_city_four_address);
            case "Gujranwala" -> getResources().getString(R.string.punjab_city_five_address);

            //Sindh province popular city cards addresses.
            case "Karachi" -> getResources().getString(R.string.sindh_city_one_address);
            case "Hyderabad" -> getResources().getString(R.string.sindh_city_two_address);
            case "Sukkur" -> getResources().getString(R.string.sindh_city_three_address);
            case "Thatta" -> getResources().getString(R.string.sindh_city_four_address);
            case "Shikarpur" -> getResources().getString(R.string.sindh_city_five_address);

            //Balochistan province popular city cards address.
            case "Quetta" -> getResources().getString(R.string.balochistan_city_one_address);
            case "Gwadar" -> getResources().getString(R.string.balochistan_city_two_address);
            case "Chaman" -> getResources().getString(R.string.balochistan_city_three_address);
            case "Sibi" -> getResources().getString(R.string.balochistan_city_four_address);
            case "Hub" -> getResources().getString(R.string.balochistan_city_five_address);

            //KPK province popular city cards address.
            case "Peshawar" -> getResources().getString(R.string.kpk_city_one_address);
            case "Mardan" -> getResources().getString(R.string.kpk_city_two_address);
            case "Mingora" -> getResources().getString(R.string.kpk_city_three_address);
            case "Kohat" -> getResources().getString(R.string.kpk_city_four_address);
            case "Abbottabad" -> getResources().getString(R.string.kpk_city_five_address);

            default -> "Address not found";
        };
    }

    /**
     * Gets the long description based on the city name clicked by the user.
     * @param name is the name of the city clicked by the user available in the list.
     * @return a string of long city description.
     */
    @Override
    public String getDescription(String name) {
        return switch (name) {
            //Punjab province popular city cards descriptions.
            case "Lahore" -> getResources().getString(R.string.punjab_city_one_description);
            case "Faisalabad" -> getResources().getString(R.string.punjab_city_two_description);
            case "Rawalpindi" -> getResources().getString(R.string.punjab_city_three_description);
            case "Multan" -> getResources().getString(R.string.punjab_city_four_description);
            case "Gujranwala" -> getResources().getString(R.string.punjab_city_five_description);

            //Sindh province popular city cards descriptions.
            case "Karachi" -> getResources().getString(R.string.sindh_city_one_description);
            case "Hyderabad" -> getResources().getString(R.string.sindh_city_two_description);
            case "Sukkur" -> getResources().getString(R.string.sindh_city_three_description);
            case "Thatta" -> getResources().getString(R.string.sindh_city_four_description);
            case "Shikarpur" -> getResources().getString(R.string.sindh_city_five_description);

            //Balochistan province popular city cards descriptions.
            case "Quetta" -> getResources().getString(R.string.balochistan_city_one_description);
            case "Gwadar" -> getResources().getString(R.string.balochistan_city_two_description);
            case "Chaman" -> getResources().getString(R.string.balochistan_city_three_description);
            case "Sibi" -> getResources().getString(R.string.balochistan_city_four_description);
            case "Hub" -> getResources().getString(R.string.balochistan_city_five_description);

            //KPK province popular city cards descriptions.
            case "Peshawar" -> getResources().getString(R.string.kpk_city_one_description);
            case "Mardan" -> getResources().getString(R.string.kpk_city_two_description);
            case "Mingora" -> getResources().getString(R.string.kpk_city_three_description);
            case "Kohat" -> getResources().getString(R.string.kpk_city_four_description);
            case "Abbottabad" -> getResources().getString(R.string.kpk_city_five_description);

            default -> "Description not found";
        };
    }

}