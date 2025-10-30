package org.example.segurcol.model;

public class Supervisor extends Empleado{
    private double bonoCoordinaccion;
    public Supervisor(double bonoCoordinaccion, String nombre, String documento, String turnoAsignado, double salarioBase) {
        super(nombre, documento, turnoAsignado, salarioBase);
        this.bonoCoordinaccion = bonoCoordinaccion;
        this.nombre = nombre;
        this.documento = documento;
    }

    public double getBonoCoordinaccion() {
        return bonoCoordinaccion;
    }
    public void setBonoCoordinaccion(double bonoCoordinaccion) {
        this.bonoCoordinaccion = bonoCoordinaccion;
    }
}
