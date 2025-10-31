package org.example.segurcol.model;
import java.util.ArrayList;
import java.util.List;

public class Equipo implements IObjetivo {

    private String codigo;
    private String tipo;
    private String estado;
    private double valorReposicion;
    protected static List<Equipo> equipos = new ArrayList<>();



    public Equipo(String codigo, double valorReposicion) {
        this.codigo = codigo;
        this.valorReposicion = valorReposicion;
        this.estado = "Disponible";
    }

    public String getCodigo() {
        return codigo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public double getValorReposicion() {
        return valorReposicion;
    }

    @Override
    public String asignarEquipo() {
        return "";
    }

    @Override
    public String retirarEquipo() {
        return "";
    }

    @Override
    public int calcularTotalRecurso() {
        return 0;
    }

    private void setEstado(String nuevoEstado) {
    }

    // CREATE
    public void crear(Equipo equipo) {
        if (obtenerPorCodigo(equipo.getCodigo()) != null) {
            System.out.println("✗ Error: Ya existe un equipo con el código " + equipo.getCodigo());
            return;
        }
        equipos.add(equipo);
        System.out.println("✓ Equipo creado exitosamente");
    }

    // READ - Obtener todos
    public List<Equipo> obtenerTodos() {
        return new ArrayList<>(equipos);
    }

    // READ - Obtener por código
    public Equipo obtenerPorCodigo(String codigo) {
        for (Equipo eq : equipos) {
            if (eq.getCodigo() != null && eq.getCodigo().equalsIgnoreCase(codigo)) {
                return eq;
            }
        }
        return null;
    }

    public void setValorReposicion(double valorReposicion) {
        this.valorReposicion = valorReposicion;
    }


    // UPDATE
    public boolean actualizar(String codigo, String nuevoTipo, String nuevoEstado, double nuevoValor) {
        for (Equipo e : equipos) {
            if (e.getCodigo() != null && e.getCodigo().equalsIgnoreCase(codigo)) {
                e.setTipo(nuevoTipo);
                e.setEstado(nuevoEstado);
                e.setValorReposicion(nuevoValor);
                System.out.println("🔄 Equipo actualizado exitosamente: " + codigo);
                return true;
            }
        }
        System.out.println("⚠️ No se encontró el equipo con código: " + codigo);
        return false;
    }


    // DELETE
    public boolean eliminar(String codigo) {
        for (int i = 0; i < equipos.size(); i++) {
            Equipo e = equipos.get(i);
            if (e.getCodigo() != null && e.getCodigo().equalsIgnoreCase(codigo)) {
                equipos.remove(i);
                System.out.println("🗑️ Equipo eliminado exitosamente: " + codigo);
                return true;
            }
        }
        System.out.println("⚠️ No se encontró el equipo con código: " + codigo);
        return false;
    }


}
