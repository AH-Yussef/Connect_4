package com.connect_4.connect4_UI.mutual;

public class ScoreCalculator {
    public int calc(int[][] state, int player_code) {
        int points = 0;
        for(int row = 5; row >= 0; row--) {
            for(int col = 0; col < 7; col++) {
                if(state[row][col] != player_code) continue;
                if(verticallyHas3CircleAbove(state, row, col)) points += 1;
                if(horizontallyHas3CircleRight(state, row, col)) points += 1;
                if(diagonallyHas3CircleRightUp(state, row, col)) points += 1;
                if(diagonallyHas3CircleRightDown(state, row, col)) points += 1;
            }
        }
        return points;
    }

    private boolean verticallyHas3CircleAbove(int[][] state, int row, int col) {
        int circlesLeft = 3;
        int toCheck = 3;

        int target = state[row--][col];
        while(toCheck > 0 && row >= 0) {
            if(state[row][col] == target) {
                circlesLeft --;
            }
            row --;
            toCheck --;
        }
        return circlesLeft == 0;
    }

    private boolean horizontallyHas3CircleRight(int[][] state, int row, int col) {
        int circlesLeft = 3;
        int toCheck = 3;

        int target = state[row][col++];
        while(toCheck > 0 && col <= 6) {
            if(state[row][col] == target) {
                circlesLeft --;
            }
            col ++;
            toCheck --;
        }
        return circlesLeft == 0;
    }

    private boolean diagonallyHas3CircleRightUp(int[][] state, int row, int col) {
        int circlesLeft = 3;
        int toCheck = 3;

        int target = state[row--][col++];
        while(toCheck > 0 && col <= 6 && row >= 0) {
            if(state[row][col] == target) {
                circlesLeft --;
            }
            row --;
            col ++;
            toCheck --;
        }
        return circlesLeft == 0;
    }

    private boolean diagonallyHas3CircleRightDown(int[][] state, int row, int col) {
        int circlesLeft = 3;
        int toCheck = 3;

        int target = state[row++][col++];
        while(toCheck > 0 && col <= 6 && row <= 5) {
            if(state[row][col] == target) {
                circlesLeft --;
            }
            row ++;
            col ++;
            toCheck --;
        }
        return circlesLeft == 0;
    }
}
