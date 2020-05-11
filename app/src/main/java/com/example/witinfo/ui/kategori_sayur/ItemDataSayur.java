package com.example.witinfo.ui.kategori_sayur;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemDataSayur implements Parcelable {
    public String pictK,namaK, hargaK;

    protected ItemDataSayur(Parcel in) {
        pictK = in.readString();
        namaK = in.readString();
        hargaK = in.readString();
    }

    public static final Creator<ItemDataSayur> CREATOR = new Creator<ItemDataSayur>() {
        @Override
        public ItemDataSayur createFromParcel(Parcel in) {
            return new ItemDataSayur(in);
        }

        @Override
        public ItemDataSayur[] newArray(int size) {
            return new ItemDataSayur[size];
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


    public ItemDataSayur(String pictK, String namaK, String hargaK) {
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
