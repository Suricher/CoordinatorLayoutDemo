package com.example.rui.myapplication.exmcollapsing;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.rui.myapplication.ATMathUtils;
import com.example.rui.myapplication.R;

public class AlipayActivity extends AppCompatActivity implements OnOffsetChangedListener {
    private final static String TAG = "AlipayActivity";
    private AppBarLayout abl_bar;
    private View tl_expand, tl_collapse;
    private RecyclerView rv_content;
    private View view_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alipay);
//		rv_content = (RecyclerView) findViewById(R.id.rv_content);
//		rv_content.setLayoutManager(new GridLayoutManager(this, 4));
//		rv_content.setAdapter(new LifeAdapter(this, LifeItem.getDefault()));

        abl_bar = (AppBarLayout) findViewById(R.id.abl_bar);
        tl_expand = (View) findViewById(R.id.tl_expand);
        tl_collapse = (View) findViewById(R.id.tl_collapse);
        view_pay = (View) findViewById(R.id.view_pay);
        abl_bar.addOnOffsetChangedListener(this);

        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AlipayActivity.this, "我是：" + v.getTag(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        int offset = Math.abs(verticalOffset);
        int total = appBarLayout.getTotalScrollRange();
        Log.d(TAG, "verticalOffset=" + verticalOffset + "---total=" + total + "---" + appBarLayout.getHeight());

        float ratio = 1 - Math.abs(offset) * 1.f / total;
        ratio = ATMathUtils.constrain(ratio, 0, 1);

        float alpha1 = 1 - Math.min(1, ratio / 0.5f);
        float alpha2 = Math.max((ratio - 0.5f) / 0.5f, 0);
        float alpha3 = 1 - Math.abs(offset) * 1.f / (0.65f * appBarLayout.getHeight());
        alpha3 = ATMathUtils.constrain(alpha3, 0, 1);
        Log.e(TAG, "onOffsetChanged: " + ratio + "----" + alpha1 + "---" + alpha2 + "---" + alpha3);
        tl_expand.setAlpha(alpha2);
        tl_collapse.setAlpha(alpha1);
        view_pay.setAlpha(alpha3);

        if (offset <= total / 2) {
            tl_expand.setVisibility(View.VISIBLE);
            tl_collapse.setVisibility(View.GONE);
        } else {
            tl_expand.setVisibility(View.GONE);
            tl_collapse.setVisibility(View.VISIBLE);
        }
    }

}
