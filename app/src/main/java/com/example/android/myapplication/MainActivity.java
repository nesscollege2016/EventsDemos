package com.example.android.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvHello;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        tvHello = (TextView) findViewById(R.id.myText);
    }

    public void btnClicked(View view) {
        Random r = new Random();

        tvHello.setText(r.nextInt(11) + "");
    }
}
