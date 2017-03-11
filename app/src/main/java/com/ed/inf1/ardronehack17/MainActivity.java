package com.ed.inf1.ardronehack17;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TuplesToLocations.init( getWindowManager());

        Button spyButton = (Button) findViewById(R.id.spy_button );
        spyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

               setContentView(R.layout.drawing_layout);

            }
        });
/*
        Button basicButton = (Button) findViewById(R.id.basic_control_button );
        basicButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                setContentView(R.layout.);

            }
        });*/



    }





}
