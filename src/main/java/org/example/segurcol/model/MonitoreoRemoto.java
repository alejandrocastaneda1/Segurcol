package org.example.segurcol.model;

public class MonitoreoRemoto extends Servicio {
    private int dispositivosVigilados;

    public MonitoreoRemoto(int dispositivosVigilados, String codigoContrato, String cliente, double tarifaMensual) {
        super(codigoContrato, cliente, tarifaMensual);
        this.dispositivosVigilados = dispositivosVigilados;
    }

    public int getDispositivosVigilados() {
        return dispositivosVigilados;
    }

    public int setDispositivosVigilados() {
        return dispositivosVigilados;
    }


}
