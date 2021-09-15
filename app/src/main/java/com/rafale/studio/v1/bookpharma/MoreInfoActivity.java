package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MoreInfoActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_MIA = 1000;
    private Class_Preloader_One loader_MIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_more_info);

        loader_MIA = new Class_Preloader_One(MoreInfoActivity.this);

    }//@Override

    @Override
    public void onBackPressed() {
        loader_MIA.startLoadingDialog();
        startActivity(new Intent(getApplicationContext(), QuestionActivity.class));
        finish();
        loader_MIA.dismissDilog();
    }
}//END