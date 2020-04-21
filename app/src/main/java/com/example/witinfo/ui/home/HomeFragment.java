package com.example.witinfo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.witinfo.R;
import com.example.witinfo.ui.kategori_buah.KategoriBuah;

public class HomeFragment extends Fragment {
    RelativeLayout categoryhias, categorybuah, categorysayur, categoryobat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        categorybuah = view.findViewById(R.id.category_buah);
        categoryhias = view.findViewById(R.id.category_hias);
        categoryobat = view.findViewById(R.id.category_obat);
        categorysayur = view.findViewById(R.id.category_sayur);

        categorybuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buah = new Intent(getActivity(), KategoriBuah.class);
                startActivity(buah);
            }
        });

        return view;
    }
}