package com.example.mark.asynctaskproblemdemo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityDemo";
    private static int counter = 0;
    public TextView textView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textview);
        textView.setText("counter is: " + counter);
//        button = (Button)findViewById(R.id.button);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ProblemTask task = new ProblemTask();
//                task.execute();
//
//            }
//        });
//        Log.d(TAG, "calling onCreate");

        ProblemTask task = new ProblemTask();
        task.execute();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }


    class ProblemTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {
            Log.d(TAG, "calling doInBackground");
//            Random random = new Random();
//            int randval = (int)(random.nextFloat()*5000);
            int randval = 2000;
            Log.d(TAG, "sleeping " + randval + " milliseconds");
            try {
                Thread.sleep(randval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ++counter;
            Log.d(TAG, "counter: " + counter);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText("Counter is: " + counter);

        }
    }
}
