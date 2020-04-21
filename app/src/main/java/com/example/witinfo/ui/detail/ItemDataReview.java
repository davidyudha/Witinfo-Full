package com.example.witinfo.ui.detail;

import android.graphics.drawable.Drawable;

public class ItemDataReview {
    public Drawable review_foto;
    public String review_username;
    public String review_desc;

    public ItemDataReview(Drawable review_foto, String review_username, String review_desc) {
        this.review_foto = review_foto;
        this.review_username = review_username;
        this.review_desc = review_desc;
    }
}
