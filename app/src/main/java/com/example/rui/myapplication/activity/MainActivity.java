package com.example.rui.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import com.example.rui.myapplication.R;
import com.example.rui.myapplication.SystemBarHelper;
import com.example.rui.myapplication.exmcollapsing.AlipayDemoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_jump)
    Button ivJump;
    @BindView(R.id.iv_jump02)
    Button ivJump02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SystemBarHelper.immersiveStatusBar(this);
    }
    
    @OnClick(R.id.iv_jump02)
    public void onClicked() {
        startActivity(new Intent(this, AlipayDemoActivity.class));
    }
}
