package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultPage extends AppCompatActivity {

    int score;
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_page);
        Intent intent = getIntent();
        score = (Integer) intent.getExtras().get("score");
        date = Start.getCurrentDate();

        TextView scoreView = (TextView) findViewById(R.id.score);

        scoreView.setText(date);
        Button continueBtn = (Button) findViewById(R.id.continue_btn);
        scoreView.setText(score + "%");
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(resultPage.this, home.class);
                intent.putExtra("submit", 1);
                startActivity(intent);
            }
        });

    }
}