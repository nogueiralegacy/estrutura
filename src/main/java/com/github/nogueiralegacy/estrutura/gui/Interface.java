package com.github.nogueiralegacy.estrutura.gui;

import javax.swing.JOptionPane;

public class Interface {
    private Interface(){}

    public static String caixaDeDialogo(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static void mostrarMensagem(String titulo, String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int caixaDeOpcao(String[] opcoes, String titulo, String mensagem) {
        return JOptionPane.showOptionDialog(null,
                mensagem,
                titulo,
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);
    }
}