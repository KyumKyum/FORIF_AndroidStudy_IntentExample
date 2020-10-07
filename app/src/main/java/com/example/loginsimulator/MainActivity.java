package com.example.loginsimulator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout mainLayout;
    TextView welcomeText;
    EditText etGetId;
    EditText etGetPW;
    Button btnLogin;
    Button btnRegister;

    private static final String curState = "CUR_BACKGROUND_STATE";
    private static final String ID = "CUR_USER_ID";
    private static final String userID = "myugyin";
    private static final String userPassword = "HELLOWORLD!";
    String curBackgroundState = "BACKGROUND_COOL_SKY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.CL_main);
        welcomeText = findViewById(R.id.tv_welcome);
        etGetId = findViewById(R.id.ET_Enter_ID);
        etGetPW = findViewById(R.id.ET_Enter_PW);
        btnLogin = findViewById(R.id.BTN_Login);
        btnRegister = findViewById(R.id.BTN_Register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curId =etGetId.getText().toString();
                String curPw = etGetPW.getText().toString();

                if(curId.trim().equals(userID) && curPw.trim().equals(userPassword)){
                    Intent intent = new Intent(getApplicationContext(),subActivity.class);
                    intent.putExtra(ID,userID);
                    intent.putExtra(curState,curBackgroundState);
                    startActivityForResult(intent,101);
                }else{
                    Toast.makeText(MainActivity.this, "Wrong ID or Password.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setBackground(curBackgroundState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101 && resultCode == RESULT_OK && data != null){
            curBackgroundState = data.getStringExtra(curState);
            setBackground(curBackgroundState);
        }
    }

    void setBackground(String code){
        switch (code){

            case "BACKGROUND_COOL_SKY":
                mainLayout.setBackgroundResource(R.drawable.background_gradient_default);
                makeTextBlack();
                break;

            case "BACKGROUND_PURE_LUST":
                mainLayout.setBackgroundResource(R.drawable.background_gradient_purelust);
                makeTextWhite();
                break;

            case "BACKGROUND_RELAXING_RED":
                mainLayout.setBackgroundResource(R.drawable.background_gradient_relaxingred);
                makeTextBlack();
                break;

            case "BACKGROUND_SUBLIME_LIGHT":
                mainLayout.setBackgroundResource(R.drawable.background_gradient_sublimelight);
                makeTextBlack();
                break;

            case "BACKGROUND_MOONLIT_ASTEROID":
                mainLayout.setBackgroundResource(R.drawable.background_gradient_moonlitasteroid);
                makeTextWhite();
                break;

        }

    }

    void makeTextWhite(){
        welcomeText.setTextColor(getResources().getColor(R.color.colorWhite));
        btnLogin.setTextColor(getResources().getColor(R.color.colorWhite));
        btnRegister.setTextColor(getResources().getColor(R.color.colorWhite));
        etGetId.setTextColor(getResources().getColor(R.color.colorWhite));
        etGetId.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    void makeTextBlack(){
        welcomeText.setTextColor(getResources().getColor(R.color.colorBlack));
        btnLogin.setTextColor(getResources().getColor(R.color.colorBlack));
        btnRegister.setTextColor(getResources().getColor(R.color.colorBlack));
        etGetId.setTextColor(getResources().getColor(R.color.colorBlack));
        etGetId.setTextColor(getResources().getColor(R.color.colorBlack));
    }

}