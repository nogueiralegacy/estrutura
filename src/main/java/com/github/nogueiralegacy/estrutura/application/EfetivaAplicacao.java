package com.github.nogueiralegacy.estrutura.application;

import java.util.ArrayList;
import java.util.List;

import com.github.nogueiralegacy.estrutura.domain.Funcionario;
import com.github.nogueiralegacy.estrutura.gui.Interface;
import com.github.nogueiralegacy.estrutura.service.FuncionarioService;

public class EfetivaAplicacao {
    FuncionarioService funcionarioService = new FuncionarioService();
    

    public void pesquisa() {
        while (true) {
            String sigla = Interface.caixaDeDialogo("CPF do funcionario");

            try {
                Funcionario funcionario = funcionarioService.findByCpf(sigla);
                Interface.mostrarMensagem("Resultado", exibirFuncionario(funcionario));
                return;
            } catch (Exception e) {
                Interface.mostrarMensagem("ERRO", "CPF não encontrado\nInforme um novo CPF");
            }
        }
    }

    private String exibirFuncionario(Funcionario funcionario) {
        StringBuilder sb = new StringBuilder();

        sb.append("CPF: " + funcionario.getCpf());
        sb.append("\n");
        sb.append("Nome: " + funcionario.getNome());
        sb.append("\n");
        sb.append("Idade: " + funcionario.getIdade());
        sb.append("\n");
        sb.append("Salario: " +funcionario.getSalario());
        sb.append("\n");
        sb.append("Cargo: " + funcionario.getCargo());
        sb.append("\n");
        sb.append("Habilidades: " + funcionario.getHabilidades());
        sb.append("\n");    
    
        return sb.toString();
    }

    public void gravacao() {
        Interface.mostrarMensagem("Cadastrar funcionario", "Informe os dados solicitados");
    
        String cpf = Interface.caixaDeDialogo("CPF");
        String nome = Interface.caixaDeDialogo("Nome");
        int idade = Integer.parseInt(Interface.caixaDeDialogo("Idade"));

        double salario = Double.parseDouble(Interface.caixaDeDialogo("Salário"));
        String cargo = Interface.caixaDeDialogo("Cargo");

        List<String> habilidades = new ArrayList<>();

        while (true) {
            String habilidade = Interface.caixaDeDialogo("Habilidade");
            habilidades.add(habilidade);

            String[] opcaoBinaria = {"SIM", "NÃO"};
            int resultadoAdicionarMaisPessoa = Interface.caixaDeOpcao(opcaoBinaria, "Cadastrar habilidades", "Deseja adicionar mais uma habilidade?");

            if (resultadoAdicionarMaisPessoa == 1) {
                break;
            }
        }

        funcionarioService.save(new Funcionario(cpf, nome, idade, salario, cargo, habilidades));
        Interface.mostrarMensagem("Sucesso", "Funcionario cadastrado com sucesso");
    }
}
