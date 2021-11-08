package com.example.afnansalameh1181469;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;


public class RunActivity extends AppCompatActivity {

    int seconds=0;
    boolean running=false;
    int begeningSeconds=0;
    Button buttonStart,buttonPause,buttonRestart,buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run);

        buttonStart=findViewById(R.id.btnStart);
        buttonBack=findViewById(R.id.btnBack);
        buttonRestart=findViewById(R.id.btnReset);
        buttonPause=findViewById(R.id.btnPause);

        buttonStart.setBackgroundColor(Color.WHITE);
        buttonStart.setTextColor(Color.BLACK);

        buttonBack.setBackgroundColor(Color.WHITE);
        buttonBack.setTextColor(Color.BLACK);

        buttonRestart.setBackgroundColor(Color.WHITE);
        buttonRestart.setTextColor(Color.BLACK);

        buttonPause.setBackgroundColor(Color.WHITE);
        buttonPause.setTextColor(Color.BLACK);





        Intent intent=getIntent();
        seconds=intent.getIntExtra("SECONDS",0);
        begeningSeconds=seconds;
        TextView txt=findViewById(R.id.txtTimer);
        int hours=seconds/3600;
        int mins=seconds%3600/60;
        int secs=seconds%60;
        String time = String.format(Locale.getDefault(),
                "%d:%02d:%02d", hours, mins, secs);
        txt.setText(time);
        if(savedInstanceState !=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }

        runTimer();


    }


    public void startOnClick(View view) {
        running=true;

    }

    public void pauseOnClick(View view) {
        running=false;
    }

    public void resetOnClick(View view) {
        running=false;
        seconds=begeningSeconds;

    }

    public void backOnClick(View view) {
        Intent intent=new Intent(this,TimePicker.class);
        startActivity(intent);
    }
    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("seconds", seconds);
        bundle.putBoolean("running", running);
    }
    private void runTimer(){
        final TextView txtView = (TextView) findViewById(R.id.txtTimer);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = seconds % 3600 /60;
                int snds = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, snds);
                txtView.setText(time);
                if(running&& seconds>0){
                    --seconds;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}