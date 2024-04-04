package com.example.demo.repository;

import com.example.demo.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    List<Funcionario> findByNome(String nome);
    Funcionario findByCpf(String cpf);
}
