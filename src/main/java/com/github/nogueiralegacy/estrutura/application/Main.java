package com.github.nogueiralegacy.estrutura.application;

import com.github.nogueiralegacy.estrutura.gui.Interface;

public class Main {
    public static void main(String[] args) {
        EfetivaAplicacao efetivaAplicacao = new EfetivaAplicacao();
        String[] opcoes = {"Gravação", "Pesquisa"};
        int opcaoInt = Interface.caixaDeOpcao(
                opcoes,
                "Funcionalidades",
                "Selecione a funcionalidade desejada:");

        if (opcaoInt == 0) {
            efetivaAplicacao.gravacao();
        } else if (opcaoInt == 1) {
            efetivaAplicacao.pesquisa();
        }
    }
}
