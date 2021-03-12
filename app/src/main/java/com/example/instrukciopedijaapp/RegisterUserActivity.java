package com.example.instrukciopedijaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterUserActivity extends AppCompatActivity {

    EditText korisnicko_ime_instruktora;
    EditText korisnicki_email_instruktora;
    EditText korisnicki_telefon_instruktora;
    EditText korisnicka_lokacija_instruktora;
    EditText lozinka_instruktora;
    ImageView slika_instruktora;
    Button button_dalje;
    boolean valid = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        korisnicko_ime_instruktora = findViewById(R.id.korisnicko_ime_instruktora);
        korisnicki_email_instruktora = findViewById(R.id.korisnicki_email_instruktora);
        korisnicki_telefon_instruktora = findViewById(R.id.korisnicki_telefon_instruktora);
        korisnicka_lokacija_instruktora = findViewById(R.id.korisnicka_lokacija_instruktora);
        lozinka_instruktora = findViewById(R.id.lozinka_instruktora);
        slika_instruktora = findViewById(R.id.slika_instruktora);
        button_dalje = findViewById(R.id.button_dalje);






    }
    public void back_btn(View view){
        startActivity(new Intent(RegisterUserActivity.this, LoginActivity.class));
    }



}