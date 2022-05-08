package com.example.instagram_01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

   public static final String TAG = "SignupActivity";
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPhone;
    private EditText etPassword;
    private Button btnSignup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Check to see if a user is already logged in to prevent from showing the login screen
//        if (ParseUser.getCurrentUser() != null) {
//            goMainActivity();
//        }

        etEmail = findViewById(R.id.etEmail);
        etUsername = findViewById(R.id.etUsername);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        btnSignup = findViewById(R.id.btnSignup);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick signup button");
                String email = etEmail.getText().toString();
                String username = etUsername.getText().toString();
                String phone = etPhone.getText().toString();
                String password = etPassword.getText().toString();
                signupUser(username, password);
            }
        });
    }

    // Create the ParseUser
    ParseUser user = new ParseUser();
//// Set core properties
//user.setUsername("joestevens");
//user.setPassword("secret123");
//user.setEmail("email@example.com");
// Set custom properties
//user.put("phone", "650-253-0000");
//// Invoke signUpInBackground
//user.signUpInBackground(new SignUpCallback() {
//        public void done(ParseException e) {
//            if (e == null) {
//                // Hooray! Let them use the app now.
//            } else {
//                // Sign up didn't succeed. Look at the ParseException
//                // to figure out what went wrong
//            }
//        }
//    });

    private void signupUser(String username, String password) {
        Log.i(TAG, "Trying to register a new user " + username);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Log.e(TAG, "Unable to signUp", e);
                    Toast.makeText(SignupActivity.this, "Issue signingUp", Toast.LENGTH_LONG).show();
                    return;
                }
                goMainActivity();
                Toast.makeText(SignupActivity.this, "Signed Up!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void goMainActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        // Following to prevent user from been logged out when the back button is pressed.
        finish();
    }
}
