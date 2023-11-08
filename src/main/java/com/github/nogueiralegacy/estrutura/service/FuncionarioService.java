package com.github.nogueiralegacy.estrutura.service;

import java.io.IOException;

import com.github.nogueiralegacy.estrutura.domain.Funcionario;
import com.github.nogueiralegacy.estrutura.domain.repository.FuncionarioRepository;
import com.github.nogueiralegacy.estrutura.persistencia.FuncionarioRepositoryXml;

public class FuncionarioService {
    FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryXml();

    public void save(Funcionario funcionario) {
        // salvar funcionario em json no arquivo resources o nome do arquivo é o cpf do funcionario .json
        funcionarioRepository.save(funcionario);
    }

    public Funcionario findByCpf(String cpf) throws IOException {
        // buscar funcionario pelo cpf no arquivo resources o nome do arquivo é o cpf do funcionario .json
        return  funcionarioRepository.findByCpf(cpf);
    }
    
}
