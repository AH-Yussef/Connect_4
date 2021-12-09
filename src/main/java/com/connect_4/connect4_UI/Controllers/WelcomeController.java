package com.connect_4.connect4_UI.Controllers;

import com.connect_4.connect4_UI.Static.Settings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeController implements Initializable {
    @FXML private StackPane withPruningBtn;
    @FXML private StackPane withoutPruningBtn;
    @FXML private TextField level_input;

    public void playGameWithPruning(){
        Settings.pruningOn = true;
        setMaxSearchDepth();
        goToGameScene();
    }

    public void playGameWithoutPruning(){
        Settings.pruningOn = false;
        setMaxSearchDepth();
        goToGameScene();
    }

    private void goToGameScene(){
        Settings.gameController.initializeGame();
        Settings.stage.setScene(Settings.gameScene);
        Settings.stage.show();
    }

    private void setMaxSearchDepth() {
        String input = level_input.getText();
        if (input.length() > 0 && input.matches("[0-9]+")) Settings.maxSearchDepth = Integer.parseInt(input);
        else Settings.maxSearchDepth = 4;
        level_input.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        withPruningBtn.setOnMouseClicked(e -> playGameWithPruning());
        withoutPruningBtn.setOnMouseClicked(e -> playGameWithoutPruning());
    }
}
