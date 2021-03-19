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