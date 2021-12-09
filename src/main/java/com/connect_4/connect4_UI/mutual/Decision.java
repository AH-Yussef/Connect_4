package com.connect_4.connect4_UI.mutual;

public class Decision {
    public Node root;
    public int promisingMove;
    public int nodesExpanded;

    public Decision(Node root, int promisingMove, int nodesExpanded) {
        this.root = root;
        this.promisingMove = promisingMove;
        this.nodesExpanded = nodesExpanded;
    }
}
