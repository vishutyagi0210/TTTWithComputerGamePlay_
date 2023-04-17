package com.example.tictactoewithcomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsetsController;
import android.widget.Button;
import android.widget.EditText;

public class TakeNamesForComputerGameplay extends AppCompatActivity {

    EditText first;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_names_for_computer_gameplay);

        first = findViewById(R.id.Name);
        btn = findViewById(R.id.startGame);

        btn.setOnClickListener(new StartGame());

    }

    class StartGame implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent inten = new Intent(TakeNamesForComputerGameplay.this , ComputerGameplay.class);
            inten.putExtra("Player" , first.getText().toString());
            startActivity(inten);
        }
    }
}