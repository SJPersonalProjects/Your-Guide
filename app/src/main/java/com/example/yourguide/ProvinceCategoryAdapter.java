package com.example.yourguide;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ProvinceCategoryAdapter extends ArrayAdapter<ProvinceCategory> {

    public ProvinceCategoryAdapter(@NonNull Context context, @NonNull ArrayList<ProvinceCategory> provinceDataList) {
        super(context, 0, provinceDataList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Checks if an existing view is being reused, otherwise inflate the view.
        View currentProvinceItem = convertView;
        if(currentProvinceItem == null) {
            currentProvinceItem = LayoutInflater.from(getContext()).inflate(R.layout.province_list, parent, false);
        }

        /*
         * Get {@link ProvinceData} object located at this position in the list.
         **/
        ProvinceCategory currentProvincePosition = getItem(position);

        //Find the TextView in the province_list.xml layout with the id province_name.
        TextView provinceName = currentProvinceItem.findViewById(R.id.province_name);
        //Get the province name from the currentProvincePosition object and set
        //the text on the provinceName TextView.
        provinceName.setText(currentProvincePosition.getProvinceName());

        //Find the TextView in the province_list.xml layout with the id province_description.
        TextView provinceDescription = currentProvinceItem.findViewById(R.id.province_description);
        //Get the province description from the currentProvincePosition object and set
        //the text on the provinceDescription TextView.
        provinceDescription.setText(currentProvincePosition.getProvinceDescription());

        //Find the TextView in the province_list.xml layout with the id province_historical_sights_number
        TextView historicalSightsNumber = currentProvinceItem.findViewById(R.id.province_historical_sights_number);
        //Get the historical sights number from the currentProvincePosition object and set
        //the text on the historicalSightsNumber TextView.
        historicalSightsNumber.setText(currentProvincePosition.getNumberOfHistoricalPlaces());

        //Set the proper background color of the historical places data.
        //Fetch the background from the TextView, which is GradientDrawable.
        GradientDrawable historicalDataCircle = (GradientDrawable) historicalSightsNumber.getBackground();

        //Get the appropriate background color based on the names of the provinces.
        int historicalDataColor = getDataColor(currentProvincePosition.getProvinceName());
        //Set the color on the historical data circles of each province.
        historicalDataCircle.setColor(historicalDataColor);

        //Find the Textview in the province_list.xml layout with the id province_popular_sights_number
        TextView popularSightsNumber = currentProvinceItem.findViewById(R.id.province_popular_sights_number);
        //Get the popular sights number from the currentProvincePosition object and set
        //the text on the popularSightsNumber TextView.
        popularSightsNumber.setText(currentProvincePosition.getNumberOfPopularPlaces());

        //Set the proper background color of the popular places data.
        //Fetch the background from the TextView, which is GradientDrawable.
        GradientDrawable popularDataCircle = (GradientDrawable) popularSightsNumber.getBackground();

        //Get the appropriate background color based on the names of the provinces.
        int popularDataColor = getDataColor(currentProvincePosition.getProvinceName());
        //Set the color on the popular data circles of each province.
        popularDataCircle.setColor(popularDataColor);

        //Find the TextView in the province_list.xml layout with the id province_cities_number
        TextView numberOfCities = currentProvinceItem.findViewById(R.id.province_cities_number);
        //Get the number of cities from the currentProvincePosition object and set
        //the text on the numberOfCities Textview.
        numberOfCities.setText(currentProvincePosition.getNumberOfCities());

        //Set the proper background color of the popular places data.
        //Fetch the background from the Textview, which GradientDrawable.
        GradientDrawable citiesDataCircle = (GradientDrawable) numberOfCities.getBackground();

        //Get the appropriate background color based on the names of the provinces.
        int citiesDataColor = getDataColor(currentProvincePosition.getProvinceName());
        //Set the color on the proper data circles of each province.
        citiesDataCircle.setColor(citiesDataColor);

        //Find the ImageView in the province_list.xml layout with the id province_background_image
        ImageView provinceBackgroundImage = currentProvinceItem.findViewById(R.id.province_background_image);
        //Get the province background image from the currentProvincePosition object and set
        //the text on the provinceBackgroundImage ImageView.
        provinceBackgroundImage.setImageResource(currentProvincePosition.getProvinceImageID());

        //Set the theme color for the list item.
        View tintContainer = currentProvinceItem.findViewById(R.id.tint_container);
        //Find the color that the resource maps to.
        int color = ContextCompat.getColor(getContext(), currentProvincePosition.getProvinceBackgroundTint());
        //set the background color to the tint container view.
        tintContainer.setBackgroundColor(color);

        //Return the whole list item layout (containing 5 TextView)
        //so that it can be shown in the listview.
        return currentProvinceItem;
    }

    /**
     * Method to get the color resource id for each specific province in the list item.
     * @param mProvinceName is the name of the province.
     * @return the color resource ID based on the province name.
     */
    private int getDataColor(String mProvinceName) {
        int mProvinceBackgroundTintID = 0;
        switch(mProvinceName) {
            case "Punjab":
                mProvinceBackgroundTintID = R.color.punjab_province_data_color;
                break;
            case "Sindh":
                mProvinceBackgroundTintID = R.color.sindh_province_data_color;
                break;
            case "Balochistan":
                mProvinceBackgroundTintID = R.color.balochistan_province_data_color;
                break;
            case "KPK":
                mProvinceBackgroundTintID = R.color.kpk_province_data_color;
                break;
        }
        return ContextCompat.getColor(getContext(), mProvinceBackgroundTintID);
    }
}
