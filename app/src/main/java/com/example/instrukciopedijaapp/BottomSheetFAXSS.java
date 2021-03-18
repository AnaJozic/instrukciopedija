package com.example.instrukciopedijaapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class BottomSheetFAXSS extends BottomSheetDialogFragment {
    public BottomSheetFAXSS() {

    }
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_faxss_layout, container, false);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userId = user.getUid();


        String predmet = getArguments().getString("predmet");



        CheckBox os_checkbox = view.findViewById(R.id.os_checkbox);
        CheckBox ss_checkbox = view.findViewById(R.id.ss_checkbox);
        CheckBox fax_checkbox = view.findViewById(R.id.fax_checkbox);





        Button uredu_btn = view.findViewById(R.id.uredu_btn);
        uredu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> Predmeti = new HashMap<>();



                if(ss_checkbox.isChecked()){
                    Predmeti.put(predmet.toString() + "_ss", "true");
                    FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").child(userId).child("Predmeti").updateChildren(Predmeti);
                    Toast.makeText(getContext(), predmet + " za srednju školu.", Toast.LENGTH_LONG).show();
                    dismiss();

                }
                if(fax_checkbox.isChecked()){
                    Predmeti.put(predmet.toString() + "_fax", "true");
                    FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").child(userId).child("Predmeti").updateChildren(Predmeti);
                    Toast.makeText(getContext(), predmet + " za fakultet.", Toast.LENGTH_LONG).show();
                    dismiss();

                }
                if(!ss_checkbox.isChecked() && !fax_checkbox.isChecked()){
                    Toast.makeText(getContext(), "Niste odabrali kome ćete predavati!", Toast.LENGTH_LONG).show();
                    dismiss();
                }
            }

        });


        return view;

    }


}


