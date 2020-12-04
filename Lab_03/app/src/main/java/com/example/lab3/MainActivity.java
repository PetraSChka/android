package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CalculateService calculateService;
    boolean mBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, CalculateService.class);
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(connection);
        mBound = false;
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            CalculateService.LocalBinder binder = (CalculateService.LocalBinder) service;
            calculateService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView resultView = findViewById(R.id.view_result);
        EditText firstNumber = findViewById(R.id.first_number);
        EditText secondNumber = findViewById(R.id.second_number);
        int number1 = Integer.parseInt(firstNumber.getText().toString());
        int number2 = Integer.parseInt(secondNumber.getText().toString());

        switch(item.getItemId()){
            case R.id.additionOperation:
                resultView.setText(calculateService.additionOfNumbers(number1, number2)+"");
                return true;
            case R.id.multiplicationOperation:
                resultView.setText(calculateService.multiplicationOfNumbers(number1, number2)+"");
                return true;
            case R.id.divisionOperation:
                resultView.setText(calculateService.divisionOfNumbers(number1, number2)+"");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}