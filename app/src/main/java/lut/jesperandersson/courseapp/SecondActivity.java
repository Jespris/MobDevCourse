package lut.jesperandersson.courseapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("lut.jesperandersson.courseapp.SOMETHING")) {
            TextView tv = (TextView) findViewById(R.id.theTextView);
            String text = Objects.requireNonNull(getIntent().getExtras()).getString("lut.jesperandersson.courseapp.SOMETHING");
            tv.setText(text);
        }
    }
}