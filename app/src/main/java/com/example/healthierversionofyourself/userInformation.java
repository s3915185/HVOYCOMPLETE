package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class userInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_information);
        Intent intent = getIntent();
        Integer id = (Integer) intent.getExtras().get("id");
        ArrayList<Customer> customers = Start.getCustomers();

        ImageButton back_button = (ImageButton) findViewById(R.id.back_button);
        TextView userId = (TextView) findViewById(R.id.userID);
        TextView userPassword = (TextView) findViewById(R.id.userPassword);
        TextView userPhonenumber = (TextView) findViewById(R.id.userPhonenumber);
        Button logout_button = (Button) findViewById(R.id.logout_button);

        for (int i = 0; i < Start.getSize(); i++) {
            if (id.equals(customers.get(i).getId())) {
                userId.setText(customers.get(i).getId().toString());
                userPassword.setText(customers.get(i).getPassword());
                userPhonenumber.setText(customers.get(i).getPhonenumber());
            }
        }

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(userInformation.this, home.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(userInformation.this, Start.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    }