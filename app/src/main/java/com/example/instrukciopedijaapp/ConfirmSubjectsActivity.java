package com.example.instrukciopedijaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ConfirmSubjectsActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private ListView list_id;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_subjects);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userId = user.getUid();

        arrayAdapter = new ArrayAdapter<String>(ConfirmSubjectsActivity.this, android.R.layout.simple_list_item_1, arrayList);
        list_id = findViewById(R.id.list_id);
        list_id.setAdapter(arrayAdapter);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").child(userId).child("Predmeti");


        mDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Object value = snapshot.getKey();
                    String valstring = value.toString();
                    String def = "def";
                    if(value != null){
                        if(valstring.contains("Njemacki")) {
                            if(valstring.contains("_os")){
                                def = "Njemački za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Njemački za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Njemački za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }

                        if(valstring.contains("Lektire")) {
                                def = "Lektire";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                        }

                        if(valstring.contains("Matematika")) {
                            if(valstring.contains("_os")){
                                def = "Matematika za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Matematika za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Matematika za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Fizika")) {
                            if(valstring.contains("_os")){
                                def = "Fizika za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Fizika za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Fizika za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Glazbeni")) {
                            if(valstring.contains("_os")){
                                def = "Glazbeni za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Glazbeni za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Glazbeni za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Hrvatski")) {
                            if(valstring.contains("_os")){
                                def = "Hrvatski za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Hrvatski za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Hrvatski za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Ekonomija")) {
                            if(valstring.contains("_ss")){
                                def = "Ekonomija za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Ekonomija za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Arhitektura")) {
                            if(valstring.contains("_ss")){
                                def = "Arhitektura za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Arhitektura za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Programiranje")) {
                            if(valstring.contains("_ss")){
                                def = "Programiranje za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Programiranje za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Povijest")) {
                            if(valstring.contains("_os")){
                                def = "Povijest za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Povijest za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Povijest za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Likovni")) {
                            if(valstring.contains("_os")){
                                def = "Likovni za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Likovni za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Likovni za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Racunovodstvo")) {
                            if(valstring.contains("_ss")){
                                def = "Racčunovodstvo za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Racčunovodstvo za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Francuski")) {
                            if(valstring.contains("_os")){
                                def = "Francuski za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Francuski za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Francuski za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Talijanski")) {
                            if(valstring.contains("_os")){
                                def = "Talijanski za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Talijanski za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Talijanski za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Engleski")) {
                            if(valstring.contains("_os")){
                                def = "Engleski za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Engleski za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Engleski za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Ruski")) {
                            if(valstring.contains("_os")){
                                def = "Ruski za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Ruski za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Ruski za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Ostali_jezici")) {
                            if(valstring.contains("_os")){
                                def = "Ostali jezici za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Ostali jezici za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Ostali jezici za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Kemija")) {
                            if(valstring.contains("_os")){
                                def = "Kemija za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Kemija za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Kemija za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Elektrotehinka")) {
                            if(valstring.contains("_ss")){
                                def = "Elektrotehinka za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Elektrotehinka za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Strojsrstvo")) {
                            if(valstring.contains("_ss")){
                                def = "Strojsrstvo za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Strojsrstvo za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Geografija")) {
                            if(valstring.contains("_os")){
                                def = "Geografija za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Geografija za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Geografija za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Biologija")) {
                            if(valstring.contains("_os")){
                                def = "Biologija za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Biologija za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Biologija za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Informatika")) {
                            if(valstring.contains("_os")){
                                def = "Informatika za osnovnu školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_ss")){
                                def = "Informatika za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Informatika za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Sociologija")) {
                            if(valstring.contains("_ss")){
                                def = "Sociologija za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Sociologija za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Medicina")) {
                            if(valstring.contains("_ss")){
                                def = "Medicina za srednju školu";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                            if(valstring.contains("_fax")){
                                def = "Medicina za fakultet";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        }
                        if(valstring.contains("Matura")) {
                                def = "Matura";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();

                        }
                        if(valstring.contains("Pravo")) {
                                def = "Pravo";
                                arrayList.add(def);
                                arrayAdapter.notifyDataSetChanged();
                        }

                       }
                    else if(value == null){
                        Toast.makeText(ConfirmSubjectsActivity.this, "null", Toast.LENGTH_SHORT).show();
                    }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}