package com.example.snapinterview.AdSquads;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snapinterview.Ad.AdActivity;
import com.example.snapinterview.Ad.Ads;
import com.example.snapinterview.Ad.AdsList;
import com.example.snapinterview.R;
import com.example.snapinterview.SnapClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AdSquadActivity extends AppCompatActivity {

    static String token;
    static String ad_squad_id;
    static String ad_squad_name;
    static String adName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_squad);

        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("access_token");
        ad_squad_name = bundle.getString("AdSquadName");
        ad_squad_id = bundle.getString("AdSquadId");

        String result = "Your Ad Squad Name is " +ad_squad_name;


        final TextView adAccountView = (TextView) findViewById(R.id.ad_squad_name);
        SpannableString ss=  new SpannableString(result);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 21, result.length(), 0);
        adAccountView.setText(ss);

        EditText simpleEditText = (EditText) findViewById(R.id.AdName);

        findViewById(R.id.post_ad).setOnClickListener((view) -> {
            adName = simpleEditText.getText().toString();
            if(adName.isEmpty()){
                Toast.makeText(AdSquadActivity.this, "Ad name is required!", Toast.LENGTH_SHORT).show();
            } else {
                Ads ads = new Ads("01a7105c-5a03-46cb-b647-73f4d2eb8721", "4a13b93b-5d20-4b5a-8e7b-e38a4dd8d08a", adName, "SNAP_AD", "PAUSED");
                List<Ads> temp = new ArrayList<Ads>();
                temp.add(ads);
                AdsList listAds = new AdsList();
                listAds.setAdsList(temp);
                createAd(listAds);
            }
        });
    }


    private void createAd(AdsList ads) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://adsapi.snapchat.com/v1/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        SnapClient client = retrofit.create(SnapClient.class);
        Log.i("AdSquadActivity ", "editTextValue: " + adName);
        Log.i("AdSquadActivity ", "token: " + token);
        Log.i("AdSquadActivity ", "ad_squad_id: " + ad_squad_id);
        Log.i("AdSquadActivity ", "ad: " + ads);


        Call<AdsList> AdCall = client.createAd(
                "Bearer " + token,
                ad_squad_id,
                ads
        );

        AdCall.enqueue(new Callback<AdsList>() {
            @Override
            public void onResponse(Call<AdsList> call, Response<AdsList> response) {
                Toast.makeText(AdSquadActivity.this, "success!", Toast.LENGTH_SHORT).show();
                Log.i("AdSquadActivity ", "response: " +response);
                if(response.isSuccessful()) {
                 Intent intent = new Intent(AdSquadActivity.this, AdActivity.class);
                 intent.putExtra("name", adName);
                 startActivity(intent);
               }
            }

            @Override
            public void onFailure(Call<AdsList> call, Throwable t) {

            }
        });

    }
}

