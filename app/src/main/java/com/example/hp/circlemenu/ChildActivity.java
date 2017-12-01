package com.example.hp.circlemenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ChildActivity extends AppCompatActivity {
    private TextView tv_center;
    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        tv_center = (TextView) findViewById(R.id.tv_center);
        value = getIntent().getIntExtra("value", -1);
        switch (value) {
            case 0 :
                tv_center.setText("游戏互动");
                break;
            case 1 :
                tv_center.setText("海外授信");
                break;
            case 2 :
                tv_center.setText("认购中心");
                break;
            case 3 :
                tv_center.setText("财务中心");
                break;
            case 4 :
                tv_center.setText("安全中心");
                break;
            case 5 :
                tv_center.setText("关于我们");
                break;
            case 6 :
                tv_center.setText("网上商城");
                break;
        }
    }
}
