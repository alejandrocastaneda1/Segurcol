package org.example.segurcol.model;

import java.util.ArrayList;
import java.util.List;

public class Segurcol {
    private String nit;
    ArrayList<Empleado> listEmpleados;
    ArrayList<Servicio> listServicios;
    ArrayList<Equipo> listEquipos;

    public Segurcol(String nit) {
        this.nit = nit;
        listEmpleados = new ArrayList<>();
        listServicios = new ArrayList<>();
        listEquipos = new ArrayList<>();
    }

    public String getNit() {
        return nit;

    }
    public ArrayList<Servicio> getListServicios() {
        return listServicios;
    }

    public void setListServicios(ArrayList<Servicio> listServicios) {
        this.listServicios = listServicios;
    }

    public ArrayList<Empleado> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(ArrayList<Empleado> listEmpleados) {
        this.listEmpleados = listEmpleados;

    }

    public ArrayList<Equipo> getListEquipos() {
        return listEquipos;
    }

    public void setListEquipos(ArrayList<Equipo> listEquipos) {
        this.listEquipos = listEquipos;
    }



}
