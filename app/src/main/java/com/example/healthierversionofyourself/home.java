package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class home extends AppCompatActivity {

    int submitted;
    int dateToday;
    int monthToday;
    int yearToday;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            dateToday = LocalDate.now().getDayOfMonth();
            monthToday = LocalDate.now().getMonthValue();
            yearToday = LocalDate.now().getYear();
        }


        ArrayList<Customer> customers = Start.getCustomers();
        Intent home = getIntent();
        TextView phonenumber = (TextView) findViewById(R.id.userID);
        Integer id = (Integer) home.getExtras().get("id");

        TextView scoreText = (TextView) findViewById(R.id.score);

        ArrayList<DateMemory> dates = Start.getDateMemories();
        int dateSize = Start.getDateSize();
        for (int i = 0; i < dateSize; i++) {
            int value = dates.get(i).getId();
            if ((value == id) && (dates.get(i).getDay() == dateToday) && (dates.get(i).getMonth() == monthToday) && (dates.get(i).getYear() == yearToday)) {
                scoreText.setText(dates.get(i).getScore() + "%");
            }
        }


        ImageButton userBtn = (ImageButton) findViewById(R.id.userBtn);
        ImageButton infoBtn = (ImageButton) findViewById(R.id.infoBtn);
        ImageButton lifestyleBtn = (ImageButton) findViewById(R.id.lifestyleBtn);
        ImageButton knowledgeBtn = (ImageButton) findViewById(R.id.knowledgeBtn);
        ImageButton foodBtn = (ImageButton) findViewById(R.id.foodBtn);
        ImageButton addBtn = (ImageButton) findViewById(R.id.addBtn);

        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userInfo = new Intent(home.this, userInformation.class);
                userInfo.putExtra("id", id);
                startActivity(userInfo);
            }
        });

        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent builderInfo = new Intent(home.this, builderInformation.class);
                startActivity(builderInfo);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent category = new Intent(home.this, category.class);
                category.putExtra("id", id);
                startActivity(category);
            }
        });
        for (int i = 0; i< Start.getSize(); i++) {
            if (id.equals(customers.get(i).getId())) {
                phonenumber.setText(customers.get(i).getPhonenumber());
            }
        }




    }


}