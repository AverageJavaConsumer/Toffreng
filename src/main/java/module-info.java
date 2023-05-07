module com.example.toffrengteam8 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.xml;


    opens com.example.toffrengteam8 to javafx.fxml;
    exports com.example.toffrengteam8;
}