package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.ArrayList;



public class Start extends AppCompatActivity {
    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static int getSize() {
        return size;
    }
    public static void increasedBy1() {
        size++;
    }
    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    private static ArrayList<Customer> customers = new ArrayList<>();
    private static int size = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        customers.add(new Customer(00001, "admin", "0123456789"));
        size++;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Button login_button = (Button) findViewById(R.id.login_button);
        Button signup_button = (Button) findViewById(R.id.signup_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, loginPhase.class);
                startActivityForResult(intent, 200);
            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Start.this, signupPhase.class);
                startActivityForResult(intent, 200);
            }
        });


    }

}