package com.connect_4.connect4_UI.mutual;

import com.connect_4.connect4_UI.Static.Settings;

public class Node {
    public int player;
    public int[][] state ;
    public Node[] children;
    public int utility ;
    public Node bestChild;
    public int column = 0;

    public Node(int[][] state, int player){
        this.state = state;
        this.children = new Node[7];
        this.player = player;
    }

    public Node[] getChildren() {
        int i = 0;
        for (int col = 0; col < 7 ; col++) {
            for (int row = 5; row >= 0; row--) {
                if (state[row][col] == 0) {
                    int[][] new_state = copyState();
                    new_state[row][col] = player;
                    Node child = new Node(new_state, getOpponentPlayer());
                    child.column = col;
                    children[i++] = child;
                    break;
                }
            }
        }
        return children;
    }

    private int[][] copyState() {
        var copy = new int[6][7];
        for(int row = 0; row < 6; row++) {
            System.arraycopy(state[row], 0, copy[row], 0, 7);
        }
        return copy;
    }

    private int getOpponentPlayer() {
        if(player == Settings.ComputerTurn) return Settings.HumanTurn;
        return Settings.ComputerTurn;
    }

    public boolean isTerminal() {
        int topRow = 0;
        for(int col = 0; col < 7; col++) {
            if(state[topRow][col] == 0) return false;
        }
        return true;
    }
}
