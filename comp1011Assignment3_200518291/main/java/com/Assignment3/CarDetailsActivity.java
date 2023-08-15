package com.Assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CarDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        // Get the intent that started this activity and extract the car information
        Intent intent = getIntent();
        String make = intent.getStringExtra("make");
        String model = intent.getStringExtra("model");
        String condition = intent.getStringExtra("condition");
        String engineCylinders = intent.getStringExtra("engineCylinders");
        String year = intent.getStringExtra("year");
        String numberOfDoors = intent.getStringExtra("numberOfDoors");
        String price = intent.getStringExtra("price");
        String color = intent.getStringExtra("color");
        int imageId = intent.getIntExtra("imageId", 0);
        String dateSold = intent.getStringExtra("dateSold");

        // Set the car information to the corresponding views
        ImageView carImage = findViewById(R.id.car_image);
        carImage.setImageResource(imageId);

        TextView carName = findViewById(R.id.car_model);
        carName.setText(make + " ");
        TextView carCondition = findViewById(R.id.car_condition);
        carCondition.setText(condition);

        TextView carEngineCylinders = findViewById(R.id.car_engine_cylinders);
        carEngineCylinders.setText(engineCylinders);

        TextView carYear = findViewById(R.id.car_year);
        carYear.setText(year);

        TextView carNumberOfDoors = findViewById(R.id.car_num_doors);
        carNumberOfDoors.setText(numberOfDoors);

        TextView carPrice = findViewById(R.id.car_price);
        carPrice.setText(price);

        TextView carColor = findViewById(R.id.car_color);
        carColor.setText(color);

        TextView carDateSold = findViewById(R.id.car_date_sold);
        if (dateSold == null) {
            carDateSold.setVisibility(View.GONE);
        } else {
            carDateSold.setText(dateSold);
        }


    }
}
