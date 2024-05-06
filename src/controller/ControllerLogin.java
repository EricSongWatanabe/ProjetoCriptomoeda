/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.JanelaLogin;
import view.JanelaMenu;

/**
 *
 * @author eric song
 */
public class ControllerLogin {
    private JanelaLogin view;

    public ControllerLogin(JanelaLogin view) {
        this.view = view;
    }
    
    public void logar(){
        Pessoa pessoa = new Pessoa(null, view.getCpfTxt().getText(), 
                                      view.getSenhaTxt().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn);
            ResultSet res = dao.consultar(pessoa);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                JanelaMenu viewMenu = new JanelaMenu(new Pessoa(nome,cpf,null));
                viewMenu.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "CPF ou senha incorreto(s)");
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
