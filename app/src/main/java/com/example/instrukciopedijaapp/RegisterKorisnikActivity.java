package com.example.instrukciopedijaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class RegisterKorisnikActivity extends AppCompatActivity {

    EditText korisnicko_ime;
    EditText korisnicki_email;
    EditText korisnicki_telefon;
    EditText korisnicka_lokacija;
    EditText registriraj_se_kao_korisnik;
    ImageView korisnicka_slika;
    Button button_reg_korisnik;
    boolean valid = true;


    Button back_btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_korisnik);


        korisnicko_ime = findViewById(R.id.korisnicko_ime);
        korisnicki_email = findViewById(R.id.korisnicki_email);
        korisnicki_telefon = findViewById(R.id.korisnicki_telefon);
        korisnicka_lokacija = findViewById(R.id.korisnicka_lokacija);
        registriraj_se_kao_korisnik = findViewById(R.id.registriraj_se_kao_korisnik);
        korisnicka_slika = findViewById(R.id.korisnicka_slika);
        button_reg_korisnik = findViewById(R.id.button_reg_korisnik);






        back_btn_2 = findViewById(R.id.back_btn_2);
        back_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterKorisnikActivity.this, LoginActivity.class));
            }
        });
    }





}