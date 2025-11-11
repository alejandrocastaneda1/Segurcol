package org.example.segurcol.model;

public class Vigilante extends Empleado {

    private int horasExtras;  // o zonaAsignada, si prefieres, depende del significado

    public Vigilante(int horasExtras, String nombre, String documento, String turnoAsignado, double salarioBase) {
        super(nombre, documento, turnoAsignado, salarioBase);
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(int horasExtras) {
        this.horasExtras = horasExtras;
    }

    @Override
    public double calcularTotal() {
        // Ejemplo: paga adicional de 10 000 por hora extra
        return salarioBase + (horasExtras * 10000);
    }
}
