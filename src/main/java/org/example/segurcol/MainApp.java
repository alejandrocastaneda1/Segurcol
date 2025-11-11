package org.example.segurcol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage stage) {
        mainStage = stage;
        setRoot("Inicio"); // Cargar directamente la vista de inicio
    }

    public static void setRoot(String nombreFXML) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/org/example/segurcol/" + nombreFXML + ".fxml"));
            if (fxmlLoader.getLocation() == null) {
                System.out.println("❌ No se encontró el archivo FXML: " + nombreFXML);
                return;
            }
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            mainStage.setTitle("Sistema de Seguridad - SEGURCOL 🛡️");
            mainStage.setScene(scene);
            mainStage.show();
            System.out.println("✅ Vista cargada correctamente: " + nombreFXML);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("⚠️ No se pudo cargar la vista: " + nombreFXML + ".fxml");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
