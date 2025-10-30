module org.example.segurcol {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.segurcol to javafx.fxml;
    exports org.example.segurcol;
    exports org.example.segurcol.view;
    opens org.example.segurcol.view to javafx.fxml;
    exports org.example.segurcol.model;
    opens org.example.segurcol.model to javafx.fxml;
}