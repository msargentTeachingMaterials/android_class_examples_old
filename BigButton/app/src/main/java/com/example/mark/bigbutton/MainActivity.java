package com.example.mark.bigbutton;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView display;
    Button button;
    Runnable rickRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView)findViewById(R.id.display);
        button = (Button)findViewById(R.id.button);

        rickRunnable = new Runnable() {
            @Override
            public void run() {
                display.setText("Never gonna give you up, never gonna let you down, never gonna" +
                        "run around and desert you!");
                MainActivity.this.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=h9ClBzQwvhw")));
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("Something cool is coming . . .");
                button.postDelayed(rickRunnable, 2000);
            }
        });
    }
}
