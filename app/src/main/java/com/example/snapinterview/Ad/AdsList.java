package com.example.snapinterview.Ad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class AdsList implements Serializable {

    @Expose
    @SerializedName("ads")
    private List<Ads> adsList = null;

    /**
     * No args constructor for use in serialization
     *
     */


 /*   public List<Ads> getAds() {
        return ads;
    }

    public void setAds(List<Ads> ads) {
        this.ads = ads;
    } */

    public List<Ads> getAdsList() {
        return adsList;
    }

    public void setAdsList(List<Ads> adsList) {
        this.adsList = adsList;
    }

}
