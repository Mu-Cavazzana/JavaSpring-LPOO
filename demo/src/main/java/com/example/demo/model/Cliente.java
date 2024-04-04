package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente extends Pessoa {

    @Id
    private long id;
    private boolean novo;

    public Cliente() {

    }
    public Cliente(String nome, String sobrenome, String cpf, String idade, boolean novo) {
        super(nome, sobrenome, cpf, idade);
        this.novo = false;
    }

    public boolean isNovo() {
        return novo;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
