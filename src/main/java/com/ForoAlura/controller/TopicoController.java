package com.ForoAlura.controller;

import com.ForoAlura.domain.topicos.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;
    private final TopicoRepository topicoRepository;

    @Autowired
    public TopicoController(TopicoService topicoService, TopicoRepository topicoRepository) {
        this.topicoService = topicoService;
        this.topicoRepository = topicoRepository;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> agregarTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico=topicoRepository.save(new Topico(datosTopico));
        DatosRespuestaTopico datosRta=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_de_creacion(),topico.getAutor(),topico.getCurso());
        URI url=uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRta);
    }
    //chequear lo de los duplicados!!!!

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopicos>> listadoTopicos(@PageableDefault(size = 4) Pageable paginacion) {
        return ResponseEntity.ok( topicoRepository.findByStatusTrue(paginacion).map(DatosListadoTopicos::new));


    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity <?>actualizarTopico(@PathVariable Long id,@RequestBody @Valid DatosAActualizar datosAActualizar) {
        Topico topicoActualizado=topicoService.actualizarDatos(id,datosAActualizar);
        return ResponseEntity.ok(topicoActualizado);
    }//CHEQUEAR ESTA INPUT!

/*
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosAActualizar datosAActualizar) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            Topico topico = optionalTopico.get();
            topico.actualizarDatos(datosAActualizar);
            topicoRepository.save(topico); // Guarda el tópico actualizado
            return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion(), topico.getAutor(), topico.getCurso()));
        } else {
            throw new EntityNotFoundException("El tópico con id " + id + " no existe");
        }
    }

@PutMapping
@Transactional
public ResponseEntity actualizarTopico(@RequestBody @Valid DatosAActualizar datosAActualizar) {
    Optional<Topico> optionalTopico = topicoRepository.findById(datosAActualizar.id());
    if (optionalTopico.isPresent()) {
        Topico topico = optionalTopico.get();
        topico.actualizarDatos(datosAActualizar);
        topicoRepository.save(topico); // Guarda el tópico actualizado
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFecha_de_creacion(), topico.getAutor(), topico.getCurso()));
    } else {
        throw new EntityNotFoundException("El tópico con id " + datosAActualizar.id()+ " no existe");
    }
}
*/
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> buscarTopico(@PathVariable Long id) {
        Topico topico=topicoRepository.getReferenceById(id);
        DatosRespuestaTopico datosRta=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getFecha_de_creacion(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosRta);

    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }
}
