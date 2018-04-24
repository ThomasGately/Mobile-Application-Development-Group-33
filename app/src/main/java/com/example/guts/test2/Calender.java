package com.example.guts.test2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.content.Intent;
import java.util.GregorianCalendar;

public class Calender extends AppCompatActivity {

    public final static String EXTRA_DATE = "com.mycompany.myfirstapp.Date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        CalendarView cw=(CalendarView)findViewById(R.id.calendar);
        cw.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
                                       public void onSelectedDayChange(    CalendarView view,    int year,    int month,    int dayOfMonth){
                                           int[] date = new int[] {dayOfMonth , month + 1 , year};
                                           java.util.Calendar c = java.util.Calendar.getInstance();
                                           GregorianCalendar today = new GregorianCalendar();

                                           //If today is after workout date, look at overview page. If it's before got to setting of workout.
                                           GregorianCalendar wDate = new GregorianCalendar(year , month ,dayOfMonth);
                                           Intent intent;
                                           if(today.compareTo(wDate) < 0) {
                                               intent = new Intent(Calender.this, DailyView.class);
                                               intent.putExtra(EXTRA_DATE, date);
                                               startActivity(intent);
                                           }
                                           else{
                                               intent = new Intent(Calender.this, DailyView.class);
                                               intent.putExtra(EXTRA_DATE, date);
                                               startActivity(intent);
                                           }
                                       }
                                   }
        );
    }
}
