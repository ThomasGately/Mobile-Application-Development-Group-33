package com.example.guts.test2;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.os.Bundle;

import java.util.List;


public class Tips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }

    private TipsDatabase tipsDB = new TipsDatabase();

    public void onClickGo(View view) {
        Spinner Category = (Spinner) findViewById(R.id.categorySpinner);
        String selectedCategory = String.valueOf(Category.getSelectedItem());
        List<String> tipsList = tipsDB.getTips(selectedCategory);
        StringBuilder tipsFormatted = new StringBuilder();
        for (String r : tipsList) {
            tipsFormatted.append(r).append("\n");
        }
        TextView specificTips = (TextView) findViewById(R.id.specificTipText);
        specificTips.setText(tipsFormatted);

    }

}
