package com.Assignment3;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private RecyclerView carList;
    private CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car(R.drawable.car1, "Toyota Camry", "$25,000", "The Toyota Camry is a mid-size car."));
        cars.add(new Car(R.drawable.car2, "Honda Civic", "$20,000", "The Honda Civic is a compact car."));
        cars.add(new Car(R.drawable.car3, "Chevrolet Corvette", "$70,000", "The Chevrolet Corvette is a sports car."));
        cars.add(new Car(R.drawable.car4, "Ford Mustang", "$30,000", "The Ford Mustang is a pony car."));
        cars.add(new Car(R.drawable.car5, "Jeep Wrangler", "$35,000", "The Jeep Wrangler is an off-road vehicle."));
        cars.add(new Car(R.drawable.car6, "Tesla Model S", "$80,000", "The Tesla Model S is an electric car."));
        cars.add(new Car(R.drawable.car7, "BMW 3 Series", "$40,000", "The BMW 3 Series is a luxury car."));
        cars.add(new Car(R.drawable.car8, "Audi A4", "$35,000", "The Audi A4 is a luxury car."));
        cars.add(new Car(R.drawable.car9, "Mercedes-Benz E-Class", "$60,000", "The Mercedes-Benz E-Class is a luxury car."));
        cars.add(new Car(R.drawable.car10, "Lamborghini Aventador", "$400,000", "The Lamborghini Aventador is a supercar."));

        carList = findViewById(R.id.car_list);
        carAdapter = new CarAdapter(cars, this, this);
        carList.setLayoutManager(new LinearLayoutManager(this));
        carList.setAdapter(carAdapter);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_car:

                Intent intent = new Intent(this, AddCarActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_about_us:

                Intent aboutIntent = new Intent(this, AboutUsActivity.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_modify_car:

                Intent aboutIntent = new Intent(this, ModifyCarActivity.class);
                startActivity(aboutIntent);
                return true;
            case R.id.action_modify_company_details:

                Intent aboutIntent = new Intent(this, ModifyCompanyDetails.class);
                startActivity(aboutIntent);
                return true;

            case R.id.action_sold_cars:

                carAdapter.filterBySoldStatus(true);
                return true;
            case R.id.action_unsold_cars:

                carAdapter.filterBySoldStatus(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemClick(int position) {
        // Get the car information at the clicked position
        Car clickedCar = carList.get(position);

        // Create an intent to start the CarDetailsActivity
        Intent intent = new Intent(MainActivity.this, CarDetailsActivity.class);
        intent.putExtra("make", clickedCar.getMake());
        intent.putExtra("model", clickedCar.getModel());
        intent.putExtra("condition", clickedCar.getCondition());
        intent.putExtra("engineCylinders", clickedCar.getEngineCylinders());
        intent.putExtra("year", clickedCar.getYear());
        intent.putExtra("numberOfDoors", clickedCar.getNumberOfDoors());
        intent.putExtra("price", clickedCar.getPrice());
        intent.putExtra("color", clickedCar.getColor());
        intent.putExtra("imageId", clickedCar.getImageId());
        intent.putExtra("dateSold", clickedCar.getDateSold());

        // Start the CarDetailsActivity
        startActivity(intent);
    }


