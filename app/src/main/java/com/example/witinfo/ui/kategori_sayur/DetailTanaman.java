package com.example.witinfo.ui.kategori_sayur;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.witinfo.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DetailTanaman extends AppCompatActivity {
    public ImageView back;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("image");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tanaman);

        getSupportActionBar().hide();

        back = findViewById(R.id.image_back_produk);

        getIncomingIntent();

    }

    public void back(View view) {
        Intent ksayur = new Intent(this, KategoriSayur.class);
        startActivity(ksayur);
        back.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), R.anim.anim));
    }

    public void getIncomingIntent(){
        if(getIntent().hasExtra("img_url") && getIntent().hasExtra("namatanaman_url") && getIntent().hasExtra("harga_url")){
            String imgUrl = getIntent().getStringExtra("img_url");
            String titleUrl = getIntent().getStringExtra("namatanaman_url");
            String hargaUrl = getIntent().getStringExtra("harga_url");


            setImage(imgUrl, titleUrl, hargaUrl);
        }
    }

    private void setImage(String imgUrl, String titleUrl, String hargaUrl) {
        TextView text_nama_tanaman = findViewById(R.id.text_nama_tanaman);
        text_nama_tanaman.setText(titleUrl);

        ImageView image_tanaman = findViewById(R.id.image_tanaman);
        Glide.with(this)
                .load(imgUrl)
                .into(image_tanaman);

        TextView text_harga = findViewById(R.id.text_harga);
        text_harga.setText(hargaUrl);

        TextView text_nama_lokasi = findViewById(R.id.text_nama_lokasi);
        text_nama_lokasi.setText("Toko Bunga Makmur");

        TextView text_nama_lokasi2 = findViewById(R.id.text_nama_lokasi2);
        text_nama_lokasi2.setText("Jl Nakula Banyuripan Jimbung Kalikotes Klaten");

        TextView text_deskripsi2 = findViewById(R.id.text_deskripsi2);
        text_deskripsi2.setText("Merupakan sebuah tanaman yang berasal dari Belanda yang hidup di tempat yang terkena paparan sinar matahari secara langsung.");

        TextView text_stok = findViewById(R.id.text_stok);
        text_stok.setText("10 tanaman");
    }

    public void telfon (View view) {
        String nomor =  "085706125451";
        Intent telfon = new Intent(Intent.ACTION_DIAL);
        telfon.setData(Uri.fromParts("tel",nomor,null));
        startActivity(telfon);
    }

    public void maps(View view) {
        Intent maps = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps?saddr=-7.7752657,110.3741690&daddr=-7.762181,110.369185"));
        startActivity(maps);
    }

}
