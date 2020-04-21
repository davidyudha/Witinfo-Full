package com.example.witinfo.ui.kategori_hias;

public class ItemDataHias {
    public String pictK;
    public String namaK;
    public String hargaK;

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

    public ItemDataHias(String pictK, String namaK, String hargaK) {
        this.pictK = pictK;
        this.namaK = namaK;
        this.hargaK = hargaK;
    }
}
