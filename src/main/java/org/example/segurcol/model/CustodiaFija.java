package org.example.segurcol.model;

public class CustodiaFija extends Servicio{
    private int cantidadVigilantes;

    public CustodiaFija(int cantidadVigilantes, String codigoContrato, String cliente, double tarifaMensual) {
        super(codigoContrato, cliente, tarifaMensual);
        this.cantidadVigilantes = cantidadVigilantes;
    }

    public int getCantidadVigilantes() {
        return cantidadVigilantes;
    }

    public void setCantidadVigilantes(int cantidadVigilantes) {
        this.cantidadVigilantes = cantidadVigilantes;
    }

}
