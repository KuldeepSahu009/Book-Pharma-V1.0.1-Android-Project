package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import soup.neumorphism.NeumorphCardView;

public class MainActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_MA = 2500;
    private Animation topAnim, bottomAnim, rightAnim, leftAnim, leftOutAnim;
    private ImageView pwIcon;
    private NeumorphCardView logo;
    private TextView logoName, sloganName;
    private LinearLayout bottomArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bottom_animation);
        leftAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_left);
        rightAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in_right);
        leftOutAnim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_out_left);

        pwIcon = (ImageView) findViewById(R.id.power_icon_main_ac);
        logo = (NeumorphCardView) findViewById(R.id.neumorphCardView_main_ac);
        logoName = (TextView) findViewById(R.id.logo_name_main_ac);
        sloganName = (TextView) findViewById(R.id.slogan_name_main_ac);
        bottomArea = (LinearLayout) findViewById(R.id.linearLayout_bottom_main_ac);

        AnimationSetUp();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pwIcon.setAnimation(leftOutAnim);
                logo.setAnimation(leftOutAnim);
                logoName.setAnimation(leftOutAnim);
                sloganName.setAnimation(leftOutAnim);
                bottomArea.setAnimation(leftOutAnim);
                startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                finish();
            }
        }, SPLASH_MA);

    }//@Override

    private void AnimationSetUp() {
        pwIcon.setAnimation(topAnim);
        logo.setAnimation(leftAnim);
        logoName.setAnimation(rightAnim);
        sloganName.setAnimation(leftAnim);
        bottomArea.setAnimation(bottomAnim);
    }

}//END