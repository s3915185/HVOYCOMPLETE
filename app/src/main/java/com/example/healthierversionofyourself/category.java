package com.example.healthierversionofyourself;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class    category extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private TextView dateText;
    Integer foodPoints, knowledgePoints, lifestylePoints = 0;
    int foodPoint, knowledgePoint, lifestylePoint = 0;
    String datePicked;
    int idGlobal;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Button foodBtn = (Button) findViewById(R.id.food_Btn);
                foodPoints = (Integer)data.getExtras().get("points");
                String foodButtonName = "Food: " + foodPoints.toString() + "/100";
                Toast.makeText(this, foodPoints.toString(), Toast.LENGTH_SHORT).show();
                foodBtn.setText(foodButtonName);
            }
        }
        if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                Button knowledgeBtn = (Button) findViewById(R.id.knowledge_Btn);
                knowledgePoints = (Integer)data.getExtras().get("points");
                String knowledgeButtonName = "Knowledge: " + knowledgePoints.toString() + "/100";
                Toast.makeText(this, knowledgePoints.toString(), Toast.LENGTH_SHORT).show();
                knowledgeBtn.setText(knowledgeButtonName);
            }
        }
        if (requestCode == 300) {
            if (resultCode == RESULT_OK) {
                Button lifestyleBtn = (Button) findViewById(R.id.lifestyle_Btn);
                lifestylePoints = (Integer)data.getExtras().get("points");
                String lifestyleButtonName = "Lifestyle: " + lifestylePoints.toString() + "/100";
                Toast.makeText(this, lifestylePoints.toString(), Toast.LENGTH_SHORT).show();
                lifestyleBtn.setText(lifestyleButtonName);
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);
        dateText =findViewById(R.id.showdate);
        dateText.setText("Pick a Date");
        Intent intent = getIntent();
        Integer id = (Integer) intent.getExtras().get("id");
        Button submit = (Button) findViewById(R.id.submit_btn);
        idGlobal = id.intValue();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (datePicked == null) {
                    Toast.makeText(category.this, "You haven't enter a date", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(foodPoints == null) {
                    foodPoint = 0;
                }
                else {
                    foodPoint = foodPoints.intValue();
                }
                if(knowledgePoints == null) {
                    foodPoint = 0;
                }
                else {
                    knowledgePoint = knowledgePoints.intValue();
                }
                if(lifestylePoints == null) {
                    foodPoint = 0;
                }
                else {
                    lifestylePoint = lifestylePoints.intValue();
                }
                int score = (foodPoint + knowledgePoint + lifestylePoint) / 3;
                Start.addDate(datePicked, score, id, lifestylePoint, knowledgePoint, foodPoint);
                Start.setCurrentDate(datePicked);
                Intent intent = new Intent(category.this, resultPage.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this, home.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        findViewById(R.id.showdate_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });


        findViewById(R.id.lifestyle_Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this, lifestyle_category.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, 300);
            }
        });


        findViewById(R.id.knowledge_Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this, knowledge_category.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, 200);

            }
        });

        findViewById(R.id.food_Btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(category.this, food_category.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, 100);

            }
        });


    }

    private void showDatePicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker datePicker, int i3, int i1, int i2) {
        int dateSize = Start.getDateSize();
        ArrayList<DateMemory> dates = Start.getDateMemories();
        for (int i = 0; i < dateSize; i++) {
            int value = dates.get(i).getId();
            if (value == idGlobal && (dates.get(i).getDay() == i2) && (dates.get(i).getMonth() == (i1+1)) && (dates.get(i).getYear() == i3)) {
                Toast.makeText(this, "You already checked this day", Toast.LENGTH_SHORT).show();
                dateText.setText("Enter a date:");
                datePicked = null;
                return;
            }
        }
        String date = "Date: " + i2 + "/" + (i1 + 1) + "/" + i3;
        datePicked = i2 + "/" + (i1+ 1) + "/" +i3;
        dateText.setText(date);
    }
}