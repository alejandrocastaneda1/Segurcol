package org.example.segurcol.model;

public class PatrullajeMovil extends Servicio {
    private int cantidadRutas;
    private int cantidadKilometraje;

    public PatrullajeMovil(int  cantidadRutas, int cantidadKilometraje, String codigoContrato, String cliente, double tarifaMensual) {
        super(codigoContrato, cliente, tarifaMensual);
        this.cantidadRutas = cantidadRutas;
        this.cantidadKilometraje = cantidadKilometraje;
    }
    public int getCantidadRutas() {
        return cantidadRutas;
    }
    public void setCantidadRutas(int cantidadRutas) {
        this.cantidadRutas = cantidadRutas;
    }
    public int getCantidadKilometraje() {
        return cantidadKilometraje;
    }
    public void setCantidadKilometraje(int cantidadKilometraje) {
        this.cantidadKilometraje = cantidadKilometraje;
    }

}
