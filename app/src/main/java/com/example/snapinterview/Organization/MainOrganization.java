package com.example.snapinterview.Organization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class MainOrganization{

    @Expose
    @SerializedName("organizations")
    private ArrayList<Organizations> organizations;

    public ArrayList<Organizations> getOrganizations() {
        return organizations;
    }


public class Organizations {


    @Expose
    @SerializedName("sub_request_status")
    private String organizations_sub_request_status;

    @Expose
    @SerializedName("organization")
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public String getOrganizations_sub_request_status() {
        return organizations_sub_request_status;
    }

    public void setOrganizations_sub_request_status(String status) {
        this.organizations_sub_request_status = status;
    }



    public class Organization {
        @Expose
        @SerializedName("id")
        String organization_id;

        @Expose
        @SerializedName("updated_at")
        private String organization_updated_at;

        @Expose
        @SerializedName("created_at")
        private String organization_created_at;

        @Expose
        @SerializedName("name")
        String organization_name;

        @Expose
        @SerializedName("address_line_1")
        private String organization_address_line_1;

        @Expose
        @SerializedName("locality")
        private String organization_locality;

        @Expose
        @SerializedName("administrative_district_level_1")
        private String organization_administrative_district_level_1;

        @Expose
        @SerializedName("country")
        private String organization_country;

        @Expose
        @SerializedName("postal_code")
        private String organization_postal_code;

        @Expose
        @SerializedName("type")
        private String organization_type;

        public String getOrganization_updated_at() {
            return organization_updated_at;
        }

        public String getOrganization_created_at() {
            return organization_created_at;
        }

        public String getOrganization_name() {
            return organization_name;
        }

        public String getOrganization_address_line_1() {
            return organization_address_line_1;
        }

        public String getOrganization_locality() {
            return organization_locality;
        }

        public String getOrganization_administrative_district_level_1() {
            return organization_administrative_district_level_1;
        }

        public String getOrganization_country() {
            return organization_country;
        }

        public String getOrganization_postal_code() {
            return organization_postal_code;
        }

        public String getOrganization_type() {
            return organization_type;
        }

        public String getOrganization_id() {
            return organization_id;
        }

    }
}
}
