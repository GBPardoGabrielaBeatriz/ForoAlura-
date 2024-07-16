package com.ForoAlura.domain.cursos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosCursos(

       @NotNull
        String nombre_curso,
       @NotNull
        String categoria
) {
}
