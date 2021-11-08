package com.example.afnansalameh1181469;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooserActivity extends AppCompatActivity {

    String name,weight,height,gender;

    Button takeARun,scheduale,backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);


        Intent intent=getIntent();
        name=intent.getStringExtra("NAME");
        gender=intent.getStringExtra("GENDER");
        weight=intent.getStringExtra("WEIGHT");
        height=intent.getStringExtra("HEIGHT");


        takeARun=findViewById(R.id.TakeARunButton);
        scheduale=findViewById(R.id.SchedualeButton);
        backButton=findViewById(R.id.backButtonINChooser);



        takeARun.setBackgroundColor(Color.WHITE);
        takeARun.setTextColor(Color.BLACK);

        scheduale.setBackgroundColor(Color.WHITE);
        scheduale.setTextColor(Color.BLACK);
        backButton.setBackgroundColor(Color.WHITE);
        backButton.setTextColor(Color.BLACK);


    }


    public void TakeARunOnClick(View view) {
        Intent intent1=new Intent(this,TimePicker.class);
        startActivity(intent1);

    }

    public void viewYourSchedualeOnClick(View view) {
        Intent intent3=new Intent(this,SchedualeAct.class);
        startActivity(intent3);
    }





//    public void viewwPersonalInfoOnClick(View view) {
//        Intent intent2=new Intent(this,PersonalInfoAct.class);
//        intent2.putExtra("NAME",name);
//        intent2.putExtra("WEIGHT",weight);
//        intent2.putExtra("HEIGHT",height);
//        intent2.putExtra("GENDER",gender);
//        startActivity(intent2);
//    }

    public void backOnClick(View view) {

        Intent inetent4=new Intent(this,MainActivity.class);
        startActivity(inetent4);
    }
}