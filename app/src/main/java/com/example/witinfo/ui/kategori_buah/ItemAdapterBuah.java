package com.example.witinfo.ui.kategori_buah;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.witinfo.MyAppGlideModule;
import com.example.witinfo.R;
import com.example.witinfo.ui.artikel.HalamanArtikel;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import android.util.Log;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StreamDownloadTask;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ItemAdapterBuah extends RecyclerView.Adapter<ItemAdapterBuah.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemDataBuah> values;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("image");

    public ItemAdapterBuah(Context context, ArrayList<ItemDataBuah> values) {
        this.context=context;
        this.values= values;
        this.inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.item_list_buah, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ItemDataBuah data=values.get(i);
        Glide.with( context)
                .load(data.pictK)
                .into(viewHolder.img_hasil_kategori);
        viewHolder.nama_tanaman.setText (data.namaK);
        viewHolder.harga_tanaman.setText (data.hargaK);
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent detail = new Intent(context, DetailTanaman.class);
                        detail.putExtra("img_url", data.pictK);
                        detail.putExtra("namatanaman_url", data.namaK);
                        detail.putExtra("harga_url", data.hargaK);
                        context.startActivity(detail);
                    }
                }
        );

    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_hasil_kategori;
        TextView nama_tanaman;
        TextView harga_tanaman;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_hasil_kategori= itemView.findViewById(R.id.image_hasil_kategori);
            nama_tanaman=itemView.findViewById(R.id.nama_tanaman);
            harga_tanaman=itemView.findViewById(R.id.harga_tanaman);


        }
    }

}
