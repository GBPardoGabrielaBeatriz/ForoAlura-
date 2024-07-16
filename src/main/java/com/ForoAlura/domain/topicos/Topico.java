package com.ForoAlura.domain.topicos;

import com.ForoAlura.domain.cursos.Cursos;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Entity(name="Topico")
@Table(name="topicos")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titulo;
    private String mensaje;
    private String fecha_de_creacion;
    private boolean status;
    private String autor;
    @Embedded
    private Cursos curso;
   // private TopicoRepository topicoRepository;


    public Topico(DatosTopico datosTopico) {
        this.titulo= datosTopico.titulo();
        this.mensaje= datosTopico.mensaje();
        this.fecha_de_creacion= datosTopico.fecha_de_creacion();
        this.status=true;
        this.autor= datosTopico.autor();
        this.curso=new Cursos(datosTopico.curso());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha_de_creacion() {
        return fecha_de_creacion;
    }

    public void setFecha_de_creacion(String fecha_de_creacion) {
        this.fecha_de_creacion = fecha_de_creacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFechaDeCreacion() {
        return fecha_de_creacion;
    }

    public void setFechaDeCreacion(String fechaDeCreacion) {
        this.fecha_de_creacion = fechaDeCreacion;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public void actualizarDatos( @RequestBody @Valid DatosAActualizar datosAActualizar) {

        if(datosAActualizar.id() != null){
            this.id=datosAActualizar.id();
        }
        if(datosAActualizar.titulo() != null){
            this.titulo=datosAActualizar.titulo();
        }
        if(datosAActualizar.mensaje() != null) {
            this.mensaje = datosAActualizar.mensaje();
        }
        if(datosAActualizar.fecha_de_creacion()!= null){
            this.fecha_de_creacion=datosAActualizar.fecha_de_creacion();
        }
        if(datosAActualizar.autor() != null){
            this.autor=datosAActualizar.autor();
        }
        if(datosAActualizar.curso() != null) {
            this.curso= curso.actualizarDatos(datosAActualizar.curso());
        }
        }

    public void desactivarTopico() {
        this.status=false;
    }
}




