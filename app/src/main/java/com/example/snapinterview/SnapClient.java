package com.example.snapinterview;

import com.example.snapinterview.Ad.AdsList;
import com.example.snapinterview.AdAccounts.MainAdAccount;
import com.example.snapinterview.AdSquads.MainAdSquad;
import com.example.snapinterview.Campaign.MainCampaign;
import com.example.snapinterview.Organization.MainOrganization;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SnapClient {

    @Headers("Accept: application/json")
    @POST("login/oauth2/access_token")
    Call<AccessToken> getAccessToken(
            @Query("client_id") String client_id,
            @Query("client_secret") String client_secret,
            @Query("code") String code,
            @Query("grant_type") String grant_type,
            @Query("redirect_uri") String redirect_uri
    );

    @GET("me/organizations")
    Call<MainOrganization> getOrganization(
            @Header("Authorization") String authHeader
    );

    @GET("organizations/{organization-id}/adaccounts")
    Call<MainAdAccount> getAdAccounts(
            @Header("Authorization") String authHeader,
            @Path("organization-id") String organizationId
    );

    @GET("adaccounts/{ad_account_id}/campaigns")
    Call<MainCampaign> getCampaigns(
            @Header("Authorization") String authHeader,
            @Path("ad_account_id") String ad_account_id
    );

    @GET("campaigns/{campaign_id}/adsquads")
    Call<MainAdSquad> getAdSquad(
            @Header("Authorization") String authHeader,
            @Path("campaign_id") String campaign_id
    );

    @Headers("Accept: application/json")
    @POST("adsquads/{ad_squad_id}/ads")
    Call<AdsList> createAd(
            @Header("Authorization") String authHeader,
            @Path("ad_squad_id") String ad_squad_id,
            @Body AdsList ads
            );
}
