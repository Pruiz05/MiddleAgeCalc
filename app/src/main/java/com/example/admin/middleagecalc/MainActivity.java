package com.example.admin.middleagecalc;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.provider.MediaStore.Files.FileColumns.TITLE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DatePicker mDatePicker;
    //variable of birthday date
    private int birth_year;
    private int birth_month;
    private int birth_day;
    //variable of current day
    private int current_year;
    private int current_month;
    private int current_day;
    //
    private int Result_Year;
    private  int Result_Month;
    private int Result_Day;

    private int[] edades;

    Button btnClear;
    int contador=0;
    int edad_mayor =0 ;

  // private AgeCalculation age = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // getSupportActionBar().setTitle(getIntent().getStringExtra(TITLE));
        //mDatePicker =  (DatePicker) findViewById(R.id.date_time);

        getSupportActionBar().setTitle("Middle Age Calculator");
        mDatePicker =  (DatePicker) findViewById(R.id.date_time);

        findViewById(R.id.btn_calcular).setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btn_clear);
        btnClear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Result_Year = 0;
                Result_Month = 0;
                Result_Day = 0;
                contador=0;
                edad_mayor=0;
                //Toast.makeText(this,"All Clear...", Toast.LENGTH_SHORT).show();

            }
        });
        edades = new int[200];
    }

    @Override
    public void onClick(View v) {
        //

        //String edad_mayor ="";

        StringBuilder sb = new StringBuilder();
        sb.append(mDatePicker.getDayOfMonth());
        sb.append("/");
        sb.append(mDatePicker.getMonth()+1);
        sb.append("/");
        sb.append(mDatePicker.getYear());

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate =  mdformat.format(calendar.getTime());

        //set current value
        Calendar current = Calendar.getInstance();
        current_year = current.get(Calendar.YEAR);
        current_month = current.get(Calendar.MONTH);
        current_month++;
        current_day = current.get(Calendar.DAY_OF_MONTH);

        //set birthday value
        birth_year = mDatePicker.getYear();
        birth_month = mDatePicker.getMonth();
        birth_month ++;
        birth_day = mDatePicker.getDayOfMonth();

        CalculateYear();
        CalculateMonth();
        CalculateDay();

        if (Result_Year<0)
        {
            Result_Year = 0;
            Result_Month = 0;
            Result_Day = 0;
            Toast.makeText(this,"La Fecha de Nacimiento No puede ser Mayor que la Fecha Actual.", Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        //pass data to activity
        intent.putExtra("BirthDate",sb.toString());
        intent.putExtra("ActualDate",strDate);
        intent.putExtra("years",Result_Year + " ");
        intent.putExtra("months",Result_Month + " ");
        intent.putExtra("days",Result_Day + " ");

        edades[contador] = Result_Year;

        if (edades[contador] > edad_mayor)
        {
            edad_mayor = edades[contador];
            Toast.makeText(this, edad_mayor + ": Ha sido la Mayor edad digitada.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(edad_mayor > 0)
            {
                Toast.makeText(this, edad_mayor + ": Ha sido la Mayor edad digitada.", Toast.LENGTH_SHORT).show();
            }

        }

        contador++;
        startActivity(intent);
    }


    public void CalculateYear()
    {
        Result_Year = current_year - birth_year;
    }

    public void CalculateMonth()
    {
        if(current_month >= birth_month)
        {
            Result_Month = current_month - birth_month;
        }
        else
        {
            Result_Month= current_month - birth_month;
            Result_Month= 12 + Result_Month;
            Result_Year--;
        }
    }


    public void CalculateDay()
    {
        if(current_day >= birth_day)
        {
            Result_Day = current_day - birth_day;
        }
        else
        {
            Result_Day = current_day - birth_day;
            Result_Day = 30 + Result_Day;
            if(Result_Month == 0)
            {
                Result_Month = 11;
                Result_Year--;
            }
            else
            {
                Result_Month--;
            }
        }
    }



/*
    public void calcualteYear()
    {
        resYear=endYear-startYear;

    }

    public void calcualteMonth()
    {
        if(endMonth>=startMonth)
        {
            resMonth= endMonth-startMonth;
        }
        else
        {
            resMonth=endMonth-startMonth;
            resMonth=12+resMonth;
            resYear--;
        }

    }
    public void  calcualteDay()
    {

        if(endDay>=startDay)
        {
            resDay= endDay-startDay;
        }
        else
        {
            resDay=endDay-startDay;
            resDay=30+resDay;
            if(resMonth==0)
            {
                resMonth=11;
                resYear--;
            }
            else
            {
                resMonth--;
            }

        }
    }
*/

}


//String valor =setCurrentDateOnView();// GetCurrentDate().toString();
//Toast.makeText(this, valor, Toast.LENGTH_SHORT).show();
///Calendar cal = new GregorianCalendar();
//Date date = cal.getTime();
//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//String formatteDate = df.format(date);
//tv.setText(formatteDate);
/*
        Calendar cal = Calendar.getInstance();
        new GregorianCalendar();
        Date date = cal.getTime();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String formatteDate = df.format(date);
*/

//end = Calendar.getInstance();
// Date date = calendar.getTime();
//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//String formatteDate = df.format(date);

//end=Calendar.getInstance();
//llamar otro activity
//   birthDate.setText("Date of Birth(DD/MM/YY): "+selectedDay+":"+(startMonth+1)+":"+startYear);