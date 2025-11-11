package org.example.segurcol.model;

public class OperadorMonitoreo extends Empleado {
    private int numeroZonas;

    public OperadorMonitoreo(int numeroZonas, String nombre, String documento, String turnoAsignado, double salarioBase) {
        super(nombre, documento, turnoAsignado, salarioBase);
        this.numeroZonas = numeroZonas;
    }

    public int getNumeroZonas() {
        return numeroZonas;
    }

    public void setNumeroZonas(int numeroZonas) {
        this.numeroZonas = numeroZonas;
    }

    @Override
    public double calcularTotal() {
        return salarioBase + (numeroZonas * 10000); // ejemplo de cálculo
    }
}
