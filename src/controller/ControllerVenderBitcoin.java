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
import model.Bitcoin;
import model.Investidor;
import model.Moedas;
import view.JanelaConsultarSaldo;
import view.JanelaVenderBitcoin;

/**
 *
 * @author eric song
 */
public class ControllerVenderBitcoin {
    private Investidor investidor;
    private JanelaVenderBitcoin view;

    public ControllerVenderBitcoin(Investidor investidor, JanelaVenderBitcoin view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void venderBitcoin(){
        String vendaString = view.getBitcoinTxt().getText();
        double venda = Double.parseDouble(vendaString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        
        double saldoBitcoin = investidor.getCarteira().getMoedas().get(1).getSaldo();
        double cotacaoBitcoin = investidor.getCarteira().getMoedas().get(1).getCotacao();
        Moedas bitcoinMoeda = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitcoinMoeda;
        double taxaVenda = bitcoin.getTaxaVenda();
        double vendaBitcoin = (venda / cotacaoBitcoin) * (1 + taxaVenda);
        double saldoBitcoinAtual = saldoBitcoin - vendaBitcoin;
        if (saldoBitcoinAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            double saldoRealAtual = saldoReal + venda;
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoRealAtual);
            investidor.getCarteira().getMoedas().get(1).setSaldo(saldoBitcoinAtual);
            JOptionPane.showMessageDialog(view, "Venda realizada!");
            Conexao conexao = new Conexao();
        
            try{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarBitcoin(investidor);
                dao.atualizarReal(investidor);
                ResultSet res = dao.consultarSenha(investidor);
                if(res.next()){
                    int id = res.getInt("id");
                    dao.extratoVendaBitcoin(investidor, venda, id);
                }
                JanelaConsultarSaldo c = new JanelaConsultarSaldo(investidor);
                c.setVisible(true);
                view.setVisible(false);
            } catch (SQLException e){
                JOptionPane.showMessageDialog(view, "Erro ao vender!");
            }
        }
        
        
    }
    
}
