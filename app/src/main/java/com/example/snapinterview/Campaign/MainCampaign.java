package com.example.snapinterview.Campaign;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MainCampaign{

    @Expose
    @SerializedName("campaigns")
    private ArrayList<campaigns> campaigns;

    public ArrayList<campaigns> getCampaigns() {
        return campaigns;
    }


    public class campaigns {


        @Expose
        @SerializedName("sub_request_status")
        private String campaigns_sub_request_status;

        @Expose
        @SerializedName("campaign")
        private campaign campaign;

        public campaign getcampaign() {
            return campaign;
        }

        public String getcampaigns_sub_request_status() {
            return campaigns_sub_request_status;
        }

        public void setcampaigns_sub_request_status(String status) {
            this.campaigns_sub_request_status = status;
        }



        public class campaign {

            @Expose
            @SerializedName("id")
            String campaign_id;

            @Expose
            @SerializedName("updated_at")
            private String campaign_updated_at;

            @Expose
            @SerializedName("created_at")
            private String campaign_created_at;

            @Expose
            @SerializedName("name")
            String campaign_name;

            @Expose
            @SerializedName("ad_account_id")
            private String campaign_ad_account_id;

            @Expose
            @SerializedName("daily_budget_micro")
            private String campaign_daily_budget_micro;

            @Expose
            @SerializedName("status")
            private String campaign_status;

            @Expose
            @SerializedName("start_time")
            private String campaign_start_time;

            @Expose
            @SerializedName("end_time")
            private String campaign_end_time;

            public String getCampaign_id() {
                return campaign_id;
            }

            public String getCampaign_updated_at() {
                return campaign_updated_at;
            }

            public String getCampaign_created_at() {
                return campaign_created_at;
            }

            public String getCampaign_name() {
                return campaign_name;
            }

            public String getCampaign_ad_account_id() {
                return campaign_ad_account_id;
            }

            public String getCampaign_daily_budget_micro() {
                return campaign_daily_budget_micro;
            }

            public String getCampaign_status() {
                return campaign_status;
            }

            public String getCampaign_start_time() {
                return campaign_start_time;
            }

            public String getCampaign_end_time() {
                return campaign_end_time;
            }
        }
    }
}

