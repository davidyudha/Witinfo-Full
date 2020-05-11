package com.example.witinfo.ui.kategori_sayur;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witinfo.MainActivity;
import com.example.witinfo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class KategoriSayur extends AppCompatActivity {
    //recyclerview
    ArrayList<ItemDataSayur> itemValuesK = new ArrayList<>();
    private RecyclerView recyclerViewK;
    private ItemAdapterSayur itemAdapterK;

    ImageView back;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_sayur);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);

        //recyclerView homepage
        recyclerViewK = findViewById(R.id.hasil_kategorisayur);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("sayur");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot childs : dataSnapshot.getChildren()) {
                    Log.d("debugging", childs.getKey());
                    DetailSayur data = childs.getValue(DetailSayur.class);
                    Log.d("debugging2", "" + data.getHarga());
                    itemValuesK.add(new ItemDataSayur(
                            data.getFoto() +"",
                            data.getNama() + "",
                            "Rp. " + data.getHarga() + ""));
                }

                itemAdapterK = new ItemAdapterSayur(KategoriSayur.this, itemValuesK);
                recyclerViewK.setLayoutManager(new GridLayoutManager(KategoriSayur.this, 2));
                recyclerViewK.setAdapter(itemAdapterK);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }

    public void backHomepage(View view) {
        Intent homepage = new Intent(this, MainActivity.class);
        startActivity(homepage);
        back.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim));
    }



}
