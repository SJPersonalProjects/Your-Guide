package com.example.yourguide.province_cards_categories;

import androidx.appcompat.app.AppCompatActivity;

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
import com.example.yourguide.R;

public class HistoricalPlaceActivity extends AppCompatActivity implements Formatter {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_place);

        //Finding views by their IDs to use their reference and set values.
        ImageView historicalPlacePreviewImage = findViewById(R.id.historical_place_preview_image);

        //Historical place title.
        TextView historicalPlaceTitle= findViewById(R.id.historical_place_name);

        //Sub heading below the place title.
        TextView historicalPlaceSubHeading = findViewById(R.id.historical_place_sub_heading);
        historicalPlaceSubHeading.setText(subHeadingFormatter()); //Brings in the subheadings randomly.

        //Address of the historical place.
        TextView historicalPlaceAddress = findViewById(R.id.historical_place_address);

        //Description for the historical place to mention details.
        TextView historicalPlaceDescription = findViewById(R.id.historical_place_description);

        //Rating of the historical place.
        TextView historicalPlaceReview = findViewById(R.id.historical_place_review);

        //Review of the historical place.
        TextView historicalPlaceRating = findViewById(R.id.historical_place_rating);

        ImageView historicalPlaceIconOneImage = findViewById(R.id.icon_one_image);
        historicalPlaceIconOneImage.setImageResource(R.drawable.museum);
        TextView historicalPlaceIconOneTitle = findViewById(R.id.icon_one_title);
        historicalPlaceIconOneTitle.setText(R.string.historical_place_icon_text_one);

        ImageView historicalPlaceIconTwoImage = findViewById(R.id.icon_two_image);
        historicalPlaceIconTwoImage.setImageResource(R.drawable.guide);
        TextView historicalPlaceIconTwoTitle = findViewById(R.id.icon_two_title);
        historicalPlaceIconTwoTitle.setText(R.string.historical_place_icon_text_two);

        ImageView historicalPlaceIconThreeImage = findViewById(R.id.icon_three_image);
        historicalPlaceIconThreeImage.setImageResource(R.drawable.camera);
        TextView historicalPlaceIconThreeTitle = findViewById(R.id.icon_three_title);
        historicalPlaceIconThreeTitle.setText(R.string.historical_place_icon_text_three);

        ImageView historicalPlaceIconFourImage = findViewById(R.id.icon_four_image);
        historicalPlaceIconFourImage.setImageResource(R.drawable.event);
        TextView historicalPlaceIconFourTitle = findViewById(R.id.icon_four_title);
        historicalPlaceIconFourTitle.setText(R.string.historical_place_icon_text_four);

        Bundle extras = getIntent().getExtras();
        String title = "";
        //Checks if extras is empty.
        if(extras != null) {
            //Pull up the extras in their variables.
            int thumbnailImage = extras.getInt("historical_place_thumbnail_image");
            title = extras.getString("historical_place_title");
            String rating = extras.getString("historical_place_rating");
            String review = extras.getString("historical_place_review");

            //Set the data to their objects to display appropriate data to user.
            historicalPlacePreviewImage.setImageResource(thumbnailImage);
            historicalPlaceTitle.setText(title);
            historicalPlaceRating.setText(rating);
            historicalPlaceReview.setText(reviewFormatter(review));

            //Setting description and address of the historical place.
            historicalPlaceAddress.setText(getLocation(title));
            historicalPlaceDescription.setText(getDescription(title));
        }

        LinearLayout museumLinearLayout = findViewById(R.id.icon_one);
        //This listeners gets triggered when the user clicks the museum icon.
        museumLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HistoricalPlaceActivity.this,
                        "No tickets for museum available right now", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout guideLinearLayout = findViewById(R.id.icon_two);
        //This listener gets triggered when the user clicks the guide icon.
        guideLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HistoricalPlaceActivity.this,
                        "No guide is available right now", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout photographLinearLayout = findViewById(R.id.icon_three);
        //This listener gets triggered when the user clicks the photography icon.
        photographLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HistoricalPlaceActivity.this,
                        "No photographer is available right now", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout eventLinearLayout = findViewById(R.id.icon_four);
        //This listener gets triggered when the user clicks the event icon.
        eventLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HistoricalPlaceActivity.this,
                        "No event is happening these days", Toast.LENGTH_SHORT).show();
            }
        });

        //Finding button with id.
        Button seeTheLocationButton = (Button)
                findViewById(R.id.historical_place_see_the_location_button);
        String historicalPlaceName = title;
        //This listener is triggered when the user clicks the
        seeTheLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String coordinates = getLatitudeLongitude(historicalPlaceName);
                //Checking if coordinates is null.
                if(coordinates == null) {
                    //If coordinates isnull display toast of coordinates not found.
                    Toast.makeText(HistoricalPlaceActivity.this,
                            "coordinates not found", Toast.LENGTH_SHORT).show();
                }else {
                    //Otherwise execute this block.
                    String[] coordinatesArray = coordinates.split(",");
                    String latitude = coordinatesArray[0].trim();
                    String longitude = coordinatesArray[1].trim();

                    //Intent to launch Map activity.
                    Intent mapsIntent = new Intent(HistoricalPlaceActivity.this,
                            Map.class);
                    //Passing in coordinates.
                    mapsIntent.putExtra("latitude", latitude);
                    mapsIntent.putExtra("longitude", longitude);
                    startActivity(mapsIntent);
                }
            }
        });

    }

    /**
     * Gets location based on the historical place name clicked by the user.
     * @param historicalPlaceName is the name of the place user wants to visit.
     * @return historical place address.
     */
    @Override
    public String getLocation(String historicalPlaceName) {
        return switch(historicalPlaceName) {
            //Punjab province historical place addresses.
            case "Badshahi Mosque" -> getResources().getString(R.string.punjab_historical_place_one_address);
            case "Wagah Border" -> getResources().getString(R.string.punjab_historical_place_two_address);
            case "Lahore Fort" -> getResources().getString(R.string.punjab_historical_place_three_address);
            case "Wazir.K Mosque" -> getResources().getString(R.string.punjab_historical_place_four_address);
            case "Walled City" -> getResources().getString(R.string.punjab_historical_place_five_address);

            //Sindh province historical place addresses.
            case "Mohenjo-daro" -> getResources().getString(R.string.sindh_historical_place_one_address);
            case "Makli Hill" -> getResources().getString(R.string.sindh_historical_place_two_address);
            case "Shah Jahan Mosque" -> getResources().getString(R.string.sindh_historical_place_three_address);
            case "Rani Kot Fort" -> getResources().getString(R.string.sindh_historical_place_four_address);
            case "Tooba Mosque" -> getResources().getString(R.string.sindh_historical_place_five_address);

            //Balochistan province historical place addresses.
            case "Quaid-e-Azam Residency" -> getResources().getString(R.string.balochistan_historical_place_one_address);
            case "Princes of Hope" -> getResources().getString(R.string.balochistan_historical_place_two_address);
            case "Kalat" -> getResources().getString(R.string.balochistan_historical_place_three_address);
            case "Gadani Beach" -> getResources().getString(R.string.balochistan_historical_place_four_address);
            case "Moola Chotok" -> getResources().getString(R.string.balochistan_historical_place_five_address);

            //KPK province historical place addresses.
            case "Chitral Fort" -> getResources().getString(R.string.kpk_historical_place_one_address);
            case "Takht-i-Bahi" -> getResources().getString(R.string.kpk_historical_place_two_address);
            case "Mahabat Khan Mosque" -> getResources().getString(R.string.kpk_historical_place_three_address);
            case "Jamrud Fort" -> getResources().getString(R.string.kpk_historical_place_four_address);
            case "St John's Church" -> getResources().getString(R.string.kpk_historical_place_five_address);

            default -> "Location not found";
        };
    }

    /**
     * Gets the long description based on the historical place name clicked by the user.
     * @param historicalPlaceName is the name of the place user wants to visit.
     * @return historical place description
     */
    @Override
    public String getDescription(String historicalPlaceName) {
        return switch(historicalPlaceName) {
            //Punjab province historical place descriptions.
            case "Badshahi Mosque" -> getResources().getString(R.string.punjab_historical_place_one_description);
            case "Wagah Border" -> getResources().getString(R.string.punjab_historical_place_two_description);
            case "Lahore Fort" -> getResources().getString(R.string.punjab_historical_place_three_description);
            case "Wazir.K Mosque" -> getResources().getString(R.string.punjab_historical_place_four_description);
            case "Walled City" -> getResources().getString(R.string.punjab_historical_place_five_description);

            //Sindh province historical place descriptions.
            case "Mohenjo-daro" -> getResources().getString(R.string.sindh_historical_place_one_description);
            case "Makli Hill" -> getResources().getString(R.string.sindh_historical_place_two_description);
            case "Shah Jahan Mosque" -> getResources().getString(R.string.sindh_historical_place_three_description);
            case "Rani Kot Fort" -> getResources().getString(R.string.sindh_historical_place_four_description);
            case "Tooba Mosque" -> getResources().getString(R.string.sindh_historical_place_five_description);

            //Balochistan province historical place descriptions.
            case "Quaid-e-Azam Residency" -> getResources().getString(R.string.balochistan_historical_place_one_description);
            case "Princes of Hope" -> getResources().getString(R.string.balochistan_historical_place_two_description);
            case "Kalat" -> getResources().getString(R.string.balochistan_historical_place_three_description);
            case "Gadani Beach" -> getResources().getString(R.string.balochistan_historical_place_four_description);
            case "Moola Chotok" -> getResources().getString(R.string.balochistan_historical_place_five_description);

            //KPK province historical place descriptions.
            case "Chitral Fort" -> getResources().getString(R.string.kpk_historical_place_one_description);
            case "Takht-i-Bahi" -> getResources().getString(R.string.kpk_historical_place_two_description);
            case "Mahabat Khan Mosque" -> getResources().getString(R.string.kpk_historical_place_three_description);
            case "Jamrud Fort" -> getResources().getString(R.string.kpk_historical_place_four_description);
            case "St John's Church" -> getResources().getString(R.string.kpk_historical_place_five_description);

            default -> "Description not found";
        };
    }

    @Override
    public String getLatitudeLongitude(String name) {
        return switch(name) {
            //Punjab province city latitude and longitude.
            case "Badshahi Mosque" -> getResources().getString(R.string.punjab_historical_place_one_latitude_longitude);
            case "Wagah Border" -> getResources().getString(R.string.punjab_historical_place_two_latitude_longitude);
            case "Lahore Fort" -> getResources().getString(R.string.punjab_historical_place_three_latitude_longitude);
            case "Wazir.K Mosque" -> getResources().getString(R.string.punjab_historical_place_four_latitude_longitude);
            case "Walled City" -> getResources().getString(R.string.punjab_historical_place_five_latitude_longitude);

            //Sindh province city latitude and longitude.
            case "Mohenjo-daro" -> getResources().getString(R.string.sindh_historical_place_one_latitude_longitude);
            case "Makli Hill" -> getResources().getString(R.string.sindh_historical_place_two_latitude_longitude);
            case "Shah Jahan Mosque" -> getResources().getString(R.string.sindh_historical_place_three_latitude_longitude);
            case "Rani Kot Fort" -> getResources().getString(R.string.sindh_historical_place_four_latitude_longitude);
            case "Tooba Mosque" -> getResources().getString(R.string.sindh_historical_place_five_latitude_longitude);

            //Balochistan province city latitude and longitude.
            case "Quaid-e-Azam Residency" -> getResources().getString(R.string.balochistan_historical_place_one_latitude_longitude);
            case "Princes of Hope" -> getResources().getString(R.string.balochistan_historical_place_two_latitude_longitude);
            case "Kalat" -> getResources().getString(R.string.balochistan_historical_place_three_latitude_longitude);
            case "Gadani Beach" -> getResources().getString(R.string.balochistan_historical_place_four_latitude_longitude);
            case "Moola Chotok" -> getResources().getString(R.string.balochistan_historical_place_five_latitude_longitude);

            //KPK province city latitude and longitude.
            case "Chitral Fort" -> getResources().getString(R.string.kpk_historical_place_one_latitude_longitude);
            case "Takht-i-Bahi" -> getResources().getString(R.string.kpk_historical_place_two_latitude_longitude);
            case "Mahabat Khan Mosque" -> getResources().getString(R.string.kpk_historical_place_three_latitude_longitude);
            case "Jamrud Fort" -> getResources().getString(R.string.kpk_historical_place_four_latitude_longitude);
            case "St John's Church" -> getResources().getString(R.string.kpk_historical_place_five_latitude_longitude);

            default -> null;
        };
    }
}