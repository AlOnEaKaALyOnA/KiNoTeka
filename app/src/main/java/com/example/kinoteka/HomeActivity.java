package com.example.kinoteka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kinoteka.Adapter.GenreAdapter;
import com.example.kinoteka.Adapter.MovieAdapter;
import com.example.kinoteka.Model.Genre;
import com.example.kinoteka.Model.Movie;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {

    private ImageView exitApp;

    RecyclerView genreRecycler, movieRecycler;
    GenreAdapter GenreAdapter;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        exitApp = (ImageView) findViewById(R.id.exit_app);

        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent exit = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(exit);

            }
        });

        List<Genre> genreList = new ArrayList<>();
        genreList.add(new Genre(1, "Комедия"));
        genreList.add(new Genre(1, "Ужасы"));
        genreList.add(new Genre(1, "Детектив"));
        genreList.add(new Genre(1, "Драма"));
        genreList.add(new Genre(1, "Боевик"));

        setGenreRecycler(genreList);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie(1, "mstiteli", "Мстители финал", "29.04.2019","#0a0a0a","Фантастика", "Оставшиеся в живых члены команды Мстителей и их союзники должны разработать новый план, который поможет противостоять разрушительным действиям могущественного титана Таноса. После наиболее масштабной и трагической битвы в истории они не могут допустить ошибку."));
        movieList.add(new Movie(1, "ono", "Оно", "05.09.2017","#0a0a0a","Ужасы", "test"));
//        movieList.add(new Genre(1, "Детектив"));
//        movieList.add(new Genre(1, "Драма"));
//        movieList.add(new Genre(1, "Боевик"));

        setMovieRecycler(movieList);
    }

    private void setMovieRecycler(List<Movie> movieList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        movieRecycler = findViewById(R.id.movieRecycler);
        movieRecycler.setLayoutManager(layoutManager);

        movieAdapter = new MovieAdapter(this, movieList);
        movieRecycler.setAdapter(movieAdapter);

    }

    private void setGenreRecycler(List<Genre> genreList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        genreRecycler = findViewById(R.id.genreRecycler);
        genreRecycler.setLayoutManager(layoutManager);

        GenreAdapter = new GenreAdapter(this, genreList);
        genreRecycler.setAdapter(GenreAdapter);

    }

}
