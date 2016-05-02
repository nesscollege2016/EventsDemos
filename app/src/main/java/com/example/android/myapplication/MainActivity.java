package com.example.android.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, TextWatcher {

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

        etRed.addTextChangedListener(this);
        etGreen.addTextChangedListener(this);
        etBlue.addTextChangedListener(this);
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

    boolean fromCode = false;
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        int color = Color.rgb(sbRed.getProgress(), sbGreen.getProgress(), sbBlue.getProgress());
        String totalColor = "#" + Integer.toHexString(color).toUpperCase().substring(2);
        etTotal.setText(totalColor);
        etTotal.setBackgroundColor(color);

        if (fromUser) {
            fromCode = true;
            etRed.setText(sbRed.getProgress() + "");
            etGreen.setText(sbGreen.getProgress() + "");
            etBlue.setText(sbBlue.getProgress() + "");
            fromCode = false;

        }


    }

    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        try {
            Integer redProgress = Integer.valueOf(etRed.getText().toString());
            Integer greenProgress = Integer.valueOf(etGreen.getText().toString());
            Integer blueProgress = Integer.valueOf(etBlue.getText().toString());


            if (!fromCode) {
                sbRed.setProgress(redProgress);
                sbGreen.setProgress(greenProgress);
                sbBlue.setProgress(blueProgress);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
