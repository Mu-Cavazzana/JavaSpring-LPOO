package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.model.Gerente;
import com.example.demo.repository.GerenteRepository;
import com.example.demo.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gerentes")
public class GerenteController {

    @Autowired
    GerenteRepository gerenteRepository;
    GerenteService gerenteService;

    @GetMapping
    public List<Gerente> listarGerentes () {
        return gerenteRepository.findAll();
    }

    @PostMapping
    public Gerente criar (@RequestBody Gerente gerente) {
        return gerenteRepository.save(gerente);
    }

    @PutMapping("/{id}")
    public Gerente atualizar (@RequestBody Gerente gerente) {return gerenteRepository.save(gerente);}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {gerenteRepository.deleteById(id);
        String mensagem = "A deleção do id: " + id + " foi realizada com sucesso.";
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mensagem);
    }

    @GetMapping("/listar-gerentes-5k") //NÃO FUNCIONAL
    public List<Gerente> salarioMaior5k() {
        return gerenteService.salarioMaior5k(); }

    //@GetMapping("/qtd-gerentes") //NÃO FUNCIONAL
    //public int qtdGerentes() {
        //return gerenteRepository.qtdGerentes();
    //}
}
