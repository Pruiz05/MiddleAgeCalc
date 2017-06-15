package com.example.admin.middleagecalc;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Date;
import java.text.DateFormat;

public class ResultActivity extends AppCompatActivity {

    //var
    Button btn;
    TextView tv;
    TextView tv_nac;
    TextView tv_year;
    TextView tv_month;
    TextView tv_day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle bundle = getIntent().getExtras();

        /*
        intent.putExtra("years",Result_Year);
        intent.putExtra("months",Result_Month);
        intent.putExtra("days",Result_Day);
        */

        tv = (TextView) findViewById(R.id.textViewFec);//textViewFec
        tv_nac = (TextView) findViewById(R.id.textViewFecNac);

        tv_day = (TextView) findViewById(R.id.total_days_result);
        tv_month = (TextView) findViewById(R.id.total_months_result);
        tv_year = (TextView) findViewById(R.id.total_years_result);

        tv.setText(bundle.getString("ActualDate"));
        tv_nac.setText( bundle.getString("BirthDate"));

        tv_day.setText(bundle.getString("days"));
        tv_month.setText(bundle.getString("months"));
        tv_year.setText(bundle.getString("years"));


    }
}
/*
        Date date = new Date(location.getTime());
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());*/

// tv.setText( mes + "" +  dia + "" + ano);
//        Date fecha = new Date(Date.parse());
//      String fechacast = DateFormat.getDateInstance().format(today);
//trash code
/*
Date date = new Date(location.getTime());
    DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
mTimeText.setText("Time: " + dateFormat.format(date));
        * */
//todayDate.setText(setCurrentDateOnView());
// btn=(Button)findViewById(R.id.btn_calcular);
        /*tv=(TextView)findViewById(R.id.textViewFecha);

        Time today=new Time(Time.getCurrentTimezone());
        today.setToNow();

        int dia=today.monthDay;
        int mes=today.month;
        int ano=today.year;
        mes=mes+1;


        tv.setText(dia + " ");
      */

