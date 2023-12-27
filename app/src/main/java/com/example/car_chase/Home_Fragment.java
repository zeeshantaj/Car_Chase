package com.example.car_chase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.car_chase.Adapterte.BrandRecycler;
import com.example.car_chase.Adapterte.CarModelAdapter;
import com.example.car_chase.Model.BrandList;
import com.example.car_chase.Model.CarModelList;

import java.util.ArrayList;
import java.util.List;

public class Home_Fragment extends Fragment {

    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment,container,false);


        initBrandRecycler();
        initModelRecycler();
        return view;
    }
    private void initModelRecycler(){

        List<CarModelList> carModelLists = new ArrayList<>();
        CarModelList model = new CarModelList("Tesla model 3","$ 40,200","4.5",R.drawable.car1);
        CarModelList model1 = new CarModelList("Tesla model x","$ 49,100","4.4",R.drawable.car2);
        CarModelList model2 = new CarModelList("Honda City 4.5","$ 20,200","4.3",R.drawable.car3);
        CarModelList model3 = new CarModelList("Honda City 4.1","$ 11,500","4.2",R.drawable.car1);
        CarModelList model4 = new CarModelList("Toyota Aquarius turbo","$ 17,700","4.1",R.drawable.car2);

        carModelLists.add(model);
        carModelLists.add(model1);
        carModelLists.add(model2);
        carModelLists.add(model3);
        carModelLists.add(model4);

        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        RecyclerView recyclerView = view.findViewById(R.id.modelRecycler);
        recyclerView.setLayoutManager(layoutManager);
        CarModelAdapter adapter = new CarModelAdapter(carModelLists);
        recyclerView.setAdapter(adapter);
    }
    private void initBrandRecycler(){
        List<BrandList> brandLists = new ArrayList<>();
        BrandList branModel = new BrandList("Tesla",R.drawable.car1);
        BrandList branModel1 = new BrandList("Tesla",R.drawable.car1);
        BrandList branModel2 = new BrandList("Tesla",R.drawable.car1);
        BrandList branModel3 = new BrandList("Tesla",R.drawable.car1);
        BrandList branModel4 = new BrandList("Tesla",R.drawable.car1);
        BrandList branMode5 = new BrandList("Tesla",R.drawable.car1);

        brandLists.add(branModel);
        brandLists.add(branModel1);
        brandLists.add(branModel2);
        brandLists.add(branModel3);
        brandLists.add(branModel4);
        brandLists.add(branMode5);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.brandRecycler);
        recyclerView.setLayoutManager(layoutManager);
        BrandRecycler adapter = new BrandRecycler(brandLists);
        recyclerView.setAdapter(adapter);
    }
}
