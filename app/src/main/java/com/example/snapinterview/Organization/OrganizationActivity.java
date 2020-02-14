package com.example.snapinterview.Organization;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snapinterview.AdAccounts.AdAccountActivity;
import com.example.snapinterview.AdAccounts.MainAdAccount;
import com.example.snapinterview.R;
import com.example.snapinterview.SnapClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OrganizationActivity extends AppCompatActivity {

    static String token;
    static String organizationId;
    static String organizationName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        Bundle bundle = getIntent().getExtras();
        token = bundle.getString("access_token");

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://adsapi.snapchat.com/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SnapClient client = retrofit.create(SnapClient.class);
        Call<MainOrganization> organizationCall = client.getOrganization(
                "Bearer "+token
        );


        organizationCall.enqueue(new Callback<MainOrganization>() {
            @Override
            public void onResponse(Call<MainOrganization> call, Response<MainOrganization> response) {

                ArrayList<MainOrganization.Organizations> organizationList = new ArrayList(response.body().getOrganizations());

                Toast.makeText(OrganizationActivity.this, "success!", Toast.LENGTH_SHORT).show();
                organizationName = organizationList.get(0).getOrganization().getOrganization_name();
                Log.i("OrganizationActivity ", "organizationName: " +organizationName);

                String result = "Your Organization Name is " +organizationName;

                organizationId = organizationList.get(0).getOrganization().getOrganization_id();

                Log.i("OrganizationActivity ", "organizationId: " +organizationId);

                final TextView helloTextView = (TextView) findViewById(R.id.organization_name);
                helloTextView.setText(result);
                SpannableString ss=  new SpannableString(result);
                ss.setSpan(new ForegroundColorSpan(Color.BLUE), 26, result.length(), 0);
                helloTextView.setText(ss);
            }

            @Override
            public void onFailure(Call<MainOrganization> call, Throwable t) {
                Toast.makeText(OrganizationActivity.this, "failed!", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.ad_accounts).setOnClickListener((view) -> {
            getAdAccounts();
        });
    }

    private void getAdAccounts(){

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://adsapi.snapchat.com/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SnapClient client = retrofit.create(SnapClient.class);
        Call<com.example.snapinterview.AdAccounts.MainAdAccount> adAccountCall = client.getAdAccounts(
                "Bearer "+token,
     //           "30647d17-4ff6-4792-98ba-74428fa07d18"
                organizationId
        );

        Log.i("OrganizationActivity ", "adAccountCall: " +adAccountCall);



        adAccountCall.enqueue(new Callback<MainAdAccount>() {
            @Override
            public void onResponse(Call<MainAdAccount> call, Response<MainAdAccount> response) {

                ArrayList<MainAdAccount.adaccounts> adaccountsList = new ArrayList(response.body().getadaccounts());

                Toast.makeText(OrganizationActivity.this, "success!", Toast.LENGTH_SHORT).show();
                Log.i("OrganizationActivity ", "adaccountsList: " +adaccountsList);

                String adAccountName = adaccountsList.get(0).getadaccount().getAdaccount_name();
                String adAccountId = adaccountsList.get(0).getadaccount().getAdaccount_id();
                if(adAccountId != null){
                    Intent intent = new Intent(OrganizationActivity.this, AdAccountActivity.class);
                    intent.putExtra("access_token", token);
                    intent.putExtra("adAccountName", adAccountName);
                    intent.putExtra("adAccountId", adAccountId);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<MainAdAccount> call, Throwable t) {
                Toast.makeText(OrganizationActivity.this, "failed!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
