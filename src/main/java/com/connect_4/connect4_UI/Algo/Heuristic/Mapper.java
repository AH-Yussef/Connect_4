package com.connect_4.connect4_UI.Algo.Heuristic;

public class Mapper {

    /* function that returns string array for all rows */
    public  String [] mapRows(int[][] board){

        String[] rows = new String[6];
        String tempRow = "";

        for (int i = 5; i >= 0; i--) {
            tempRow = "";
            for (int j = 0; j < 7; j++) {
                if (board[i][j] == 1) { tempRow = tempRow + "X"; }
                else if (board[i][j] == 2) { tempRow = tempRow + "O"; }
                else { tempRow = tempRow + "-"; }
            }
            tempRow = "/"+tempRow+"/";
            rows[5-i] = tempRow;
        }
        return rows;
    }

    /* function that returns string array for all columns */
    public  String [] mapColumns(int[][] board){

        String[] columns = new String[7];
        String tempColumn = "";

        for (int i = 0; i < 7; i++) {
            tempColumn = "";
            for (int j = 0; j < 6; j++) {
                if (board[j][i] == 1) { tempColumn = tempColumn + "X"; }
                else if (board[j][i] == 2) { tempColumn = tempColumn + "O"; }
                else { tempColumn = tempColumn + "-"; }
            }
            tempColumn = "/"+tempColumn+"/";
            columns[i] = tempColumn;

        }
        return columns;
    }

    /* function that returns string array for all DownUp diagonals */
    public  String [] mapDownUp(int[][] board){

        String[] downUp = new String[6];
        String tempDiagonal1 = "";
        String tempDiagonal2 = "";

        for(int i = 3 ; i < 6 ; i++){
            tempDiagonal1 = "";
            tempDiagonal2 = "";
            for (int j = 0 ; j <= i ;j++){
                /*first 3 from left*/
                if (board[i-j][j] == 1) { tempDiagonal1 = tempDiagonal1 + "X"; }
                else if (board[i-j][j] == 2) { tempDiagonal1 = tempDiagonal1 + "O"; }
                else { tempDiagonal1 = tempDiagonal1 + "-"; }
                /*first 3 diagonals from right*/
                if (board[5-j][6-i+j] == 1) { tempDiagonal2 = tempDiagonal2 + "X"; }
                else if (board[5-j][6-i+j] == 2) { tempDiagonal2 = tempDiagonal2 + "O"; }
                else { tempDiagonal2 = tempDiagonal2 + "-"; }

            }
            tempDiagonal1 = "/"+tempDiagonal1+"/";
            tempDiagonal2 = "/"+tempDiagonal2+"/";
            downUp[i-3] = tempDiagonal1;
            downUp[8-i] = tempDiagonal2;

        }

        return downUp;
    }

    /* function that returns string array for all UpDown diagonals */
    public  String [] mapUpDown(int[][] board){

        String[] upDown = new String[6];
        String tempDiagonal1 = "";
        String tempDiagonal2 = "";

        for(int i = 3 ; i > 0 ; i--){
            tempDiagonal1 = "";
            tempDiagonal2 = "";
            for (int j = 0 ; j <= 6-i ;j++){
                /*first 3 from left*/
                if (board[i+j-1][j] == 1) { tempDiagonal1 = tempDiagonal1 + "X"; }
                else if (board[i+j-1][j] == 2) { tempDiagonal1 = tempDiagonal1 + "O"; }
                else { tempDiagonal1 = tempDiagonal1 + "-"; }
                /*first 3 diagonals from right*/
                if (board[j][i+j] == 1) { tempDiagonal2 = tempDiagonal2 + "X"; }
                else if (board[j][i+j] == 2) { tempDiagonal2 = tempDiagonal2 + "O"; }
                else { tempDiagonal2 = tempDiagonal2 + "-"; }

            }
            tempDiagonal1 = "/"+tempDiagonal1+"/";
            tempDiagonal2 = "/"+tempDiagonal2+"/";
            upDown[3-i] = tempDiagonal1;
            upDown[2+i] = tempDiagonal2;

        }
        return upDown;
    }
}
