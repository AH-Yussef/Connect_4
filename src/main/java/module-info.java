module com.eightpuzzle.eightpuzzlesolver {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.connect_4.connect4_UI to javafx.fxml;
    exports com.connect_4.connect4_UI;
    exports com.connect_4.connect4_UI.Controllers;
    opens com.connect_4.connect4_UI.Controllers to javafx.fxml;
    exports com.connect_4.connect4_UI.Static;
    opens com.connect_4.connect4_UI.Static to javafx.fxml;
}