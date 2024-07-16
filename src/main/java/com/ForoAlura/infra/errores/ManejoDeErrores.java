package com.ForoAlura.infra.errores;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManejoDeErrores {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manejoError404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manejorError400(MethodArgumentNotValidException e){
        var errores=e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }


private record DatosErrorValidacion(String campo,String error){
public DatosErrorValidacion(FieldError error){
        this(error.getField(), error.getDefaultMessage());
}
}}
