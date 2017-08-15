package com.example.rui.myapplication.exmcollapsing;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.rui.myapplication.R;
import com.example.rui.myapplication.exmcollapsing.adapter.RecyclerAdapter;

public class ImageFadeActivity extends AppCompatActivity {
	private CoordinatorLayout cl_main;
	private CollapsingToolbarLayout ctl_title;
	private RecyclerView rv_main;
	private String[] yearArray = {"鼠年", "牛年", "虎年", "兔年", "龙年", "蛇年",
			"马年", "羊年", "猴年", "鸡年", "狗年", "猪年"};

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_fade);
		Toolbar tl_title = (Toolbar) findViewById(R.id.tl_title);
//		setSupportActionBar(tl_title);
		cl_main = (CoordinatorLayout) findViewById(R.id.cl_main);
		ctl_title = (CollapsingToolbarLayout) findViewById(R.id.ctl_title);
		ctl_title.setTitle("Hello World");
		ctl_title.setExpandedTitleColor(Color.BLACK); 
		ctl_title.setCollapsedTitleTextColor(Color.RED);
	    
		rv_main = (RecyclerView) findViewById(R.id.rv_main);
		LinearLayoutManager llm = new LinearLayoutManager(this);
		llm.setOrientation(LinearLayout.VERTICAL);
		rv_main.setLayoutManager(llm);
		RecyclerAdapter adapter = new RecyclerAdapter(this, yearArray);
		rv_main.setAdapter(adapter);
	}
    
}
