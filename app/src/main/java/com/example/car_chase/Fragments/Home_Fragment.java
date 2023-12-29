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
        CarModelList model = new CarModelList("Tesla model 3","$ 7,500","4.5","Model 3 is fully electric with 333 miles of estimated range, so you never need to visit a gas station again. You can charge at home anytime, or plug in on the road with access to over 50,000 Superchargers worldwide.",R.drawable.model_tesla3);
        CarModelList model1 = new CarModelList("Mercedes Benz GLE","$ 39,500","4.6","The Mercedes-Benz GLE has 1 Diesel Engine and 1 Petrol Engine on offer. The Diesel engine is 1993 cc while the Petrol engine is 2999 cc . It is available with Automatic transmission.Depending upon the variant and fuel type the GLE has a mileage of . The GLE is a 5 seater 6 cylinder car and has length of 4926, width of 2157 and a wheelbase of 2995.",R.drawable.model_mercedes);
        CarModelList model2 = new CarModelList("Honda Civic 4.5","$ 25,350","4.3","he Honda Civic has 1 Diesel Engine and 1 Petrol Engine on offer. The Diesel engine is 1597 cc while the Petrol engine is 1799 cc . It is available with Manual & Automatic transmission. Depending upon the variant and fuel type the Civic has a mileage of 16.5 to 26.8 kmpl",R.drawable.car3);
        CarModelList model3 = new CarModelList("Suzuki Vitara","$ 29,990","4.4","Vitara is available in 1 transmission option(s) i.e Automatic. The Vitara car has a fuel average of 13 KM/L with a fuel tank capacity of 47L. With the dimensions of 4175 mm in length, 1775 mm in width, and 1610 mm in height ,the Vitara has a seating capacity of 5 persons.",R.drawable.model_suzuki_vitra);
        CarModelList model4 = new CarModelList("Toyota Aqua","$ 29,600","4.3","Toyota Aqua is available in 1 engine option(s) i.e. Hybrid. The Toyota Aqua is capable of generating a horsepower of 116 HP and a torque of 120 Nm with a top speed of 180 KM/H. Aqua is available in 1 transmission option(s) i.e Automatic. The Aqua car has a fuel average of 24 KM/L with a fuel tank capacity of 36L.",R.drawable.model_toyota_aqua);
        CarModelList model6 = new CarModelList("Mazda6","$ 35,200","4.1","The standard engine makes 187 horsepower, while the available turbocharged engine generates up to 250 horsepower. The turbo 2.5-liter gained 10 pound-feet of torque for 2021, raising that output to 320 pound-feet, but this requires using premium fuel.",R.drawable.car1);
        CarModelList model5 = new CarModelList("BMW M2","$ 64,195","4.1","The M2 is powered by a twin-turbocharged 3.0-liter inline-six, which churns out a whopping 453 horsepower and 406 pound-ft of torque. This is the same engine that is standard in M3s and M4s, though here it makes 20 fewer horsepower; its torque output is identical",R.drawable.model_bmw);


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
