package com.example.android.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar sbRed, sbGreen, sbBlue;
    EditText etRed, etGreen, etBlue, etTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1) findViewById
        initLayout();

        //2) register event listeners:
        initEvents();
    }

    private void initEvents() {
        sbRed.setOnSeekBarChangeListener(this);
        sbBlue.setOnSeekBarChangeListener(this);
        sbGreen.setOnSeekBarChangeListener(this);
    }

    private void initLayout() {
        sbRed = (SeekBar) findViewById(R.id.sbRed);
        sbGreen = (SeekBar) findViewById(R.id.sbGreen);
        sbBlue = (SeekBar) findViewById(R.id.sbBlue);

        etRed = (EditText) findViewById(R.id.etRed);
        etGreen = (EditText) findViewById(R.id.etGreen);
        etBlue = (EditText) findViewById(R.id.etBlue);
        etTotal = (EditText) findViewById(R.id.etTotal);
    }

    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        etTotal.setBackgroundColor(Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress()));
    }

    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
