/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.InvestidorDAO;
import DAO.Conexao;
import model.Pessoa;
import view.JanelaCadastro;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.JanelaLogin;

/**
 *
 * @author eric song
 */
public class ControllerCadastro {
    private JanelaCadastro view;

    public ControllerCadastro(JanelaCadastro view) {
        this.view = view;
    }
    
    public void cadastrar() {
        String nome = view.getNomeTxt().getText();
        String cpf = view.getCpfTxt().getText();
        String senha = view.getSenhaTxt().getText();

        try {
            validarCPF(cpf);
            validarSenha(senha);

            Investidor investidor = new Investidor(nome, cpf, senha);
            Conexao conexao = new Conexao();

            try {
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.inserir(investidor);
                JOptionPane.showMessageDialog(view, "Pessoa Cadastrada!");
                view.setVisible(false);
                JanelaLogin l = new JanelaLogin();
                l.setVisible(true);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(view, "Pessoa nao Cadastrada!");
            }
        } catch (CPFInvalidoException | SenhaInvalidaException e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void validarCPF(String cpf) throws CPFInvalidoException {
        if (!cpf.matches("\\d{11}")) {
            throw new CPFInvalidoException("O CPF deve ter exatamente 11 dígitos numéricos.");
        }
    }

    private void validarSenha(String senha) throws SenhaInvalidaException {
        if (!senha.matches("\\d{6}")) {
            throw new SenhaInvalidaException("A senha deve ter exatamente 6 dígitos numéricos.");
        }
    }




}
