package cl.perfumes.rincon_perfumes_back.service.impl;

import cl.perfumes.rincon_perfumes_back.dto.request.LoginRequest;
import cl.perfumes.rincon_perfumes_back.dto.response.LoginResponse;
import cl.perfumes.rincon_perfumes_back.model.entidades.UsuarioEntidad;
import cl.perfumes.rincon_perfumes_back.repository.UsuarioRepositorio;
import cl.perfumes.rincon_perfumes_back.service.AuthServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServicioImplementacion implements AuthServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public LoginResponse login(LoginRequest request) {
        Optional<UsuarioEntidad> usuarioOpt = usuarioRepositorio.findByCorreo(request.getCorreo());

        if (usuarioOpt.isEmpty()) {
            return new LoginResponse(" Correo no registrado", null, false);
        }

        UsuarioEntidad usuario = usuarioOpt.get();

        // Comparar contraseña directamente (solo para fines académicos)
        if (!usuario.getContrasena().equals(request.getContrasena())) {
            return new LoginResponse(" Contraseña incorrecta", null, false);
        }

        if (!usuario.getActivo()) {
            return new LoginResponse(" Usuario inactivo", null, false);
        }

        return new LoginResponse(" Inicio de sesión exitoso",
                usuario.getNombre() + " " + usuario.getApellido(),
                true);
    }
}
