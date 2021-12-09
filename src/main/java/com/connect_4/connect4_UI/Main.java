package com.connect_4.connect4_UI;

import com.connect_4.connect4_UI.Static.Settings;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Settings.stage = stage;

        FXMLLoader gameFxml = new FXMLLoader(Main.class.getResource("main.fxml"));
        Settings.gameScene = new Scene(gameFxml.load());

        FXMLLoader welcomeFxml = new FXMLLoader(Main.class.getResource("welcome.fxml"));
        Settings.welcomeScene = new Scene(welcomeFxml.load());

        String boardStyle = Objects.requireNonNull(Main.class.getResource("styles/board.css")).toExternalForm();
        String mainStyle = Objects.requireNonNull(Main.class.getResource("styles/main.css")).toExternalForm();
        Settings.gameScene.getStylesheets().add(boardStyle);
        Settings.gameScene.getStylesheets().add(mainStyle);

        Image icon = new Image(Objects.requireNonNull(Main.class.getResourceAsStream("assets/ai.png")));
        stage.getIcons().add(icon);
        stage.setTitle("Connect 4");
        stage.setResizable(false);

        stage.setScene(Settings.welcomeScene);
        stage.show();
    }

    public static void main(String[] args) {
        try{
            launch();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}