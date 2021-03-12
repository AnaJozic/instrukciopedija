package com.example.instrukciopedijaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterUserActivity extends AppCompatActivity {


    FirebaseAuth fAuth;
    FirebaseFirestore fStore;

    private EditText korisnicko_ime_instruktora, korisnicki_email_instruktora, korisnicki_telefon_instruktora, korisnicka_lokacija_instruktora, lozinka_instruktora;
    private ImageView slika_instruktora;
    Button button_dalje;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        korisnicko_ime_instruktora = findViewById(R.id.korisnicko_ime_instruktora);
        korisnicki_email_instruktora = findViewById(R.id.korisnicki_email_instruktora);
        korisnicki_telefon_instruktora = findViewById(R.id.korisnicki_telefon_instruktora);
        korisnicka_lokacija_instruktora = findViewById(R.id.korisnicka_lokacija_instruktora);
        lozinka_instruktora = findViewById(R.id.lozinka_instruktora);


        button_dalje = findViewById(R.id.button_dalje);


        button_dalje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

    }
    public void back_btn(View view){
        startActivity(new Intent(RegisterUserActivity.this, LoginActivity.class));
    }
    private void check() {
        String username = korisnicko_ime_instruktora.getText().toString();
        String email = korisnicki_email_instruktora.getText().toString();
        String password = lozinka_instruktora.getText().toString();

        if (username.isEmpty() || username.length()<6)
        {
            showError(korisnicko_ime_instruktora, "Username not valid!");
        }
        else if (email.isEmpty() || !email.contains("@")){
            showError(korisnicki_email_instruktora, "Email is not valid!");
        }
        else if (password.isEmpty() || password.length()<7){
            showError(lozinka_instruktora, "Password must be at least 7 characters long!");
        }
        else{
                Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show();

        }

    }


    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }


}