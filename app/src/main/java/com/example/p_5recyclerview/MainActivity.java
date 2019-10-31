package com.example.p_5recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.item_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), layoutManager.getOrientation()));

        recyclerView.setAdapter(new ItemsAdapter());
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView name, desc;
        ImageView image_tours;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
            desc = itemView.findViewById(R.id.item_desc);
            image_tours = itemView.findViewById(R.id.image_tours);
        }
    }

    class ItemsAdapter extends RecyclerView.Adapter<ItemViewHolder> {

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {

            final Item item = ItemList.itemList.get(position);

            holder.name.setText(item.name);
            holder.desc.setText(item.desc);
            holder.image_tours.set(item.image_tours);

//            holder.rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//                @Override
//                public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                    item.rating = v;
//                }
//            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                    intent.putExtra("ITEM_POSITION", position);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return ItemList.itemList.size();
        }
    }

}

class Item {
    String name;
    String desc;
    ImageView image_tours;
}

class ItemList {
    static List<Item> itemList = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Item item = new Item();
            item.name = "Item " + i;
            item.desc = "Description " + i;
            //item.image_tours.setImageDrawable(R.drawable/fig-02.jpeg);
            item.image_tours.setImageDrawable(R.drawable);
            itemList.add(item);
        }
    }
}




