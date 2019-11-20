package com.example.pknulibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

import static android.graphics.BlendMode.COLOR;

public class oneA extends AppCompatActivity {

    TextView display, text;
    Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        display = (TextView) findViewById(R.id.tv1);
        text = (TextView) findViewById(R.id.tv2);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        final String btn2text = btn2.getText().toString();

        btn1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
// 시간 나타내는 코드 전부 수정했습니다~ 필요없어 보이는 부분 지우고 물결 뒤에 숫자 한 자리씩 나와서 두자리씩 포매팅 되게 만들었습니다.
                String btn1text = btn1.getText().toString();

                String thistime = null; //현재 시간 저장할 변수
                String after6 = null;  //6시간 추가해서 저장할 함수
                Date current = new Date();   //현재시간 불러오기
                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm");  //포매팅
                Calendar cal = Calendar.getInstance();  //cal 이라는 시간 인스턴스 만들어줌
                cal.setTime(current);  //현재 시간 저장

                thistime = formater.format(cal.getTime()); //현재시간 문자열로 저장
                cal.add(Calendar.HOUR, 6); //시간에 6시간 추가
                after6 =formater.format(cal.getTime());; //추가한 걸 문자열로 저장
                display.setText(thistime+ "~" + after6); //시간 붙여서 출력
                text.setText(" "+btn1text+"번 좌석 사용 중");
                //다른 버튼 눌렀을 때도 이 시간 포맷으로 수정해야 함

                Intent intent=new Intent(oneA.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

                // 색 변경

                if(arg1.getAction() == MotionEvent.ACTION_DOWN)
                {
                    arg0.setBackgroundColor(btn1.getResources().getColor(R.color.material_blue_grey_800));
                }

                return true;
            }


        });


        btn2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View arg0, MotionEvent arg1) {

                TimeZone timezone = TimeZone.getTimeZone("Etc/GMT-9");
                TimeZone.setDefault(timezone);

                SimpleDateFormat formater = new SimpleDateFormat("yyyy.MM.dd HH:mm", Locale.KOREA);

                Date current = new Date();

                String btn1text = btn1.getText().toString();

                String mtime = formater.format(current);
                System.out.println(mtime);

                TimeZone jst = TimeZone.getTimeZone ("JST");
                Calendar cal = Calendar.getInstance(Locale.KOREA); // 주어진 시간대에 맞게 현재 시각으로 초기화된 GregorianCalender 객체를 반환.// 또는 Calendar now = Calendar.getInstance(Locale.KOREA);
                System.out.println ( cal.get ( Calendar.YEAR ) + "." + ( cal.get ( Calendar.MONTH ) + 1 ) + "." + cal.get ( Calendar.DATE ) + "." + (cal.get ( Calendar.HOUR_OF_DAY ) +6)+ "." +cal.get ( Calendar.MINUTE ));

                display.setText(mtime+" ~ "+cal.get ( Calendar.YEAR ) + " . " + ( cal.get ( Calendar.MONTH ) + 1 ) + "." + cal.get ( Calendar.DATE ) + "." + (cal.get ( Calendar.HOUR_OF_DAY ) +6)+ ":" +cal.get ( Calendar.MINUTE ));
                text.setText(" "+btn2text+"번 좌석 사용 중");

                Intent intent=new Intent(oneA.this,MyPageActivity.class);
                intent.putExtra("name",display.getText().toString());
                intent.putExtra("text1",text.getText().toString());

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
        editor.putString("text1",text.getText().toString());
        editor.commit();
    }

    protected void restoreSatate(){
        SharedPreferences pref = getSharedPreferences("pref",Activity.MODE_PRIVATE);
        if((pref!=null)&&(pref.contains("name"))&&(pref.contains(("text1")))){
            String name = pref.getString("name","");
            String text1 = pref.getString("text1","");
            display.setText(name);
            text.setText(text1);

        }
    }

}