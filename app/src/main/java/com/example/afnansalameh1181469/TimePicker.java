package com.example.afnansalameh1181469;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
public class TimePicker extends AppCompatActivity {


    Button button,backButton;
    NumberPicker hrsPiceker,minutesPicker,secondsPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);


        button=findViewById(R.id.timePickerButton);
        button.setBackgroundColor(Color.WHITE);
        button.setTextColor(Color.BLACK);

        backButton=findViewById(R.id.timePickerBackButton);
        backButton.setBackgroundColor(Color.WHITE);
        backButton.setTextColor(Color.BLACK);

        hrsPiceker=findViewById(R.id.hrsPicker);
        minutesPicker=findViewById(R.id.minPicker);
        secondsPicker=findViewById(R.id.secPicker);
        hrsPiceker.setMinValue(0);
        hrsPiceker.setMaxValue(23);
        minutesPicker.setMinValue(0);
        minutesPicker.setMaxValue(59);
        secondsPicker.setMinValue(0);
        secondsPicker.setMaxValue(59);
    }

    public void continueOnClick(View view) {
        int secs=secondsPicker.getValue();
        int mins=minutesPicker.getValue();
        int hrs=hrsPiceker.getValue();
        int wholeseconds=secs+(60*mins)+(60*60*hrs);
        Intent intent=new Intent(this,RunActivity.class);
        intent.putExtra("SECONDS",wholeseconds);
        startActivity(intent);





    }

    public void timePickerBackOnClick(View view) {
        Intent intent=new Intent(this,ChooserActivity.class);
        startActivity(intent);
    }
}