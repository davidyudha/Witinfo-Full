package com.example.witinfo.ui.kategori_sayur;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witinfo.MainActivity;
import com.example.witinfo.R;

import java.util.ArrayList;

public class KategoriBuah extends AppCompatActivity {
    //recyclerview
    private ArrayList<ItemDataBuah> itemValuesK;
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
        recyclerViewK=findViewById(R.id.hasil_kategoribuah);

        itemValuesK=new ArrayList<>();
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Pacar Cina",
                "Rp. 8.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Bunga Lily",
                "Rp. 56.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Pacar Cina",
                "Rp. 8.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Bunga Lily",
                "Rp. 56.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));
        itemValuesK.add(new ItemDataBuah(getDrawable(R.drawable.ic_user),
                "Lidah Mertua Sansivera",
                "Rp. 12.000"));

        itemAdapterK=new ItemAdapterBuah(this,itemValuesK);
        recyclerViewK.setLayoutManager(new GridLayoutManager(this,2));
        recyclerViewK.setAdapter(itemAdapterK);
    }

    public void backHomepage(View view) {
        Intent homepage = new Intent(this, MainActivity.class);
        startActivity(homepage);
        back.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim));
    }

    /*public void kesimpan(View view) {
        Intent simpan = new Intent(this, Simpan.class);
        startActivity(simpan);
    }

    public void keprofil(View view) {
        Intent profil = new Intent(this, Profil.class);
        startActivity(profil);
    }

    public void keDetailProduk(View view) {
        Intent detailproduk = new Intent(this,DetailProduk.class);
        startActivity(detailproduk);
    }*/
}
