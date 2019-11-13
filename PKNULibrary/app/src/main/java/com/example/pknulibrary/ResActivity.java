package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
    }

    public void oneA(View v){
        Intent intent = new Intent(ResActivity.this, oneA.class);
        startActivity(intent);
    }

    public void oneB(View v){
        Intent intent = new Intent(ResActivity.this, oneB.class);
        startActivity(intent);
    }

    public void three(View v){
        Intent intent = new Intent(ResActivity.this, three.class);
        startActivity(intent);
    }

    public void four(View v){
        Intent intent = new Intent(ResActivity.this, four.class);
        startActivity(intent);
    }
    public void five(View v){
        Intent intent = new Intent(ResActivity.this, five.class);
        startActivity(intent);
    }
}
