package com.example.guts.test2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GraphMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_menu);
    }

     void onClickSugar (View view){
        startActivity(new Intent(GraphMenu.this, GraphSugar.class));

        EditText input= (EditText) findViewById(R.id.enterMonth);
        String month = input.getText().toString();

        EditText input2 = (EditText) findViewById(R.id.enterYear);
        String year = input2.getText().toString();

        Intent intent = new Intent(getBaseContext(), GraphSugar.class);
        intent. putExtra("DATE", month+"-"+year);
        startActivity(intent);

    }
    public void onClickCarbs (View view){
        startActivity(new Intent(GraphMenu.this, GraphCarbs.class));

        EditText input= (EditText) findViewById(R.id.enterMonth);
        String month = input.getText().toString();

        EditText input2 = (EditText) findViewById(R.id.enterYear);
        String year = input2.getText().toString();

        Intent intent = new Intent(getBaseContext(), GraphCarbs.class);
        intent.putExtra("DATE", month+"-"+year);
        startActivity(intent);
    }
    public void onClickBS (View view){
        startActivity(new Intent(GraphMenu.this, GraphBS.class));

        EditText input= (EditText) findViewById(R.id.enterMonth);
        String month = input.getText().toString();

        EditText input2 = (EditText) findViewById(R.id.enterYear);
        String year = input2.getText().toString();

        Intent intent = new Intent(getBaseContext(), GraphBS.class);
        intent.putExtra("DATE", month+"-"+year);
        startActivity(intent);
    }


}
