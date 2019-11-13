package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class oneA extends AppCompatActivity {

    TextView display;

    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        display = (TextView) findViewById(R.id.tv1);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        final String btn1text = btn1.getText().toString();
        final String btn2text = btn2.getText().toString();

        btn1.setOnTouchListener(new View.OnTouchListener() {
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
                display.setText(btn1text+"번 좌석 사용 중"+"\n\n"+mtime+" ~ "+cal.get ( Calendar.YEAR ) + " . " + ( cal.get ( Calendar.MONTH ) + 1 ) + "." + cal.get ( Calendar.DATE ) + "." + (cal.get ( Calendar.HOUR_OF_DAY ) +6)+ ":" +cal.get ( Calendar.MINUTE ));

                Intent intent=new Intent(oneA.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                //startActivity(intent);

                return true;
            }
        });

        btn2.setOnTouchListener(new View.OnTouchListener() {
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
                display.setText(btn2text+"번 좌석 사용 중"+"\n\n"+mtime+" ~ "+cal.get ( Calendar.YEAR ) + " . " + ( cal.get ( Calendar.MONTH ) + 1 ) + "." + cal.get ( Calendar.DATE ) + "." + (cal.get ( Calendar.HOUR_OF_DAY ) +6)+ ":" +cal.get ( Calendar.MINUTE ));

                Intent intent=new Intent(oneA.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());

                Intent intent1 = new Intent(oneA.this,MyPageActivity.class);
                intent1.putExtra("name",btn2text);

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
        editor.putString("name",display.getText().toString());
        editor.commit();
    }

    protected void restoreSatate(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if((pref!=null)&&(pref.contains("name"))){
            String name = pref.getString("name","");
            display.setText(name);
        }
    }

}