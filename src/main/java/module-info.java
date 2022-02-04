module com.example.groupworkgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.groupworkgame to javafx.fxml;
    exports com.example.groupworkgame;
}