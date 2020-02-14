package com.example.snapinterview.Ad;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.snapinterview.R;

public class AdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);

        Bundle bundle = getIntent().getExtras();
        String adName = bundle.getString("name");

        String result = "Ad with Ad Name " +adName+ " of type SNAP_AD is created in  PAUSED status";


        final TextView adView = (TextView) findViewById(R.id.ad_result);
        SpannableString ss=  new SpannableString(result);
        ss.setSpan(new ForegroundColorSpan(Color.BLUE), 16, 17+ adName.length(), 0);
        adView.setText(ss);

    }
}
