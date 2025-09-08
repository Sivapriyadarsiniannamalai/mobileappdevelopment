package com.example.registrationform;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText etName, etEmail, etPhone, etPassword, etAge;
    CheckBox cbDancing, cbSports, cbSinging, cbReading, cbTravelling;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Link views to layout (make sure IDs match XML)
        etName = findViewById(R.id.editTextText);
        etEmail = findViewById(R.id.editTextText2);
        etPhone = findViewById(R.id.editTextText3);
        etPassword = findViewById(R.id.editTextText4);
        etAge = findViewById(R.id.editTextText5);

        cbDancing = findViewById(R.id.checkBox);
        cbSports = findViewById(R.id.checkBox2);
        cbSinging = findViewById(R.id.checkBox3);
        cbReading = findViewById(R.id.checkBox4);
        cbTravelling = findViewById(R.id.checkBox5);

        rgGender = findViewById(R.id.radiogroup4);
        rbMale = findViewById(R.id.radioButton);
        rbFemale = findViewById(R.id.radioButton2);

        // Make all EditText fields read-only without disabling focus style or greying out
        setReadOnly(etName);
        setReadOnly(etEmail);
        setReadOnly(etPhone);
        setReadOnly(etPassword);
        setReadOnly(etAge);

        // Make CheckBoxes and RadioButtons read-only
        cbDancing.setEnabled(false);
        cbSports.setEnabled(false);
        cbSinging.setEnabled(false);
        cbReading.setEnabled(false);
        cbTravelling.setEnabled(false);

        rbMale.setEnabled(false);
        rbFemale.setEnabled(false);

        // Populate fields if data passed from previous activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            etName.setText(extras.getString("username", ""));
            etEmail.setText(extras.getString("email", ""));
            etPhone.setText(extras.getString("phone", ""));
            etPassword.setText(extras.getString("password", ""));
            etAge.setText(extras.getString("age", ""));

            String gender = extras.getString("gender", "");
            if (gender.equalsIgnoreCase("Male")) {
                rbMale.setChecked(true);
            } else if (gender.equalsIgnoreCase("Female")) {
                rbFemale.setChecked(true);
            }

            String hobbies = extras.getString("hobbies", "");
            if (hobbies.contains("Dancing")) cbDancing.setChecked(true);
            if (hobbies.contains("Sports")) cbSports.setChecked(true);
            if (hobbies.contains("Singing")) cbSinging.setChecked(true);
            if (hobbies.contains("Reading")) cbReading.setChecked(true);
            if (hobbies.contains("Travelling")) cbTravelling.setChecked(true);
        }
    }

    private void setReadOnly(EditText editText) {
        editText.setFocusable(false);
        editText.setFocusableInTouchMode(false);
        editText.setCursorVisible(false);
        editText.setLongClickable(false);
        editText.setKeyListener(null);
        editText.setTextIsSelectable(true);
        // Prevent keyboard from showing on focus (API 21+)
        editText.setShowSoftInputOnFocus(false);
    }
}
