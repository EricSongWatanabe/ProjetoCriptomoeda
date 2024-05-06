/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.PessoaDAO;
import DAO.Conexao;
import model.Pessoa;
import view.JanelaCadastro;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author eric song
 */
public class ControllerCadastro {
    private JanelaCadastro view;

    public ControllerCadastro(JanelaCadastro view) {
        this.view = view;
    }
    
    public void cadastrar(){
        String nome = view.getNomeTxt().getText();
        String cpf = view.getCpfTxt().getText();
        String senha = view.getSenhaTxt().getText();
        
        Pessoa pessoa = new Pessoa(nome, cpf, senha);
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            dao.inserir(pessoa);
            JOptionPane.showMessageDialog(view, "Pessoa Cadastrada!");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Pessoa nao Cadastrada!");
        }
    }
}
