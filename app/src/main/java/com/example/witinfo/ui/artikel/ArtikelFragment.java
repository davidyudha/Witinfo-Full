package com.example.witinfo.ui.artikel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witinfo.MainActivity;
import com.example.witinfo.R;
import com.example.witinfo.ui.kategori_buah.KategoriBuah;
import com.example.witinfo.ui.login.Login;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ArtikelFragment extends Fragment {
    //recyclerview
    ArrayList<ItemDataArtikel> itemValuesA = new ArrayList<>();
    private RecyclerView recyclerViewA;
    private ItemAdapterArtikel itemAdapterA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artikel,container,false);
        setHasOptionsMenu(true);

        //recyclerView
        recyclerViewA = view.findViewById(R.id.list_artikel);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("artikel");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot childs : dataSnapshot.getChildren()) {
                    Log.d("debugging", childs.getKey());
                    DetailArtikel data = childs.getValue(DetailArtikel.class);
                    itemValuesA.add(new ItemDataArtikel(
                            data.getFoto() + " ",
                            data.getIsi() + "",
                            data.getJudul() + ""));
                }

                itemAdapterA = new ItemAdapterArtikel(getActivity(), itemValuesA);
                recyclerViewA.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerViewA.setAdapter(itemAdapterA);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //null
            }
        });
        return view;
    }
}