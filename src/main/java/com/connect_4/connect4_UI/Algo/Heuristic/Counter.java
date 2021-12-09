package com.connect_4.connect4_UI.Algo.Heuristic;

public class Counter {

    /*------------------------------------------COUNTING FUNCTIONS--------------------------------------------*/

                              /*-----------------COUNTING 4 (1 case)------------------*/

    /* count the number of four consecutive pieces */
    public int countFour(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player) {

        String four = "";
        if (player == 1){
            four = "XXXX";/* count for human */
        }else if(player == 2) {
            four = "OOOO"; /* count for computer */
        }
        /* counter for the number of occurrences of 4 consecutive */
        int count = 0;

        /* count fours in rows */
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 6; j++) {
                if (rows[i].substring(j, j+4).contains(four)) {
                    count++;
                }
            }
        }

        /* count fours in columns */
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 5; j++) {
                if (columns[i].substring(j, j+4).contains(four)) {
                    count++;
                }
            }
        }

        /* count fours in upDown and downUp diagonals of the left half of the board */
        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[i].substring(j, j+4).contains(four)) {
                    count++;
                }
                if (upDown[i].substring(j, j+4).contains(four)) {
                    count++;
                }
            }
        }

        /* count fours in upDown and downUp diagonals of the right half of the board */
        for(int i = 2 ; i >= 0 ; i--) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[5-i].substring(j, j+4).contains(four)) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+4).contains(four)) {
                    count++;
                }
            }
        }

        return count;
    }

    /*--------------------------------------------------------------------------------------------------------*/


                            /*-----------------COUNTING 3 (3 cases)------------------*/

    /*count the number of three consecutive with two free adjacent places on both sides*/
    public int countThreeWith2FreeAdj(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String three2Adj = "";

        if (player == 1){
            three2Adj = "-XXX-";/* count for human */
        }else if(player == 2) {
            three2Adj = "-OOO-"; /* count for computer */
        }

        int count = 0;

        /*count threes in rows*/
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 5; j++) {
                if (rows[i].substring(j, j+5).contains(three2Adj)) {
                    count++;
                }
            }
        }

        /*count threes in columns*/
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (columns[i].substring(j, j+5).contains(three2Adj)) {
                    count++;
                }
            }
        }

        /*count threes in upDown and downUp diagonals of the left half of the board*/
        for(int i = 1 ; i < 3 ; i++) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[i].substring(j, j+5).contains(three2Adj)) {
                    count++;
                }
                if (upDown[i].substring(j, j+5).contains(three2Adj)) {
                    count++;
                }
            }
        }

        /*count threes in upDown and downUp diagonals of the right half of the board*/
        for(int i = 2 ; i > 0 ; i--) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[5-i].substring(j, j+5).contains(three2Adj)) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+5).contains(three2Adj)) {
                    count++;
                }
            }
        }
        return count;
    }

    /* count the number of three consecutive with one free adjacent place on one of the sides */
    public int countThreeWith1FreeAdj(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String three1Adj_Case1= "";
        String three1Adj_Case2= "";
        String three1Adj_Case3= "";
        String three1Adj_Case4= "";

        if (player == 1){
            three1Adj_Case1 = "/XXX-"; /* count for human */
            three1Adj_Case2 = "-XXX/";
            three1Adj_Case3 = "OXXX-";
            three1Adj_Case4 = "-XXXO";
        }else if(player == 2) {
            three1Adj_Case1 = "/OOO-"; /* count for computer */
            three1Adj_Case2 = "-OOO/";
            three1Adj_Case3 = "XOOO-";
            three1Adj_Case4 = "-OOOX";
        }

        int count = 0;

        /* count threes in rows */
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 5; j++) {
                if (rows[i].substring(j, j+5).contains(three1Adj_Case1)||
                        rows[i].substring(j, j+5).contains(three1Adj_Case2)||
                        rows[i].substring(j, j+5).contains(three1Adj_Case3)||
                        rows[i].substring(j, j+5).contains(three1Adj_Case4)) {
                    count++;
                }
            }
        }

        /* count threes in columns */
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (columns[i].substring(j, j+5).contains(three1Adj_Case1)||
                        columns[i].substring(j, j+5).contains(three1Adj_Case2)||
                        columns[i].substring(j, j+5).contains(three1Adj_Case3)||
                        columns[i].substring(j, j+5).contains(three1Adj_Case4)) {
                    count++;
                }
            }
        }

        /* count threes in upDown and downUp diagonals of the left half of the board */
        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[i].substring(j, j+5).contains(three1Adj_Case1)||
                        downUp[i].substring(j, j+5).contains(three1Adj_Case2)||
                        downUp[i].substring(j, j+5).contains(three1Adj_Case3)||
                        downUp[i].substring(j, j+5).contains(three1Adj_Case4)) {
                    count++;
                }
                if (upDown[i].substring(j, j+5).contains(three1Adj_Case1)||
                        upDown[i].substring(j, j+5).contains(three1Adj_Case2)||
                        upDown[i].substring(j, j+5).contains(three1Adj_Case3)||
                        upDown[i].substring(j, j+5).contains(three1Adj_Case4)) {
                    count++;
                }
            }
        }

        /* count threes in upDown and downUp diagonals of the right half of the board */
        for(int i = 2 ; i >= 0 ; i--) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[5-i].substring(j, j+5).contains(three1Adj_Case1)||
                        downUp[5-i].substring(j, j+5).contains(three1Adj_Case2)||
                        downUp[5-i].substring(j, j+5).contains(three1Adj_Case3)||
                        downUp[5-i].substring(j, j+5).contains(three1Adj_Case4)) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+5).contains(three1Adj_Case1)||
                        upDown[5-i].substring(j, j+5).contains(three1Adj_Case2)||
                        upDown[5-i].substring(j, j+5).contains(three1Adj_Case3)||
                        upDown[5-i].substring(j, j+5).contains(three1Adj_Case4)) {
                    count++;
                }
            }
        }
        return count;
    }


    /* count the case with two consecutive that has a single piece away by 1 square */
    public  int countThreeSeparated(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String threeSep_Case1= "";
        String threeSep_Case2= "";
        String threeSep_Case3= "";
        String threeSep_Case4= "";
        String threeSep_Case5= "";
        String threeSep_Case6= "";

        if (player == 1){
            threeSep_Case1 = "/XX-X"; /* count for human */
            threeSep_Case2 = "X-XX/";
            threeSep_Case3 = "OXX-X";
            threeSep_Case4 = "X-XXO";
            threeSep_Case5 = "-XX-X";
            threeSep_Case6 = "X-XX-";
        }else if(player == 2) {
            threeSep_Case1 = "/OO-O"; /* count for computer */
            threeSep_Case2 = "O-OO/";
            threeSep_Case3 = "XOO-O";
            threeSep_Case4 = "O-OOX";
            threeSep_Case5 = "-OO-O";
            threeSep_Case6 = "O-OO-";
        }

        int count = 0;

        /* count separated threes in rows */
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 5; j++) {
                if (rows[i].substring(j, j+5).contains(threeSep_Case1)||
                        rows[i].substring(j, j+5).contains(threeSep_Case2)||
                        rows[i].substring(j, j+5).contains(threeSep_Case3)||
                        rows[i].substring(j, j+5).contains(threeSep_Case4)||
                        rows[i].substring(j, j+5).contains(threeSep_Case5)||
                        rows[i].substring(j, j+5).contains(threeSep_Case6)) {
                    count++;
                }
            }
        }

        /* count separated threes in columns */
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (columns[i].substring(j, j+5).contains(threeSep_Case1)||
                        columns[i].substring(j, j+5).contains(threeSep_Case2)||
                        columns[i].substring(j, j+5).contains(threeSep_Case3)||
                        columns[i].substring(j, j+5).contains(threeSep_Case4)||
                        columns[i].substring(j, j+5).contains(threeSep_Case5)||
                        columns[i].substring(j, j+5).contains(threeSep_Case6)) {
                    count++;
                }
            }
        }

        /* count separated threes in upDown and downUp diagonals of the left half of the board */
        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[i].substring(j, j+5).contains(threeSep_Case1)||
                        downUp[i].substring(j, j+5).contains(threeSep_Case2)||
                        downUp[i].substring(j, j+5).contains(threeSep_Case3)||
                        downUp[i].substring(j, j+5).contains(threeSep_Case4)||
                        downUp[i].substring(j, j+5).contains(threeSep_Case5)||
                        downUp[i].substring(j, j+5).contains(threeSep_Case6)) {
                    count++;
                }
                if (upDown[i].substring(j, j+5).contains(threeSep_Case1)||
                        upDown[i].substring(j, j+5).contains(threeSep_Case2)||
                        upDown[i].substring(j, j+5).contains(threeSep_Case3)||
                        upDown[i].substring(j, j+5).contains(threeSep_Case4)||
                        upDown[i].substring(j, j+5).contains(threeSep_Case5)||
                        upDown[i].substring(j, j+5).contains(threeSep_Case6)) {
                    count++;
                }
            }
        }

        /* count separated threes in upDown and downUp diagonals of the right half of the board */
        for(int i = 2 ; i >= 0 ; i--) {
            for (int j = 0; j < i+2; j++) {
                if (downUp[5-i].substring(j, j+5).contains(threeSep_Case1)||
                        downUp[5-i].substring(j, j+5).contains(threeSep_Case2)||
                        downUp[5-i].substring(j, j+5).contains(threeSep_Case3)||
                        downUp[5-i].substring(j, j+5).contains(threeSep_Case4)||
                        downUp[5-i].substring(j, j+5).contains(threeSep_Case5)||
                        downUp[5-i].substring(j, j+5).contains(threeSep_Case6)) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+5).contains(threeSep_Case1)||
                        upDown[5-i].substring(j, j+5).contains(threeSep_Case2)||
                        upDown[5-i].substring(j, j+5).contains(threeSep_Case3)||
                        upDown[5-i].substring(j, j+5).contains(threeSep_Case4)||
                        upDown[5-i].substring(j, j+5).contains(threeSep_Case5)||
                        upDown[5-i].substring(j, j+5).contains(threeSep_Case6)) {
                    count++;
                }
            }
        }
        return count;
    }
    /*---------------------------------------------------------------------------------------------------------*/

                             /*---------------------COUNTING 2 (5 cases)------------------------*/

    /*count two consecutive that has free square on both sides of them*/
    public int countTwoWith2FreeAdj(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String two2Adj_case1 = "";
        String two2Adj_case2 = "";
        String two2Adj_case3 = "";
        String two2Adj_case4 = "";
        String two2Adj_case5 = "";
        String two2Adj_case6 = "";
        String two2Adj_case7 = "";
        String two2Adj_case8 = "";
        String two2Adj_case9 = "";

        if (player == 1){
            two2Adj_case1 = "/-XX-/"; /* human */
            two2Adj_case2 = "O-XX-O";
            two2Adj_case3 = "--XX--";
            two2Adj_case4 = "/-XX--";
            two2Adj_case5 = "--XX-/";
            two2Adj_case6 = "/-XX-O";
            two2Adj_case7 = "O-XX-/";
            two2Adj_case8 = "O-XX--";
            two2Adj_case9 = "--XX-O";

        }else if(player == 2) {
            two2Adj_case1 = "/-OO-/"; /* computer */
            two2Adj_case2 = "X-OO-X";
            two2Adj_case3 = "--OO--";
            two2Adj_case4 = "/-OO--";
            two2Adj_case5 = "--OO-/";
            two2Adj_case6 = "/-OO-X";
            two2Adj_case7 = "X-OO-/";
            two2Adj_case8 = "X-OO--";
            two2Adj_case9 = "--OO-X";
        }

        int count = 0;

        /*count twos with free 2 sides in rows*/
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (rows[i].substring(j, j+6).contains(two2Adj_case1)||
                        (rows[i].substring(j, j+6).contains(two2Adj_case2))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case3))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case4))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case5))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case6))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case7))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case8))||
                        (rows[i].substring(j, j+6).contains(two2Adj_case9))) {
                    count++;
                }
            }
        }

        /*count twos with free 2 sides in columns*/
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (columns[i].substring(j, j+6).contains(two2Adj_case1)||
                        (columns[i].substring(j, j+6).contains(two2Adj_case2))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case3))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case4))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case5))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case6))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case7))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case8))||
                        (columns[i].substring(j, j+6).contains(two2Adj_case9))) {
                    count++;
                }
            }
        }

        /*count twos with free 2 sides in upDown and downUp diagonals of the left half of the board*/
        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < i+1; j++) {
                if (downUp[i].substring(j, j+6).contains(two2Adj_case1)||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case2))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case3))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case4))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case5))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case6))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case7))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case8))||
                        (downUp[i].substring(j, j+6).contains(two2Adj_case9))) {
                    count++;
                }
                if (upDown[i].substring(j, j+6).contains(two2Adj_case1)||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case2))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case3))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case4))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case5))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case6))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case7))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case8))||
                        (upDown[i].substring(j, j+6).contains(two2Adj_case9))) {
                    count++;
                }
            }
        }

        /*count twos with free 2 sides in upDown and downUp diagonals of the right half of the board*/
        for(int i = 2 ; i >= 0 ; i--) {
            for (int j = 0; j < i+1; j++) {
                if (downUp[5-i].substring(j, j+6).contains(two2Adj_case1)||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case2))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case3))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case4))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case5))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case6))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case7))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case8))||
                        (downUp[5-i].substring(j, j+6).contains(two2Adj_case9))) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+6).contains(two2Adj_case1)||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case2))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case3))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case4))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case5))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case6))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case7))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case8))||
                        (upDown[5-i].substring(j, j+6).contains(two2Adj_case9))) {
                    count++;
                }
            }
        }
        return count;
    }

    /*count two consecutive with 5 free squares on one side of them (only can be found in rows)*/
    public int countTwoWith5Free(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String twoWith5_case1 = "";
        String twoWith5_case2= "";

        if (player == 1){
            twoWith5_case1 = "/XX-----/";/* human */
            twoWith5_case2 = "/-----XX/";
        }else if(player == 2) {
            twoWith5_case1 = "/OO-----/";/* computer */
            twoWith5_case2 = "/-----OO/";
        }

        int count = 0;

        /*count twos with free 5 squares in one side in just the rows*/
        for(int i = 0 ; i < 6 ; i++) {
                if (rows[i].substring(0, 9).contains(twoWith5_case1)||
                        (rows[i].substring(0, 9).contains(twoWith5_case2))) {
                    count++;
                }
            }

        return count;
    }

    /*count two consecutive with 4 free squares on one side of them */
    public int countTwoWith4Free(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String twoWith4_rowCase1 = "";
        String twoWith4_rowCase2 = "";
        String twoWith4_rowCase3 = "";
        String twoWith4_rowCase4 = "";
        String twoWith4_colAndDiagCase1 = "";
        String twoWith4_colAndDiagCase2 = "";

        if (player == 1){
            twoWith4_rowCase1 = "XX----O"; /* human */
            twoWith4_rowCase2 = "O----XX";
            twoWith4_rowCase3 = "OXX----";
            twoWith4_rowCase4 = "----XXO";
            twoWith4_colAndDiagCase1 = "/XX----/";
            twoWith4_colAndDiagCase2 = "/----XX/";

        }else if(player == 2) {
            twoWith4_rowCase1 = "OO----X"; /* computer */
            twoWith4_rowCase2 = "X----OO";
            twoWith4_rowCase3 = "XOO----";
            twoWith4_rowCase4 = "----OOX";
            twoWith4_colAndDiagCase1 = "/OO----/";
            twoWith4_colAndDiagCase2 = "/----OO/";
        }

        int count = 0;

        /*count twos with free 4 squares in one side in rows*/
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (rows[i].substring(j, j+7).contains(twoWith4_rowCase1)||
                        (rows[i].substring(j, j+7).contains(twoWith4_rowCase2))||
                        (rows[i].substring(j, j+7).contains(twoWith4_rowCase3))||
                        (rows[i].substring(j, j+7).contains(twoWith4_rowCase4))) {
                    count++;
                }
            }
        }

        /*count twos with free 4 squares in one side in columns*/
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 1; j++) {
                if (columns[i].substring(j, j+8).contains(twoWith4_colAndDiagCase1)||
                        (columns[i].substring(j, j+8).contains(twoWith4_colAndDiagCase2))) {
                    count++;
                }
            }
        }

        /*count twos with free 4 squares in upDown and downUp largest diagonals only (with 6 pieces) */
        for(int i = 0 ; i < 1 ; i++) {
                if (downUp[2].substring(i, i+8).contains(twoWith4_colAndDiagCase1)||
                        (downUp[2].substring(i, i+8).contains(twoWith4_colAndDiagCase2))) {
                    count++;
                }
                if (downUp[3].substring(i, i+8).contains(twoWith4_colAndDiagCase1)||
                         (downUp[3].substring(i, i+8).contains(twoWith4_colAndDiagCase2))) {
                    count++;
                }
                if (upDown[2].substring(i, i+8).contains(twoWith4_colAndDiagCase1)||
                        (upDown[2].substring(i, i+8).contains(twoWith4_colAndDiagCase2))) {
                    count++;
                }

                if (upDown[3].substring(i, i+8).contains(twoWith4_colAndDiagCase1)||
                         (upDown[3].substring(i, i+8).contains(twoWith4_colAndDiagCase2))) {
                    count++;
                }
            }
        return count;
    }

    /*count two consecutive with 3 free squares on one side of them */
    public int countTwoWith3Free(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String twoWith3_case1 = "";
        String twoWith3_case2 = "";
        String twoWith3_case3 = "";
        String twoWith3_case4 = "";
        String twoWith3_case5 = "";
        String twoWith3_case6 = "";
        String twoWith3_case7 = "";
        String twoWith3_case8 = "";
        String twoWith3_case9 = "";
        String twoWith3_case10 = "";
        String twoWith3_case11 = "";
        String twoWith3_case12 = "";

        if (player == 1){
            twoWith3_case1 = "/XX---O"; /* human */
            twoWith3_case2 = "/XX---X";
            twoWith3_case3 = "/XX---/";
            twoWith3_case4 = "OXX---O";
            twoWith3_case5 = "OXX---X";
            twoWith3_case6 = "OXX---/";
            twoWith3_case7 = "O---XX/";
            twoWith3_case8 = "X---XX/";
            twoWith3_case9 = "/---XX/";
            twoWith3_case10 = "O---XXO";
            twoWith3_case11 = "X---XXO";
            twoWith3_case12 = "/---XXO";

        }else if(player == 2) {
            twoWith3_case1 = "/OO---X"; /* computer */
            twoWith3_case2 = "/OO---O";
            twoWith3_case3 = "/OO---/";
            twoWith3_case4 = "XOO---X";
            twoWith3_case5 = "XOO---O";
            twoWith3_case6 = "XOO---/";
            twoWith3_case7 = "X---OO/";
            twoWith3_case8 = "O---OO/";
            twoWith3_case9 = "/---OO/";
            twoWith3_case10 = "X---OOX";
            twoWith3_case11 = "O---OOX";
            twoWith3_case12 = "/---OOX";
        }

        int count = 0;

        /*count twos with free 3 squares in one side in rows*/
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (rows[i].substring(j, j+7).contains(twoWith3_case1)||
                        (rows[i].substring(j, j+7).contains(twoWith3_case2))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case3))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case4))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case5))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case6))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case7))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case8))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case9))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case10))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case11))||
                        (rows[i].substring(j, j+7).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }

        /*count twos with free 3 squares in one side in columns*/
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 2; j++) {
                if (columns[i].substring(j, j+7).contains(twoWith3_case1)||
                        (columns[i].substring(j, j+7).contains(twoWith3_case2))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case3))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case4))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case5))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case6))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case7))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case8))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case9))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case10))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case11))||
                        (columns[i].substring(j, j+7).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }

        /*count twos with free 3 squares in one side in left half diagonals ( first and last excluded) */
        for(int i = 1 ; i < 3 ; i++) {
            for (int j = 0; j < i; j++) {
                if (downUp[i].substring(j, j+7).contains(twoWith3_case1)||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case2))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case3))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case4))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case5))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case6))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case7))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case8))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case9))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case10))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case11))||
                        (downUp[i].substring(j, j+7).contains(twoWith3_case12))) {
                    count++;
                }
                if (upDown[i].substring(j, j+7).contains(twoWith3_case1)||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case2))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case3))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case4))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case5))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case6))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case7))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case8))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case9))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case10))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case11))||
                        (upDown[i].substring(j, j+7).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }

        /*count twos with free 3 squares in one side in right half diagonals ( first and last excluded) */
        for(int i = 2 ; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (downUp[5-i].substring(j, j+7).contains(twoWith3_case1)||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case2))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case3))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case4))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case5))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case6))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case7))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case8))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case9))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case10))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case11))||
                        (downUp[5-i].substring(j, j+7).contains(twoWith3_case12))) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+7).contains(twoWith3_case1)||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case2))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case3))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case4))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case5))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case6))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case7))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case8))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case9))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case10))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case11))||
                        (upDown[5-i].substring(j, j+7).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }
        return count;
    }

    /*count two consecutive with 2 free squares on one side of them */
    public int countTwoWith2Free(String[] rows,String[] columns,String[] downUp ,String[] upDown, int player){

        String twoWith3_case1 = "";
        String twoWith3_case2 = "";
        String twoWith3_case3 = "";
        String twoWith3_case4 = "";
        String twoWith3_case5 = "";
        String twoWith3_case6 = "";
        String twoWith3_case7 = "";
        String twoWith3_case8 = "";
        String twoWith3_case9 = "";
        String twoWith3_case10 = "";
        String twoWith3_case11 = "";
        String twoWith3_case12 = "";

        if (player == 1){
            twoWith3_case1 = "/XX--O"; /* human */
            twoWith3_case2 = "/XX--X";
            twoWith3_case3 = "/XX--/";
            twoWith3_case4 = "OXX--O";
            twoWith3_case5 = "OXX--X";
            twoWith3_case6 = "OXX--/";
            twoWith3_case7 = "O--XX/";
            twoWith3_case8 = "X--XX/";
            twoWith3_case9 = "/--XX/";
            twoWith3_case10 = "O--XXO";
            twoWith3_case11 = "X--XXO";
            twoWith3_case12 = "/--XXO";

        }else if(player == 2) {
            twoWith3_case1 = "/OO--X"; /* computer */
            twoWith3_case2 = "/OO--O";
            twoWith3_case3 = "/OO--/";
            twoWith3_case4 = "XOO--X";
            twoWith3_case5 = "XOO--O";
            twoWith3_case6 = "XOO--/";
            twoWith3_case7 = "X--OO/";
            twoWith3_case8 = "O--OO/";
            twoWith3_case9 = "/--OO/";
            twoWith3_case10 = "X--OOX";
            twoWith3_case11 = "O--OOX";
            twoWith3_case12 = "/--OOX";
        }

        int count = 0;

        /*count twos with free 2 squares in one side in rows*/
        for(int i = 0 ; i < 6 ; i++) {
            for (int j = 0; j < 4; j++) {
                if (rows[i].substring(j, j+6).contains(twoWith3_case1)||
                        (rows[i].substring(j, j+6).contains(twoWith3_case2))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case3))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case4))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case5))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case6))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case7))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case8))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case9))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case10))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case11))||
                        (rows[i].substring(j, j+6).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }

        /*count twos with free 2 squares in one side in columns*/
        for(int i = 0 ; i < 7 ; i++) {
            for (int j = 0; j < 3; j++) {
                if (columns[i].substring(j, j+6).contains(twoWith3_case1)||
                        (columns[i].substring(j, j+6).contains(twoWith3_case2))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case3))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case4))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case5))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case6))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case7))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case8))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case9))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case10))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case11))||
                        (columns[i].substring(j, j+6).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }

        /*count twos with free 3 squares in one side in left half diagonals */
        for(int i = 0 ; i < 3 ; i++) {
            for (int j = 0; j < i+1; j++) {
                if (downUp[i].substring(j, j+6).contains(twoWith3_case1)||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case2))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case3))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case4))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case5))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case6))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case7))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case8))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case9))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case10))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case11))||
                        (downUp[i].substring(j, j+6).contains(twoWith3_case12))) {
                    count++;
                }
                if (upDown[i].substring(j, j+6).contains(twoWith3_case1)||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case2))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case3))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case4))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case5))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case6))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case7))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case8))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case9))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case10))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case11))||
                        (upDown[i].substring(j, j+6).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }

        /*count twos with free 3 squares in one side in right half diagonals */
        for(int i = 2 ; i >= 0 ; i--) {
            for (int j = 0; j < i+1; j++) {
                if (downUp[5-i].substring(j, j+6).contains(twoWith3_case1)||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case2))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case3))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case4))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case5))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case6))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case7))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case8))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case9))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case10))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case11))||
                        (downUp[5-i].substring(j, j+6).contains(twoWith3_case12))) {
                    count++;
                }
                if (upDown[5-i].substring(j, j+6).contains(twoWith3_case1)||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case2))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case3))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case4))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case5))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case6))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case7))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case8))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case9))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case10))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case11))||
                        (upDown[5-i].substring(j, j+6).contains(twoWith3_case12))) {
                    count++;
                }
            }
        }
        return count;
    }

    /*---------------------------------------------------------------------------------------------------------*/

                              /*---------------------COUNTING 1------------------------*/


    public  int[][] countOne(int[][]board, int player){
        int[][] matrix = {{0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}, // or just use a for loop
                {0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0}};

        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++) {
                if (board[i][j] == player) {
                    if (isIndividual(board, i, j)) {
                        matrix[i][j] = 1;
                    }
                }
            }
        }
        return matrix;
    }

    // compares current element with its neighbours
    private  boolean isIndividual(int[][] board, int row, int col){
        for(int i=-1; i<=1; i++){
            if(row+i > 5 || row+i < 0) continue;
            for(int j=-1; j<=1; j++){
                if(i==0 && j==0) continue;
                if(col+j > 6 || col+j < 0) continue;
                if(board[row][col] == board[row+i][col+j]) return false;
            }
        }
        return true;
    }

    /*-----------------------------------------------------------------------------------------------------------*/

}