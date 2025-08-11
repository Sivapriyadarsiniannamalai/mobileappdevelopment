package com.example.basicoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2,b3,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        e3 = findViewById(R.id.editTextText3);
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(e1.getText().toString());
                int n2 = Integer.parseInt(e2.getText().toString());
                int n3 = n1+n2;
                String n4 = String.valueOf(n3);
                e3.setText(n4);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(e1.getText().toString());
                int n2 = Integer.parseInt(e2.getText().toString());
                int n3 = n1-n2;
                String n4 = String.valueOf(n3);
                e3.setText(n4);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(e1.getText().toString());
                int n2 = Integer.parseInt(e2.getText().toString());
                int n3 = n1*n2;
                String n4 = String.valueOf(n3);
                e3.setText(n4);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(e1.getText().toString());
                int n2 = Integer.parseInt(e2.getText().toString());
                int n3 = n1/n2;
                String n4 = String.valueOf(n3);
                e3.setText(n4);
            }
        });
    }
}
