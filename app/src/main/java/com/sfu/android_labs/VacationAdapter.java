package com.sfu.android_labs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VacationAdapter extends RecyclerView.Adapter<VacationAdapter.MovieViewHolder> {

    private final List<Vacation> vacations;

    public VacationAdapter(List<Vacation> vacations) {
        this.vacations = vacations;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.element_vacation, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder viewHolder, int i) {
        viewHolder.bind(vacations.get(i));
    }

    @Override
    public int getItemCount() {
        return vacations.size();
    }

    static final class MovieViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView descriptionTextView;
        private final ImageView posterImageView;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.movie_item__tv_name);
            descriptionTextView = itemView.findViewById(R.id.movie_item__tv_description);
            posterImageView = itemView.findViewById(R.id.movie_item__iv_poster);
        }

        private void bind(@NonNull Vacation vacation) {
            nameTextView.setText(vacation.name);
            descriptionTextView.setText(vacation.description);
            posterImageView.setImageResource(vacation.poster);
        }

    }

}
