package lut.jesperandersson.courseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculatorBtn = (Button) findViewById(R.id.calculatorBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), CalculatorActivity.class);

                startActivity(startIntent);
            }
        });

        Button ticTacBtn = (Button) findViewById(R.id.ticTacBtn);
        ticTacBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), TictactoeActivity.class);

                startActivity(startIntent);
            }
        });

        Button secondActivityBn = (Button) findViewById(R.id.secondActivityBtn);
        secondActivityBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
                // how to pass information
                startIntent.putExtra(
                        "lut.jesperandersson.courseapp.SOMETHING",
                        "HELLO WORLD!");
                startActivity(startIntent);
            }
        });

        Button listActivityBtn = (Button) findViewById(R.id.ListActivityBtn);
        listActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(startIntent);
            }
        });

        // Attempt to launch an activity outside our app
        Button googleBtn = (Button) findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View view) {
                Log.d("TAG", "Google button pressed");
                String google = "http://www.google.com";
                Uri web_address = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, web_address);
                if (gotoGoogle.resolveActivity(getPackageManager()) != null) {
                    Log.d("TAG", "We can open google!");
                    startActivity(gotoGoogle);
                } else {
                    Log.d("TAG", "No activity found to resolve the intent :(");
                }
            }
        });
    }
}