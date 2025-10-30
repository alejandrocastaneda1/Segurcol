package org.example.segurcol.model;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected String turnoAsignado;
    protected double salarioBase;

    public Empleado(String nombre, String documento, String turnoAsignado, double salarioBase) {
        this.nombre = nombre;
        this.documento = documento;
        this.turnoAsignado = turnoAsignado;
        this.salarioBase = salarioBase;

    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getTurnoAsignado() {
        return turnoAsignado;
    }
    public void setTurnoAsignado(String turnoAsignado) {
        this.turnoAsignado = turnoAsignado;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double calcularTotal() {
        return salarioBase;
    }


}
