package org.example.segurcol.model;
import java.time.LocalDate;

public record Agenda(
        LocalDate fecha,
        String tipo,
        String descripcion,
        String responsable,
        String servicioRelacionado
) {}
