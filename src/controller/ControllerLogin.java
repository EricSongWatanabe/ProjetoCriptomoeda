/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
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
        Investidor investidor = new Investidor(null, null, view.getCpfTxt().getText(),
                                      view.getSenhaTxt().getText()); 
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                JOptionPane.showMessageDialog(view, "Login feito!");
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                JanelaMenu m = new JanelaMenu(new Investidor(null,nome,cpf,null));
                m.setVisible(true);
                view.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(view, "CPF ou senha incorreto(s)");
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
}
