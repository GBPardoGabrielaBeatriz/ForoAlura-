package com.ForoAlura.domain.usuarios;

import com.ForoAlura.controller.DatosAutenticacion;
import com.ForoAlura.infra.security.DatosJWTToken;
import com.ForoAlura.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @PostMapping
    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacion datosUtenticacion){
        Authentication authenticationToken=new UsernamePasswordAuthenticationToken(datosUtenticacion.login(),datosUtenticacion.clave());
        var usuarioAutenticado=authenticationManager.authenticate(authenticationToken);
        var JWTToken=tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTToken(JWTToken));
    }
}
