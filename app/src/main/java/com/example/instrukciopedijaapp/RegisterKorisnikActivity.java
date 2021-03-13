
package com.example.instrukciopedijaapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterKorisnikActivity<FirebaseDatabase> extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore mStore;




    EditText korisnicko_ime;
    EditText korisnicki_email;
    EditText korisnicki_telefon;
    EditText korisnicka_lokacija;
    EditText registriraj_se_kao_korisnik;
    Button button_reg_korisnik;
    boolean valid = true;


    Button back_btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_korisnik);


        mAuth = FirebaseAuth.getInstance();
        mStore = FirebaseFirestore.getInstance();


        korisnicko_ime = findViewById(R.id.korisnicko_ime);
        korisnicki_email = findViewById(R.id.korisnicki_email);
        korisnicki_telefon = findViewById(R.id.korisnicki_telefon);
        korisnicka_lokacija = findViewById(R.id.korisnicka_lokacija);
        registriraj_se_kao_korisnik = findViewById(R.id.registriraj_se_kao_korisnik);
        button_reg_korisnik = findViewById(R.id.button_reg_korisnik);


        button_reg_korisnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });


        back_btn_2 = findViewById(R.id.back_btn_2);
        back_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterKorisnikActivity.this, LoginActivity.class));
            }
        });
    }

    private void check() {
        String username = korisnicko_ime.getText().toString();
        String email = korisnicki_email.getText().toString();
        String password = registriraj_se_kao_korisnik.getText().toString();

        if (username.isEmpty() || username.length() < 6) {
            showError(korisnicko_ime, "Username not valid!");
        } else if (email.isEmpty() || !email.contains("@")) {
            showError(korisnicki_email, "Email is not valid!");

        } else if (password.isEmpty() || password.length() < 7) {
            showError(registriraj_se_kao_korisnik, "Password must be at least 7 characters long!");

        } else {
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
                            Toast.makeText(RegisterKorisnikActivity.this, "Registered user!\n" + user.getEmail(),Toast.LENGTH_SHORT).show();
                            DocumentReference df = mStore.collection("Users").document(user.getUid());
                            Map<String, Object> userInfo = new HashMap<>();
                            userInfo.put("Username", korisnicko_ime.getText().toString());
                            userInfo.put("Email", korisnicki_email.getText().toString());
                            userInfo.put("Phone", korisnicki_telefon.getText().toString());
                            userInfo.put("Location", korisnicka_lokacija.getText().toString());
                            userInfo.put("Password", registriraj_se_kao_korisnik.getText().toString());

                            userInfo.put("UserType", "Korisnik");
                            com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("User").child("Korisnik").push().setValue(userInfo);


                            df.set(userInfo);
                            startActivity(new Intent(RegisterKorisnikActivity.this, LoginActivity.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterKorisnikActivity.this, "Authentication failed.",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(RegisterKorisnikActivity.this, "Authentication failed!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }
}


