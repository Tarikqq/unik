module org.example.naida {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.naida to javafx.fxml;
    exports org.example.naida;
}