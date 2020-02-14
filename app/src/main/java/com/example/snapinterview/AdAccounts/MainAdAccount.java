package com.example.snapinterview.AdAccounts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MainAdAccount{

    @Expose
    @SerializedName("adaccounts")
    private ArrayList<adaccounts> adaccounts;

    public ArrayList<adaccounts> getadaccounts() {
        return adaccounts;
    }


    public class adaccounts {


        @Expose
        @SerializedName("sub_request_status")
        private String adaccounts_sub_request_status;

        @Expose
        @SerializedName("adaccount")
        private adaccount adaccount;

        public adaccount getadaccount() {
            return adaccount;
        }

        public String getadaccounts_sub_request_status() {
            return adaccounts_sub_request_status;
        }

        public void setadaccounts_sub_request_status(String status) {
            this.adaccounts_sub_request_status = status;
        }



        public class adaccount {

            @Expose
            @SerializedName("id")
            String adaccount_id;

            @Expose
            @SerializedName("updated_at")
            private String adaccount_updated_at;

            @Expose
            @SerializedName("created_at")
            private String adaccount_created_at;

            @Expose
            @SerializedName("name")
            String adaccount_name;

            @Expose
            @SerializedName("type")
            private String adaccount_type;

            @Expose
            @SerializedName("status")
            private String adaccount_status;

            @Expose
            @SerializedName("organization_id")
            private String adaccount_organization_id;

            @Expose
            @SerializedName("currency")
            private String adaccount_currency;

            @Expose
            @SerializedName("timezone")
            private String adaccount_timezone;

            @Expose
            @SerializedName("advertiser")
            private String adaccount_advertiser;

            public String getAdaccount_id() {
                return adaccount_id;
            }

            public String getAdaccount_updated_at() {
                return adaccount_updated_at;
            }

            public String getAdaccount_created_at() {
                return adaccount_created_at;
            }

            public String getAdaccount_name() {
                return adaccount_name;
            }

            public String getAdaccount_type() {
                return adaccount_type;
            }

            public String getAdaccount_status() {
                return adaccount_status;
            }

            public String getAdaccount_organization_id() {
                return adaccount_organization_id;
            }

            public String getAdaccount_currency() {
                return adaccount_currency;
            }

            public String getAdaccount_timezone() {
                return adaccount_timezone;
            }

            public String getAdaccount_advertiser() {
                return adaccount_advertiser;
            }

        }
    }
}
