package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ErrorOneActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_EOA = 2000;
    private Class_Preloader_One loader_EOA;
    private Button retryBtn_EOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_error_one);

        loader_EOA = new Class_Preloader_One(ErrorOneActivity.this);
        retryBtn_EOA = (Button) findViewById(R.id.retry_btn_error_one_ac);

        retryBtn_EOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loader_EOA.startLoadingDialog();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(getApplicationContext(), IntroActivity.class));
                        finish();
                        loader_EOA.dismissDilog();
                    }
                }, SPLASH_EOA);
            }
        });

    }//@Override

    @Override
    public void onBackPressed() {
        Toast.makeText(ErrorOneActivity.this, "some thing went wrong please retry!", Toast.LENGTH_SHORT).show();
    }

}//END