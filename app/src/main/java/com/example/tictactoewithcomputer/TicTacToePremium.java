package com.example.tictactoewithcomputer;
//lets make computer gameplay as well.

public class TicTacToePremium extends TicTacToe{
    //    for computer moves.
    public int computerMaze[][];
    private String playerName;

    TicTacToePremium(){
        computerMaze = new int[][]{{2,2,2},{2,2,2},{2,2,2}};
    }

    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }


    public boolean isPlaceEmpty(int row , int col){
        if(array[row][col] != 'X' && array[row][col] != 'O')
            return true;
        return false;
    }

//   building computer moves logic.

    public int computerMove(){
        int max = 0 , maxRow = 0, maxCol = 0, currentMax = 0;

//      checking computer best move.
        for(int row = 0; row<3; row++){
            for(int col = 0; col<3; col++){
//                check is place is empty.
                if(isPlaceEmpty(row , col)){
                    computerMaze[row][col] = 3;
                    currentMax = computerMaze[row][0] * computerMaze[row][1] * computerMaze[row][2];
                    if(currentMax == 27){
                        array[row][col] = chooseMark();
//                       convertin i and j into 0 to 8 value for button.
                        return 3*row+col;
                    }
                    else if(max < currentMax){
                        max = currentMax;
                        maxRow = row;
                        maxCol = col;
                    }

//                    checking col.
                    currentMax = computerMaze[0][col] * computerMaze[1][col] * computerMaze[2][col];
                    if(currentMax == 27){
                        array[row][col] = chooseMark();
                        return 3*row+col;
                    }
                    else if(max < currentMax){
                        max = currentMax;
                        maxRow = row;
                        maxCol = col;
                    }

//                    checking diagonals
                    if(row == col){
                        currentMax = computerMaze[0][0] * computerMaze[1][1] * computerMaze[2][2];
                        if(currentMax == 27){
                            array[row][col] = chooseMark();
                            return 3*row+col;
                        }
                        else if(max < currentMax){
                            max = currentMax;
                            maxRow = row;
                            maxCol = col;
                        }
                    }
                    if((row == 0 && col == 2) || (row == 1 && col == 1) || (row == 2 && col == 0)){
                        currentMax = computerMaze[0][2] * computerMaze[1][1] * computerMaze[2][0];
                        if(currentMax == 27){
                            array[row][col] = chooseMark();
                            return 3*row+col;
                        }
                        else if(max<currentMax){
                            max = currentMax;
                            maxRow = row;
                            maxCol = col;
                        }
                    }
                    computerMaze[row][col] = 2;
                }
            }
        }
//       resisting user to win.
        for(int row = 0; row<3; row++){
            for(int col = 0; col<3; col++){
                if(isPlaceEmpty(row , col)){
                    computerMaze[row][col] = 3;
                    currentMax = computerMaze[row][0] * computerMaze[row][1] * computerMaze[row][2];
                    if(currentMax == 3){
                        array[row][col] = chooseMark();
                        return 3*row+col;
                    }
                    currentMax = computerMaze[0][col] * computerMaze[1][col] * computerMaze[2][col];
                    if(currentMax == 3){
                        array[row][col] = chooseMark();
                        return 3*row+col;
                    }
//                    checking diagonal
                    if(row == col){
                        currentMax = computerMaze[0][0] * computerMaze[1][1] * computerMaze[2][2];
                        if(currentMax == 3){
                            array[row][col] = chooseMark();
                            return 3*row+col;
                        }
                    }
                    if((row == 0 && col == 2) || (row == 1 && col == 1) || (row == 2 && col == 0)){
                        currentMax = computerMaze[0][2] * computerMaze[1][1] * computerMaze[2][0];
                        if(currentMax == 3){
                            array[row][col] = chooseMark();
                            return 3*row+col;
                        }
                    }
                    computerMaze[row][col] = 2;
                }
            }
        }
        computerMaze[maxRow][maxCol] = 3;
        array[maxRow][maxCol] = chooseMark();
        return 3*maxRow+maxCol;
    }

    public void fillUserMoveToComputerMaze(int move){
        computerMaze[move/3][move%3] = 1;
    }

    @Override
    public void reset(){
        super.reset();
        computerMaze = new int[][]{{2,2,2},{2,2,2},{2,2,2}};
    }

    @Override
    public String getPlayer(){
        if(player == 1)
            return playerName;
        else
            return "Computer thinking....";
    }
}
