package org.example.segurcol.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected String turnoAsignado;
    protected double salarioBase;

    // Lista estática compartida por todos los empleados
    private static final List<Empleado> listaEmpleados = new ArrayList<>();

    // Constructor
    public Empleado(String nombre, String documento, String turnoAsignado, Double salarioBase) {
        this.nombre = nombre;
        this.documento = documento;
        this.turnoAsignado = turnoAsignado;
        this.salarioBase = salarioBase;
    }

    // 🔹 Getters y Setters
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

    // 🔹 Métodos de gestión en memoria
    public static void agregarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
    }

    public static boolean eliminarEmpleado(String documento) {
        return listaEmpleados.removeIf(e -> e.getDocumento().equalsIgnoreCase(documento));
    }

    public static List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    // 🔹 Método abstracto que cada clase hija implementa
    public abstract double calcularTotal();

}
