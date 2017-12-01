package com.example.hp.circlemenu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int src_n[] = {R.mipmap.main_game_nor, R.mipmap.mian_oversea_credit_nor,R.mipmap.main_buy_center_nor, R.mipmap.main_finance_nor, R.mipmap.main_safecenter_nor, R.mipmap.main_aboutour_nor, R.mipmap.main_shopping_nor};
    private int src_s[] = {R.mipmap.main_game_nor_s, R.mipmap.mian_oversea_credit_nor_s,R.mipmap.main_buy_center_nor_s, R.mipmap.main_finance_nor_s, R.mipmap.main_safecenter_nor_s, R.mipmap.main_aboutour_nor_s, R.mipmap.main_shopping_nor_s};

    private int position = 2;
    private SlidingArcView qtView;
    private ImageView image_comein_btn;
    private ImageView image_anim;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0 :
                    Intent intent=new Intent(MainActivity.this,ChildActivity.class);
                    intent.putExtra("value",0);
                    startActivity(intent);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
                case 1 :
                    Intent intent1=new Intent(MainActivity.this,ChildActivity.class);
                    intent1.putExtra("value",1);
                    startActivity(intent1);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
                case 2 :
                    Intent intent2=new Intent(MainActivity.this,ChildActivity.class);
                    intent2.putExtra("value",2);
                    startActivity(intent2);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
                case 3 :
                    Intent intent3=new Intent(MainActivity.this,ChildActivity.class);
                    intent3.putExtra("value",3);
                    startActivity(intent3);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
                case 4 :
                    Intent intent4=new Intent(MainActivity.this,ChildActivity.class);
                    intent4.putExtra("value",4);
                    startActivity(intent4);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
                case 5 :
                    Intent intent5=new Intent(MainActivity.this,ChildActivity.class);
                    intent5.putExtra("value",5);
                    startActivity(intent5);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
                case 6 :
                    Intent intent6=new Intent(MainActivity.this,ChildActivity.class);
                    intent6.putExtra("value",6);
                    startActivity(intent6);
                    image_anim.clearAnimation();
                    image_anim.setVisibility(View.GONE);
                    image_comein_btn.setClickable(true);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.initScreen(this);
        setContentView(R.layout.activity_main);

        qtView = (SlidingArcView) findViewById(R.id.view);
        image_comein_btn = (ImageView) findViewById(R.id.image_comein_btn);
        image_anim = (ImageView)findViewById(R.id.image_anim);

        RotateAnimation rotateAnim =new RotateAnimation(0,720, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        TranslateAnimation translateAnim=new TranslateAnimation(0,0,0,ScreenUtils.dp2px(195));
        final AnimationSet set=new AnimationSet(false);
        set.addAnimation(rotateAnim);
        set.addAnimation(translateAnim);
        set.setFillAfter(true);
        set.setDuration(1000);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) image_anim.getLayoutParams();
        params.width = ScreenUtils.dp2px(70);
        params.height = ScreenUtils.dp2px(70);
        image_anim.setLayoutParams(params);

        qtView.setQtScrollListener(new SlidingArcView.QTScrollListener() {
            @Override
            public void onSelect(View v, int index, List<SlidingArcView.SignView> views) {
                position = index;
                for(int i = 0; i < views.size(); i++) {
                    if(position%7==i){
                        views.get(i).getView().setBackgroundResource(src_s[i]);
                    }else {
                        views.get(i).getView().setBackgroundResource(src_n[i]);
                    }
                }
            }
        });

        qtView.setQtItemClickListener(new SlidingArcView.QTItemClickListener() {
            @Override
            public void onClick(View v, int index,List<SlidingArcView.SignView> views) {
                position = index;
                for(int i = 0; i < views.size(); i++) {
                    if(position%7==i){
                        views.get(i).getView().setBackgroundResource(src_s[i]);
                    }else {
                        views.get(i).getView().setBackgroundResource(src_n[i]);
                    }
                }
            }
        });

        image_comein_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position) {
                    case 0:
                        position = 0;//游戏互动
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(0, 1000);
                            }
                        }).start();

                        break;
                    case 1:
                        position = 1;//海外授信
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(1, 1000);
                            }
                        }).start();
                        break;
                    case 2:
                        position = 2;
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(2, 1000);
                            }
                        }).start();

                        break;
                    case 3:
                        position = 3;
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(3, 1000);
                            }
                        }).start();
                        break;
                    case 4:
                        position = 4;
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(4, 1000);
                            }
                        }).start();
                        break;
                    case 5:
                        position = 5;
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(5, 1000);
                            }
                        }).start();
                        break;
                    case 6:
                        position = 6;//网上商城
                        image_anim.setVisibility(View.VISIBLE);
                        image_anim.setImageResource(src_s[position]);
                        image_anim.startAnimation(set);
                        image_comein_btn.setClickable(false);

                        new Thread(new Runnable() {
                            public void run() {
                                handler.sendEmptyMessageDelayed(6, 1000);
                            }
                        }).start();
                        break;
                }
            }
        });

    }



}
