package com.github.nogueiralegacy.estrutura.domain.repository;

import java.io.IOException;

import com.github.nogueiralegacy.estrutura.domain.Funcionario;

public interface FuncionarioRepository {
    void save(Funcionario funcionario);
    
    Funcionario findByCpf(String cpf) throws IOException;
}
