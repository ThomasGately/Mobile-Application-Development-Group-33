package com.example.guts.test2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Date extends AppCompatActivity {

    public final static String EXTRA_PASS = "pass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
    }

    public void onClickLog (View view)
    {

        int[] date = getIntent().getIntArrayExtra("pass");
            EditText typeInput = (EditText) findViewById(R.id.enterType);
            String typeString = typeInput.getText().toString();

            EditText foodInput = (EditText) findViewById(R.id.enterFood);
            String foodString = foodInput.getText().toString();

            EditText sugarInput = (EditText) findViewById(R.id.enterSugarContent);
            String sugarString = sugarInput.getText().toString();

            EditText carbInput = (EditText) findViewById(R.id.enterCarbContent);
            String carbString = carbInput.getText().toString();

            EditText saInput = (EditText) findViewById(R.id.enterTotalSlow);
            String saString = saInput.getText().toString();

            EditText rapidInput = (EditText) findViewById(R.id.enterRapid);
            String rapidString = rapidInput.getText().toString();

            DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
            SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();

            Log.e("rrr>", typeString+" -- "+foodString+" -- "+sugarString+" -- "+carbString);

            if(!typeString.isEmpty() && !foodString.isEmpty() && !sugarString.isEmpty() && !carbString.isEmpty() && (!saString.isEmpty() || !rapidString.isEmpty())) {

            int lnikID = dbHandlerGrim.getNewLink(db);
            dbHandlerGrim.insertLink(db, new Link(lnikID, date[0], date[1], date[2], "00-00-00"), lnikID);
            dbHandlerGrim.insertMeal(db, new Meal(lnikID, typeString, foodString, Double.parseDouble(carbString), Double.parseDouble(sugarString)), lnikID);

            if (!rapidString.isEmpty()) {
                dbHandlerGrim.insertInjection(db, new Injection(Double.parseDouble(rapidString), "normal"), lnikID);
            } else {
                dbHandlerGrim.insertInjection(db, new Injection(Double.parseDouble(saString), "slow"), lnikID);
            }
        } else {

            }




    }

}
