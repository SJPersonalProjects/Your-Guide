package com.example.yourguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yourguide.balochistan_province.BalochistanActivity;
import com.example.yourguide.kpk_province.KPKActivity;
import com.example.yourguide.punjab_province.PunjabActivity;
import com.example.yourguide.sindh_province.SindhActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Current list of provinces in Pakistan.
        ArrayList<ProvinceCategory> provinceDataList = new ArrayList<>();
        provinceDataList.add(new ProvinceCategory("Punjab", R.string.punjab_province_description,
                getResources().getString(R.string.province_number_of_historical_sights),
                getResources().getString(R.string.province_number_of_restaurants),
                getResources().getString(R.string.province_number_of_cities), R.drawable.punjab_province_header,
                R.color.punjab_province));
        provinceDataList.add(new ProvinceCategory("Sindh", R.string.sindh_province_description,
                getResources().getString(R.string.province_number_of_historical_sights),
                getResources().getString(R.string.province_number_of_restaurants),
                getResources().getString(R.string.province_number_of_cities), R.drawable.sindh_province_header,
                R.color.sindh_province));
        provinceDataList.add(new ProvinceCategory("Balochistan", R.string.balochistan_province_description,
                getResources().getString(R.string.province_number_of_historical_sights),
                getResources().getString(R.string.province_number_of_restaurants),
                getResources().getString(R.string.province_number_of_cities), R.drawable.balochistan_province_header,
                R.color.balochistan_province));
        provinceDataList.add(new ProvinceCategory("KPK", R.string.kpk_province_description,
                getResources().getString(R.string.province_number_of_historical_sights),
                getResources().getString(R.string.province_number_of_restaurants),
                getResources().getString(R.string.province_number_of_cities), R.drawable.kpk_province_header,
                 R.color.kpk_province));

        //Custom adapter for provincial data.
        ProvinceCategoryAdapter adapter = new ProvinceCategoryAdapter(this, provinceDataList);

        //Find the ListView to display the data.
        ListView listView = findViewById(R.id.list_view);

        //Set the adapter on the listview.
        listView.setAdapter(adapter);

        //OnClickListener to perform click events on the list items.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Selects the activity based on the position and launches it.
                activitySelector(position);
            }
        });
    }

    /**
     * Selecting Activity using their index position.
     * @param position is the index position for the activities.
     */
    private void activitySelector(int position) {
        //Getting position for each activity and open that activity using Intent.
        switch (position) {
            case 0 -> {
                Intent punjabActivity = new Intent(getApplicationContext(), PunjabActivity.class);
                startActivity(punjabActivity);
            }
            case 1 -> {
                Intent sindhActivity = new Intent(getApplicationContext(), SindhActivity.class);
                startActivity(sindhActivity);
            }
            case 2 -> {
                Intent balochistanActivity = new Intent(getApplicationContext(), BalochistanActivity.class);
                startActivity(balochistanActivity);
            }
            default -> {
                Intent kpkActivity = new Intent(getApplicationContext(), KPKActivity.class);
                startActivity(kpkActivity);
            }
        }
    }
}