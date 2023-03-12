package com.example.splashscreen;

import static com.example.splashscreen.R.layout.activity_login_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class LoginScreen extends AppCompatActivity {
    EditText yourname, idnumber;
    TextInputLayout password;
    Button login;
    TextView fPassword, signUp;
    ImageView faceBook, google, phone, gps;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login_screen);
        yourname = findViewById(R.id.yourname);
        idnumber = findViewById(R.id.idno);
        password = findViewById(R.id.passwordfield);
        login = findViewById(R.id.startadventure);
        signUp = findViewById(R.id.signup);
        faceBook = findViewById(R.id.imageView7);
        google = findViewById(R.id.imageView6);
        phone = findViewById(R.id.imageView8);
        gps = findViewById(R.id.imageView9);
        fPassword = findViewById(R.id.forgrtpassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(yourname.getText().toString().trim().length()> 0 &&
                        password.getEditText().getText().toString().trim().length() > 0 &&
                            idnumber.getText().toString().trim().length() > 0){
                    Intent intent = new Intent(LoginScreen.this,SecoundActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginScreen.this, "Please Enter Your Name Or You password To Help You", Toast.LENGTH_SHORT).show();
                }
            }
        });
            faceBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri uri = Uri.parse("https://www.facebook.com");
                    Intent intent = new Intent(Intent.ACTION_VIEW , uri);
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }

                }
            });
            google.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://myaccount.google.com"));
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }
                }
            });

            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri c = Uri.parse("tel: 01023681403");
                    Intent intent = new Intent(Intent.ACTION_DIAL, c);
                    if (intent.resolveActivity(getPackageManager()) != null){
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginScreen.this, "please Download App", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            gps.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri g = Uri.parse("geo:26.8358, 30.7957?z=-10");
                    Intent intent = new Intent(Intent.ACTION_VIEW, g);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginScreen.this, "please Download App", Toast.LENGTH_SHORT).show();
                    }
                }
                });
            fPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginScreen.this,ForgetPasswordAcyivity.class );
                    startActivityForResult(intent, 1);
                }
            });




            }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1 && resultCode==2){
            String profession = data.getStringExtra("professional");
            Toast.makeText(LoginScreen.this, "Your phone is" + profession, Toast.LENGTH_SHORT).show();
        }

    }

}