package com.example.loginsimulator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class subActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String curState = "CUR_BACKGROUND_STATE";
    private static final String ID = "CUR_USER_ID";

    private static final String COOL_SKY = "BACKGROUND_COOL_SKY";
    private static final String PURE_LUST = "BACKGROUND_PURE_LUST";
    private static final String RELAXING_RED = "BACKGROUND_RELAXING_RED";
    private static final String SUBLIME_LIGHT = "BACKGROUND_SUBLIME_LIGHT";
    private static final String MOONLIT_ASTEROID = "BACKGROUND_MOONLIT_ASTEROID";
    private static final String TAG = "SYSTEM";

    TextView welcomeText;
    ConstraintLayout mainLayout;
    Button option1;
    Button option2;
    Button option3;
    Button option4;
    Button option5;

    String curBackgroundState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mainLayout = findViewById(R.id.CL_sub);
        welcomeText = findViewById(R.id.welcomeUser);
        option1 = findViewById(R.id.BTN_Option1);
        option2 = findViewById(R.id.BTN_Option2);
        option3 = findViewById(R.id.BTN_Option3);
        option4 = findViewById(R.id.BTN_Option4);
        option5 = findViewById(R.id.BTN_Option5);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);
        option5.setOnClickListener(this);

        Intent intent = getIntent();
        welcomeText.append("\n"+intent.getStringExtra(ID));
        curBackgroundState = intent.getStringExtra(curState);

        if(curBackgroundState!=null) //Objects.isNull method is only support android version 24 or more.
            setBackground(curBackgroundState);

        Toast.makeText(this, "Welcome!\n" + intent.getStringExtra(ID), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        int cid = view.getId();

        switch (cid){

            case R.id.BTN_Option1:
                setBackground(COOL_SKY);
                break;

            case R.id.BTN_Option2:
                setBackground(PURE_LUST);
                break;

            case R.id.BTN_Option3:
                setBackground(RELAXING_RED);
                break;

            case R.id.BTN_Option4:
                setBackground(SUBLIME_LIGHT);
                break;

            case R.id.BTN_Option5:
                setBackground(MOONLIT_ASTEROID);
                break;

        }
    }

    void setBackground(String code) {

        curBackgroundState = code;

        switch (code) {

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
        option1.setTextColor(getResources().getColor(R.color.colorWhite));
        option2.setTextColor(getResources().getColor(R.color.colorWhite));
        option3.setTextColor(getResources().getColor(R.color.colorWhite));
        option4.setTextColor(getResources().getColor(R.color.colorWhite));
        option5.setTextColor(getResources().getColor(R.color.colorWhite));
    }

    void makeTextBlack(){
        welcomeText.setTextColor(getResources().getColor(R.color.colorBlack));
        option1.setTextColor(getResources().getColor(R.color.colorBlack));
        option2.setTextColor(getResources().getColor(R.color.colorBlack));
        option3.setTextColor(getResources().getColor(R.color.colorBlack));
        option4.setTextColor(getResources().getColor(R.color.colorBlack));
        option5.setTextColor(getResources().getColor(R.color.colorBlack));
    }

    @Override
    public void onBackPressed() { //Override onBackPressed : Event when back button clicked.
        Intent intent = new Intent();
        intent.putExtra(curState,curBackgroundState);
        setResult(RESULT_OK,intent);

        super.onBackPressed();
    }
}