package com.example.instrukciopedijaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText email_login, password_login;
    Button button_prijava, button, button_regInstruktor;
    Button reg;
    CheckBox zapamti_me;

    private FirebaseAuth mAuth;

    SharedPreferences sharedPreferences;
    String PREFS_NAME = "prefsFile";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_login = findViewById(R.id.editText);
        password_login = findViewById(R.id.editText2);
        button_prijava = findViewById(R.id.button_prijava);
        button = findViewById(R.id.button);
        button_regInstruktor = findViewById(R.id.button_regInstruktor);
        reg = findViewById(R.id.reg);
        zapamti_me = findViewById(R.id.zapamti_me);

        SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
        String checkbox = preferences.getString("remember", "");
        if(checkbox.equals("true")){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else if(checkbox.equals("false")){
            Toast.makeText(this, "Please sign in!", Toast.LENGTH_SHORT).show();
        }


        mAuth = FirebaseAuth.getInstance();

        button_prijava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });



        zapamti_me.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "true");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                }
                else if(!compoundButton.isChecked()){
                    SharedPreferences preferences = getSharedPreferences("checkbox", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("remember", "false");
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Unchecked", Toast.LENGTH_SHORT).show();
                }

            }
        });








        Button btn_register_instruktor;
        btn_register_instruktor = (Button) findViewById(R.id.button_regInstruktor);
        btn_register_instruktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register_intent;
                register_intent = new Intent(LoginActivity.this, RegisterUserActivity.class);
                startActivity(register_intent);
            }
        });

        reg = findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_reg = new Intent (LoginActivity.this, RegisterKorisnikActivity.class);
                startActivity(intent_reg);
            }
        });

    }

    private void loginUser() {
        String email = email_login.getText().toString().trim();
        String password = password_login.getText().toString().trim();

        if (email.isEmpty()){
            email_login.setError("Email is required!");
            email_login.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email_login.setError("Please enter valid email!");
            email_login.requestFocus();
            return;
        }
        if(password.isEmpty()){
            password_login.setError("Password is required!");
            password_login.requestFocus();
            return;
        }
        if(password.length()<6){
            password_login.setError("Minimal password length is 6 characters!");
            password_login.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                   startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else{
                    Toast.makeText(LoginActivity.this, "Failed to login!", Toast.LENGTH_LONG).show();
                }

            }
        });



    }



}