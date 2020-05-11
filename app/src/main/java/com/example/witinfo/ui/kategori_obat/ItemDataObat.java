package com.example.witinfo.ui.kategori_obat;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemDataObat implements Parcelable {
    public String pictK,namaK, hargaK;

    protected ItemDataObat(Parcel in) {
        pictK = in.readString();
        namaK = in.readString();
        hargaK = in.readString();
    }

    public static final Creator<ItemDataObat> CREATOR = new Creator<ItemDataObat>() {
        @Override
        public ItemDataObat createFromParcel(Parcel in) {
            return new ItemDataObat(in);
        }

        @Override
        public ItemDataObat[] newArray(int size) {
            return new ItemDataObat[size];
        }
    };

    public String getPictK() {
        return pictK;
    }

    public void setPictK(String pictK) {
        this.pictK = pictK;
    }

    public String getNamaK() {
        return namaK;
    }

    public void setNamaK(String namaK) {
        this.namaK = namaK;
    }

    public String getHargaK() {
        return hargaK;
    }

    public void setHargaK(String hargaK) {
        this.hargaK = hargaK;
    }


    public ItemDataObat(String pictK, String namaK, String hargaK) {
        this.pictK = pictK;
        this.namaK = namaK;
        this.hargaK = hargaK;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pictK);
        dest.writeString(namaK);
        dest.writeString(hargaK);
    }
}
