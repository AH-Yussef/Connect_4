package com.connect_4.connect4_UI.Controllers;

import com.connect_4.connect4_UI.Algo.MinMax;
import com.connect_4.connect4_UI.Main;
import com.connect_4.connect4_UI.Static.Settings;
import com.connect_4.connect4_UI.mutual.Decision;
import com.connect_4.connect4_UI.mutual.Node;
import com.connect_4.connect4_UI.mutual.ScoreCalculator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class GameController {
    private final AnchorPane gameBoard;
    private final int[][] gameBoardData;
    private final Circle[][] circles;
    private int freeCircles;
    private int humanScore;
    private int computerScore;
    private final MainController mainController;
    private final ScoreCalculator scoreCalculator;
    private MinMax computerBrain;

    public GameController(AnchorPane gameBoard, MainController controller) {
        this.gameBoard = gameBoard;
        this.mainController = controller;
        this.gameBoardData = new int[6][7];
        this.circles = new Circle[6][7];
        this.scoreCalculator = new ScoreCalculator();
        this.createGameBoard();
    }

    public void createGameBoard() {
        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 7; col++) {
                StackPane container = new StackPane();
                container.setLayoutY(row *100);
                container.setLayoutX(col *100);

                Rectangle rec = new Rectangle(100, 100);
                rec.getStyleClass().add("rectangle");

                Circle circle = new Circle(45);
                circle.getStyleClass().add("circle");

                container.getChildren().add(rec);
                container.getChildren().add(circle);
                gameBoard.getChildren().add(container);
                circles[row][col] = circle;

                int finalCol = col;
                int finalRow = row;
                circle.setOnMouseEntered(e -> {
                    if (isLegalCircle(finalRow, finalCol)) {
                        circle.getStyleClass().add("human-circle");
                    }
                });

                circle.setOnMouseExited(e -> {
                    if (isLegalCircle(finalRow, finalCol)) {
                        circle.getStyleClass().remove("human-circle");
                    }
                });

                circle.setOnMouseClicked(e -> {
                    if(isLegalCircle(finalRow, finalCol)) {
                        gameBoardData[finalRow][finalCol] = Settings.HumanTurn;
                        circle.getStyleClass().remove("human-circle");
                        circle.getStyleClass().add("human-circle");
                        humanScore = scoreCalculator.calc(gameBoardData, Settings.HumanTurn);
                        this.mainController.updateHumanScore(humanScore);

                        if(!hasGameEnded()) computerPlay();
                    }
                });
            }
        }
    }

    private boolean isLegalCircle(int row, int col) {
        if(gameBoardData[row][col] != 0) return false;
        if(row == 5) return true;
        return gameBoardData[row + 1][col] != 0;
    }

    private int[][] gameBoardCopy() {
        var copy = new int[6][7];
        for(int row = 0; row < 6; row++) {
            System.arraycopy(gameBoardData[row], 0, copy[row], 0, 7);
        }
        return copy;
    }

    private void computerPlay() {
        Decision decision = computerBrain.decide(gameBoardCopy());
        int promisingCol = decision.promisingMove;
        for(int row = 5; row >= 0; row--) {
            if(gameBoardData[row][promisingCol] == 0) {
                gameBoardData[row][promisingCol] = Settings.ComputerTurn;
                Circle circle = circles[row][promisingCol];
                circle.getStyleClass().add("computer-circle");
                break;
            }
        }

        computerScore = scoreCalculator.calc(gameBoardData, Settings.ComputerTurn);
        this.mainController.updateComputerScore(computerScore);
        this.mainController.showSearchGraph(decision.root);
        hasGameEnded();
    }

    public void initializeGame() {
        computerBrain = new MinMax();

        this.freeCircles = 7*6;
        this.humanScore = 0;
        this.computerScore = 0;

        mainController.updateHumanScore(0);
        mainController.updateComputerScore(0);
        mainController.showInfo("");

        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 7; col++) {
                gameBoardData[row][col] = 0;
                Circle circle = circles[row][col];
                circle.getStyleClass().remove("computer-circle");
                circle.getStyleClass().remove("human-circle");
            }
        }

        int turn = new Random().nextInt(2) +1;
        if(turn == Settings.ComputerTurn) computerPlay();
    }

    private boolean hasGameEnded() {
        freeCircles --;
        if(freeCircles > 0) return false;

        String msg;
        if(computerScore > humanScore) msg = "Computer has won";
        else if(computerScore < humanScore) msg = "You Won";
        else msg = "Tie";

        mainController.showInfo(msg);
        return true;
    }
}
