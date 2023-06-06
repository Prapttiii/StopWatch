package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
private Chronometer chronometer;
private long pauseoffset;
private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer=findViewById(R.id.chronometer);
      chronometer.setFormat("TIME: %s");

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void startChronometer(View v){
           if (!running){
               chronometer.setBase(SystemClock.elapsedRealtime()- pauseoffset);
               chronometer.start();
               running=true;
           }
   }
    public void stopChronometer(View v){
          chronometer.setBase(SystemClock.elapsedRealtime());
          pauseoffset=0;
    }
    public void holdChronometer(View v){
               if (running){
                   chronometer.stop();
                   pauseoffset = SystemClock.elapsedRealtime() -chronometer.getBase();
                   running=false;
               }

    }



}

