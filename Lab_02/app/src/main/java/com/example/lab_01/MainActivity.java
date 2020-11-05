package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    TextView tView;
    EditText edText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tView = findViewById(R.id.value1);
        edText = findViewById(R.id.enterValue1);
        button = findViewById(R.id.button1);

        Intent intentFromSecondActivity = getIntent();

        if( intentFromSecondActivity.getStringExtra("value2") != null) {
            tView.setText(intentFromSecondActivity.getStringExtra("value2"));
        }

        button.setOnClickListener(oclBtnOpenForm2);
    }

    View.OnClickListener oclBtnOpenForm2 = new View.OnClickListener() {
        public void onClick(View view) {
            Intent intentToSecondActivity = new Intent(getApplicationContext(), SecondActivity.class);

            String value1 = "";
            value1 = edText.getText().toString();
            int sendingValue = Integer.parseInt(tView.getText().toString()) + Integer.parseInt(value1);
            intentToSecondActivity.putExtra("value1", Integer.toString(sendingValue));

            startActivity(intentToSecondActivity);
        }
    };
}