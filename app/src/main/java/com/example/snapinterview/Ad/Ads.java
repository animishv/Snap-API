package com.example.snapinterview.Ad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ads {


    @Expose
    @SerializedName("id")
    String ad_id;

    @Expose
    @SerializedName("updated_at")
    private String ad_updated_at;

    @Expose
    @SerializedName("created_at")
    private String ad_created_at;

    public void setAd_name(String ad_name) {
        this.ad_name = ad_name;
    }

    public void setAd_ad_squad_id(String ad_ad_squad_id) {
        this.ad_ad_squad_id = ad_ad_squad_id;
    }

    public void setAd_creative_id(String ad_creative_id) {
        this.ad_creative_id = ad_creative_id;
    }

    public void setAd_status(String ad_status) {
        this.ad_status = ad_status;
    }

    public void setAd_type(String ad_type) {
        this.ad_type = ad_type;
    }

    @Expose
    @SerializedName("name")
    String ad_name;

    @Expose
    @SerializedName("ad_squad_id")
    private String ad_ad_squad_id;

    @Expose
    @SerializedName("creative_id")
    private String ad_creative_id;

    @Expose
    @SerializedName("status")
    private String ad_status;

    @Expose
    @SerializedName("type")
    private String ad_type;

    public String getAd_id() {
        return ad_id;
    }

    public String getAd_updated_at() {
        return ad_updated_at;
    }

    public String getAd_created_at() {
        return ad_created_at;
    }

    public String getAd_name() {
        return ad_name;
    }

    public String getAd_ad_squad_id() {
        return ad_ad_squad_id;
    }

    public String getAd_creative_id() {
        return ad_creative_id;
    }

    public String getAd_status() {
        return ad_status;
    }

    public String getAd_type() {
        return ad_type;
    }

    public Ads(String ad_ad_squad_id, String ad_creative_id, String ad_name, String ad_type, String ad_status) {
        this.ad_ad_squad_id = ad_ad_squad_id;
        this.ad_creative_id = ad_creative_id;
        this.ad_name = ad_name;
        this.ad_type = ad_type;
        this.ad_status = ad_status;
    }

}
