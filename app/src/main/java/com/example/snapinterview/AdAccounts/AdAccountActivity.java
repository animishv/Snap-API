package com.example.snapinterview.AdAccounts;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snapinterview.Campaign.CampaignActivity;
import com.example.snapinterview.Campaign.MainCampaign;
import com.example.snapinterview.R;
import com.example.snapinterview.SnapClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdAccountActivity extends AppCompatActivity {

    static String token;
    static String ad_account_id;
    static String ad_account_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_account);

        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("access_token");
        ad_account_name = bundle.getString("adAccountName");
        ad_account_id = bundle.getString("adAccountId");

        String result = "Your Ad Account Name is " +ad_account_name;
        final TextView adAccountView = (TextView) findViewById(R.id.AdAccount_name);
        SpannableString ss=  new SpannableString(result);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 24, result.length(), 0);
        adAccountView.setText(ss);


        findViewById(R.id.campaign).setOnClickListener((view) -> {
            getCampaigns();
        });
    }

    private void getCampaigns(){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://adsapi.snapchat.com/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SnapClient client = retrofit.create(SnapClient.class);
        Call<MainCampaign> CampaignCall = client.getCampaigns(
                "Bearer "+token,
                ad_account_id
        );

        CampaignCall.enqueue(new Callback<MainCampaign>() {
            @Override
            public void onResponse(Call<MainCampaign> call, Response<MainCampaign> response) {
                Toast.makeText(AdAccountActivity.this, "success!", Toast.LENGTH_SHORT).show();

                ArrayList<MainCampaign.campaigns> campaignsList = new ArrayList(response.body().getCampaigns());

                Toast.makeText(AdAccountActivity.this, "success!", Toast.LENGTH_SHORT).show();
                Log.i("AdAccountActivity ", "campaignsList: " +campaignsList);

                String CampaignName = campaignsList.get(0).getcampaign().getCampaign_name();
                String campaign_id = campaignsList.get(0).getcampaign().getCampaign_id();


                if(campaign_id != null){
                    Intent intent = new Intent(AdAccountActivity.this, CampaignActivity.class);
                    intent.putExtra("access_token", token);
                    intent.putExtra("CampaignName", CampaignName);
                    intent.putExtra("CampaignId", campaign_id);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<MainCampaign> call, Throwable t) {
                Toast.makeText(AdAccountActivity.this, "failed!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
