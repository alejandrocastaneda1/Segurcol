package org.example.segurcol.model;
import java.time.LocalDate;

public record RegistroNovedad(
        LocalDate fecha,
        String tipo,
        String descripcion,
        String empleadoRelacionado,
        String servicioRelacionado
) {}
