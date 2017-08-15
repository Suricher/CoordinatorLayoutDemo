package com.example.rui.myapplication.exmcollapsing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.rui.myapplication.R;
import com.example.rui.myapplication.exmcollapsing.AlipayActivity;
import com.example.rui.myapplication.exmcollapsing.CollapseParallaxActivity;
import com.example.rui.myapplication.exmcollapsing.CollapsePinActivity;
import com.example.rui.myapplication.exmcollapsing.ImageFadeActivity;
import com.example.rui.myapplication.exmcollapsing.ScrollFlagActivity;

public class AlipayDemoActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipay_demo);
        findViewById(R.id.btn_pin).setOnClickListener(this);
        findViewById(R.id.btn_parallax).setOnClickListener(this);
        findViewById(R.id.btn_image_fade).setOnClickListener(this);
        findViewById(R.id.btn_scroll_flag).setOnClickListener(this);
        findViewById(R.id.btn_alipay).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_pin) {
            Intent intent = new Intent(this, CollapsePinActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_parallax) {
            Intent intent = new Intent(this, CollapseParallaxActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_image_fade) {
            Intent intent = new Intent(this, ImageFadeActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_scroll_flag) {
            Intent intent = new Intent(this, ScrollFlagActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_alipay) {
            Intent intent = new Intent(this, AlipayActivity.class);
            startActivity(intent);
        }
    }

}
