package com.example.n551.myapplicationd;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView showD;
    private Button setD;
    private int year;
    private int month;
    private int day;
    private int year1;
    private int month1;
    private int day1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showD=(TextView)this.findViewById(R.id.textView);
        setD=(Button)this.findViewById(R.id.button);
        Calendar c1=Calendar.getInstance(Locale.CHINA);
        Date myD=new Date();
        c1.setTime(myD);
        year=c1.get(Calendar.YEAR);
        month=c1.get(Calendar.MONTH);
        day=c1.get(Calendar.DAY_OF_MONTH);
        year1=c1.get(Calendar.YEAR);
        month1=c1.get(Calendar.MONTH);
        day1=c1.get(Calendar.DAY_OF_MONTH);
        showD.setText("当前日期:"+year+"-"+(month+1)+"-"+day);
        setD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog my_datePickerDialog=new DatePickerDialog(MainActivity.this,Datelistener,year,month,day);
                my_datePickerDialog.show();//显示DatePickerDialog组件
            }
        });
    }
    private DatePickerDialog.OnDateSetListener Datelistener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int y, int m, int d) {
            if(y>year1||y==year1&&m>month1||y==year1&&m==month1&&d>day1)
            {
                showD.setText("当前日期不符");
            }
            else {
                year = y;
                month = m;
                day = d;
                updateDate();
            }
        }
    };
    private void updateDate()//回调函数
    {
        //在TextView上显示日期
        showD.setText("当前日期："+year+"-"+(month+1)+"-"+day);
    }
}
