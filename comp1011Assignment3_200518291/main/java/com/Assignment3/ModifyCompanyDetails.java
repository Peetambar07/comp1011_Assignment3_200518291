package com.Assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ModifyCompanyDetails extends AppCompatActivity {

    private EditText editTextAboutUs;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_company_details);

        editTextAboutUs = findViewById(R.id.editText_about_us);
        buttonSave = findViewById(R.id.button_save);

        Intent intent = getIntent();
        String aboutUsText = intent.getStringExtra("aboutUsText");
        editTextAboutUs.setText(aboutUsText);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCompanyDetails();
            }
        });
    }

    private void saveCompanyDetails() {

        String aboutUsText = editTextAboutUs.getText().toString().trim();

        Intent intent = new Intent();
        intent.putExtra("aboutUsText", aboutUsText);
        setResult(RESULT_OK, intent);
        finish();
    }
}
