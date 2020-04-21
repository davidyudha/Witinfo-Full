package com.example.witinfo.ui.simpan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.witinfo.R;

import java.util.ArrayList;

public class ItemAdapterSimpan extends RecyclerView.Adapter<ItemAdapterSimpan.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemDataSimpan> values;

    public ItemAdapterSimpan(Context context, ArrayList<ItemDataSimpan> values) {
        this.context=context;
        this.values= values;
        this.inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.item_list_simpan, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ItemDataSimpan data=values.get(i);
        viewHolder.img_hasil_kategori.setImageDrawable(data.pictK);
        viewHolder.nama_tanaman.setText (data.namaK);
        viewHolder.harga_tanaman.setText (data.hargaK);
        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

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
