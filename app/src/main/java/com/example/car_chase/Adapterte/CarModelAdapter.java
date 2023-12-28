package com.example.car_chase.Adapterte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Model.CarModelList;
import com.example.car_chase.R;

import java.util.List;

public class CarModelAdapter extends RecyclerView.Adapter<CarModelAdapter.ViewHolder> {

    private List<CarModelList> carModelLists;
    private boolean isHeartFilled;

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
        holder.heart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (isHeartFilled) {
                     holder.heart_img.setImageResource(R.drawable.black_heart_icon);
                    Toast.makeText(v.getContext(), "Set to favourite", Toast.LENGTH_SHORT).show();
                } else {
                    holder.heart_img.setImageResource(R.drawable.heart_filled); // Filled heart image
                    Toast.makeText(v.getContext(), "Remove from favourite", Toast.LENGTH_SHORT).show();
                }
                isHeartFilled = !isHeartFilled;

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
        }
    }
}
