package com.example.witinfo.ui.profil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.witinfo.R;
import com.example.witinfo.ui.login.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfilFragment extends Fragment {
    TextView logout;
    EditText textname, textusername, textemail, textpassword;
    ImageView pensilname, pensilusername, pensilemail, pensilpassword, fotoprofil;
    boolean statusname = false, statususername = false, statusemail = false, statuspassword = false;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil,container,false);
        textname = view.findViewById(R.id.textname);
        textemail = view.findViewById(R.id.textemail);
        textpassword = view.findViewById(R.id.textpassword);
        pensilname = view.findViewById(R.id.pensilname);
        pensilemail = view.findViewById(R.id.pensilemail);
        pensilpassword = view.findViewById(R.id.pensilpassword);
        logout = view.findViewById(R.id.logout);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users/"
                +FirebaseAuth.getInstance().getCurrentUser().getUid()
                +"/username");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                textname.setText(String.valueOf(value));
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });


        pensilname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statusname==true){
                    pensilname.setImageDrawable(getResources().getDrawable(R.drawable.ic_edit));
                    textname.setEnabled(false);
                    statusname=false;
                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("");

                    myRef.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .child("username")
                            .setValue(String.valueOf(textname.getText()));


                } else {
                    textname.setEnabled(true);
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim));
                    pensilname.setImageDrawable(getResources().getDrawable(R.drawable.ic_check_circle));
                    statusname = true;
                }
        }
        });

        pensilemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statusemail==true){
                    pensilemail.setImageDrawable(getResources().getDrawable(R.drawable.ic_edit));
                    textemail.setEnabled(false);
                    statusemail=false;
                    FirebaseAuth.getInstance().getCurrentUser().updateEmail(String.valueOf(textemail.getText()));
                } else {
                    textemail.setEnabled(true);
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim));
                    pensilemail.setImageDrawable(getResources().getDrawable(R.drawable.ic_check_circle));
                    statusemail = true;
                }
            }
        });

        pensilpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statuspassword==true){
                    pensilpassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_edit));
                    textpassword.setEnabled(false);
                    statuspassword=false;
                    FirebaseAuth.getInstance().getCurrentUser().updatePassword(String.valueOf(textpassword.getText()));
                } else {
                    textpassword.setEnabled(true);
                    v.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim));
                    pensilpassword.setImageDrawable(getResources().getDrawable(R.drawable.ic_check_circle));
                    statuspassword = true;
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signOut();
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
            }
        });
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        textemail.setText(user.getEmail());
        textpassword.setText("");

        return view;
    }
}