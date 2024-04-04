package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public boolean deletar(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Cliente atualizar(Long id, Cliente cliente) {
        //verificar se o id é valido
        if(clienteRepository.existsById(id)) {
            //atualizar o objeto na base
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
        // não realiza nenhuma alteração
    }

    public int qtdClientes () {
        return clienteRepository.findAll().size();
    }

}
