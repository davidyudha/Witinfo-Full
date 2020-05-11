package com.example.witinfo.ui.artikel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.witinfo.MainActivity;
import com.example.witinfo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HalamanArtikel extends AppCompatActivity {
    public ImageView back;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("image");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_artikel);

        getSupportActionBar().hide();

        back = findViewById(R.id.coverartikel);

        getIncomingIntent();
    }

    public void backArtikelFragment(View view) {
        Intent artikelf = new Intent(this, ArtikelFragment.class);
        startActivity(artikelf);
        back.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim));
    }

    public void getIncomingIntent(){
        if(getIntent().hasExtra("img_url") && getIntent().hasExtra("title_url") && getIntent().hasExtra("desc_url")){
            String imgUrl = getIntent().getStringExtra("img_url");
            String titleUrl = getIntent().getStringExtra("title_url");
            String descUrl = getIntent().getStringExtra("desc_url");

            setImage(imgUrl, titleUrl, descUrl);
        }
    }

    private void setImage(String imgUrl, String titleUrl, String descUrl) {
        ImageView gambarartikel = findViewById(R.id.gambarartikel);
        Glide.with(this)
                .load(imgUrl)
                .into(gambarartikel);

        TextView judul_halamanartikel = findViewById(R.id.judul_halamanartikel);
        judul_halamanartikel.setText(titleUrl);

        TextView isi_bacaanartikel = findViewById(R.id.isi_bacaanartikel);
        isi_bacaanartikel.setText(descUrl);
    }
}
