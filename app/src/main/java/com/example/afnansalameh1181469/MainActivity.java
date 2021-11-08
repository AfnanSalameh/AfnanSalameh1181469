package com.example.afnansalameh1181469;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    Button button;

    EditText nameFd,heightFd,weightFd;
    CheckBox rememberMeCheck;
    Spinner genderSpinner;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button=findViewById(R.id.mainButton);
        button.setBackgroundColor(Color.WHITE);
        button.setTextColor(Color.BLACK);
        nameFd=findViewById(R.id.nameField);
        heightFd=findViewById(R.id.heightField);
        weightFd=findViewById(R.id.weightField);
        rememberMeCheck=findViewById(R.id.chkRemember);
        genderSpinner=findViewById(R.id.spn);


        String []genders={"Male","Female"};

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,genders);

        genderSpinner.setAdapter(adapter);


        pref= PreferenceManager.getDefaultSharedPreferences(this);
        editor=pref.edit();

        checkPref();


    }

    public void continueOnClick(View view) {
        boolean in =false;
        try {
            double w=Double.parseDouble(weightFd.getText().toString());
            double h=Double.parseDouble(heightFd.getText().toString());


        }catch(Exception e){
            Toast.makeText(this,"Please enter real values for weight and height",Toast.LENGTH_LONG).show();

            in= true;
        }

        if(nameFd.getText().toString().isEmpty()||weightFd.getText().toString().isEmpty()||heightFd.getText().toString().isEmpty()){
            Toast.makeText(this,"Please fill all the fields",Toast.LENGTH_SHORT).show();


        }
        else if(!in){
            if(rememberMeCheck.isChecked()){

//                editor.putString("NAME",nameFd.getText().toString());
//                editor.putString("WEIGHT",weightFd.getText().toString());
//                editor.putString("HEIGHT",heightFd.getText().toString());
//                editor.putString("GENDER",genderSpinner.getSelectedItem().toString());

                User user=new User(nameFd.getText().toString(),Double.parseDouble(weightFd.getText().toString()),Double.parseDouble(heightFd.getText().toString()),genderSpinner.getSelectedItem().toString());
                Gson gson=new Gson();
                String gsonString=gson.toJson(user);
                editor.putString("user",gsonString);



                editor.putBoolean("FLAG",true);
                editor.commit();
            }else{
                editor.putBoolean("FLAG",false);
                editor.commit();
            }


            Intent intent=new Intent(this,ChooserActivity.class);
            intent.putExtra("NAME",nameFd.getText().toString());
            intent.putExtra("WEIGHT",weightFd.getText().toString());
            intent.putExtra("HEIGHT",heightFd.getText().toString());
            intent.putExtra("GENDER",genderSpinner.getSelectedItem().toString());


            startActivity(intent);
        }




    }

    public void checkPref(){
        boolean flag=pref.getBoolean("FLAG",false);
        if(flag){
//            String name =pref.getString("NAME","");
//            String gender=pref.getString("GENDER","");
//            String height=pref.getString("HEIGHT","");
//            String weight=pref.getString("WEIGHT","");
            Gson gson = new Gson();
            String str = pref.getString("user", "");
            User user=gson.fromJson(str,User.class);



            rememberMeCheck.setChecked(true);
            nameFd.setText(user.name);
            heightFd.setText(user.height+"");
            weightFd.setText(user.weight+"");


        }
    }
}