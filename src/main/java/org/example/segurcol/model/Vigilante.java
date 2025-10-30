package org.example.segurcol.model;

public class Vigilante extends Empleado {
    private int numeroPuesto;
    public TipoArma tipoArma;

    public Vigilante(int numeroPuesto, TipoArma tipoArma, double salarioBase, String nombre, String documento, String turnoAsignado) {
        super(nombre, documento, turnoAsignado, salarioBase);
        this.numeroPuesto = numeroPuesto;
    }

    public int getNumeroPuesto() {
        return numeroPuesto;
    }
    public void setNumeroPuesto(int numeroPuesto) {
        this.numeroPuesto = numeroPuesto;
    }

}
