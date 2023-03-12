package com.example.splashscreen;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ForgetPasswordAcyivity extends AppCompatActivity {


    EditText phone;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_acyivity);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(view -> {
            Intent i = new Intent();
            String massege = phone.getText().toString().trim();
            i.putExtra("professional",massege);
            setResult(2, i);
            finish();
        });




    }
}