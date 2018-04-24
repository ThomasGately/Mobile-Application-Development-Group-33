package com.example.guts.test2;


import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Injections extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injections);
    }

    public void onClickCalculate (View view)
    {

        DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();

        int correctionFactor = 50;
        int diff,BSunits,carbUnits,totalUnits;
        int tbs = 120;

        EditText cbsInput = (EditText) findViewById(R.id.enterCBS);
        String cbsString = cbsInput.getText().toString();
        int cbs = Integer.parseInt(cbsString);

        EditText carbInput = (EditText) findViewById(R.id.enterCarbs);
        String carbString = carbInput.getText().toString();
        int carbs = Integer.parseInt(carbString);

        diff = cbs - tbs;
        BSunits = diff/correctionFactor;

        carbUnits = carbs/10;
        totalUnits = BSunits + carbUnits;
        String insulin = String.valueOf(totalUnits);


        TextView output = (TextView) findViewById(R.id.outputText);
        output.setText(insulin);

        int lnikID = dbHandlerGrim.getNewLink(db);
        Log.e("innnn", lnikID+"--");
        dbHandlerGrim.insertLink(db,       new Link(lnikID), lnikID);
        dbHandlerGrim.insertInjection(db,  new Injection(totalUnits, "normal"), lnikID);
        dbHandlerGrim.insertBloodSugar(db, new BloodSugar((double) cbs), lnikID);
    }
}
