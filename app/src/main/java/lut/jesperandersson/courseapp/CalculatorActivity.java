package lut.jesperandersson.courseapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                float num1 = getFirstNum();
                float num2 = getSecondNum();
                float result = num1 + num2;
                updateResultText(String.format("%.2f", result));
            }
        });

        Button subBtn = (Button) findViewById(R.id.subBtn);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                float num1 = getFirstNum();
                float num2 = getSecondNum();
                float result = num1 - num2;
                updateResultText(String.format("%.2f", result));
            }
        });

        Button multBtn = (Button) findViewById(R.id.multBtn);
        multBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                float num1 = getFirstNum();
                float num2 = getSecondNum();
                float result = num1 * num2;
                updateResultText(String.format("%.2f", result));
            }
        });

        Button divBtn = (Button) findViewById(R.id.divBtn);
        divBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                float num1 = getFirstNum();
                float num2 = getSecondNum();
                if (num2 != 0f){  // cannot divide by zero
                    float result = num1 / num2;
                    updateResultText(String.format("%.2f", result));
                }
            }
        });

    }

    private float getFirstNum(){
        EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
        try {
            return Float.parseFloat(firstNumEditText.getText().toString());
        } catch (Exception e){
            // no integer found, default value 0
            return 0f;
        }

    }

    private float getSecondNum(){
        EditText secondNumEditText = (EditText) findViewById(R.id.secondNumEditText);
        try {
            return Float.parseFloat(secondNumEditText.getText().toString());
        } catch (Exception e){
            return 0f;
        }
    }

    private void updateResultText(String res){
        TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText("= " + res);
    }
}