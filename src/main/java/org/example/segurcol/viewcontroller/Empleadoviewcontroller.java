package org.example.segurcol.viewcontroller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.segurcol.MainApp;
import org.example.segurcol.model.*;

import java.util.ArrayList;

public class Empleadoviewcontroller {

    // 🔹 Campos del formulario
    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtTurno;
    @FXML private TextField txtSalario;
    @FXML private ComboBox<String> cbTipoEmpleado;
    @FXML private Label lblDatoExtra;
    @FXML private TextField txtDatoExtra;

    // 🔹 Tabla y columnas
    @FXML private TableView<Empleado> tablaEmpleados;
    @FXML private TableColumn<Empleado, String> colNombre;
    @FXML private TableColumn<Empleado, String> colDocumento;
    @FXML private TableColumn<Empleado, String> colTurno;
    @FXML private TableColumn<Empleado, Double> colSalario;
    @FXML private TableColumn<Empleado, String> colTipo;

    // 🔹 Lista de empleados (memoria temporal)
    private final ObservableList<Empleado> listaEmpleados = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Tipos de empleados disponibles
        cbTipoEmpleado.setItems(FXCollections.observableArrayList("Supervisor", "Operador de Monitoreo", "Vigilante"));

        // Columnas
        colNombre.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getNombre()));
        colDocumento.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getDocumento()));
        colTurno.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getTurnoAsignado()));
        colSalario.setCellValueFactory(data -> new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getSalarioBase()));
        colTipo.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getClass().getSimpleName()));

        tablaEmpleados.setItems(listaEmpleados);

        // Cambiar etiqueta según tipo de empleado
        cbTipoEmpleado.setOnAction(event -> {
            String tipo = cbTipoEmpleado.getValue();
            if (tipo == null) return;

            switch (tipo) {
                case "Supervisor" -> lblDatoExtra.setText("Bono Coordinación:");
                case "Operador de Monitoreo" -> lblDatoExtra.setText("Número de zonas:");
                case "Vigilante" -> lblDatoExtra.setText("Horas extra:");
            }
        });
    }

    // 🔹 Agregar un empleado
    @FXML
    private void agregarEmpleado() {
        try {
            String nombre = txtNombre.getText();
            String documento = txtDocumento.getText();
            String turno = txtTurno.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            String tipo = cbTipoEmpleado.getValue();

            if (nombre.isEmpty() || documento.isEmpty() || turno.isEmpty() || tipo == null) {
                mostrarAlerta("Por favor, complete todos los campos obligatorios.");
                return;
            }

            Empleado nuevo = null;

            // Crear el tipo correspondiente de empleado
            switch (tipo) {
                case "Supervisor" -> {
                    double bono = Double.parseDouble(txtDatoExtra.getText());
                    nuevo = new Supervisor(bono, nombre, documento, turno, salario);
                }
                case "Operador de Monitoreo" -> {
                    int zonas = Integer.parseInt(txtDatoExtra.getText());
                    nuevo = new OperadorMonitoreo(zonas, nombre, documento, turno, salario);
                }
                case "Vigilante" -> {
                    int horas = Integer.parseInt(txtDatoExtra.getText());
                    nuevo = new Vigilante(horas, nombre, documento, turno, salario);
                }
            }

            listaEmpleados.add(nuevo);
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Por favor, ingrese números válidos en salario o dato extra.");
        }
    }

    // 🔹 Eliminar un empleado
    @FXML
    private void eliminarEmpleado() {
        Empleado seleccionado = tablaEmpleados.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            listaEmpleados.remove(seleccionado);
        } else {
            mostrarAlerta("Seleccione un empleado para eliminar.");
        }
    }

    // 🔹 Volver al inicio
    @FXML
    private void volverAlInicio() {
        MainApp.setRoot("Inicio");
    }

    // 🔹 Mostrar alerta simple
    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle("Atención");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    // 🔹 Limpiar campos del formulario
    private void limpiarCampos() {
        txtNombre.clear();
        txtDocumento.clear();
        txtTurno.clear();
        txtSalario.clear();
        txtDatoExtra.clear();
        cbTipoEmpleado.getSelectionModel().clearSelection();
    }
}
