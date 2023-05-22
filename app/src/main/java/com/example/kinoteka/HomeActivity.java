package com.example.kinoteka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kinoteka.Adapter.GenreAdapter;
import com.example.kinoteka.Model.Genre;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {

    RecyclerView genreRecycler;
    GenreAdapter GenreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<Genre> genreList = new ArrayList<>();
        genreList.add(new Genre(1, "Комедия"));
        genreList.add(new Genre(1, "Ужасы"));
        genreList.add(new Genre(1, "Детектив"));
        genreList.add(new Genre(1, "Драма"));
        genreList.add(new Genre(1, "Боевик"));

        setGenreRecycler(genreList);
    }

    private void setGenreRecycler(List<Genre> genreList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        genreRecycler = findViewById(R.id.genreRecycler);
        genreRecycler.setLayoutManager(layoutManager);

        GenreAdapter = new GenreAdapter(this, genreList);
        genreRecycler.setAdapter(GenreAdapter);

    }

}
