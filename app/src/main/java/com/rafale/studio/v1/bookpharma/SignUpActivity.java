package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import soup.neumorphism.NeumorphButton;
import soup.neumorphism.NeumorphTextView;

public class SignUpActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_SUA = 1000;
    private Class_Preloader_One loader_SUA;
    private EditText fullNameInput_SUA, emailInput_SUA, mobileInput_SUA, passwordInput_SUA, confirmPasswordInput_SUA;
    private CheckBox checkBox_SUA;
    private NeumorphButton signUpBtn_SUA;
    private NeumorphTextView alreadyAcBtn_SUA;
    private String str_fullNameSUA, str_emailSUA, str_mobileSUA, str_createPassSUA, str_confirmPassSUA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        loader_SUA = new Class_Preloader_One(SignUpActivity.this);
        fullNameInput_SUA = (EditText) findViewById(R.id.full_name_input_sing_up_ac);
        emailInput_SUA = (EditText) findViewById(R.id.email_input_sing_up_ac);
        mobileInput_SUA = (EditText) findViewById(R.id.mobile_input_sing_up_ac);
        passwordInput_SUA = (EditText) findViewById(R.id.create_pass_input_sing_up_ac);
        confirmPasswordInput_SUA = (EditText) findViewById(R.id.confirm_pass_input_sing_up_ac);
        checkBox_SUA = (CheckBox) findViewById(R.id.checkBox_sign_up_ac);
        signUpBtn_SUA = (NeumorphButton) findViewById(R.id.sign_up_btn_sign_up_ac);
        alreadyAcBtn_SUA = (NeumorphTextView) findViewById(R.id.already_account_btn_sign_up_ac);

        str_fullNameSUA = (String) fullNameInput_SUA.getText().toString().trim();
        str_emailSUA = (String) emailInput_SUA.getText().toString().trim();
        str_mobileSUA = (String) mobileInput_SUA.getText().toString().trim();
        str_createPassSUA = (String) passwordInput_SUA.getText().toString().trim();
        str_confirmPassSUA = (String) confirmPasswordInput_SUA.getText().toString().trim();

        signUpBtn_SUA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validationSUA();
            }
        });

    }//@Override

    private void validationSUA() {
        if (str_fullNameSUA.isEmpty()) {
            fullNameInput_SUA.setError("*required field!");
            fullNameInput_SUA.requestFocus();
            return;
        } else if (str_emailSUA.isEmpty()) {
            emailInput_SUA.setError("*required field!");
            emailInput_SUA.requestFocus();
            return;
        } else if (str_mobileSUA.isEmpty()) {
            mobileInput_SUA.setError("*required field!");
            mobileInput_SUA.requestFocus();
            return;
        } else if (str_createPassSUA.isEmpty()) {
            passwordInput_SUA.setError("*required field!");
            passwordInput_SUA.requestFocus();
            return;
        } else if (str_confirmPassSUA.isEmpty()) {
            confirmPasswordInput_SUA.setError("*required field!");
            confirmPasswordInput_SUA.requestFocus();
            return;
        } else if (!str_emailSUA.endsWith("@gmail.com")) {
            emailInput_SUA.setError("invalid email!");
            emailInput_SUA.requestFocus();
            return;
        } else if (str_mobileSUA.length() != 10) {
            mobileInput_SUA.setError("*invalid number!");
            mobileInput_SUA.requestFocus();
            return;
        } else if (str_createPassSUA.length() != 8) {
            passwordInput_SUA.setError("*must be 8 in length!");
            passwordInput_SUA.requestFocus();
            return;
        } else if (str_createPassSUA == str_confirmPassSUA) {
            if (checkBox_SUA.isChecked()) {
                SignUpMove();
            } else {
                checkBox_SUA.setError("*required field!");
                checkBox_SUA.requestFocus();
                return;
            }
        } else {
            confirmPasswordInput_SUA.setError("*password mismatch!");
            confirmPasswordInput_SUA.requestFocus();
            return;
        }
    }

    private void SignUpMove() {
        loader_SUA.startLoadingDialog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentSUA = new Intent(getApplicationContext(), OTPActivity.class);
                intentSUA.putExtra("mobileNumberOfUser", str_mobileSUA);
                startActivity(intentSUA);
                finish();
                loader_SUA.dismissDilog();
            }
        }, SPLASH_SUA);
    }

}//END