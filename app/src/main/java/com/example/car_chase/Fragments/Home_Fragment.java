package com.example.car_chase.Fragments;

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
import com.example.car_chase.R;

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
        CarModelList model = new CarModelList("Tesla model 3","$ 7,500","4.5",R.drawable.model_tesla3);
        CarModelList model1 = new CarModelList("Mercedes Benz GLE","$ 39,500","4.6",R.drawable.model_mercedes);
        CarModelList model2 = new CarModelList("Honda Civic 4.5","$ 25,350","4.3",R.drawable.car3);
        CarModelList model3 = new CarModelList("Suzuki Vitara","$ 29,990","4.4",R.drawable.model_suzuki_vitra);
        CarModelList model4 = new CarModelList("Toyota Aquarius","$ 29,600","4.3",R.drawable.model_toyota_aqua);
        CarModelList model6 = new CarModelList("Mazda6","$ 35,200","4.1",R.drawable.car1);
        CarModelList model5 = new CarModelList("BMW M2","$ 64,195","4.1",R.drawable.model_bmw);


        carModelLists.add(model);
        carModelLists.add(model1);
        carModelLists.add(model2);
        carModelLists.add(model3);
        carModelLists.add(model4);
        carModelLists.add(model6);
        carModelLists.add(model5);

        LinearLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        RecyclerView recyclerView = view.findViewById(R.id.modelRecycler);
        recyclerView.setLayoutManager(layoutManager);
        CarModelAdapter adapter = new CarModelAdapter(carModelLists);
        recyclerView.setAdapter(adapter);
    }
    private void initBrandRecycler(){
        List<BrandList> brandLists = new ArrayList<>();
        BrandList branModel = new BrandList("Tesla",R.drawable.tesla_logo);
        BrandList branModel1 = new BrandList("Honda",R.drawable.honda_logo);
        BrandList branModel2 = new BrandList("BMW",R.drawable.bmw_logo);
        BrandList branModel3 = new BrandList("Mercedes",R.drawable.mercedes_logo);
        BrandList branModel4 = new BrandList("Kia",R.drawable.kia_logo);
        BrandList branMode5 = new BrandList("Suzuki",R.drawable.suzuki_logo);
        BrandList branMode6 = new BrandList("Toyota",R.drawable.toyota_logo);
        BrandList branMode7 = new BrandList("Mazda",R.drawable.mazda_logo);

        brandLists.add(branModel);
        brandLists.add(branModel1);
        brandLists.add(branModel2);
        brandLists.add(branModel3);
        brandLists.add(branModel4);
        brandLists.add(branMode5);
        brandLists.add(branMode6);
        brandLists.add(branMode7);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.brandRecycler);
        recyclerView.setLayoutManager(layoutManager);
        BrandRecycler adapter = new BrandRecycler(brandLists);
        recyclerView.setAdapter(adapter);
    }
}
