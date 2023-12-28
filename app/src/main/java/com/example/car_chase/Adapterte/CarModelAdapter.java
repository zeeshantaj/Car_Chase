package com.example.car_chase.Adapterte;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Details.DetailsActivity;
import com.example.car_chase.Model.CarModelList;
import com.example.car_chase.R;

import java.util.List;

public class CarModelAdapter extends RecyclerView.Adapter<CarModelAdapter.ViewHolder> {

    private List<CarModelList> carModelLists;
    private boolean isHeartFilled = false;

    public CarModelAdapter(List<CarModelList> carModelLists) {
        this.carModelLists = carModelLists;
    }

    @NonNull
    @Override
    public CarModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_model_recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarModelAdapter.ViewHolder holder, int position) {
        CarModelList carModel = carModelLists.get(position);
        holder.title.setText(carModel.getCarName());
        holder.price.setText(carModel.getCarPrice());
        holder.rating.setText(carModel.getRating());

        holder.imageView.setImageResource(carModel.getCarImage());
        if (carModel.isFavourite()) {
            holder.heart_img.setImageResource(R.drawable.heart_filled); // Set filled heart image
        } else {
            holder.heart_img.setImageResource(R.drawable.black_heart_icon); // Set simple heart image
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }
    private void toggleHeartState(ImageView ImageView) {

    }
    @Override
    public int getItemCount() {
        return carModelLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,price,rating;
        private ImageView imageView,heart_img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.model_name);
            price = itemView.findViewById(R.id.model_price);
            rating = itemView.findViewById(R.id.model_rating_txt);
            imageView = itemView.findViewById(R.id.model_img);
            heart_img = itemView.findViewById(R.id.heart_img);

            heart_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        CarModelList currentItem = carModelLists.get(position);
                        currentItem.setFavourite(!currentItem.isFavourite()); // Toggle the favorite state

                        // Update the heart icon based on the favorite state
                        if (currentItem.isFavourite()) {
                            heart_img.setImageResource(R.drawable.heart_filled); // Set filled heart image
                            Toast.makeText(v.getContext(), "Added to favourite", Toast.LENGTH_SHORT).show();

                        } else {
                            heart_img.setImageResource(R.drawable.black_heart_icon); // Set simple heart image
                            Toast.makeText(v.getContext(), "Remove from favourite", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
    }
}
