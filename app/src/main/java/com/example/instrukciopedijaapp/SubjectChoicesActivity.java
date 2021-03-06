package com.example.instrukciopedijaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.common.io.LittleEndianDataInputStream;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

public class SubjectChoicesActivity extends AppCompatActivity {

    Button btn_back;
    Button fizika_btn, lektire_btn, matematika_btn, hrvatski_btn, ekonomija_btn, glazbeni_btn, arhitektura_btn,
            programiranje_btn, povijest_btn, likovni_btn, racunovodstvo_btn, njemacki_btn, francuski_btn, talijanski_btn,
            engleski_btn, ruski_btn, ostali_strani_jezici, kemija_btn, elektrotehnika_btn, strojarstvo_btn,
            geografija_btn, biologija_btn, informatika_btn, sociologija_btn, medicina_btn, drzavna_matura__btn,
            pravo_btn, pregled_predmeta;
    private FirebaseAuth mAuth;
    DatabaseReference mRef;
    ///////////////////////////////////////
    private ListView list_id;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    //////////////////////////////////////
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




        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userId = user.getUid();


        fizika_btn = findViewById(R.id.fizika_btn);
        glazbeni_btn = findViewById(R.id.glazbeni_btn);
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
        pregled_predmeta = findViewById(R.id.pregled_predmeta);



        fizika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Fizika");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        matematika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Matematika");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        hrvatski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Hrvatski");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        povijest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Povijest");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        likovni_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Likovni");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        njemacki_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Njemacki");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        francuski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Francuski");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });
        geografija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Geografija");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        talijanski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Talijanski");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        engleski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Engleski");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });
        ruski_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Ruski");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });
        ostali_strani_jezici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Ostali jezici");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        kemija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Kemija");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        biologija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Biologija");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        informatika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Informatika");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });


        pravo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Pravo");
                BttomSheetLaw bottomSheetLaw = new BttomSheetLaw();
                bottomSheetLaw.setArguments(args);
                bottomSheetLaw.show(getSupportFragmentManager(), "TAG");
            }
        });


        lektire_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetLektire bottomSheetLektire = new BottomSheetLektire();
                bottomSheetLektire.show(getSupportFragmentManager(), "TAG");
            }
        });


//Predmeti sa samo srednjom i faksom


        ekonomija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Ekonomija");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });



        arhitektura_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Arhitektura");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });


        programiranje_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Programiranje");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        racunovodstvo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Racunovodstvo");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });


        elektrotehnika_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Elektrotehnika");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });


        strojarstvo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Strojarstvo");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        sociologija_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Sociologija");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        medicina_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Medicina");
                BottomSheetFAXSS bottomSheet = new BottomSheetFAXSS();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });


        glazbeni_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Glazbeni");
                BottomSheet bottomSheet = new BottomSheet();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });


        drzavna_matura__btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("predmet", "Matura");
                BottomSheetMatura bottomSheet = new BottomSheetMatura();
                bottomSheet.setArguments(args);
                bottomSheet.show(getSupportFragmentManager(), "TAG");
            }
        });

        pregled_predmeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubjectChoicesActivity.this, ConfirmSubjectsActivity.class);
                startActivity(intent);
            }
        });



    }


}