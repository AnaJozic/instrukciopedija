package com.example.instrukciopedijaapp;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterUserActivity extends AppCompatActivity {


    FirebaseAuth mAuth;
    FirebaseFirestore mStore;

    private EditText korisnicko_ime_instruktora, korisnicki_email_instruktora, korisnicki_telefon_instruktora, korisnicka_lokacija_instruktora, lozinka_instruktora;
    private ImageView slika_instruktora;
    Button button_dalje;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);


        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();

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
            registerUser(email, password);


        }

    }



    private void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(RegisterUserActivity.this, "Registered user!\n" + user.getEmail(),Toast.LENGTH_SHORT).show();
                            DocumentReference df = mStore.collection("Users").document(user.getUid());
                            Map<String, Object> instructorInfo = new HashMap<>();
                            instructorInfo.put("Username", korisnicko_ime_instruktora.getText().toString());
                            instructorInfo.put("Email", korisnicki_email_instruktora.getText().toString());
                            instructorInfo.put("Phone", korisnicki_telefon_instruktora.getText().toString());
                            instructorInfo.put("Location", korisnicka_lokacija_instruktora.getText().toString());
                            instructorInfo.put("Password", lozinka_instruktora.getText().toString());

                            instructorInfo.put("UserType", "Instruktor");

                            df.set(instructorInfo);
                            com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").push().setValue(instructorInfo);
                            startActivity(new Intent(RegisterUserActivity.this, SubjectChoicesActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterUserActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterUserActivity.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }


}