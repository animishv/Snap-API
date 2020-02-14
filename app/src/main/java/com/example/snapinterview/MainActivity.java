package com.example.snapinterview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snapinterview.Organization.OrganizationActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private final String client_id = "c5151194-9ded-4ac5-b69a-bb9914401698";
    private final String client_secret = "4665c0ca45ef10dbefa2";
    private final String redirect_uri = "https://example.com/snap";

    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = myWebView.getSettings();
        settings.setDomStorageEnabled(true);

        myWebView.loadUrl("https://accounts.snapchat.com/login/oauth2/authorize?response_type=code&client_id=" + client_id + "&redirect_uri=" + redirect_uri + "&scope=snapchat-marketing-api&state=wmKkg0TWgppW8PTBZ20sldUmF7hwvU");
        //     myWebView.loadUrl("https://accounts.snapchat.com/login/oauth2/authorize");

        myWebView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //   view.loadUrl(url);
                Uri uri = Uri.parse(url);

                if (uri != null && uri.toString().startsWith(redirect_uri)) {
                    String code = uri.getQueryParameter("code");

                    myWebView.stopLoading();
                    myWebView.loadUrl("about:blank");

                    Retrofit.Builder builder = new Retrofit.Builder()
                            .baseUrl("https://accounts.snapchat.com/")
                            .addConverterFactory(GsonConverterFactory.create());

                    Retrofit retrofit = builder.build();

                    SnapClient client = retrofit.create(SnapClient.class);
                    Call<AccessToken> accessTokenCall = client.getAccessToken(
                            client_id,
                            client_secret,
                            code,
                            "authorization_code",
                            "https://example.com/snap"
                    );
                    accessTokenCall.enqueue(new Callback<AccessToken>() {
                        @Override
                        public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                            Toast.makeText(MainActivity.this, "success!", Toast.LENGTH_SHORT).show();
                            token = response.body().getAccessToken();

                            if (token != null) {
                                Intent intent = new Intent(MainActivity.this, OrganizationActivity.class);
                                intent.putExtra("access_token", token);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<AccessToken> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "failed!", Toast.LENGTH_SHORT).show();

                        }
                    });


                }
                return false;

            }
        });

    }

}

