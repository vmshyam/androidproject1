package com.example.ihp.assignment_1_prog3210;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText accountNameValue;
    private EditText usernameValue;
    private EditText emailValue;
    private EditText passwordValue;
    private Button btnNewRegister;
    public String usersName;
    public String usersUsername;
    public String userEmail;
    public String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        accountNameValue = (EditText) findViewById(R.id.etNameReg);
        usernameValue = (EditText) findViewById(R.id.etUsernameReg);
        emailValue = (EditText) findViewById(R.id.etEmailReg);
        passwordValue = (EditText) findViewById(R.id.etPasswordReg);
        btnNewRegister = (Button) findViewById(R.id.btnSignUpReg);

        btnNewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ValidateRegistrationInputs()){
                    Toast.makeText(RegisterActivity.this, "Registration was Unsuccessful", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    intent.putExtra("USERNAME_REG", usersUsername);
                    intent.putExtra("PASSWORD_REG", userPassword);
                    startActivity(intent);
                }
            }
        });

    }

    public boolean ValidateRegistrationInputs(){
        boolean inputValueCheck = true;
        usersName = accountNameValue.getText().toString().trim();
        usersUsername = usernameValue.getText().toString().trim();
        userEmail = emailValue.getText().toString().trim();
        userPassword =  passwordValue.getText().toString().trim();

        if (usersName.isEmpty()){
            //Toast.makeText(RegisterActivity.this, "Please enter you account name", Toast.LENGTH_SHORT).show();
            accountNameValue.setError("Please Enter a Valid Name");
            accountNameValue.getText().clear();
            inputValueCheck = false;
        }

        if (usersUsername.isEmpty()){
            //Toast.makeText(RegisterActivity.this, "Please enter you account Username", Toast.LENGTH_SHORT).show();
            usernameValue.setError("Please Enter a Username");
            usernameValue.getText().clear();
            inputValueCheck = false;
        }

        if (userEmail.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            //Toast.makeText(RegisterActivity.this, "Please enter you account Username", Toast.LENGTH_SHORT).show();
            emailValue.setError("Please Enter a Valid email");
            emailValue.getText().clear();
            inputValueCheck = false;
        }

        if (userPassword.isEmpty()){
            //Toast.makeText(RegisterActivity.this, "Please enter you account Username", Toast.LENGTH_SHORT).show();
            passwordValue.setError("Please Enter a Valid Password");
            passwordValue.getText().clear();
            inputValueCheck = false;
        }

        return inputValueCheck;
    }
}
