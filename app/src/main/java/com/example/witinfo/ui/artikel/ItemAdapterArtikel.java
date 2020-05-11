package com.example.witinfo.ui.artikel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.witinfo.R;
import com.example.witinfo.ui.kategori_buah.ItemDataBuah;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class ItemAdapterArtikel extends RecyclerView.Adapter<ItemAdapterArtikel.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemDataArtikel> values;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("image");

    public ItemAdapterArtikel(Context context, ArrayList<ItemDataArtikel> values) {
        this.context=context;
        this.values= values;
        this.inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.item_list_artikel, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ItemDataArtikel data=values.get(i);
        Glide.with( context)
                .load(data.imgA)
                .into(viewHolder.img_article);
        viewHolder.title_artikel.setText (data.titleA);
        viewHolder.desc_artikel.setText (data.descA);
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, HalamanArtikel.class);
                        intent.putExtra("img_url", data.imgA);
                        intent.putExtra("title_url", data.titleA);
                        intent.putExtra("desc_url", data.descA);
                        context.startActivity(intent);
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_article;
        TextView title_artikel;
        TextView desc_artikel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_article= itemView.findViewById(R.id.img_article);
            title_artikel=itemView.findViewById(R.id.title_artikel);
            desc_artikel=itemView.findViewById(R.id.desc_artikel);
        }
    }
}
