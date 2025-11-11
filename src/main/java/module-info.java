module org.example.segurcol {
    requires javafx.controls;
    requires javafx.fxml;

    // Abre los paquetes al FXML Loader
    opens org.example.segurcol to javafx.fxml;
    opens org.example.segurcol.model to javafx.fxml;
    opens org.example.segurcol.viewcontroller to javafx.fxml;

    // Exporta solo los que usa fuera del módulo
    exports org.example.segurcol;
    exports org.example.segurcol.model;
    exports org.example.segurcol.viewcontroller;
}
