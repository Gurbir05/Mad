package com.example.nutriplan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class WelcomeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String username = getIntent().getStringExtra("username");
        if (username == null || username.trim().isEmpty()) username = "User";

        TextView welcome = findViewById(R.id.welcome);
        Button start = findViewById(R.id.next);
        Button back = findViewById(R.id.back);

        welcome.setText("Welcome, " + username + "!");
        String finalUsername = username;

        start.setOnClickListener(v -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            intent.putExtra("username", finalUsername);
            startActivity(intent);
        });

        back.setOnClickListener(v -> finish());
    }
}
