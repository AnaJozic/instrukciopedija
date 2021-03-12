package com.example.instrukciopedijaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText email_login, password_login;
    Button button_prijava, button, button_regInstruktor;
    Button reg;

    boolean valid = true;

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


        checkField(email_login);
        checkField(password_login);







        Button btn_register_instruktor;
        btn_register_instruktor = (Button) findViewById(R.id.button_regInstruktor);
        btn_register_instruktor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
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
    public void openRegisterActivity() {
        Intent register_intent;
        register_intent = new Intent(this, RegisterUserActivity.class);
        startActivity(register_intent);
    }

    public boolean checkField(EditText textField){
        if(textField.getText().toString().isEmpty()){
            textField.setError("Error");
            valid = false;
        } else{
            valid = true;
        }
        return valid;
    }




}