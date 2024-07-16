package com.ForoAlura.domain.cursos;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Cursos {

    private String nombre_curso;
    private String categoria;

    public Cursos(DatosCursos datosCursos) {
        this.nombre_curso= datosCursos.nombre_curso();
        this.categoria= datosCursos.categoria();
    }

    public Cursos actualizarDatos(DatosCursos datosCursos) {
        this.nombre_curso= datosCursos.nombre_curso();
        this.categoria= datosCursos.categoria();
        return  this;


    }
}
