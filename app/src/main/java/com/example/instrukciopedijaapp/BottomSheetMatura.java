package com.example.instrukciopedijaapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class BottomSheetMatura extends BottomSheetDialogFragment {
    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet_matura_layout, container, false);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String userId = user.getUid();



        String predmet = getArguments().getString("predmet");



        Button uredu_btn = view.findViewById(R.id.uredu_btn);
        uredu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Map<String, Object> Predmeti = new HashMap<>();
                Predmeti.put("Matura" + "_ss", "true");
                FirebaseDatabase.getInstance().getReference().child("User").child("Instruktor").child(userId).child("Predmeti").updateChildren(Predmeti);
                Toast.makeText(getContext(), "userString", Toast.LENGTH_LONG).show();
                dismiss();
            }
        });


        return view;

    }

}
