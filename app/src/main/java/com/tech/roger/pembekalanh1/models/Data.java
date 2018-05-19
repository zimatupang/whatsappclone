
package com.tech.roger.pembekalanh1.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("no_telp")
    @Expose
    private String noTelp;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("img")
    @Expose
    private String img;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
