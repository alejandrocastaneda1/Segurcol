package org.example.segurcol.viewcontroller;

import javafx.fxml.FXML;
import org.example.segurcol.MainApp;

public class Inicioviewcontroller {

    @FXML
    private void abrirCrudEmpleado() {
        MainApp.setRoot("CrudEmpleado");
    }

    @FXML
    private void abrirCrudAsistencia() {
        MainApp.setRoot("CrudAsistencia");
    }

    @FXML
    private void abrirCrudNovedad() {
        MainApp.setRoot("CrudNovedad");
    }

    @FXML
    private void cerrarAplicacion() {
        System.exit(0);
    }
}
