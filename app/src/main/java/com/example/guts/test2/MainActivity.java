package com.example.guts.test2;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    //login list Variable.
    static List<User> loginUserInfo;
    private String email;
    private EditText password;
    EditText loginEmail;
    EditText loginPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  final List<User> loginUserInfo;

        //Connecting Database
        final DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
        try {
            SQLiteDatabase db = dbHandlerGrim.getReadableDatabase();


            // User user1 = new User("Thomas", "Gately", "kek@gmail.com", "kek");
            // dbHandlerGrim.insertUser(db, user1);

            loginUserInfo = dbHandlerGrim.getAllUser(db);


        } catch (SQLException e) {
            Log.i("DB", "Error");
        }
        if (loginUserInfo.isEmpty()) {
            Log.i("List", "Empty");
        }
        Button login_button = findViewById(R.id.loginButton);
        login_button = (Button) findViewById(R.id.loginButton);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton(loginUserInfo);
            }
        });
        Button register_button = findViewById(R.id.regButton);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

    }

    public void LoginButton(List<User> a) {
        loginEmail = (EditText) findViewById(R.id.loginEmail);
        password = (EditText) findViewById(R.id.loginPassword);
        String aPassword = password.getText().toString();
        String Email = loginEmail.getText().toString();
        User aUser = new User();
        boolean found = false;
        String error = "";

        try {
            if (!Email.isEmpty() && !aPassword.isEmpty()) {
                for (int i = 0; i < loginUserInfo.size() && !found; i++) {
                    if (loginUserInfo.get(i).getEmail().equals(Email) && loginUserInfo.get(i).getPassword().equals(aPassword)) {
                        aUser = loginUserInfo.get(i);
                        found = true;
                        DBHandlerGrim dbHandlerGrim = new DBHandlerGrim(this);
                        dbHandlerGrim.setUID(loginUserInfo.get(i).getId());
                        Intent intent = new Intent(MainActivity.this, mainMenu.class);
                        startActivity(intent);
                        Log.i("Login", "right");
                    } else {
                        Log.i("login", "wrong");
                        error = "Wrong enter email and password";
                    }
                    Log.e("tt", password.getText() + " loginApassword " + loginUserInfo.get(i).getPassword());
                    Log.e("mt", loginEmail.getText() + " loginAEmail " + loginUserInfo.get(i).getEmail());
                }
            } else {
                error = "Please enter email and password";
            }
        } catch (NullPointerException e){

        }
        TextView output = (TextView) findViewById(R.id.error2);
        output.setText(error);
    }
}




