package com.example.car_chase.Adapterte;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Model.BrandList;
import com.example.car_chase.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BrandRecycler extends RecyclerView.Adapter<BrandRecycler.ViewHolder> {

    private List<BrandList> brandLists;

    public BrandRecycler(List<BrandList> brandLists) {
        this.brandLists = brandLists;
    }

    @NonNull
    @Override
    public BrandRecycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_recycler_itrem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandRecycler.ViewHolder holder, int position) {

        BrandList brandModel = brandLists.get(position);
        holder.title.setText(brandModel.getBrandTitle());
        holder.imageView.setImageResource(brandModel.getBrandImage());

    }

    @Override
    public int getItemCount() {
        return brandLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imageView;
        private TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.brand_img);
            title = itemView.findViewById(R.id.brandTitle);
        }
    }
}
