package com.example.yourguide.province_cards_categories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourguide.Formatter;
import com.example.yourguide.R;

public class PopularCityActivity extends AppCompatActivity implements Formatter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_city);

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
        //Checks if extras is empty.
        if(extras != null) {
            int cityImage = extras.getInt("city_thumbnail");
            String cityName = extras.getString("city_name");
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
    }

    /**
     * Gets location based on the city name clicked by the user.
     * @param cityName is the name of the city clicked by the user available in the list.
     * @return a string of city address on the globe.
     */
    private String getLocation(String cityName) {
        switch(cityName) {
            case "Lahore" :
                return getResources().getString(R.string.lahore_city_address);
            case "Faisalabad" :
                return getResources().getString(R.string.faisalabad_city_address);
            case "Rawalpindi" :
                return getResources().getString(R.string.rawalpindi_city_address);
            case "Multan" :
                return getResources().getString(R.string.multan_city_address);
            case "Gujranwala" :
                return getResources().getString(R.string.gujranwala_city_address);
        }
        return "";
    }

    /**
     * Gets the long description based on the city name clicked by the user.
     * @param cityName is the name of the city clicked by the user available in the list.
     * @return a string of long city description.
     */
    private String getDescription(String cityName) {
        switch (cityName) {
            case "Lahore" :
                return getResources().getString(R.string.lahore_city_long_description);
            case "Faisalabad" :
                return getResources().getString(R.string.faisalabad_city_long_description);
            case "Rawalpindi" :
                return getResources().getString(R.string.rawalpindi_city_long_description);
            case "Multan" :
                return getResources().getString(R.string.multan_city_long_description);
            case "Gujranwala" :
                return getResources().getString(R.string.gujranwala_city_long_description);
        }
        return null;
    }
}