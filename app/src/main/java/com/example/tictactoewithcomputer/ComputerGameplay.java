package com.example.tictactoewithcomputer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ComputerGameplay extends AppCompatActivity {
    TicTacToePremium game = new TicTacToePremium();


    Button zero, first,second,third,fourth,fifth,sixth,seventh,eight;
    EditText currentPlayer;

    int checkWinningStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_gameplay);
        setAllReferenceVar();
        Intent fetchInfo = getIntent();
        game.setPlayerName(fetchInfo.getStringExtra("Player"));
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
        if(tempBtn.getText().toString().equals("")){
            currentPlayer.setText(game.getPlayer());
            game.choosePlayer();
            tempBtn.setText(Character.toString(game.chooseMark()));
            game.fillMaze(whichButtonClicked(tempBtn));
//          we also have to fill computer maze with use move as 1.
            game.fillUserMoveToComputerMaze(whichButtonClicked(tempBtn));
            checkWinningStart++;

            if(game.checkWinning()){
                Toast.makeText(this, game.getPlayer()+"Winner", Toast.LENGTH_LONG).show();
                resetMaze();
            }
            else if(checkWinningStart >= 9){
                Toast.makeText(this, "Match Draw better luck next time" ,Toast.LENGTH_LONG ).show();
                resetMaze();
            }
            else{
                //computer moves is also done along with user click.
                //for setting computer move on ui we need to return computer move.
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentPlayer.setText(game.getPlayer());
                        game.choosePlayer();
                        setComputerMoveOnUi(game.computerMove());
                        checkWinningStart++;
                        if(game.checkWinning()){
                            Toast.makeText(ComputerGameplay.this, game.getPlayer()+" Wins", Toast.LENGTH_LONG).show();
                            resetMaze();
                        }
                        else if(checkWinningStart>=9){
                            Toast.makeText(ComputerGameplay.this, "Match draw better luck next time" , Toast.LENGTH_LONG).show();
                            resetMaze();
                        }
                    }
                }, 1000); // delay for 1 second

            }

        }
    }

    public int selectObject(View view){
        Spinner temp = (Spinner) view;
        if(temp.getSelectedItem().equals("Playing With Friend")){
            return 1;
        }
        else
            return 0;
    }


//    creating a function which tells us that which button is clicked so, that we can transfer the value to our tictactoe class.

    public int whichButtonClicked(Button tempBtn){
        if(tempBtn.getId()==R.id._0){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 0;
        }
        else if(tempBtn.getId() == R.id._1){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 1;
        }
        else if(tempBtn.getId() == R.id._2){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 2;
        }
        else if(tempBtn.getId() == R.id._3){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 3;
        }
        else if(tempBtn.getId() == R.id._4){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 4;
        }
        else if(tempBtn.getId() == R.id._5){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 5;
        }
        else if(tempBtn.getId() == R.id._6){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 6;
        }
        else if(tempBtn.getId() == R.id._7){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 7;
        }
        else if(tempBtn.getId() == R.id._8){
            tempBtn.setBackgroundColor(Color.BLUE);
            return 8;
        }

        return -1;
    }

    public void setComputerMoveOnUi(int move){
        switch (move){
            case 0:
                zero.setText(Character.toString(game.chooseMark()));
                zero.setBackgroundColor(Color.RED);
                break;
            case 1:
                first.setText(Character.toString(game.chooseMark()));
                first.setBackgroundColor(Color.RED);
                break;
            case 2:
                second.setText(Character.toString(game.chooseMark()));
                second.setBackgroundColor(Color.RED);
                break;
            case 3:
                third.setText(Character.toString(game.chooseMark()));
                third.setBackgroundColor(Color.RED);
                break;
            case 4:
                fourth.setText(Character.toString(game.chooseMark()));
                fourth.setBackgroundColor(Color.RED);
                break;
            case 5:
                fifth.setText(Character.toString(game.chooseMark()));
                fifth.setBackgroundColor(Color.RED);
                break;

            case 6:
                sixth.setText(Character.toString(game.chooseMark()));
                sixth.setBackgroundColor(Color.RED);
                break;
            case 7:
                seventh.setText(Character.toString(game.chooseMark()));
                seventh.setBackgroundColor(Color.RED);
                break;
            case 8:
                eight.setText(Character.toString(game.chooseMark()));
                eight.setBackgroundColor(Color.RED);
                break;
        }
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
                zero.setBackgroundColor(Color.parseColor("#334455"));
                first.setBackgroundColor(Color.parseColor("#334455"));
                second.setBackgroundColor(Color.parseColor("#334455"));
                third.setBackgroundColor(Color.parseColor("#334455"));
                fourth.setBackgroundColor(Color.parseColor("#334455"));
                fifth.setBackgroundColor(Color.parseColor("#334455"));
                sixth.setBackgroundColor(Color.parseColor("#334455"));
                seventh.setBackgroundColor(Color.parseColor("#334455"));
                eight.setBackgroundColor(Color.parseColor("#334455"));
                currentPlayer.setText("");
                checkWinningStart = 0;
                game.reset();
            }
        }, 2500); // delay for 1 second
    }
}