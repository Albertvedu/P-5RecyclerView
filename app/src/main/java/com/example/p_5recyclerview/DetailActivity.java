package com.example.p_5recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int position = getIntent().getIntExtra("ITEM_POSITION", 0);

        Item item = ItemList.itemList.get(position);

        TextView textViewName = findViewById(R.id.name);
        TextView textViewDesc = findViewById(R.id.desc);
        ImageView viewImage_tours = findViewById(R.id.image_tours);

        textViewName.setText(item.name);
        textViewDesc.setText(item.desc);
        viewImage_tours.
       // ratingBar.setRating(item.rating);
    }
}
