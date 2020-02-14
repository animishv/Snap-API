package com.example.snapinterview.AdSquads;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MainAdSquad{

    @Expose
    @SerializedName("adsquads")
    private ArrayList<adsquads> adsquads;

    public ArrayList<adsquads> getadsquads() {
        return adsquads;
    }


    public class adsquads {


        @Expose
        @SerializedName("sub_request_status")
        private String adsquads_sub_request_status;

        @Expose
        @SerializedName("adsquad")
        private adsquad adsquad;

        public adsquad getadsquad() {
            return adsquad;
        }

        public String getadsquads_sub_request_status() {
            return adsquads_sub_request_status;
        }

        public void setadsquads_sub_request_status(String status) {
            this.adsquads_sub_request_status = status;
        }



        public class adsquad {

            @Expose
            @SerializedName("id")
            String adsquad_id;

            @Expose
            @SerializedName("updated_at")
            private String adsquad_updated_at;

            @Expose
            @SerializedName("created_at")
            private String adsquad_created_at;

            @Expose
            @SerializedName("name")
            String adsquad_name;

            @Expose
            @SerializedName("status")
            private String adsquad_status;

            @Expose
            @SerializedName("campaign_id")
            private String adsquad_campaign_id;

            @Expose
            @SerializedName("type")
            private String adsquad_type;

            @Expose
            @SerializedName("billing_event")
            private String adsquad_billing_event;

            @Expose
            @SerializedName("bid_micro")
            private String adsquad_bid_micro;

            public String getAdsquad_id() {
                return adsquad_id;
            }

            public String getAdsquad_updated_at() {
                return adsquad_updated_at;
            }

            public String getAdsquad_created_at() {
                return adsquad_created_at;
            }

            public String getAdsquad_name() {
                return adsquad_name;
            }

            public String getAdsquad_status() {
                return adsquad_status;
            }

            public String getAdsquad_campaign_id() {
                return adsquad_campaign_id;
            }

            public String getAdsquad_type() {
                return adsquad_type;
            }

            public String getAdsquad_billing_event() {
                return adsquad_billing_event;
            }

            public String getAdsquad_bid_micro() {
                return adsquad_bid_micro;
            }
        }
    }
}


