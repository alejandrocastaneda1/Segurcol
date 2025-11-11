package org.example.segurcol.model;

public class Supervisor extends Empleado {
    private double bonoCoordinacion;

    public Supervisor(double bonoCoordinacion, String nombre, String documento, String turnoAsignado, double salarioBase) {
        super(nombre, documento, turnoAsignado, salarioBase);
        this.bonoCoordinacion = bonoCoordinacion;
    }

    public double getBonoCoordinacion() {
        return bonoCoordinacion;
    }

    public void setBonoCoordinacion(double bonoCoordinacion) {
        this.bonoCoordinacion = bonoCoordinacion;
    }

    @Override
    public double calcularTotal() {
        return salarioBase + bonoCoordinacion;
    }
}
