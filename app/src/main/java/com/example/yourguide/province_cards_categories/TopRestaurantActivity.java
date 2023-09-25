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

public class TopRestaurantActivity extends AppCompatActivity implements Formatter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_restaurant);

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

        //Finding views by their IDs to use their references and set values.
        ImageView restaurantPreviewImage = findViewById(R.id.restaurant_preview_image);

        //Restaurant name.
        TextView restaurantName = findViewById(R.id.restaurant_name);

        //Restaurant long description.
        TextView restaurantLongDescription = findViewById(R.id.restaurant_long_description);

        //Restaurant advertising phrases.
        TextView restaurantAdvertisingPhrase = findViewById(R.id.restaurant_advertising_phrase);
        restaurantAdvertisingPhrase.setText(subHeadingFormatter()); //Default method is implemented.

        //Restaurant reviews.
        TextView restaurantReview = findViewById(R.id.restaurant_review);

        //Restaurant rating.
        TextView restaurantRating = findViewById(R.id.restaurant_rating);

        //Restaurant address.
        TextView restaurantAddress = findViewById(R.id.restaurant_address);

        //Restaurant icons and their titles.
        ImageView restaurantIconOne = findViewById(R.id.icon_one); //Icon one.
        restaurantIconOne.setImageResource(R.drawable.delivery);
        TextView restaurantIconOneTitle = findViewById(R.id.icon_one_title); //Icon title one.
        restaurantIconOneTitle.setText(R.string.top_restaurant_icon_text_one);

        ImageView restaurantIconTwo = findViewById(R.id.icon_two); //Icon two.
        restaurantIconTwo.setImageResource(R.drawable.pick_up);
        TextView restaurantIconTwoTitle = findViewById(R.id.icon_two_title); //Icon title two.
        restaurantIconTwoTitle.setText(R.string.top_restaurant_icon_text_two);

        ImageView restaurantIconThree = findViewById(R.id.icon_three); //Icon three.
        restaurantIconThree.setImageResource(R.drawable.dine_in);
        TextView restaurantIconThreeTitle = findViewById(R.id.icon_three_title); //Icon title three.
        restaurantIconThreeTitle.setText(R.string.top_restaurant_icon_text_three);

        ImageView restaurantIconFour = findViewById(R.id.icon_four); //Icon four.
        restaurantIconFour.setImageResource(R.drawable.dine_out);
        TextView restaurantIconFourTitle = findViewById(R.id.icon_four_title); //Icon title four.
        restaurantIconFourTitle.setText(R.string.top_restaurant_icon_text_four);

        Bundle extras = getIntent().getExtras();
        int restaurantNameString = 0;
        //Checks if extras is empty.
        if(extras != null) {
            int restaurantImage = extras.getInt("restaurant_thumbnail_image");
            restaurantNameString = extras.getInt("restaurant_name");
            int restaurantRatingString = extras.getInt("restaurant_rating");
            String restaurantReviewString = extras.getString("restaurant_review");

            restaurantPreviewImage.setImageResource(restaurantImage);
            restaurantName.setText(restaurantNameString);
            restaurantLongDescription.setText(getDescription(getResources().getString(restaurantNameString)));
            restaurantAddress.setText(getLocation(getResources().getString(restaurantNameString)));
            restaurantRating.setText(restaurantRatingString);
            restaurantReview.setText(reviewFormatter(restaurantReviewString));
        }

        //Find the button ID and storing it's reference in bookATableButton variable.
        //And setting a click listener on it.
        Button bookATableButton = findViewById(R.id.book_a_table_button); //Button for booking table.
        bookATableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopRestaurantActivity.this,
                        "No tables are available for reservation these days", Toast.LENGTH_SHORT).show();
            }
        });


        //Deliver icon and text LinearLayout.
        LinearLayout deliverLinearLayout = findViewById(R.id.deliver_linear_layout);

        /**
         * This listener gets triggered when the deliver option is clicked
         * by the user.
         */
        deliverLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopRestaurantActivity.this,
                        "No delivery available right now", Toast.LENGTH_SHORT).show();
            }
        });

        //Pick-up icon and text LinearLayout.
        LinearLayout pickupLinearLayout = findViewById(R.id.pickup_linear_layout);

        /**
         * This listener gets triggered when the pick-up option is clicked
         * by the user.
         */
        pickupLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopRestaurantActivity.this,
                        "No pick-up is available right now", Toast.LENGTH_SHORT).show();
            }
        });

        //Dine-in icon and text LinearLayout.
        LinearLayout dineinLinearLayout = findViewById(R.id.dinein_linear_layout);

        /**
         * This listener gets triggered when the dine-in option is clicked
         * by the user.
         */
        dineinLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopRestaurantActivity.this,
                        "No dine-in is available right now", Toast.LENGTH_SHORT).show();
            }
        });

        //Dine-out icon and text LinearLayout.
        LinearLayout dineoutLinearLayout = findViewById(R.id.dineout_linear_layout);

        /**
         * This listener gets triggered when the dine-out option gets clicked
         * by the user.
         */
        dineoutLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopRestaurantActivity.this,
                        "No dine-out is available right now", Toast.LENGTH_SHORT).show();
            }
        });

        List<Map> topRestaurantCoordinatesList = new ArrayList<>();
        //Adding punjab province city coordinates.
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.punjab_restaurant_one_latitude),
                getResources().getString(R.string.punjab_restaurant_one_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.punjab_restaurant_two_latitude),
                getResources().getString(R.string.punjab_restaurant_two_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.punjab_restaurant_three_latitude),
                getResources().getString(R.string.punjab_restaurant_three_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.punjab_restaurant_four_latitude),
                getResources().getString(R.string.punjab_restaurant_four_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.punjab_restaurant_five_latitude),
                getResources().getString(R.string.punjab_restaurant_five_longitude)));
        //Adding sindh province city coordinates.
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.sindh_restaurant_one_latitude),
                getResources().getString(R.string.sindh_restaurant_one_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.sindh_restaurant_two_latitude),
                getResources().getString(R.string.sindh_restaurant_two_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.sindh_restaurant_three_latitude),
                getResources().getString(R.string.sindh_restaurant_three_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.sindh_restaurant_four_latitude),
                getResources().getString(R.string.sindh_restaurant_four_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.sindh_restaurant_five_latitude),
                getResources().getString(R.string.sindh_restaurant_five_longitude)));
        //Adding balochistan province city coordinates.
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_restaurant_one_latitude),
                getResources().getString(R.string.balochistan_restaurant_one_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_restaurant_two_latitude),
                getResources().getString(R.string.balochistan_restaurant_two_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_restaurant_three_latitude),
                getResources().getString(R.string.balochistan_restaurant_three_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_restaurant_four_latitude),
                getResources().getString(R.string.balochistan_restaurant_four_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.balochistan_restaurant_five_latitude),
                getResources().getString(R.string.balochistan_restaurant_five_longitude)));
        //Adding kpk province city coordinates.
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.kpk_restaurant_one_latitude),
                getResources().getString(R.string.kpk_restaurant_one_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.kpk_restaurant_two_latitude),
                getResources().getString(R.string.kpk_restaurant_two_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.kpk_restaurant_three_latitude),
                getResources().getString(R.string.kpk_restaurant_three_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.kpk_restaurant_four_latitude),
                getResources().getString(R.string.kpk_restaurant_four_longitude)));
        topRestaurantCoordinatesList.add(new Map(getResources().getString(R.string.kpk_restaurant_five_latitude),
                getResources().getString(R.string.kpk_restaurant_five_longitude)));
        
        //Restaurant location button and a clicked listener to see a toast message when clicked.
        Button restaurantSeeTheLocationButton = findViewById(R.id.restaurant_see_the_location_button);
        String nameOfRestaurant = getResources().getString(restaurantNameString);
        restaurantSeeTheLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coordinates = getLatitudeLongitude(nameOfRestaurant, topRestaurantCoordinatesList);
                if(coordinates == null) {
                    Toast.makeText(TopRestaurantActivity.this, "coordinates not found",
                            Toast.LENGTH_SHORT).show();
                }else {
                    String[] coordinatesArray = coordinates.split(",");
                    String latitude = coordinatesArray[0].trim();
                    String longitude = coordinatesArray[1].trim();

                    Intent mapsIntent = new Intent(TopRestaurantActivity.this, MapActivity.class);
                    mapsIntent.putExtra("latitude", latitude);
                    mapsIntent.putExtra("longitude", longitude);
                    startActivity(mapsIntent);
                }
            }
        });
    }

    /**
     * Gets the location of the restaurant based on its name.
     * @param restaurantName is the name of the restaurant.
     * @return the location of the restaurant.
     */
    @Override
    public String getLocation(String restaurantName) {
        return switch (restaurantName) {
            //Punjab province top restaurants cards addresses.
            case "Monal" -> getResources().getString(R.string.punjab_restaurant_one_address);
            case "Haveli" -> getResources().getString(R.string.punjab_restaurant_two_address);
            case "Andaaz" -> getResources().getString(R.string.punjab_restaurant_three_address);
            case "Spice Bazar" -> getResources().getString(R.string.punjab_restaurant_four_address);
            case "Dera" -> getResources().getString(R.string.punjab_restaurant_five_address);

            //Sindh province top restaurant cards addresses..
            case "Royal Taj" -> getResources().getString(R.string.sindh_restaurant_one_address);
            case "Ridan" -> getResources().getString(R.string.sindh_restaurant_two_address);
            case "LalQila" -> getResources().getString(R.string.sindh_restaurant_three_address);
            case "Chef's Table" -> getResources().getString(R.string.sindh_restaurant_four_address);
            case "Kababjees" -> getResources().getString(R.string.sindh_restaurant_five_address);

            //Balochistan province top restaurant cards addresses.
            case "Lehri Sajji House" -> getResources().getString(R.string.balochistan_restaurant_one_address);
            case "Usmania Tandoori" -> getResources().getString(R.string.balochistan_restaurant_two_address);
            case "Saigon" -> getResources().getString(R.string.balochistan_restaurant_three_address);
            case "Gulshan Karahi" -> getResources().getString(R.string.balochistan_restaurant_four_address);
            case "Mehfil" -> getResources().getString(R.string.balochistan_restaurant_five_address);

            //KPK province top restaurant cards addresses.
            case "Chief Burger" -> getResources().getString(R.string.kpk_restaurant_one_address);
            case "Cafe Crunch" -> getResources().getString(R.string.kpk_restaurant_two_address);
            case "Pinetree" -> getResources().getString(R.string.kpk_restaurant_three_address);
            case "Bukhara Rooftop BBQ" -> getResources().getString(R.string.kpk_restaurant_four_address);
            case "Swat Marina" -> getResources().getString(R.string.kpk_restaurant_five_address);

            default -> "Address not found";
        };
    }

    /**
     * Gets the long description based on the restaurant name.
     * @param restaurantName is the name of the restaurant.
     * @return the complete long description for a restaurant.
     */
    @Override
    public String getDescription(String restaurantName) {
        return switch (restaurantName) {
            //Punjab province top restaurants descriptions.
            case "Monal" -> getResources().getString(R.string.punjab_restaurant_one_description);
            case "Haveli" -> getResources().getString(R.string.punjab_restaurant_two_description);
            case "Andaaz" -> getResources().getString(R.string.punjab_restaurant_three_description);
            case "Spice Bazar" ->
                    getResources().getString(R.string.punjab_restaurant_four_description);
            case "Dera" -> getResources().getString(R.string.punjab_restaurant_five_description);

            //Sindh province top restaurants descriptions.
            case "Royal Taj" -> getResources().getString(R.string.sindh_restaurant_one_description);
            case "Ridan" -> getResources().getString(R.string.sindh_restaurant_two_description);
            case "LalQila" -> getResources().getString(R.string.sindh_restaurant_three_description);
            case "Chef's Table" -> getResources().getString(R.string.sindh_restaurant_four_description);
            case "Kababjees" -> getResources().getString(R.string.sindh_restaurant_five_description);

            //Balochistan province top restaurants descriptions.
            case "Lehri Sajji House" -> getResources().getString(R.string.balochistan_restaurant_one_description);
            case "Usmania Tandoori" -> getResources().getString(R.string.balochistan_restaurant_two_description);
            case "Saigon" -> getResources().getString(R.string.balochistan_restaurant_three_description);
            case "Gulshan Karahi" -> getResources().getString(R.string.balochistan_restaurant_four_description);
            case "Mehfil" -> getResources().getString(R.string.balochistan_restaurant_five_description);

            //KPK province top restaurant cards descriptions.
            case "Chief Burger" -> getResources().getString(R.string.kpk_restaurant_one_description);
            case "Cafe Crunch" -> getResources().getString(R.string.kpk_restaurant_two_description);
            case "Pinetree" -> getResources().getString(R.string.kpk_restaurant_three_description);
            case "Bukhara Rooftop BBQ" -> getResources().getString(R.string.kpk_restaurant_four_description);
            case "Swat Marina" -> getResources().getString(R.string.kpk_restaurant_five_description);

            default -> "Description not found";
        };
    }

    @Override
    public String getLatitudeLongitude(String name, List<Map> topRestaurantList) {
        return switch(name) {
            //Punjab province city latitude and longitude.
            case "Monal" -> topRestaurantList.get(0).getLatitude() + ", " +
                    topRestaurantList.get(0).getLongitude();
            case "Haveli" -> topRestaurantList.get(1).getLatitude() + ", " +
                    topRestaurantList.get(1).getLongitude();
            case "Andaaz" -> topRestaurantList.get(2).getLatitude() + ", " +
                    topRestaurantList.get(2).getLongitude();
            case "Spice Bazar" -> topRestaurantList.get(3).getLatitude() + ", " +
                    topRestaurantList.get(3).getLongitude();
            case "Dera" -> topRestaurantList.get(4).getLatitude() + ", " +
                    topRestaurantList.get(4).getLongitude();

            //Sindh province city latitude and longitude.
            case "Royal Taj" -> topRestaurantList.get(5).getLatitude() + ", " +
                    topRestaurantList.get(5).getLongitude();
            case "Ridan" -> topRestaurantList.get(6).getLatitude() + ", " +
                    topRestaurantList.get(6).getLongitude();
            case "LalQila" -> topRestaurantList.get(7).getLatitude() + ", " +
                    topRestaurantList.get(7).getLongitude();
            case "Chef's Table" -> topRestaurantList.get(8).getLatitude() + ", " +
                    topRestaurantList.get(8).getLongitude();
            case "Kababjees" -> topRestaurantList.get(9).getLatitude() + ", " +
                    topRestaurantList.get(9).getLongitude();

            //Balochistan province city latitude and longitude.
            case "Lehri Sajji House" -> topRestaurantList.get(10).getLatitude() + ", " +
                    topRestaurantList.get(10).getLongitude();
            case "Usmania Tandoori" -> topRestaurantList.get(11).getLatitude() + ", " +
                    topRestaurantList.get(11).getLongitude();
            case "Saigon" -> topRestaurantList.get(12).getLatitude() + ", " +
                    topRestaurantList.get(12).getLongitude();
            case "Gulshan Karahi" -> topRestaurantList.get(13).getLatitude() + ", " +
                    topRestaurantList.get(13).getLongitude();
            case "Mehfil" -> topRestaurantList.get(14).getLatitude() + ", " +
                    topRestaurantList.get(14).getLongitude();

            //KPK province city latitude and longitude.
            case "Chief Burger" -> topRestaurantList.get(15).getLatitude() + ", " +
                    topRestaurantList.get(15).getLongitude();
            case "Cafe Crunch" -> topRestaurantList.get(16).getLatitude() + ", " +
                    topRestaurantList.get(16).getLongitude();
            case "Pinetree" -> topRestaurantList.get(17).getLatitude() + ", " +
                    topRestaurantList.get(17).getLongitude();
            case "Bukhara Rooftop BBQ" -> topRestaurantList.get(18).getLatitude() + ", " +
                    topRestaurantList.get(18).getLongitude();
            case "Swat Marina" -> topRestaurantList.get(19).getLatitude() + ", " +
                    topRestaurantList.get(19).getLongitude();

            default -> null;
        };
    }
}