package com.github.nogueiralegacy.estrutura.domain;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.Data;

@Data
@XStreamAlias("funcionario")
public class Funcionario {
    private String cpf;
    private String nome;
    private int idade;
    private double salario;
    private String cargo;
    private List<String> habilidades;

    public Funcionario(String cpf, String nome, int idade, double salario, String cargo, List<String> habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
        this.cargo = cargo;
        this.habilidades = habilidades;
    }
}
