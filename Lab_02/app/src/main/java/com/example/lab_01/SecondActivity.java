package com.example.lab_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tView;
    EditText edText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tView =findViewById(R.id.value2);
        edText =findViewById(R.id.enterValue2);
        button =findViewById(R.id.button2);

        Intent intentFromMainActivity = getIntent();
        tView.setText(intentFromMainActivity.getStringExtra("value1"));

        button.setOnClickListener(oclBtnOpenForm1);
    }

    View.OnClickListener oclBtnOpenForm1 = new View.OnClickListener() {
        public void onClick(View view) {
            Intent intentToFirstActivity = new Intent(getApplicationContext(),MainActivity.class);

            String value2 = "";
            value2 = edText.getText().toString();
            int sendingValue = Integer.parseInt(tView.getText().toString()) + Integer.parseInt(value2);
            intentToFirstActivity.putExtra("value2", Integer.toString(sendingValue));

            startActivity(intentToFirstActivity);
        }
    };
}