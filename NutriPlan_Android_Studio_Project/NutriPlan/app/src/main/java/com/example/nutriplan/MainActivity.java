package com.example.nutriplan;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView user = findViewById(R.id.user);
        String username = getIntent().getStringExtra("username");
        user.setText("Hello, " + (username == null ? "User" : username) + "!");

        CheckBox egg = findViewById(R.id.egg);
        CheckBox milk = findViewById(R.id.milk);
        CheckBox fruits = findViewById(R.id.fruits);
        CheckBox vegetables = findViewById(R.id.vegetables);
        RadioGroup gender = findViewById(R.id.gender);
        Button submit = findViewById(R.id.submit);

        submit.setOnClickListener(v -> {
            StringBuilder food = new StringBuilder();
            if (egg.isChecked()) food.append("Eggs, ");
            if (milk.isChecked()) food.append("Milk, ");
            if (fruits.isChecked()) food.append("Fruits, ");
            if (vegetables.isChecked()) food.append("Vegetables, ");

            if (food.length() > 0) food.setLength(food.length() - 2);
            else food.append("No food selected");

            String selectedGender = "Not selected";
            int selectedId = gender.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton selected = findViewById(selectedId);
                selectedGender = selected.getText().toString();
            }

            Toast.makeText(this,
                    "Food: " + food + "\nGender: " + selectedGender,
                    Toast.LENGTH_LONG).show();
        });
    }
}
