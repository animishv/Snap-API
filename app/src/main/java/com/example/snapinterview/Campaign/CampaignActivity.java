package com.example.snapinterview.Campaign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snapinterview.AdSquads.AdSquadActivity;
import com.example.snapinterview.AdSquads.MainAdSquad;
import com.example.snapinterview.R;
import com.example.snapinterview.SnapClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CampaignActivity extends AppCompatActivity {

    static String token;
    static String campaign_id;
    static String campaign_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign);

        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("access_token");
        campaign_name = bundle.getString("CampaignName");
        campaign_id = bundle.getString("CampaignId");

        String result = "Your Campaign Name is " +campaign_name;

        final TextView adAccountView = (TextView) findViewById(R.id.campaign_name);
        SpannableString ss=  new SpannableString(result);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 21, result.length(), 0);
        adAccountView.setText(ss);

        findViewById(R.id.ad_squad).setOnClickListener((view) -> {
            getAdSquad();
        });
    }

    private void getAdSquad(){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://adsapi.snapchat.com/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SnapClient client = retrofit.create(SnapClient.class);
        Call<MainAdSquad> AdSquadCall = client.getAdSquad(
                "Bearer "+token,
                campaign_id
        );

        AdSquadCall.enqueue(new Callback<MainAdSquad>() {
            @Override
            public void onResponse(Call<MainAdSquad> call, Response<MainAdSquad> response) {
                Toast.makeText(CampaignActivity.this, "success!", Toast.LENGTH_SHORT).show();

                ArrayList<MainAdSquad.adsquads> adsquadsList = new ArrayList(response.body().getadsquads());

                Toast.makeText(CampaignActivity.this, "success!", Toast.LENGTH_SHORT).show();
                Log.i("CampaignActivity ", "adsquadsList: " +adsquadsList);

                String AdSquadName = adsquadsList.get(0).getadsquad().getAdsquad_name();
                String adSquadId = adsquadsList.get(0).getadsquad().getAdsquad_id();


                if(adSquadId != null){
                    Intent intent = new Intent(CampaignActivity.this, AdSquadActivity.class);
                    intent.putExtra("access_token", token);
                    intent.putExtra("AdSquadName", AdSquadName);
                    intent.putExtra("AdSquadId", adSquadId);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<MainAdSquad> call, Throwable t) {
                Toast.makeText(CampaignActivity.this, "failed!", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
