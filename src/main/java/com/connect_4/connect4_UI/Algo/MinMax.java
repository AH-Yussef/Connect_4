package com.connect_4.connect4_UI.Algo;

import com.connect_4.connect4_UI.Algo.Heuristic.HeuristicCalculator;
import com.connect_4.connect4_UI.Static.Settings;
import com.connect_4.connect4_UI.mutual.Decision;
import com.connect_4.connect4_UI.mutual.Node;
import com.connect_4.connect4_UI.mutual.ScoreCalculator;

public class MinMax {
    private ScoreCalculator scoreCalculator;
    private HeuristicCalculator heuristicCalculator;
    private int nodesExpanded;

    public MinMax() {
        this.scoreCalculator = new ScoreCalculator();
        this.heuristicCalculator = new HeuristicCalculator();
    }

    public Decision decide(int[][] state) {
        nodesExpanded = 1;
        Node root = new Node(state, Settings.ComputerTurn);
        maximize(root, Settings.maxSearchDepth, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new Decision(root, root.bestChild.column, nodesExpanded);
    }

    public void maximize(Node node, int currDepth, double alpha, double beta) {
        nodesExpanded ++;
        if (node.isTerminal() || currDepth == 0) {
            node.utility = eval(node);
            return;
        }

        Node maxChild = null;
        int maxUtility = Integer.MIN_VALUE;
        node.getChildren();
        Node child;
        for (int i = 0; i < 7; i++) {
            child = node.children[i];
            if(child == null) break;
            minimize(child, currDepth -1, alpha, beta);

            if (child.utility > maxUtility) {
                maxUtility = child.utility;
                maxChild = child;
            }

            if(Settings.pruningOn) {
                if (maxUtility >= beta) {
                    for(int j = i; j < 7; j++) {
                        node.children[j] = null;
                    }
                    break;
                }
                if (maxUtility > alpha) alpha = maxUtility;
            }
        }
        node.utility = maxUtility;
        node.bestChild = maxChild;
    }

    public void minimize(Node node, int currDepth, double alpha, double beta) {
        nodesExpanded ++;
        if (node.isTerminal() || currDepth == 0) {
            node.utility = eval(node);
            return;
        }

        Node minChild = null;
        int minUtility = Integer.MAX_VALUE;
        node.getChildren();
        Node child;
        for (int i = 0; i < 7; i++) {
            child = node.children[i];
            if(child == null) break;
            maximize(child, currDepth -1, alpha, beta);
            if (child.utility < minUtility) {
                minUtility = child.utility;
                minChild = child;
            }

            if(Settings.pruningOn) {
                if (minUtility <= alpha) {
                    for(int j = i; j < 7; j++) {
                        node.children[j] = null;
                    }
                    break;
                }
                if (minUtility < beta) beta = minUtility;
            }
        }
        node.utility = minUtility;
        node.bestChild = minChild;
    }

    private int eval(Node node) {
        if(node.isTerminal()) return score(node);
        return heuristic(node);
    }

    private int score(Node node) {
        int humanScore = scoreCalculator.calc(node.state, Settings.HumanTurn);
        int computerScore = scoreCalculator.calc(node.state, Settings.ComputerTurn);

        return computerScore - humanScore;
    }

    private int heuristic(Node node) {
        int humanHeuristic = heuristicCalculator.evaluateHuman(node.state);
        int computerHeuristic = heuristicCalculator.evaluateComputer(node.state);

        return computerHeuristic - humanHeuristic;
    }
}
