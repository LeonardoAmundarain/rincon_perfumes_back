package cl.perfumes.rincon_perfumes_back.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfumes.rincon_perfumes_back.model.entidades.ClienteEntidad;
import cl.perfumes.rincon_perfumes_back.model.entidades.UsuarioEntidad;
import cl.perfumes.rincon_perfumes_back.repository.ClienteRepositorio;
import cl.perfumes.rincon_perfumes_back.service.ClienteServicio;
import cl.perfumes.rincon_perfumes_back.service.UsuarioServicio;
import jakarta.transaction.Transactional;

@Service
public class ClienteServicioImplementacion implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired 
    private UsuarioServicio usuarioServicio;

   // Dentro de ClienteServicioImplementacion.java

@Override
@Transactional
public ClienteEntidad guardar(ClienteEntidad cliente) {
    
    UsuarioEntidad usuario = cliente.getUsuario();

    // SOLUCIÓN DE RESGUARDO: Si el ID llega como 0 (o null) y es un nuevo registro, forzar a null.
    // JPA necesita 'null' para saber que debe INSERTAR.
    if (usuario.getIdUsuario() != null && usuario.getIdUsuario() == 0L) {
        usuario.setIdUsuario(null);
    }
    
    // 1. Persistir el Usuario
    UsuarioEntidad usuarioPersistido = usuarioServicio.guardar(usuario); 
    
    // 2. Asignar el usuario persistido (con ID generado) al Cliente
    cliente.setUsuario(usuarioPersistido); 
    
    // 3. Guardar el Cliente
    return clienteRepositorio.save(cliente); 
}

    @Override
    public List<ClienteEntidad> listarClientes() {
        return clienteRepositorio.findAll();
    }

    @Override
    public Optional<ClienteEntidad> obtenerPorId(Long id) {
        return clienteRepositorio.findById(id);
    }

    @Override
    public Optional<ClienteEntidad> obtenerPorRut(String rut) {
        return clienteRepositorio.findByRut(rut);
    }


    @Override
    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
