package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Gerente;
import com.example.demo.repository.GerenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GerenteService implements PessoaService<Gerente>{

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    GerenteRepository gerenteRepository;

    @Override
    public List<Gerente> listar() {
       return gerenteRepository.findAll();
    }

    @Override
    public Gerente criar(Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @Override
    public Gerente atualizar(Gerente gerente, Long id) {
        if(gerenteRepository.existsById(id)) {
            gerente.setId(id);
            return gerenteRepository.save(gerente);
        } else {
            return null;
        }
    }

    public boolean deletar(Long id) {
        if (gerenteRepository.existsById(id)) {
            gerenteRepository.deleteById(id);
        }
        return false;
    }

    public List<Gerente> listarGerentes() {
        return gerenteRepository.findAll();
    }
    public List<Gerente> salarioMaior5k() {
        List<Gerente> listaDeGerentes = listarGerentes();
        List<Gerente> listaDeGerentes5k = new ArrayList<>();

        for(Gerente gerente : listaDeGerentes) {
            //System.out.println(funcionario.getNome());
            if(gerente.getSalario() > 5000) {
                System.out.println(gerente.getNome());
                listaDeGerentes5k.add(gerente);
            }
        }
        return listaDeGerentes5k;

    }

    //public int qtdGerentes () {
        //return gerenteRepository.findAll().size();
    //}
}
