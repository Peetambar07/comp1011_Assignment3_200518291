package com.Assignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddCarActivity extends AppCompatActivity {

    private EditText carNameEditText, carPriceEditText, carDescriptionEditText, carImageEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        carNameEditText = findViewById(R.id.carNameEditText);
        carPriceEditText = findViewById(R.id.carPriceEditText);
        carDescriptionEditText = findViewById(R.id.carDescriptionEditText);
        carImageEditText = findViewById(R.id.carImageEditText);
        addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String carName = carNameEditText.getText().toString().trim();
                String carPrice = carPriceEditText.getText().toString().trim();
                String carDescription = carDescriptionEditText.getText().toString().trim();
                String carImage = carImageEditText.getText().toString().trim();

                if (carName.isEmpty()) {
                    carNameEditText.setError("Car name is required!");
                    carNameEditText.requestFocus();
                    return;
                }

                if (carPrice.isEmpty()) {
                    carPriceEditText.setError("Car price is required!");
                    carPriceEditText.requestFocus();
                    return;
                }

                if (carDescription.isEmpty()) {
                    carDescriptionEditText.setError("Car description is required!");
                    carDescriptionEditText.requestFocus();
                    return;
                }

                if (carImage.isEmpty()) {
                    carImageEditText.setError("Car image URL is required!");
                    carImageEditText.requestFocus();
                    return;
                }

                int imageId = getResources().getIdentifier(carImage, "drawable", getPackageName());

                Car newCar = new Car(imageId, carName, carPrice, carDescription);

                // Do something with the necar object, like adding it to a list or saving to database

                finish();
            }
        });
    }
}
