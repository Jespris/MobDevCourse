package lut.jesperandersson.courseapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
                EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
                int num2 = Integer.parseInt(secondNumEditText.getText().toString());
                int result = num1 + num2;
                resultTextView.setText(String.format("%d", result));
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