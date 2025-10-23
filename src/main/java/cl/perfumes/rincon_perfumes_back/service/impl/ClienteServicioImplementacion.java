package cl.perfumes.rincon_perfumes_back.service.impl;

import cl.perfumes.rincon_perfumes_back.model.entidades.ClienteEntidad;
import cl.perfumes.rincon_perfumes_back.repository.ClienteRepositorio;
import cl.perfumes.rincon_perfumes_back.service.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImplementacion implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

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
    public ClienteEntidad guardar(ClienteEntidad cliente) {
        return clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
