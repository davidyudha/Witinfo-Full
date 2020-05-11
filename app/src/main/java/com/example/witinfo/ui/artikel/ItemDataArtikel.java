package com.example.witinfo.ui.artikel;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class ItemDataArtikel implements Parcelable {
    public String imgA;
    public String titleA;
    public String descA;

    protected ItemDataArtikel(Parcel in) {
        imgA = in.readString();
        titleA = in.readString();
        descA = in.readString();
    }

    public static final Creator<ItemDataArtikel> CREATOR = new Creator<ItemDataArtikel>() {
        @Override
        public ItemDataArtikel createFromParcel(Parcel in) {
            return new ItemDataArtikel(in);
        }

        @Override
        public ItemDataArtikel[] newArray(int size) {
            return new ItemDataArtikel[size];
        }
    };


    public String getImgA() {
        return imgA;
    }

    public void setImgA(String ImgA) {
        this.imgA = ImgA;
    }

    public String getTitleA() {
        return titleA;
    }

    public void setTitleA(String titleA) {
        this.titleA = titleA;
    }

    public String getDescA() {
        return descA;
    }

    public void setDescA(String descA) {
        this.descA = descA;
    }

    public ItemDataArtikel(String imgA, String titleA, String descA) {
        this.imgA = imgA;
        this.titleA = titleA;
        this.descA = descA;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imgA);
        dest.writeString(titleA);
        dest.writeString(descA);
    }
}
