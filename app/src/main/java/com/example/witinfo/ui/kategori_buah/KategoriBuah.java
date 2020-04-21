package com.example.witinfo.ui.kategori_buah;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witinfo.MainActivity;
import com.example.witinfo.R;
import com.example.witinfo.ui.detail.DetailTanaman;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KategoriBuah extends AppCompatActivity {
    //recyclerview
    ArrayList<ItemDataBuah> itemValuesK = new ArrayList<>();
    private RecyclerView recyclerViewK;
    private ItemAdapterBuah itemAdapterK;

    ImageView back;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategori_buah);

        getSupportActionBar().hide();

        back = findViewById(R.id.back);

        //recyclerView homepage
        recyclerViewK = findViewById(R.id.hasil_kategoribuah);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("buah");
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot childs : dataSnapshot.getChildren()) {
                    Log.d("debugging", childs.getKey());
                    DetailBuah data = childs.getValue(DetailBuah.class);
                    Log.d("debugging2", "" + data.getHarga());
                    itemValuesK.add(new ItemDataBuah(
                            data.getFoto() +"",
                            data.getNama() + "",
                            "Rp. " + data.getHarga() + ""));
                }

                itemAdapterK = new ItemAdapterBuah(KategoriBuah.this, itemValuesK);
                recyclerViewK.setLayoutManager(new GridLayoutManager(KategoriBuah.this, 2));
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
