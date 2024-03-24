package com.example.fitfusionfriends;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EnterWorkoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter_workout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        confirmButton();
        collectData();
    }

    private void confirmButton(){
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int exp = collectData();
                Intent intent = new Intent(EnterWorkoutActivity.this, MainGameScreen.class);
                intent.putExtra("exp", exp);
                startActivity(intent);
            }
        });
    }

    private int collectData(){
        EditText weightEditText = findViewById(R.id.editWeight);
        EditText cardioEditText = findViewById(R.id.cardioEditText);
        EditText stretchingEditText = findViewById(R.id.stretchingEditText);

        int weightTime = Integer.parseInt(weightEditText.getText().toString());
        int cardioTime = Integer.parseInt(cardioEditText.getText().toString());
        int stretchingTime = Integer.parseInt(stretchingEditText.getText().toString());

        return weightTime + cardioTime + stretchingTime;
    }
}