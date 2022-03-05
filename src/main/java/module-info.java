module com.example.groupworkgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.groupworkgame to javafx.fxml;
    exports com.example.groupworkgame;
}