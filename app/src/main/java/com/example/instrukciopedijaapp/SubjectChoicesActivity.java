package com.example.instrukciopedijaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SubjectChoicesActivity<Checkbox> extends AppCompatActivity {

    Button btn_back;
    Button fizika_btn, lektire_btn, matematika_btn, hrvatski_btn, ekonomija_btn, glazbeni_btn, arhitektura_btn,
            programiranje_btn, povijest_btn, likovni_btn, racunovodstvo_btn, njemacki_btn, francuski_btn, talijanski_btn,
            engleski_btn, ruski_btn, ostali_strani_jezici, kemija_btn, elektrotehnika_btn, strojarstvo_btn,
            geografija_btn, biologija_btn, informatika_btn, sociologija_btn, medicina_btn, drzavna_matura__btn,
            pravo_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_choices);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubjectChoicesActivity.this, RegisterUserActivity.class));
            }
        });


        fizika_btn = findViewById(R.id.fizika_btn);
        lektire_btn = findViewById(R.id.lektire_btn);
        matematika_btn = findViewById(R.id.matematika_btn);
        hrvatski_btn = findViewById(R.id.hrvatski_btn);
        ekonomija_btn = findViewById(R.id.ekonomija_btn);
        arhitektura_btn = findViewById(R.id.arhitektura_btn);
        programiranje_btn = findViewById(R.id.programiranje_btn);
        povijest_btn = findViewById(R.id.povijest_btn);
        likovni_btn = findViewById(R.id.likovni_btn);
        racunovodstvo_btn = findViewById(R.id.racunovodstvo_btn);
        njemacki_btn = findViewById(R.id.njemacki_btn);
        francuski_btn = findViewById(R.id.francuski_btn);
        talijanski_btn = findViewById(R.id.talijanski_btn);
        engleski_btn = findViewById(R.id.engleski_btn);
        ruski_btn = findViewById(R.id.ruski_btn);
        ostali_strani_jezici = findViewById(R.id.ostali_strani_jezici);
        kemija_btn = findViewById(R.id.kemija_btn);
        elektrotehnika_btn = findViewById(R.id.elektrotehnika_btn);
        strojarstvo_btn = findViewById(R.id.strojarstvo_btn);
        geografija_btn = findViewById(R.id.geografija_btn);
        biologija_btn = findViewById(R.id.biologija_btn);
        informatika_btn = findViewById(R.id.informatika_btn);
        sociologija_btn = findViewById(R.id.sociologija_btn);
        medicina_btn = findViewById(R.id.medicina_btn);
        drzavna_matura__btn = findViewById(R.id.drzavna_matura__btn);
        pravo_btn = findViewById(R.id.pravo_btn);






        fizika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String predmet = "Fizika";
                //Intent i = new Intent(SubjectChoicesActivity.this, BottomSheet.class);
                //i.putExtra("predmet", predmet);
                //startActivity(i);

                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        matematika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        hrvatski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        povijest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        likovni_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        njemacki_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        francuski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        talijanski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        engleski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        kemija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        biologija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        informatika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });



    }


}