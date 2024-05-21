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
import view.JanelaConsultarSaldo;
import view.JanelaDepositar;

/**
 *
 * @author eric song
 */
public class ControllerDepositar {
    private JanelaDepositar view;
    private Investidor investidor;

    public ControllerDepositar(JanelaDepositar view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    public void depositar(){
        String depositoString = view.getDepositoTxt().getText();
        double deposito = Double.parseDouble(depositoString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        double saldoAtual = saldoReal + deposito;
        investidor.getCarteira().getMoedas().get(0).setSaldo(saldoAtual);
        
        Conexao conexao = new Conexao();
        
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            dao.atualizarReal(investidor);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                int id = res.getInt("id");
                dao.extratoDeposito(investidor, deposito, id);
                JOptionPane.showMessageDialog(view, "Deposito realizado!");
                JanelaConsultarSaldo c = new JanelaConsultarSaldo(investidor);
                c.setVisible(true);
                view.setVisible(false);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro ao depositar!");
        }
    }
}
