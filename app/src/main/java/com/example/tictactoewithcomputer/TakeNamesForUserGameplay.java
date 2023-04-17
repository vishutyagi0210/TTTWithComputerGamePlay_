package com.example.tictactoewithcomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TakeNamesForUserGameplay extends AppCompatActivity {


    EditText first , second;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_names_for_user_gameplay);

        first = findViewById(R.id.firstName);
        second = findViewById(R.id.secondName);
        btn = findViewById(R.id.startGame);

        btn.setOnClickListener(new StartGame());
    }

    class StartGame implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent inten = new Intent(TakeNamesForUserGameplay.this , UserGamePlay.class);
            inten.putExtra("firstPlayer" , first.getText().toString());
            inten.putExtra("secondPlayer" , second.getText().toString());
            startActivity(inten);
        }
    }
}