package org.example.segurcol.model;

import java.util.ArrayList;
import java.util.List;

public class Segurcol implements IFuncionalidades {

    private String nit;
    ArrayList<Empleado> listEmpleados;
    ArrayList<Servicio> listServicios;
    ArrayList<Equipo> listEquipos;
    private List<RegistroNovedad> listaNovedades = new ArrayList<>();
    private List<Agenda> listaAgenda = new ArrayList<>();


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

    public List<RegistroNovedad> getListaNovedades() {
        return listaNovedades;
    }
    public void setListaNovedades(List<RegistroNovedad> listaNovedades) {
        this.listaNovedades = listaNovedades;
    }

    public List<Agenda> getListaAgenda() {
        return listaAgenda;
    }
    public void setListaAgenda(List<Agenda> listaAgenda) {
        this.listaAgenda = listaAgenda;
    }
    @Override
    public void registrarEmpleado() {

    }

    @Override
    public void asignarPersonal() {

    }

    @Override
    public void asignarEquipo() {

    }

    @Override
    public void calcularCostoTotalServicios() {

    }

    @Override
    public void generarReporte() {

    }

    @Override
    public void calcularGastoTotal() {

    }

}
