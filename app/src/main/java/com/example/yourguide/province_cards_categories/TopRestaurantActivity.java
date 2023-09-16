package com.example.yourguide.province_cards_categories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourguide.Formatter;
import com.example.yourguide.R;

public class TopRestaurantActivity extends AppCompatActivity implements Formatter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_restaurant);

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
        //Checks if extras is empty.
        if(extras != null) {
            int restaurantImage = extras.getInt("restaurant_thumbnail_image");
            int restaurantNameString = extras.getInt("restaurant_name");
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

        //Restaurant location button and a clicked listener to see a toast message when clicked.
        Button restaurantSeeTheLocationButton = findViewById(R.id.restaurant_see_the_location_button);
        restaurantSeeTheLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopRestaurantActivity.this,
                        "No location is available right now", Toast.LENGTH_SHORT).show();
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
    }

    /**
     * Gets the location of the restaurant based on its name.
     * @param restaurantName is the name of the restaurant.
     * @return the location of the restaurant.
     */
    @Override
    public String getLocation(String restaurantName) {
        return switch (restaurantName) {
            //Punjab province restaurant locations.
            case "Monal" -> getResources().getString(R.string.punjab_restaurant_one_address);
            case "Haveli" -> getResources().getString(R.string.punjab_restaurant_two_address);
            case "Andaaz" -> getResources().getString(R.string.punjab_restaurant_three_address);
            case "Spice Bazar" -> getResources().getString(R.string.punjab_restaurant_four_address);
            case "Dera" -> getResources().getString(R.string.punjab_restaurant_five_address);

            //Sindh province restaurant locations.
            case "Royal Taj" -> getResources().getString(R.string.sindh_restaurant_one_address);
            case "Ridan Mandi House" -> getResources().getString(R.string.sindh_restaurant_two_address);
            case "LalQila" -> getResources().getString(R.string.sindh_restaurant_three_address);
            case "Chef's Table" -> getResources().getString(R.string.sindh_restaurant_four_address);
            case "Kababjees" -> getResources().getString(R.string.sindh_restaurant_five_address);

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
            //Punjab province restaurant descriptions.
            case "Monal" -> getResources().getString(R.string.punjab_restaurant_one_description);
            case "Haveli" -> getResources().getString(R.string.punjab_restaurant_two_description);
            case "Andaaz" -> getResources().getString(R.string.punjab_restaurant_three_description);
            case "Spice Bazar" ->
                    getResources().getString(R.string.punjab_restaurant_four_description);
            case "Dera" -> getResources().getString(R.string.punjab_restaurant_five_description);

            //Sindh province restaurant descriptions.
            case "Royal Taj" -> getResources().getString(R.string.sindh_restaurant_one_description);
            case "Ridan Mandi House" -> getResources().getString(R.string.sindh_restaurant_two_description);
            case "LalQila" -> getResources().getString(R.string.sindh_restaurant_three_description);
            case "Chef's Table" -> getResources().getString(R.string.sindh_restaurant_four_description);
            case "Kababjees" -> getResources().getString(R.string.sindh_restaurant_five_description);

            default -> "Description not found";
        };
    }
}