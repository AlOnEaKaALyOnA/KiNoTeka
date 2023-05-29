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
import com.example.kinoteka.Prevalent.Prevalent;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;

public class HomeActivity extends AppCompatActivity {

    private ImageView exitApp;

    RecyclerView genreRecycler, movieRecycler;
    GenreAdapter GenreAdapter;
    static MovieAdapter movieAdapter;
    static List<Movie> movieList = new ArrayList<>();
    static List<Movie> fullMoviesList = new ArrayList<>();
    private AlertDialog.Builder confirmOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        confirmOut = new AlertDialog.Builder(this);

        movieList.clear();

        exitApp = (ImageView) findViewById(R.id.exit_app);

        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutAccount();
            }

        });

        List<Genre> genreList = new ArrayList<>();
        genreList.add(new Genre(1, "Комедия"));
        genreList.add(new Genre(2, "Ужасы"));
        genreList.add(new Genre(3, "Фантастика"));
        genreList.add(new Genre(4, "Драма"));
        genreList.add(new Genre(5, "Боевик"));

        setGenreRecycler(genreList);


        movieList.add(new Movie(1, "mstiteli", "Мстители финал", "29.04.2019","#0a0a0a","Фантастика", "Оставшиеся в живых члены команды Мстителей и их союзники должны разработать новый план, который поможет противостоять разрушительным действиям могущественного титана Таноса. После наиболее масштабной и трагической битвы в истории они не могут допустить ошибку.",3));
        movieList.add(new Movie(2, "ono", "Оно", "05.09.2017","#0a0a0a","Ужасы", "Когда в городке Дерри штата Мэн начинают пропадать дети, несколько ребят сталкиваются со своими величайшими страхами - не только с группой школьных хулиганов, но со злобным клоуном Пеннивайзом, чьи проявления жестокости и список жертв уходят в глубь веков.",2));
        movieList.add(new Movie(3,"odnplusodn","1+1","26.04.2012","#0a0a0a","Драма","Пострадав в результате несчастного случая, богатый аристократ Филипп нанимает в помощники человека, который менее всего подходит для этой работы, – молодого жителя предместья Дрисса, только что освободившегося из тюрьмы. Несмотря на то, что Филипп прикован к инвалидному креслу, Дриссу удается привнести в размеренную жизнь аристократа дух приключений.",4));
        movieList.add(new Movie(4,"mimiller","Мы-Миллеры","15.08.2013","#0a0a0a","Комедия","Дэвид Кларк — мелкий торговец наркотиками. Среди его клиентов — повара и скучающие домохозяйки. Детям он наркотики не продаёт и поэтому считает себя принципиальным человеком. Дэвид действительно хорошо относится к детям, но это не остается безнаказанным — он пытается помочь подросткам, попавшим в беду, и на него нападают хулиганы-панки.",1));
        movieList.add(new Movie(5,"macbot","Мачо и Ботан","12.03.2012","#0a0a0a","Комедия","Шмидт и Дженко люто ненавидели друг друга в школе. Однако жизнь распорядилась так, чтобы в полицейской академии они стали друзьями. Их никак нельзя было назвать гордостью альма-матер до тех пор, пока судьба не подкинула шанс все изменить — они поступили на службу в департамент секретной службы на Джамп-стрит, которой руководит капитан Диксон.",1));
        movieList.add(new Movie(6,"jw","Джон Уик","13.10.2014","#0a0a0a","Боевик","Джон Уик - на первый взгляд, самый обычный среднестатистический американец, который ведет спокойную мирную жизнь. Однако мало кто знает, что он был наёмным убийцей, причём одним из лучших профессионалов в своём деле.",5));

        fullMoviesList.clear();
        fullMoviesList.addAll(movieList);

        setMovieRecycler(movieList);
    }

    public void openMovieCart(View view){
            Intent Izb = new Intent(this, OrderPage.class);
            startActivity(Izb);
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

    public static void showMovieByCategories(int category){
        movieList.clear();
        movieList.addAll(fullMoviesList);

        List<Movie> filterMovies = new ArrayList<>();

        for(Movie c : movieList) {
            if(c.getCategory() == category)
                filterMovies.add(c);
        }

        movieList.clear();
        movieList.addAll(filterMovies);

        movieAdapter.notifyDataSetChanged();



    }

    private void OutAccount()
    {
        confirmOut.setMessage("Вы действительно хотите выйти из аккаунта?");
        confirmOut.setTitle("Подтверждение");
        confirmOut.setCancelable(true);
        confirmOut.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Paper.book().write(Prevalent.UserPhoneKey, "");
                Paper.book().write(Prevalent.UserPasswordKey, "");
                Toast.makeText(HomeActivity.this, "Вы вышли из аккаунта!", Toast.LENGTH_SHORT).show();
                Intent goMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(goMain);
            }
        });
        confirmOut.setNegativeButton("Нет", null);
        confirmOut.create().show();
    }

}
