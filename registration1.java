package com.example.registrationform;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etEmail, etPhone, etPassword, etAge;
    CheckBox cbDancing, cbSports, cbSinging, cbReading, cbTravelling;
     RadioGroup rgGender;
     Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        etUsername = findViewById(R.id.editTextText6);
        etEmail = findViewById(R.id.editTextText7);
        etPhone = findViewById(R.id.editTextText8);
        etPassword = findViewById(R.id.editTextText9);
        etAge = findViewById(R.id.editTextText10);

        cbDancing = findViewById(R.id.checkBox5);
        cbSports = findViewById(R.id.checkBox6);
        cbSinging = findViewById(R.id.checkBox7);
        cbReading = findViewById(R.id.checkBox8);
        cbTravelling = findViewById(R.id.checkBox9);

        rgGender = findViewById(R.id.radiogroup3);
        btnSubmit = findViewById(R.id.button);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    Toast.makeText(MainActivity.this, "Form submitted successfully!", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(MainActivity.this, "Login failed!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean validateForm() {
        boolean isValid = true;


        String username = etUsername.getText().toString().trim();
        if (username.isEmpty()) {
            etUsername.setError("Username is required");
            isValid = false;
        } else {
            etUsername.setError(null);
        }


        String email = etEmail.getText().toString().trim();
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            isValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Enter a valid email");
            isValid = false;
        } else {
            etEmail.setError(null);
        }


        String phone = etPhone.getText().toString().trim();
        if (phone.isEmpty()) {
            etPhone.setError("Phone number is required");
            isValid = false;
        } else if (!Patterns.PHONE.matcher(phone).matches() || phone.length() < 10) {
            etPhone.setError("Enter a valid phone number");
            isValid = false;
        } else {
            etPhone.setError(null);
        }


        String password = etPassword.getText().toString();
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            isValid = false;
        } else if (password.length() < 8) {
            etPassword.setError("Password must be at least 8 characters");
            isValid = false;
        } else {
            etPassword.setError(null);
        }


        String ageStr = etAge.getText().toString().trim();
        if (ageStr.isEmpty()) {
            etAge.setError("Age is required");
            isValid = false;
        } else {
            try {
                int age = Integer.parseInt(ageStr);
                if (age < 10) {
                    etAge.setError("Minimum age is 10");
                    isValid = false;
                } else {
                    etAge.setError(null);
                }
            } catch (NumberFormatException e) {
                etAge.setError("Enter a valid number");
                isValid = false;
            }
        }


        if (rgGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show();
            isValid = false;
        }


        if (!cbDancing.isChecked() && !cbSports.isChecked() && !cbSinging.isChecked() &&
                !cbReading.isChecked() && !cbTravelling.isChecked()) {
            Toast.makeText(this, "Please select at least one hobby", Toast.LENGTH_SHORT).show();
            isValid = false;
        }

        return isValid;
    }
}
