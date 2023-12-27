package com.example.car_chase.Adapterte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Model.CarModelList;
import com.example.car_chase.R;

import java.util.List;

public class CarModelAdapter extends RecyclerView.Adapter<CarModelAdapter.ViewHolder> {

    private List<CarModelList> carModelLists;

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

    }

    @Override
    public int getItemCount() {
        return carModelLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,price,rating;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.model_name);
            price = itemView.findViewById(R.id.model_price);
            rating = itemView.findViewById(R.id.model_rating_txt);
            imageView = itemView.findViewById(R.id.model_img);
        }
    }
}
