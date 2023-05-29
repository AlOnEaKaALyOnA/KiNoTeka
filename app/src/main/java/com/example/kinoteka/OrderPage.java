package com.example.kinoteka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.kinoteka.Model.Movie;
import com.example.kinoteka.Model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    private Button backizb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        backizb = findViewById(R.id.glav_str);

        backizb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_Izb = new Intent(OrderPage.this, HomeActivity.class);
                startActivity(back_Izb);
            }
        });

        ListView orders_list = findViewById(R.id.orders_list);

        List<String> MoviesTitle = new ArrayList<>();

        for(Movie c: HomeActivity.fullMoviesList){
            if(Order.items_id.contains(c.getId()))
                MoviesTitle.add(c.getTitle());
        }

        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MoviesTitle));

    }

}