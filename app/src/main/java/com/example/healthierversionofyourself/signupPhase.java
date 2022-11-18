package com.example.healthierversionofyourself;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class signupPhase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_phase);

        Intent intent = getIntent();

        ImageButton back_button = (ImageButton) findViewById(R.id.back_button);

        Button signUp = (Button) findViewById(R.id.signup_button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText id_input = (EditText) findViewById(R.id.id_input);
                EditText password_input = (EditText) findViewById(R.id.password_input);
                EditText phone_input = (EditText) findViewById(R.id.phone_input);
                Integer id = Integer.parseInt(id_input.getText().toString());
                String password = password_input.getText().toString();
                String phonenumber = phone_input.getText().toString();
                boolean hasId = false;
                if (id == 1) {
                    Toast.makeText(signupPhase.this, "Id already existed", Toast.LENGTH_SHORT).show();
                }
                else if (id.equals("") || (password.equals("") || phonenumber.equals(""))){
                    Toast.makeText(signupPhase.this, "Inputs cant be left empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    Customer customer = new Customer(id, password, phonenumber);
                    Start.addCustomer(customer);
                    Start.increasedBy1();
                    Intent home = new Intent(signupPhase.this, home.class);
                    home.putExtra("id", id);
                    startActivity(home);
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signupPhase.this, Start.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}