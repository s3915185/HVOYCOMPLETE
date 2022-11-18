package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class knowledge_category extends AppCompatActivity {

    private double points = 0;
    private String pointsCalculated;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_category);


        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int point = (int) points;
                Intent intent = new Intent(knowledge_category.this, category.class);
                intent.putExtra("points", point);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public void onCheckboxClicked(View view) {
        TextView pointsCalt = (TextView)findViewById(R.id.Points);
        CheckBox checkBox = (CheckBox)view;

        if (checkBox.isChecked()) {
            points = points + 14.3;
        }
        else {
            points = points - 14.3;
        }
        pointsCalculated = "Points :" + (int) points;
        pointsCalt.setText(pointsCalculated);
    }
}