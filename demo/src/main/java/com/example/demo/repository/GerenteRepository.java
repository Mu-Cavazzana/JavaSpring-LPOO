package com.example.demo.repository;

import com.example.demo.model.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GerenteRepository extends JpaRepository<Gerente, Long> {
    //int qtdGerentes();
}
