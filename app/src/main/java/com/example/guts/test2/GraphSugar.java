package com.example.guts.test2;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.androidplot.util.PixelUtils;
import com.androidplot.xy.CatmullRomInterpolator;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYGraphWidget;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphSugar extends AppCompatActivity {

    private XYPlot plot;
    static final String TAG = "DrinkDetails";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_sugar);

        plot = (XYPlot) findViewById(R.id.plot);

        DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        try {
            SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();

            ArrayList<Double[]> temp =  dbHandlerGrim.getCountSugar(db, "month", getIntent().getStringExtra("DATE"));
            final Number[] domainLabels = new Number[temp.size()];
            Number[] series1Numbers = new Number[temp.size()];
            String error = "";

            if(temp.size() < 3) {
                for (int i = 0; i < temp.size(); i++) {
                    domainLabels[i] = temp.get(i)[0];
                    series1Numbers[i] = temp.get(i)[1];
                }

                // turn the above arrays into XYSeries':
                // (Y_VALS_ONLY means use the element index as the x value)
                XYSeries series1 = new SimpleXYSeries(
                        Arrays.asList(series1Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "Series1");

                LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.GREEN, null, null);


                // just for fun, add some smoothing to the lines:
                // see: http://androidplot.com/smooth-curves-and-androidplot/
                series1Format.setInterpolationParams(
                        new CatmullRomInterpolator.Params(30, CatmullRomInterpolator.Type.Centripetal));


                // add a new series' to the xyplot:
                plot.addSeries(series1, series1Format);

                plot.getGraph().getLineLabelStyle(XYGraphWidget.Edge.BOTTOM).setFormat(new Format() {
                    @Override
                    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
                        int i = Math.round(((Number) obj).floatValue());
                        return toAppendTo.append(domainLabels[i]);
                    }

                    @Override
                    public Object parseObject(String source, ParsePosition pos) {
                        return null;
                    }
                });
            } else {
                error = "DB needs values on 3 different days";
            }
        } catch(SQLiteException e) {
            String message = "Database error: " + e.getClass().getName() + " - " + e.getMessage();
            Log.e(TAG, message);
        }
    }
}
