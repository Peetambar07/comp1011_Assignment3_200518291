package com.Assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyCarActivity extends AppCompatActivity {

    private EditText editTextMakeModel;
    private EditText editTextPrice;
    private EditText editTextDescription;
    private ImageView imageViewCar;
    private Button buttonSave;
    private Button buttonDelete;

    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_car);

        // Get the car object passed from the previous activity
        Intent intent = getIntent();
        car = intent.getParcelableExtra("car");


        editTextMakeModel = findViewById(R.id.editText_make_model);
        editTextPrice = findViewById(R.id.editText_price);
        editTextDescription = findViewById(R.id.editText_description);
        imageViewCar = findViewById(R.id.imageView_car);
        buttonSave = findViewById(R.id.button_save);
        buttonDelete = findViewById(R.id.button_delete);



        editTextPrice.setText(car.getPrice());
        editTextDescription.setText(car.getDescription());


        // Set click listeners for the Save and Delete buttons
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCarDetails();
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteCar();
            }
        });
    }

    private void saveCarDetails() {
        // Get the updated car details from the UI elements
        String makeModel = editTextMakeModel.getText().toString().trim();
        String price = editTextPrice.getText().toString().trim();
        String description = editTextDescription.getText().toString().trim();

        // Validate the input
        if (makeModel.isEmpty() || price.isEmpty()) {
            Toast.makeText(this, "Please enter make and price", Toast.LENGTH_SHORT).show();
            return;
        }

        // Update the car object with the new details
        car.setMakeModel(makeModel);
        car.setPrice(price);
        car.setDescription(description);

        // Send the updated car object back to the previous activity
        Intent intent = new Intent();
        intent.putExtra("car", (Parcelable) car);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void deleteCar() {
        // Send the car object to be deleted back to the previous activity
        Intent intent = new Intent();
        intent.putExtra("car", (Parcelable) car);
        setResult(RESULT_CANCELED, intent);
        finish();
    }
}

