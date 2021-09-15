package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_QA = 1000;
    private Class_Preloader_One loader_QA;
    private RadioGroup radioGroup_QA;
    private CheckBox yesBtn_QA, noBtn_QA;
    private Button nextBtn_QA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_question);

        loader_QA = new Class_Preloader_One(QuestionActivity.this);
        radioGroup_QA = (RadioGroup) findViewById(R.id.radio_group_one_question_ac);
        yesBtn_QA = (CheckBox) findViewById(R.id.yes_btn_question_ac);
        noBtn_QA = (CheckBox) findViewById(R.id.no_btn_question_ac);
        nextBtn_QA = (Button) findViewById(R.id.next_btn_question_ac);

        nextBtn_QA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNextBtn();
            }
        });

    }//@Override

    private void clickNextBtn() {
        if (!yesBtn_QA.isChecked() && !noBtn_QA.isChecked()) {
            loader_QA.startLoadingDialog();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(QuestionActivity.this, "please select your category!", Toast.LENGTH_SHORT).show();
                    loader_QA.dismissDilog();
                }
            }, SPLASH_QA);
        } else if (yesBtn_QA.isChecked() && noBtn_QA.isChecked()) {
            loader_QA.startLoadingDialog();
            Toast.makeText(QuestionActivity.this, "some thing went wrong!", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), ErrorOneActivity.class));
                    finish();
                    loader_QA.dismissDilog();
                }
            }, SPLASH_QA);
        } else if (yesBtn_QA.isChecked() && !noBtn_QA.isChecked()) {
            loader_QA.startLoadingDialog();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), MoreInfoActivity.class));
                    finish();
                    loader_QA.dismissDilog();
                }
            }, SPLASH_QA);
        } else if (noBtn_QA.isChecked() && !yesBtn_QA.isChecked()) {
            loader_QA.startLoadingDialog();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                    finish();
                    loader_QA.dismissDilog();
                }
            }, SPLASH_QA);
        } else {
            loader_QA.startLoadingDialog();
            Toast.makeText(QuestionActivity.this, "some thing went wrong!", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), ErrorOneActivity.class));
                    finish();
                    loader_QA.dismissDilog();
                }
            }, SPLASH_QA);
        }
    }

    @Override
    public void onBackPressed() {
        loader_QA.startLoadingDialog();
        startActivity(new Intent(getApplicationContext(), IntroActivity.class));
        finish();
        loader_QA.dismissDilog();
    }

}//END