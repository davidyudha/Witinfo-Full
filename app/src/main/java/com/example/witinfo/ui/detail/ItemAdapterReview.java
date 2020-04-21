package com.example.witinfo.ui.detail;

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

public class ItemAdapterReview extends RecyclerView.Adapter<ItemAdapterReview.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<ItemDataReview> values;

    public ItemAdapterReview(Context context, ArrayList<ItemDataReview> values) {
        this.context=context;
        this.values= values;
        this.inflater=LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.item_list_review, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ItemDataReview data=values.get(i);
        viewHolder.foto.setImageDrawable(data.review_foto);
        viewHolder.username.setText(data.review_username);
        viewHolder.desc.setText (data.review_desc);
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
        ImageView foto;
        TextView username;
        TextView desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foto= itemView.findViewById(R.id.review_foto);
            username= itemView.findViewById(R.id.review_username);
            desc=itemView.findViewById(R.id.review_desc);
        }
    }

}
