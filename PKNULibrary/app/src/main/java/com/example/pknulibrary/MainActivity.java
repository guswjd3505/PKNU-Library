package com.example.pknulibrary;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick1(View v){
        Intent intent = new Intent(MainActivity.this, ResActivity.class);
        startActivity(intent);
    }
    public void onclick2(View v){
        Intent intent = new Intent(MainActivity.this, MyPageActivity.class);
        startActivity(intent);
    }
    public void onclick3(View v){
        Intent intent = new Intent(MainActivity.this, BeaActivity.class);
        startActivity(intent);
    }
    public void onclick4(View v) {
        Intent intent = new Intent(MainActivity.this, NoActivity.class);
        startActivity(intent);
    }
    public void onclick5(View v){
        Intent intent = new Intent(MainActivity.this, SetActivity.class);
        startActivity(intent);
    }
}