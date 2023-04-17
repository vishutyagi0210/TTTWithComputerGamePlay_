package com.example.tictactoewithcomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    Intent inten;
    Spinner spinner;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new StartGame());
    }

    class StartGame implements View.OnClickListener{
        String choice;
        @Override
        public void onClick(View view) {
            choice = spinner.getSelectedItem().toString();
            if(choice.equals("Playing With Friend")){
               inten = new Intent(MainActivity.this , TakeNamesForUserGameplay.class);
            }
            else{
                inten = new Intent(MainActivity.this , TakeNamesForComputerGameplay.class);
            }

            startActivity(inten);
        }
    }
}