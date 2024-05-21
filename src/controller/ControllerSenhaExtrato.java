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
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Carteira;
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Ripple;
import view.JanelaExtrato;
import view.JanelaMenu;
import view.JanelaSenhaExtrato;

/**
 *
 * @author eric song
 */
public class ControllerSenhaExtrato {
    private JanelaMenu viewM;
    private JanelaSenhaExtrato view;

    public ControllerSenhaExtrato(JanelaMenu viewM, JanelaSenhaExtrato view) {
        this.viewM = viewM;
        this.view = view;
    }
    
    public void consultarSenha(){
    Investidor investidor = new Investidor(null, null, viewM.getCpfLbl().getText(), 
                                  view.getSenhaTxt().getText());   
    Conexao conexao = new Conexao();
    try{
        Connection conn = conexao.getConnection();
        InvestidorDAO dao = new InvestidorDAO(conn, viewM);
        ResultSet res = dao.consultarSenha(investidor);
        if(res.next()){
            String nome = res.getString("nome");
            String cpf = res.getString("cpf");
            String senha = res.getString("senha");
            double saldoReal = res.getDouble("saldoReal");
            double saldoBitcoin = res.getDouble("saldoBitcoin");
            double saldoEthereum = res.getDouble("saldoEthereum");
            double saldoRipple = res.getDouble("saldoRipple");
            ArrayList<Moedas> moedas = new ArrayList<Moedas>();
            moedas.add(new Real(saldoReal));
            moedas.add(new Bitcoin(saldoBitcoin));
            moedas.add(new Ethereum(saldoEthereum));
            moedas.add(new Ripple(saldoRipple));
            Carteira carteira = new Carteira(moedas);
            JOptionPane.showMessageDialog(view, "Dados corretos!");
            JanelaExtrato e = new JanelaExtrato(new Investidor(carteira, nome, cpf, senha));
            view.setVisible(false);
            e.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Senha incorreta");
        }

    } catch (SQLException e){
        JOptionPane.showMessageDialog(view, "Erro de conexao!");
    }
    }
}
