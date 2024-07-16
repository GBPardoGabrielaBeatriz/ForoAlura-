package com.ForoAlura.domain.topicos;

import com.ForoAlura.domain.cursos.Cursos;
import jakarta.validation.constraints.NotNull;

public record DatosRespuestaTopico(
  @NotNull
  Long id,
  String titulo,
  String mensaje,
  String fecha_de_creacion,

  String autor,
  Cursos curso

) {
}
