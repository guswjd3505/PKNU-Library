package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;


public class MyPageActivity extends AppCompatActivity {

    TextView textView,text;
    Button extend, seat, empty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);

        textView=findViewById(R.id.date);
        text=(TextView)findViewById(R.id.text);

        extend = findViewById(R.id.extend);
        seat = findViewById(R.id.seat);
        empty = findViewById(R.id.empty);

        extend.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                TimeZone timezone = TimeZone.getTimeZone("Etc/GMT-9");
                TimeZone.setDefault(timezone);

                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.KOREA);

                Date current = new Date();

                String mtime = formater.format(current);
                System.out.println(mtime);

                TimeZone jst = TimeZone.getTimeZone ("JST");
                Calendar cal = Calendar.getInstance(Locale.KOREA); // 주어진 시간대에 맞게 현재 시각으로 초기화된 GregorianCalender 객체를 반환.// 또는 Calendar now = Calendar.getInstance(Locale.KOREA);
                System.out.println ( cal.get ( Calendar.YEAR ) + "." + ( cal.get ( Calendar.MONTH ) + 1 ) + "." + cal.get ( Calendar.DATE ) + "." + (cal.get ( Calendar.HOUR_OF_DAY ) +6)+ "." +cal.get ( Calendar.MINUTE ));

                textView.setText(mtime+" ~ "+cal.get ( Calendar.YEAR ) + " . " + ( cal.get ( Calendar.MONTH ) + 1 ) + "." + cal.get ( Calendar.DATE ) + "." + (cal.get ( Calendar.HOUR_OF_DAY ) +6)+ ":" +cal.get ( Calendar.MINUTE ));

                //startActivity(intent);

                return true;
            }

        });

        seat.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
                textView.setText(" 남은 시간");
                text.setText(" 현재 좌석");

                return true;
            }
        });

        empty.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {
empty.setText("자리비움해제");
                return true;
            }
        });
    }

    @Override
    protected  void onPause(){
        super.onPause();
        saveState();
    }

    @Override
    protected void onResume(){
        super.onResume();
        restoreSatate();
    }

    protected void saveState(){
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("name",textView.getText().toString());
        editor.putString("text1",text.getText().toString());
        editor.commit();
    }

    protected void restoreSatate(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if((pref!=null)&&(pref.contains("name"))&&(pref.contains("text1"))){
            String name = pref.getString("name","남은시간");
            String text1 = pref.getString("text1","남은");
            textView.setText(name);
            text.setText(text1);
        }
    }

}