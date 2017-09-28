package com.example.ihp.assignment_1_prog3210;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    public TextView topUsernameDisplay;
    public String profileUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        topUsernameDisplay = (TextView) findViewById(R.id.tvUserName);
        profileUsername = "Hi " + getIntent().getStringExtra("USERNAME");
        topUsernameDisplay.setText(profileUsername);


    }
}
