package com.rafale.studio.v1.bookpharma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.cardemulation.HostNfcFService;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;

import soup.neumorphism.NeumorphButton;

public class OTPActivity extends AppCompatActivity {
    /**
     * Design & Developed by Kuldeep Sahu.
     * E-mail: sahukuldeep912001@gmail.com
     * http://skywarrior09.gq
     */

    private static int SPLASH_OA = 1000;
    private Class_Preloader_One loader_OA;
    private PinView otpInputOA;
    private NeumorphButton verifyBtnOA;
    private Button resendCodeBtnOA;
    private String str_otpInputOA;
    private TextView showNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_otpactivity);

        loader_OA = new Class_Preloader_One(OTPActivity.this);
        otpInputOA = (PinView) findViewById(R.id.pin_view_otp_ac);
        verifyBtnOA = (NeumorphButton) findViewById(R.id.verify_btn_otp_ac);
        resendCodeBtnOA = (Button) findViewById(R.id.resend_code_btn_otp_ac);
        showNum = (TextView) findViewById(R.id.number_show_text_view_otp_ac);

        str_otpInputOA = (String) otpInputOA.getText().toString().trim();

        String numberUserStr = getIntent().getStringExtra("mobileNumberOfUser");
        showNum.setText("+91" + numberUserStr);

        resendCodeBtnOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickResendCodeBtn();
            }
        });

        verifyBtnOA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickVerifyBtn();
            }
        });

    }//@Override

    private void clickVerifyBtn() {
        if (str_otpInputOA.isEmpty()) {
            otpInputOA.setError("*required field!");
            otpInputOA.requestFocus();
            return;
        } else {
            loader_OA.startLoadingDialog();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(getApplicationContext(), CheckedTwoActivity.class));
                    finish();
                    loader_OA.dismissDilog();
                }
            }, SPLASH_OA);
        }
    }

    private void clickResendCodeBtn() {
        loader_OA.startLoadingDialog();
        Toast.makeText(OTPActivity.this, "code resend successfully", Toast.LENGTH_SHORT).show();
        loader_OA.dismissDilog();
    }

}//END