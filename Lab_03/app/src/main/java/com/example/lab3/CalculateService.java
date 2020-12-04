package com.example.lab3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class CalculateService extends Service {
    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        CalculateService getService() {
            return CalculateService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public int additionOfNumbers(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }

    public int multiplicationOfNumbers(int firstNumber, int secondNumber){
        return firstNumber * secondNumber;
    }

    public int divisionOfNumbers(int firstNumber, int secondNumber){
        if(secondNumber == 0){
            return 0;
        }
        return firstNumber / secondNumber;
    }
}