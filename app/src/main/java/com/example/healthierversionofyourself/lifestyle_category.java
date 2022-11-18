package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class lifestyle_category extends AppCompatActivity {

    private int points = 0;
    private String pointsCalculated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle_category);

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(lifestyle_category.this, category.class);
                intent.putExtra("points", points);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
    public void onCheckboxClicked(View view) {
        TextView pointsCalt = (TextView)findViewById(R.id.Points);
        CheckBox checkBox = (CheckBox)view;

        if (checkBox.isChecked()) {
            points = points + 10;
        }
        else {
            points = points - 10;
        }
        pointsCalculated = "Points :" + points;
        pointsCalt.setText(pointsCalculated);
    }
}