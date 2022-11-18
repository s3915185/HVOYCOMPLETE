package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class resultPage extends AppCompatActivity {

    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);
        Intent intent = getIntent();
        Integer id = (Integer) intent.getExtras().get("id");
        ArrayList<DateMemory> dates = Start.getDateMemories();
        score = dates.get(Start.getDateMemories().size() -1 ).getScore();

        TextView scoreView = (TextView) findViewById(R.id.score);
        TextView pickedDate = (TextView) findViewById(R.id.pickedDate);

        Button continueBtn = (Button) findViewById(R.id.continue_btn);
        scoreView.setText(score + "%");
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(resultPage.this, home.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        String date = Start.getCurrentDate();
        pickedDate.setText(date);

    }
}