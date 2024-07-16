package com.ForoAlura.domain.topicos;
import com.ForoAlura.domain.cursos.Cursos;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico actualizarDatos(Long id, @RequestBody @Valid DatosAActualizar datosAActualizar) {
        // Busca el tópico por ID y devuelve un Optional
        Optional<Topico> optionalTopico = topicoRepository.findById(id);

        // Si el tópico está presente, actualiza sus datos; de lo contrario, lanza una EntityNotFoundException
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.setTitulo(datosAActualizar.titulo());
            topico.setMensaje(datosAActualizar.mensaje());
            //topico.setFechaDeCreacion(datosAActualizar.fecha_de_creacion());
            //topico.setAutor(datosAActualizar.autor());
            topico.setCurso(new Cursos(datosAActualizar.curso()));

            // Guarda el tópico actualizado y lo devuelve
            return topicoRepository.save(topico);
        } else {
            throw new EntityNotFoundException("El tópico con id " + id + " no existe");
        }
    }
}