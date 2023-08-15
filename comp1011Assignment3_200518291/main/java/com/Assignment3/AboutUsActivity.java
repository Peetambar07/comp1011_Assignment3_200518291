package com.Assignment3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {

    private TextView aboutUsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        aboutUsTextView = findViewById(R.id.aboutUsTextView);
        aboutUsTextView.setText("Welcome to Georgian Cars, a trusted car dealership that specializes in buying and selling high-quality pre-owned vehicles. Our mission is to provide our customers with the best car-buying experience possible, by offering a wide range of vehicles at affordable prices, and delivering exceptional customer service every step of the way.\n" +
                "\n" +
                "At Georgian Cars, we take pride in the quality of our vehicles. We carefully inspect and handpick each car that comes into our inventory, to ensure that it meets our high standards for safety, reliability, and performance. We offer a diverse selection of cars, from sports cars and SUVs to sedans and trucks, so you're sure to find the perfect car for your needs and budget.\n" +
                "\n" +
                "Our team of experienced and knowledgeable professionals is here to guide you through the car-buying process, from helping you find the right car to securing financing and completing the paperwork. We understand that buying a car can be a daunting experience, which is why we strive to make it as easy and stress-free as possible.\n" +
                "\n" +
                "Whether you're looking to sell your current car or buy a new one, come visit Georgian Cars and experience the difference for yourself. We're committed to providing you with a hassle-free, enjoyable car-buying experience that you won't find anywhere else.");
    }
}
