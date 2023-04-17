package com.example.tictactoewithcomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UserGamePlay extends AppCompatActivity {


    TicTacToe game = new TicTacToe();
    Button zero, first,second,third,fourth,fifth,sixth,seventh,eight;
    EditText currentPlayer;



    int checkWinningStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_game_play);
        setAllReferenceVar();
        Intent takeInfo = getIntent();
        game.setPlayer1(takeInfo.getStringExtra("firstPlayer"));
        game.setOpponent1(takeInfo.getStringExtra("secondPlayer"));
    }

    public void setAllReferenceVar(){
        zero = findViewById(R.id._0);
        first = findViewById(R.id._1);
        second = findViewById(R.id._2);
        third = findViewById(R.id._3);
        fourth = findViewById(R.id._4);
        fifth = findViewById(R.id._5);
        sixth = findViewById(R.id._6);
        seventh = findViewById(R.id._7);
        eight = findViewById(R.id._8);
        currentPlayer = findViewById(R.id.playerName);
    }

//    creating an on click method.

    public void insertMark(View view){
        Button tempBtn = (Button) view;
        //checking if button is already filled with either X or O
        if(tempBtn.getText().toString().equals("")){
            currentPlayer.setText(game.getPlayer());
            game.choosePlayer();
            tempBtn.setText(Character.toString(game.chooseMark()));
            game.fillMaze(whichButtonClicked(tempBtn));
            checkWinningStart++;
            if(checkWinningStart > 4){
                if(game.checkWinning()){
                    Toast.makeText(this,game.getPlayer()+" is winner",Toast.LENGTH_LONG).show();
                    resetMaze();
                }
                else if(checkWinningStart == 9){
                    Toast.makeText(this,"Draw better luck next time",Toast.LENGTH_LONG).show();
                    resetMaze();
                }
            }
        }
    }


//    creating a function which tells us that which button is clicked so, that we can transfer the value to our tictactoe class.

    public int whichButtonClicked(Button tempBtn){
        if(tempBtn.getId()==R.id._0){
            zero.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 0;
        }
        else if(tempBtn.getId() == R.id._1){
            first.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 1;
        }
        else if(tempBtn.getId() == R.id._2){
            second.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 2;
        }
        else if(tempBtn.getId() == R.id._3){
            third.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 3;
        }
        else if(tempBtn.getId() == R.id._4){
            fourth.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 4;
        }
        else if(tempBtn.getId() == R.id._5){
            fifth.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 5;
        }
        else if(tempBtn.getId() == R.id._6){
            sixth.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 6;
        }
        else if(tempBtn.getId() == R.id._7){
            seventh.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 7;
        }
        else if(tempBtn.getId() == R.id._8){
            eight.setBackgroundColor(game.player==1?Color.BLUE:Color.RED);
            return 8;
        }

        return -1;
    }
    public void resetMaze(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                zero.setText("");
                first.setText("");
                second.setText("");
                third.setText("");
                fourth.setText("");
                fifth.setText("");
                sixth.setText("");
                seventh.setText("");
                eight.setText("");
                zero.setBackgroundColor(Color.parseColor("#343555"));
                first.setBackgroundColor(Color.parseColor("#343555"));
                second.setBackgroundColor(Color.parseColor("#343555"));
                third.setBackgroundColor(Color.parseColor("#343555"));
                fourth.setBackgroundColor(Color.parseColor("#343555"));
                fifth.setBackgroundColor(Color.parseColor("#343555"));
                sixth.setBackgroundColor(Color.parseColor("#343555"));
                seventh.setBackgroundColor(Color.parseColor("#343555"));
                eight.setBackgroundColor(Color.parseColor("#343555"));
                currentPlayer.setText("");
                checkWinningStart = 0;
                game.reset();
            }
        },2500);
    }
}