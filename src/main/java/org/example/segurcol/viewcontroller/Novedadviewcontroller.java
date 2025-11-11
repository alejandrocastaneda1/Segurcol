package org.example.segurcol.viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.segurcol.MainApp;

import java.time.LocalDate;

public class Novedadviewcontroller {

    @FXML private TextField txtIdNovedad;
    @FXML private TextField txtDescripcion;
    @FXML private TextField txtEmpleado;
    @FXML private DatePicker dpFecha;

    @FXML private TableView<Novedad> tablaNovedades;
    @FXML private TableColumn<Novedad, String> colId;
    @FXML private TableColumn<Novedad, String> colDescripcion;
    @FXML private TableColumn<Novedad, String> colEmpleado;
    @FXML private TableColumn<Novedad, LocalDate> colFecha;

    private static final ObservableList<Novedad> listaNovedades = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));
        colDescripcion.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getDescripcion()));
        colEmpleado.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEmpleado()));
        colFecha.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getFecha()));

        tablaNovedades.setItems(listaNovedades);
    }

    @FXML
    private void agregarNovedad() {
        try {
            String id = txtIdNovedad.getText();
            String descripcion = txtDescripcion.getText();
            String empleado = txtEmpleado.getText();
            LocalDate fecha = dpFecha.getValue();

            if (id.isEmpty() || descripcion.isEmpty() || empleado.isEmpty() || fecha == null) {
                mostrarAlerta("Por favor completa todos los campos.");
                return;
            }

            Novedad nueva = new Novedad(id, descripcion, empleado, fecha);
            listaNovedades.add(nueva);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error al agregar la novedad.");
        }
    }

    @FXML
    private void eliminarNovedad() {
        Novedad seleccionada = tablaNovedades.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaNovedades.remove(seleccionada);
        } else {
            mostrarAlerta("Selecciona una novedad para eliminar.");
        }
    }

    @FXML
    private void volverInicio() {
        MainApp.setRoot("Inicio");
    }

    private void limpiarCampos() {
        txtIdNovedad.clear();
        txtDescripcion.clear();
        txtEmpleado.clear();
        dpFecha.setValue(null);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Clase interna simple para manejar los datos
    public static class Novedad {
        private final String id;
        private final String descripcion;
        private final String empleado;
        private final LocalDate fecha;

        public Novedad(String id, String descripcion, String empleado, LocalDate fecha) {
            this.id = id;
            this.descripcion = descripcion;
            this.empleado = empleado;
            this.fecha = fecha;
        }

        public String getId() { return id; }
        public String getDescripcion() { return descripcion; }
        public String getEmpleado() { return empleado; }
        public LocalDate getFecha() { return fecha; }
    }
}
