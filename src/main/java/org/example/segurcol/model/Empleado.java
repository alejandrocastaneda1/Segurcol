package org.example.segurcol.model;
import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected String turnoAsignado;
    protected double salarioBase;
    protected static List<Empleado> listaEmpleados = new ArrayList<>();

    public Empleado(String nombre, String documento, String turnoAsignado, double salarioBase) {
        this.nombre = nombre;
        this.documento = documento;
        this.turnoAsignado = turnoAsignado;
        this.salarioBase = salarioBase;

    }

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

    public double calcularTotal() {
        return salarioBase;
    }
    // ✅ CREATE
    public void agregarEmpleado(Empleado empleado) {
        if (obtenerPorDocumento(empleado.getDocumento()) != null) {
            System.out.println("✗ Error: Ya existe un empleado con el documento " + empleado.getDocumento());
            return;
        }
        listaEmpleados.add(empleado);
        System.out.println("✅ Empleado agregado: " + empleado.getNombre());
    }

    // ✅ READ - Listar todos los empleados
    public List<Empleado> listarEmpleados() {
        return new ArrayList<>(listaEmpleados);
    }

    // ✅ READ - Buscar por documento
    public Empleado obtenerPorDocumento(String documento) {
        for (Empleado e : listaEmpleados) {
            if (e.getDocumento() != null && e.getDocumento().equalsIgnoreCase(documento)) {
                return e;
            }
        }
        return null;
    }

    // ✅ UPDATE
    public boolean actualizarEmpleado(String documento, String nuevoNombre, String nuevoTurno, double nuevoSalario) {
        for (Empleado e : listaEmpleados) {
            if (e.getDocumento() != null && e.getDocumento().equalsIgnoreCase(documento)) {
                e.setNombre(nuevoNombre);
                e.setTurnoAsignado(nuevoTurno);
                e.setSalarioBase(nuevoSalario);
                System.out.println("🔄 Empleado actualizado: " + documento);
                return true;
            }
        }
        System.out.println("⚠ No se encontró empleado con documento: " + documento);
        return false;
    }

    // ✅ DELETE
    public boolean eliminarEmpleado(String documento) {
        for (int i = 0; i < listaEmpleados.size(); i++) {
            Empleado e = listaEmpleados.get(i);
            if (e.getDocumento() != null && e.getDocumento().equalsIgnoreCase(documento)) {
                listaEmpleados.remove(i);
                System.out.println("🗑 Empleado eliminado: " + documento);
                return true;
            }
        }
        System.out.println("⚠ No se encontró empleado con documento: " + documento);
        return false;
    }
}
