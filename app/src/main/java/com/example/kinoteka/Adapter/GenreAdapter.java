package com.example.kinoteka.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kinoteka.HomeActivity;
import com.example.kinoteka.Model.Genre;
import com.example.kinoteka.R;

import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {

    Context context;
    List<Genre> genreies;

    public GenreAdapter(Context context, List<Genre> genreies) {
        this.context = context;
        this.genreies = genreies;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View genreItems = LayoutInflater.from(context).inflate(R.layout.genre_item, parent, false);
        return new GenreViewHolder(genreItems);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreAdapter.GenreViewHolder holder, int position) {

        holder.genreTitle.setText(genreies.get(position).getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.showMovieByCategories(genreies.get(position).getId());

            }
        });
    }

    @Override
    public int getItemCount() {
        return genreies.size();
    }

    public static final class GenreViewHolder extends RecyclerView.ViewHolder {

        TextView genreTitle;

        public GenreViewHolder(@NonNull View itemView) {
            super(itemView);

            genreTitle = itemView.findViewById(R.id.genreTitle);
        }


    }


}
