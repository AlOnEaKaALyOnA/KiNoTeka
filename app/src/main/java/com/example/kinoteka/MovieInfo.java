package com.example.kinoteka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kinoteka.Model.Order;

import org.w3c.dom.Text;

public class MovieInfo extends AppCompatActivity {

    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);

        back = findViewById(R.id.BACK);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backBtn = new Intent(MovieInfo.this, HomeActivity.class);
                startActivity(backBtn);
            }
        });

        ConstraintLayout courseBg = findViewById(R.id.MovieInfoBg);
        ImageView movieImage = findViewById(R.id.MovieInfoImage);
        TextView movieTitle = findViewById(R.id.MoviePageTitle);
        TextView movieText = findViewById(R.id.moviePageText);
        TextView movieLevel = findViewById(R.id.moviePageLevel);
        TextView movieDate = findViewById(R.id.moviePageDate);

        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        movieImage.setImageResource(getIntent().getIntExtra("movieImage",0));
        movieTitle.setText(getIntent().getStringExtra("movieTitle"));
        movieText.setText(getIntent().getStringExtra("movieText"));
        movieLevel.setText(getIntent().getStringExtra("movieLevel"));
        movieDate.setText(getIntent().getStringExtra("movieDate"));
    }

    public void addToCart(View view){

        int item_id = getIntent().getIntExtra("movieId",0);
        Order.items_id.add(item_id);
        Toast.makeText(this, "Добавлено в избранное!", Toast.LENGTH_LONG).show();
    }

}