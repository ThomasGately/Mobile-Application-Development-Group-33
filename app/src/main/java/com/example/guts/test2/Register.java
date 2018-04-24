package com.example.guts.test2;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.SQLException;

public class Register extends AppCompatActivity {

    private String fName;
    private String sName;
    private String email;
    private String password;
    private double bloodSugerGoal;
    private double multiplier;

    EditText fNameInput;
    EditText sNameInput;
    EditText emailInput;
    EditText password1;
    EditText password2;
    EditText bloodSugarInput;
    EditText multiplierInput;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Retrieve data from fields
        fNameInput = findViewById(R.id.fName);
        sNameInput = findViewById(R.id.sName);
        emailInput = findViewById(R.id.email);
        password1  = findViewById(R.id.password1);
        password2  = findViewById(R.id.password2);
        bloodSugarInput = findViewById(R.id.bloodSuger);
        multiplierInput = findViewById(R.id.multiplier);

        final DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();
        User aUser;
        submitButton = (Button) findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String error = "";

                if(password1.getText().toString().equals(password2.getText().toString())){
                    password1  = findViewById(R.id.password1);
                    fName = fNameInput.getText().toString();
                    sName = sNameInput.getText().toString();
                    email = emailInput.getText().toString();
                    password = password1.getText().toString();
                    bloodSugerGoal = Double.parseDouble(bloodSugarInput.getText().toString());
                    multiplier = Double.parseDouble(multiplierInput.getText().toString());
                    SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();
                    dbHandlerGrim.insertUser(db, new User(fName,sName,email,password,multiplier,bloodSugerGoal));

                    Log.i("fName+Password Check", fName+"  "+password);
                }
                else {
                    error = "Password did not match ";
                }
                TextView output = (TextView) findViewById(R.id.error1);
                output.setText(error);

            }

        });
    }//validate info
    //create user with data in DB
}

