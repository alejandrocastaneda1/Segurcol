package org.example.segurcol.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Servicio {
    protected String codigoContrato;
    protected String cliente;
    protected double tarifaMensual;
    protected Estado estado;
    List<Servicio> servicios;

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

    public void crear(Servicio servicio) {
        servicios.add(servicio);
        System.out.println(" Servicio creado exitosamente");
    }

    //READ - Obtener todos
    public List<Servicio> obtenerTodos() {
        return new ArrayList<>(servicios); // devuelve una copia para no modificar la lista directamente
    }

    // READ - Obtener por código
    public Servicio obtenerPorCodigo(String codigo) {
        for (Servicio s : servicios) {
            if (s.getCodigoContrato() != null && s.getCodigoContrato().equals(codigo)) {
                return s;
            }
        }
        return null;
    }

    // UPDATE
    public boolean actualizar(String codigo, Servicio servicioActualizado) {
        for (int i = 0; i < servicios.size(); i++) {
            Servicio s = servicios.get(i);
            if (s.getCodigoContrato() != null && s.getCodigoContrato().equals(codigo)) {
                servicios.set(i, servicioActualizado);
                System.out.println(" Servicio actualizado exitosamente");
                return true;
            }
        }
        System.out.println("Servicio no encontrado");
        return false;
    }

    //  DELETE
    public boolean eliminar(String codigo) {
        for (int i = 0; i < servicios.size(); i++) {
            Servicio s = servicios.get(i);
            if (s.getCodigoContrato() != null && s.getCodigoContrato().equals(codigo)) {
                servicios.remove(i);
                System.out.println("Servicio eliminado exitosamente");
                return true;
            }
        }
        System.out.println("Servicio no encontrado");
        return false;
    }

}


