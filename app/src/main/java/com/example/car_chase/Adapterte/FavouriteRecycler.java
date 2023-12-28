package com.example.car_chase.Adapterte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Model.FavouriteList;
import com.example.car_chase.R;

import java.util.List;

public class FavouriteRecycler extends RecyclerView.Adapter<FavouriteRecycler.ViewHolder> {
    private List<FavouriteList> favouriteLists;

    public FavouriteRecycler(List<FavouriteList> favouriteLists) {
        this.favouriteLists = favouriteLists;
    }

    @NonNull
    @Override
    public FavouriteRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourite_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteRecycler.ViewHolder holder, int position) {

        FavouriteList modelList = favouriteLists.get(position);
        holder.title.setText(modelList.getCarTitle());
        holder.price.setText(modelList.getCarPrice());
        holder.votes.setText(modelList.getCarVotes()+" Viewers");
        holder.rating.setText(modelList.getCarRating());
        holder.carImage.setImageResource(modelList.getCarImage());
    }

    @Override
    public int getItemCount() {
        return favouriteLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,price,rating,votes;
        private ImageView carImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView8);
            price = itemView.findViewById(R.id.textView9);
            rating = itemView.findViewById(R.id.textView10);
            votes = itemView.findViewById(R.id.votersTxt);
            carImage = itemView.findViewById(R.id.imageView3);

        }
    }
}
