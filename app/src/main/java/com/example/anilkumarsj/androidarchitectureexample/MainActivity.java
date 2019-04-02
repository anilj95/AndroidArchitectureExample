package com.example.anilkumarsj.androidarchitectureexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  String TAG = this.getClass().getSimpleName();
    TextView mtextView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtextView = findViewById(R.id.randomNumber);
        btn = findViewById(R.id.button);

        //DataGenerator dataGenerator = new DataGenerator();

        final DataGenerator dataGenerator = ViewModelProviders.of(this).get(DataGenerator.class);


        //String number = dataGenerator.getNumber();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataGenerator.createNumber();
                Log.i(TAG, "Random number Changed");
            }
        });

       final LiveData<String> numberM = dataGenerator.getNumberM();

        numberM.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mtextView.setText(s);
                Log.i(TAG, "data updated in UI");
            }
        });

        //mtextView.setText(number);
    }
}
