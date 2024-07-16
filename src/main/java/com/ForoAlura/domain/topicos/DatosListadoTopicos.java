package com.ForoAlura.domain.topicos;

import com.ForoAlura.domain.cursos.Cursos;

public record DatosListadoTopicos(
        Long id,
        
        String titulo,
        String mensaje,
        String fecha,
        boolean status, 
        String autor,
       Cursos Curso


) {
    public DatosListadoTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion(), topico.isStatus(),topico.getAutor(),topico.getCurso());
    }


}
/*
Opcionales:

        ¿Qué hay de mostrar los primeros 10 resultados ordenados por fecha de creación del tópico en orden ASC?
        ¿Qué tal mostrar los resultados usando un criterio de búsqueda? Sugerimos listar por: nombre de curso y año específico.
         Otra opción opcional: ¿Qué tal practicar el listado de resultados con paginación? Utilizando la anotación @PageableDefault en tu código para manejar el volumen de datos presentados al usuario.

         */
