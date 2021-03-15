package com.example.instrukciopedijaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.HashMap;
import java.util.Map;

public class BottomSheet extends BottomSheetDialogFragment {
    public BottomSheet() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_layout, container, false);



        //Intent i = getIntent();
        //String predmet = i.getStringExtra("predmet");



        CheckBox os_checkbox = view.findViewById(R.id.os_checkbox);
        CheckBox ss_checkbox = view.findViewById(R.id.ss_checkbox);
        CheckBox fax_checkbox = view.findViewById(R.id.fax_checkbox);


        Button uredu_btn = view.findViewById(R.id.uredu_btn);
        uredu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> Predmeti = new HashMap<>();


                if(os_checkbox.isChecked()){
                    //Predmeti.put(predmet.toString() + "_os", "true");
                    //com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").push().setValue(Predmeti);
                    Toast.makeText(getContext(), "1", Toast.LENGTH_LONG).show();
                }
                if(ss_checkbox.isChecked()){
                    //Predmeti.put(predmet.toString() + "_ss", "true");
                    //com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").push().setValue(Predmeti);
                    Toast.makeText(getContext(), "2", Toast.LENGTH_LONG).show();
                }
                if(fax_checkbox.isChecked()){
                    //Predmeti.put(predmet.toString() + "_fax", "true");
                    //com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").push().setValue(Predmeti);
                    Toast.makeText(getContext(), "3", Toast.LENGTH_LONG).show();
                }
                if(!os_checkbox.isChecked() && !ss_checkbox.isChecked() && !fax_checkbox.isChecked()){
                    Toast.makeText(getContext(), "Niste odabrali kome ćete predavati!", Toast.LENGTH_LONG).show();
                }
                if(os_checkbox.isChecked() && ss_checkbox.isChecked() && fax_checkbox.isChecked()){
                    //Predmeti.put(predmet.toString() + "_os", "true");
                    //Predmeti.put(predmet.toString() + "_ss", "true");
                    //Predmeti.put(predmet.toString() + "_fax", "true");
                    //com.google.firebase.database.FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").push().setValue(Predmeti);
                    Toast.makeText(getContext(), "1, 2 and 3", Toast.LENGTH_LONG).show();

                }
            }
        });


        return view;

    }
}
