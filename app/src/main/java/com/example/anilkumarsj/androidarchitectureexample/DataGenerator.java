package com.example.anilkumarsj.androidarchitectureexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class DataGenerator extends ViewModel {

    private  String TAG = this.getClass().getSimpleName();

    private String myRandomNumber;
    private MutableLiveData<String> randomNumber;

    public  MutableLiveData<String> getNumberM(){



        if (randomNumber == null){

            randomNumber = new MutableLiveData<>();

            createNumber();
            Log.i(TAG,"get created number");
        }
        return randomNumber;
    }

    public  String getNumber(){

        if (myRandomNumber == null){

            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {

        Log.i(TAG,"Create number called");

        Random random = new Random();

        randomNumber.setValue("Number:"+ (random.nextInt(10-1)+1));

        //myRandomNumber = "Number:"+ (random.nextInt(10-1)+1);

    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.i(TAG,"view model destroyed");
    }
}
