package org.example.segurcol.model;

public abstract class Servicio {
    protected String codigoContrato;
    protected String cliente;
    protected double tarifaMensual;
    protected Estado estado;

    public Servicio(String codigoContrato, String cliente, double tarifaMensual) {
        this.codigoContrato = codigoContrato;
        this.cliente = cliente;
        this.tarifaMensual = tarifaMensual;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getTarifaMensual() {
        return tarifaMensual;
    }

    public void setTarifaMensual(double tarifaMensual) {
        this.tarifaMensual = tarifaMensual;
    }



}
