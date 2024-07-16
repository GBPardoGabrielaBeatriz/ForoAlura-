package com.ForoAlura.domain.topicos;

import com.ForoAlura.domain.cursos.DatosCursos;
import jakarta.validation.constraints.NotNull;

public record DatosAActualizar(
 String titulo,
 String mensaje,
 String fecha_de_creacion,
 String autor,
 DatosCursos curso,
 @NotNull
 Long id

) {
}
