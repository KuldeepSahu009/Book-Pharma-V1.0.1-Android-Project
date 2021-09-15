package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import soup.neumorphism.NeumorphButton;
import soup.neumorphism.NeumorphTextView;

public class LoginActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_LIA = 1000;
    private Class_Preloader_One loader_LIA;
    private EditText emailImput_LIA, passwordInput_LIA;
    private NeumorphTextView forgotPassBtn_LIA, newAcBtn_LIA;
    private NeumorphButton signInBtn_LIA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        loader_LIA = new Class_Preloader_One(LoginActivity.this);
        emailImput_LIA = (EditText) findViewById(R.id.email_input_login_ac);
        passwordInput_LIA = (EditText) findViewById(R.id.password_input_login_ac);
        forgotPassBtn_LIA = (NeumorphTextView) findViewById(R.id.forgot_pass_btn_login_ac);
        newAcBtn_LIA = (NeumorphTextView) findViewById(R.id.new_account_btn_login_ac);
        signInBtn_LIA = (NeumorphButton) findViewById(R.id.sign_in_btn_login_ac);

        forgotPassBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickForgotPasswordBtn();
            }
        });

        newAcBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickNewAccountBtn();
            }
        });

        signInBtn_LIA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str_emailInput_LIA, str_passwordInput_LIA;
                str_emailInput_LIA = (String) emailImput_LIA.getText().toString().trim();
                str_passwordInput_LIA = (String) passwordInput_LIA.getText().toString().trim();

                if (str_emailInput_LIA.isEmpty()) {
                    emailImput_LIA.setError("*required field!");
                    emailImput_LIA.requestFocus();
                    return;
                } else if (str_passwordInput_LIA.isEmpty()) {
                    passwordInput_LIA.setError("*required field!");
                    passwordInput_LIA.requestFocus();
                    return;
                } else if (str_emailInput_LIA.endsWith("@gmail.com")) {
                    if (str_passwordInput_LIA.length() == 8) {
                        clickSignBtn();
                    } else {
                        passwordInput_LIA.setError("password must be 8 in length!");
                        passwordInput_LIA.requestFocus();
                        return;
                    }
                } else {
                    emailImput_LIA.setError("*invalid email!");
                    emailImput_LIA.requestFocus();
                    return;
                }

            }//SignUp
        });

    }//@Override

    private void clickSignBtn() {
        loader_LIA.startLoadingDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                finish();
                loader_LIA.dismissDilog();
            }
        }, SPLASH_LIA);
    }

    private void clickNewAccountBtn() {
        loader_LIA.startLoadingDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                finish();
                loader_LIA.dismissDilog();
            }
        }, SPLASH_LIA);
    }

    private void clickForgotPasswordBtn() {
        loader_LIA.startLoadingDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "Under Construction...!", Toast.LENGTH_SHORT).show();
                loader_LIA.dismissDilog();
            }
        }, SPLASH_LIA);
    }

    @Override
    public void onBackPressed() {
        loader_LIA.startLoadingDialog();
        startActivity(new Intent(LoginActivity.this, IntroActivity.class));
        finish();
        loader_LIA.dismissDilog();
    }

}//END