package com.example.tictactoewithcomputer;


// lets make it a lil more good looking and optimized.
public class TicTacToe {
    protected char array[][];
    public int player;
    protected String Player1;
    protected String opponent1;
    private char mark = 'O';

    //    const.
    TicTacToe(){
        array = new char[][]{{'0','1','2'},{'3','4','5'},{'6','7','8'}};
    }

    public String getPlayer(){
        if(player==1)
            return Player1;
        else
            return opponent1;
    }

    public void choosePlayer(){
        if(player == 0)
            player++;
        else
            player--;
    }

    public char chooseMark(){
        if(player == 1)
            mark = 'X';
        else
            mark = 'O';

        return mark;
    }

    public void setPlayer1(String Player1){
        this.Player1 = Player1;
    }
    public void setOpponent1(String opponent1){
        this.opponent1 = opponent1;
    }


    //    setting the user move which we are fetching from the ui.
    public void fillMaze(int move){
        array[move/3][move%3] = mark;
    }

    public boolean checkWinning(){
//        first checking rows.
        for(int row = 0; row<3; row++){
            if(array[row][0] == array[row][1] && array[row][1] == array[row][2] && array[row][2] == array[row][0])
                return true;
        }
//        checking col
        for(int col = 0; col<3; col++){
            if(array[0][col]==array[1][col] && array[1][col] == array[2][col] && array[2][col] == array[0][col])
                return true;
        }

//        checking diagonals
        if(array[0][0] == array[1][1] && array[1][1] == array[2][2] && array[2][2] == array[0][0])
            return true;

        if(array[0][2] == array[1][1] && array[1][1] == array[2][0] && array[2][0] == array[0][2])
            return true;

        return false;
    }

    public void reset(){
        array = new char[][]{{'0','1','2'},{'3','4','5'},{'6','7','8'}};
        player=0;
        mark = 'O';
    }
}

