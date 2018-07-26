package com.skplanet.wonyoung.wonyoung;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

/**
 * Created by anderson on 2018. 7. 26..
 */

public class DetailActivity extends Activity {

    Button kakaoShareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        kakaoShareButton = (Button) findViewById(R.id.button_kakao_share);
        kakaoShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double myHomeLatitude = 37.539548;
                double myHomeLongitude = 126.967387;
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                String text = "원영이의 집은 여기로 가시면 됩니다. \n"
                        +"https://www.google.com/maps/search/?api=1&query="+myHomeLatitude+","+myHomeLongitude;
                intent.putExtra(Intent.EXTRA_TEXT, text);
                Intent chooser = Intent.createChooser(intent, "친구에게 공유하기");
                startActivity(chooser);
            }
        });
    }
}