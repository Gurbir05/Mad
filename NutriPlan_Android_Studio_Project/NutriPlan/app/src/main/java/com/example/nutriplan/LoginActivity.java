package com.example.nutriplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private EditText name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(v -> {
            String username = name.getText().toString().trim();
            String pass = password.getText().toString();

            if (username.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
            intent.putExtra("username", username);
            startActivity(intent);
        });
    }
}
