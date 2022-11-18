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

public class loginPhase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_phase);
        Intent intent = getIntent();

        ImageButton back_button = (ImageButton) findViewById(R.id.back_button);
        Button signIn = (Button) findViewById(R.id.login_button);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText id_input = (EditText) findViewById(R.id.id_input);
                EditText password_input = (EditText) findViewById(R.id.password_input);
                Integer id = Integer.parseInt(id_input.getText().toString());
                String password = password_input.getText().toString();
             //   Toast.makeText(loginPhase.this, id, Toast.LENGTH_LONG).show();
                if ((id.equals(1)) && (password.equals("1"))) {
                    Intent home = new Intent(loginPhase.this, home.class);
                    home.putExtra("id", id);
                    startActivity(home);

                }
               else {
                  Toast.makeText(loginPhase.this, "Incorrect", Toast.LENGTH_SHORT).show();
              }

            }
        });

        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginPage = new Intent(loginPhase.this, Start.class);
                setResult(RESULT_OK, loginPage);
                finish();
            }
        });
    }

}