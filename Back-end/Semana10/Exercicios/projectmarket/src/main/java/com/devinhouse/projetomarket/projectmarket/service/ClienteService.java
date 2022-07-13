package com.devinhouse.projetomarket.projectmarket.service;

import com.devinhouse.projetomarket.projectmarket.models.Cliente;
import com.devinhouse.projetomarket.projectmarket.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public Cliente salvaCliente(Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    public Cliente getCliente(Long id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        throw new IllegalArgumentException("Cliente inexistente com esse ID");
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        if (this.clienteRepository.existsById(id)) {
            cliente.setId(id);
            return this.clienteRepository.save(cliente);
        }
        throw new IllegalArgumentException("Cliente inexistente com esse ID");
    }

    public void deleteCliente(Long id) {
        this.clienteRepository.deleteById(id);
    }
}

