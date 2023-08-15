package com.Assignment3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import com.Assignment3.Car;


public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    private List<Car> cars;
    private Context context;
    private final RecyclerViewInterface recyclerViewInterface;

    public CarAdapter(List<Car> cars, Context context,RecyclerViewInterface recyclerViewInterface) {
        this.cars = cars;
        this.context=context;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item, parent, false);
        return new CarViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
            Car car = cars.get(position);

            holder.carImage.setImageResource(car.getImageId());
            holder.carName.setText(car.getName());
            holder.carPrice.setText(car.getPrice());
            holder.carDescription.setText(car.getDescription());

    }
    public void setCarList(List<Car> cars) {
        this.cars = cars;
    }


    public void filterBySoldStatus(boolean sold) {
        List<Car> filteredList = new ArrayList<>();
        for (Car car : cars) {
            if (car.isSold() == sold) {
                filteredList.add(car);
            }
        }
        setCarList(filteredList);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return cars.size();
    }


}
