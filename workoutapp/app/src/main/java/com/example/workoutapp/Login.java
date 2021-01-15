package com.example.workoutapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.widget.Toolbar;


public class Login extends Activity {
    Button b1;          // Login Button object
    EditText ed1,ed2;   // The username and password fields
    int counter = 5;    // Allowed failed logins

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        // b1 is login button, checks for clicks on login and checks that the fields are correct
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            // Checks if credentials are correct
            public void onClick(View v) {
                // If correct, prints a appropriate message
                // TODO: Implement actual redirection to main
                if(ed1.getText().toString().equals("admin") &&  ed2.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, LandingPage.class);
                    startActivity(intent);
                }
                // If incorrect, reduce allowed logins, print message
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    counter--;
                    // Used available login attempts, lock login button
                    // TODO: Decide if we actually want this, I put it here as an example of options
                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });
    }
}