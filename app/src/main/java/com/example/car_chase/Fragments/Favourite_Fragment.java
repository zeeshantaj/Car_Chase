package com.example.car_chase.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Adapterte.BrandRecycler;
import com.example.car_chase.Adapterte.FavouriteRecycler;
import com.example.car_chase.Model.BrandList;
import com.example.car_chase.Model.FavouriteList;
import com.example.car_chase.R;

import java.util.ArrayList;
import java.util.List;

public class Favourite_Fragment extends Fragment {
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.favourite_fragment,container,false);

        initRecycler();
        return view;
    }
    private void initRecycler(){
        List<FavouriteList> favouriteLists = new ArrayList<>();

        FavouriteList favoriteModel = new FavouriteList("Tesla model 3","$ 7,500","4.5","192",R.drawable.model_tesla3);
        FavouriteList favoriteModel1 = new FavouriteList("Mercedes Benz GLE","$ 39,500","4.6","331",R.drawable.model_mercedes);
        FavouriteList favoriteModel2 = new FavouriteList("Suzuki Vitara","$ 29,990","4.4","12",R.drawable.model_suzuki_vitra);
        FavouriteList favoriteModel3 = new FavouriteList("BMW M2","$ 64,195","4.1","121",R.drawable.model_bmw);

        favouriteLists.add(favoriteModel);
        favouriteLists.add(favoriteModel1);
        favouriteLists.add(favoriteModel2);
        favouriteLists.add(favoriteModel3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.favouriteRecycler);
        recyclerView.setLayoutManager(layoutManager);
        FavouriteRecycler adapter = new FavouriteRecycler(favouriteLists);
        recyclerView.setAdapter(adapter);
    }

}
