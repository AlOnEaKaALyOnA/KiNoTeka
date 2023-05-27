package com.example.kinoteka.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinoteka.HomeActivity;
import com.example.kinoteka.Model.Movie;
import com.example.kinoteka.MovieInfo;
import com.example.kinoteka.R;
import com.google.firebase.database.collection.LLRBNode;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View MovieItems = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
        return new MovieAdapter.MovieViewHolder(MovieItems);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.MovieViewHolder holder, int position) {
        holder.courseBg.setCardBackgroundColor(Color.parseColor(movies.get(position).getColor()));

        int imageId = context.getResources().getIdentifier(movies.get(position).getImg(),"drawable",context.getPackageName());
        holder.movieImage.setImageResource(imageId);

        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.movieLevel.setText(movies.get(position).getLevel());
        holder.movieDate.setText(movies.get(position).getDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MovieInfo.class);

                intent.putExtra("courseBg", Color.parseColor(movies.get(position).getColor()));
                intent.putExtra("movieImage",imageId);
                intent.putExtra("movieTitle", movies.get(position).getTitle());
                intent.putExtra("movieDate",movies.get(position).getDate());
                intent.putExtra("movieLevel",movies.get(position).getLevel());
                intent.putExtra("movieText",movies.get(position).getText());


                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static final class MovieViewHolder extends RecyclerView.ViewHolder {

        CardView courseBg;
        ImageView movieImage;
        TextView movieTitle, movieDate, movieLevel;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            movieImage = itemView.findViewById(R.id.movieImage);
            movieDate = itemView.findViewById(R.id.movieDate);
            movieLevel = itemView.findViewById(R.id.movieLevel);
            movieTitle = itemView.findViewById(R.id.movieTitle);

        }
    }

}
