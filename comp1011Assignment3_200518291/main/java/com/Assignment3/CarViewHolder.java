package com.Assignment3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CarViewHolder extends RecyclerView.ViewHolder {
    ImageView carImage;
    TextView carName;
    TextView carPrice;
    TextView carDescription;
    public CardView cardView;

    public CarViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);

        carImage = itemView.findViewById(R.id.car_image);
        carName = itemView.findViewById(R.id.car_name);
        carPrice = itemView.findViewById(R.id.car_price);
        carDescription = itemView.findViewById(R.id.car_description);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerViewInterface !=null){
                    int pos = getAdapterPosition();

                    if(pos !=RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);}
                }
            }
        });
    }
}
