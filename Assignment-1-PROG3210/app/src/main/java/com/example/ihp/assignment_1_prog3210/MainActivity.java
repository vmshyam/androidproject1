package com.example.ihp.assignment_1_prog3210;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public EditText usernameLogin;
    public EditText passwordLogin;
    public Button btnSignIn;
    public TextView etSignUp;

    public String usernameLoggedIn = null;
    public String passwordLoggedIn = null;
    public String regUsername = null;
    public String regPassword = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameLogin = (EditText) findViewById(R.id.etUsernameMain);
        passwordLogin = (EditText) findViewById(R.id.etPasswordMain);
        btnSignIn = (Button) findViewById(R.id.btnSignInMain);
        etSignUp = (TextView) findViewById(R.id.etSignUpMain);

        regUsername = getIntent().getStringExtra("USERNAME_REG");
        regPassword = getIntent().getStringExtra("PASSWORD_REG");
        Log.i("Check", "Value: " + "Testing");
        Log.i("Check", "Value: " + "Testing");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String resultValue = usernameLogin.getText().toString();
                //Log.d("Check", "Value: " + resultValue);
                usernameLoggedIn = usernameLogin.getText().toString().trim();
                passwordLoggedIn = passwordLogin.getText().toString().trim();

                Log.d("Check", "Value: " + "Testing");
                Log.d("Check", "Value: " + "Testing");

                boolean tempresultcheck = CheckLoginValidation();
                if (CheckLoginValidation()){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("USERNAME", usernameLoggedIn);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "Please Enter Correct Username and Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        etSignUp.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public boolean CheckLoginValidation()
    {
        boolean checkResult = false;

        if ((usernameLoggedIn.equals(regUsername)) && (passwordLoggedIn.equals(regPassword))){
            checkResult = true;
        }

        return checkResult;
    }


}
