package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tvSize;
    SeekBar sbSize;
    ProgressBar pbSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSize = (TextView) findViewById(R.id.tvSize);
        sbSize = (SeekBar) findViewById(R.id.sbSize);
        pbSize = (ProgressBar) findViewById(R.id.pbSize);

        sbSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress += 10;
                tvSize.setText("" + progress);
                tvSize.setTextSize(progress);
                pbSize.setProgress(progress * 8);

            }
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }



}
