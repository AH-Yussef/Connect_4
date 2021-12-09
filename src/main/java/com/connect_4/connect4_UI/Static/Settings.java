package com.connect_4.connect4_UI.Static;

import com.connect_4.connect4_UI.Controllers.GameController;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Settings {
    public static int HumanTurn = 1;
    public static int ComputerTurn = 2;
    public static boolean pruningOn = false;
    public static int maxSearchDepth = 2;

    public static Stage stage;
    public static Scene gameScene;
    public static Scene welcomeScene;

    public static GameController gameController;
}
