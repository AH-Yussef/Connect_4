package com.connect_4.connect4_UI.Controllers;

import com.connect_4.connect4_UI.Static.Settings;
import com.connect_4.connect4_UI.mutual.Node;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private AnchorPane gameBoard;
    @FXML private Text humanScore;
    @FXML private Text computerScore;
    @FXML private Text info;
    @FXML private StackPane backToWelcomeBtn;
    @FXML private AnchorPane graphContainer;

    private GraphController graphController;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        backToWelcomeBtn.setOnMouseClicked(e -> goToWelcomeScene());
        Settings.gameController = new GameController(gameBoard, this);
        graphController = new GraphController(graphContainer);
    }

    public void updateHumanScore(int score) {
        humanScore.setText(Integer.toString(score));
    }
    public void updateComputerScore(int score) {
        computerScore.setText(Integer.toString(score));
    }
    public void showInfo(String msg) {
        info.setText(msg);
    }

    public void showSearchGraph(Node root) {
        graphController.constructGraph(root);
    }

    public void goToWelcomeScene(){
        Settings.stage.setScene(Settings.welcomeScene);
        Settings.stage.show();
    }
}