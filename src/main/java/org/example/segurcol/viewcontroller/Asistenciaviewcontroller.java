package org.example.segurcol.viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.segurcol.MainApp;
import java.time.LocalDate;

public class Asistenciaviewcontroller {

    @FXML private TextField txtIdAsistencia;
    @FXML private TextField txtEmpleado;
    @FXML private DatePicker dpFecha;
    @FXML private CheckBox chkAsistio;

    @FXML private TableView<Asistencia> tablaAsistencias;
    @FXML private TableColumn<Asistencia, String> colId;
    @FXML private TableColumn<Asistencia, String> colEmpleado;
    @FXML private TableColumn<Asistencia, LocalDate> colFecha;
    @FXML private TableColumn<Asistencia, String> colAsistio;

    private static final ObservableList<Asistencia> listaAsistencias = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));
        colEmpleado.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getEmpleado()));
        colFecha.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getFecha()));
        colAsistio.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().isAsistio() ? "Sí" : "No"));

        tablaAsistencias.setItems(listaAsistencias);
    }

    @FXML
    private void agregarAsistencia() {
        try {
            String id = txtIdAsistencia.getText();
            String empleado = txtEmpleado.getText();
            LocalDate fecha = dpFecha.getValue();
            boolean asistio = chkAsistio.isSelected();

            if (id.isEmpty() || empleado.isEmpty() || fecha == null) {
                mostrarAlerta("Por favor completa todos los campos.");
                return;
            }

            Asistencia nueva = new Asistencia(id, empleado, fecha, asistio);
            listaAsistencias.add(nueva);
            limpiarCampos();
        } catch (Exception e) {
            mostrarAlerta("Error al agregar asistencia.");
        }
    }

    @FXML
    private void eliminarAsistencia() {
        Asistencia seleccionada = tablaAsistencias.getSelectionModel().getSelectedItem();
        if (seleccionada != null) {
            listaAsistencias.remove(seleccionada);
        } else {
            mostrarAlerta("Selecciona una asistencia para eliminar.");
        }
    }

    @FXML
    private void volverInicio() {
        MainApp.setRoot("Inicio");
    }

    private void limpiarCampos() {
        txtIdAsistencia.clear();
        txtEmpleado.clear();
        dpFecha.setValue(null);
        chkAsistio.setSelected(false);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // 🔹 Clase interna para representar una asistencia
    public static class Asistencia {
        private final String id;
        private final String empleado;
        private final LocalDate fecha;
        private final boolean asistio;

        public Asistencia(String id, String empleado, LocalDate fecha, boolean asistio) {
            this.id = id;
            this.empleado = empleado;
            this.fecha = fecha;
            this.asistio = asistio;
        }

        public String getId() { return id; }
        public String getEmpleado() { return empleado; }
        public LocalDate getFecha() { return fecha; }
        public boolean isAsistio() { return asistio; }
    }
}
