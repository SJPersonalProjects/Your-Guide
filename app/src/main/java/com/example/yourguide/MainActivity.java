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
                "13", "27", "48", R.drawable.province_punjab,
                R.color.punjab_province));
        provinceDataList.add(new ProvinceCategory("Sindh", R.string.sindh_province_description,
                "21", "58", "96", R.drawable.province_sindh,
                R.color.sindh_province));
        provinceDataList.add(new ProvinceCategory("Balochistan", R.string.balochistan_province_description,
                "14", "12", "19", R.drawable.province_balochistan,
                R.color.balochistan_province));
        provinceDataList.add(new ProvinceCategory("KPK", R.string.kpk_province_description,
                "8", "19", "27", R.drawable.province_kpk,
                 R.color.kpk_province));

        //Custom adapter for provincial data.
        ProvinceDataAdapter adapter = new ProvinceDataAdapter(this, provinceDataList);

        //Find the ListView to display the data.
        ListView listView = findViewById(R.id.list_view);

        //Set the adapter on the listview.
        listView.setAdapter(adapter);

        //OnClickListener to perform click events on the list items.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //Toast message on the screen is shown any province list item is clicked.
                Toast.makeText(MainActivity.this, provinceDataList.get(position).getProvinceName(), Toast.LENGTH_SHORT).show();
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
        switch(position) {
            case 0:
                Intent punjabActivity = new Intent(getApplicationContext(), PunjabActivity.class);
                startActivity(punjabActivity);
                break;
            case 1:
                Intent sindhActivity = new Intent(getApplicationContext(), SindhActivity.class);
                startActivity(sindhActivity);
                break;
            case 2:
                Intent balochistanActivity = new Intent(getApplicationContext(), BalochistanActivity.class);
                startActivity(balochistanActivity);
                break;
            default:
                Intent kpkActivity = new Intent(getApplicationContext(), KPKActivity.class);
                startActivity(kpkActivity);
                break;
        }
    }
}