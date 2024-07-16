package com.ForoAlura.domain.topicos;

import com.ForoAlura.domain.cursos.DatosCursos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String fecha_de_creacion,

        @NotBlank
        String autor,
        @NotNull
        DatosCursos curso

) {
 }