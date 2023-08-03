package com.example.yourguide.punjab_province;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yourguide.R;

import java.io.DataOutputStream;
import java.util.ArrayList;

public class PunjabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_punjab);

        ArrayList<PunjabProvinceCard> punjabProvinceCardsList = new ArrayList<>();
        punjabProvinceCardsList.add(new PunjabProvinceCard(R.drawable.lahore_city, R.string.lahore_city_title,
                R.string.lahore_city_description, R.string.lahore_city_rating));
        punjabProvinceCardsList.add(new PunjabProvinceCard(R.drawable.faisalabad_city, R.string.faisalabad_city_title,
                R.string.faisalabad_city_description, R.string.faisalabad_city_rating));
        punjabProvinceCardsList.add(new PunjabProvinceCard(R.drawable.rawalpindi_city, R.string.rawalpindi_city_title,
                R.string.rawalpindi_city_description, R.string.rawalpindi_city_rating));
        punjabProvinceCardsList.add(new PunjabProvinceCard(R.drawable.multan_city, R.string.multan_city_title,
                R.string.multan_city_description, R.string.multan_city_rating));
        punjabProvinceCardsList.add(new PunjabProvinceCard(R.drawable.gujranwala_city, R.string.gujranwala_city_title,
                R.string.gujranwala_city_description, R.string.gujranwala_city_rating));

        RecyclerView punjabProvinceRecyclerView = (RecyclerView) findViewById(R.id.punjab_province_recycler_view);
        punjabProvinceRecyclerView.setVerticalScrollBarEnabled(false);
        punjabProvinceRecyclerView.setHorizontalScrollBarEnabled(false);
        punjabProvinceRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        PunjabProvinceCardAdapter adapter = new PunjabProvinceCardAdapter(punjabProvinceCardsList);

        punjabProvinceRecyclerView.setLayoutManager(mLayoutManager);
        punjabProvinceRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PunjabProvinceCardAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast to show the click event message of cards in Punjab Activity.
                Toast.makeText(PunjabActivity.this, punjabProvinceCardsList.get(position).getCardTitle(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}