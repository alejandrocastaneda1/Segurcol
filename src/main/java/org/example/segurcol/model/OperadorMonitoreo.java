package org.example.segurcol.model;

public class OperadorMonitoreo extends Empleado {

    // 🔹 Atributo propio
    private int numeroZonas;

    // 🔹 Constructor
    public OperadorMonitoreo(int numeroZonas,String nombre, int salarioBase,String documento, String turnoAsignado ) {
        super(nombre, documento, turnoAsignado, salarioBase);
        this.numeroZonas = numeroZonas;
    }

    // 🔹 Getters y Setters
    public int getNumeroZonas() {
        return numeroZonas;
    }

    public void setNumeroZonas(int numeroZonas) {
        this.numeroZonas = numeroZonas;
    }

}
