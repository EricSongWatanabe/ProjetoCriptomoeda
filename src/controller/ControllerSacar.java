/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Investidor;
import view.JanelaSacar;

/**
 *
 * @author eric song
 */
public class ControllerSacar {
    private JanelaSacar view;
    private Investidor investidor;

    public ControllerSacar(JanelaSacar view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void sacar(){
        String depositoString = view.getSaqueTxt().getText();
        double deposito = Double.parseDouble(depositoString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double saldoAtual = saldoReal - deposito;
        if (saldoAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoAtual);
            JOptionPane.showMessageDialog(view, "Saque realizado!");
        }
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.atualizarSaque(investidor);
            view.setVisible(false);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro ao sacar!");
        }
    }
}
