/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.InvestidorDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Bitcoin;
import model.Investidor;
import model.Moedas;
import view.JanelaComprarBitcoin;
import view.JanelaConsultarSaldo;

/**
 *
 * @author eric song
 */
public class ControllerComprarBitcoin {
    private Investidor investidor;
    private JanelaComprarBitcoin view;

    public ControllerComprarBitcoin(Investidor investidor, JanelaComprarBitcoin view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void comprarBitcoin(){
        String compraString = view.getBitcoinTxt().getText();
        double compra = Double.parseDouble(compraString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        
        double saldoBitcoin = investidor.getCarteira().getMoedas().get(1).getSaldo();
        double cotacaoBitcoin = investidor.getCarteira().getMoedas().get(1).getCotacao();
        Moedas bitcoinMoeda = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitcoinMoeda;
        double taxaCompra = bitcoin.getTaxaCompra();
        double saldoRealAtual = saldoReal - compra * (1 + taxaCompra);
        if (saldoRealAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoRealAtual);
            double compraBitcoin = compra / cotacaoBitcoin;
            double saldoBitcoinAtual = saldoBitcoin + compraBitcoin;
            investidor.getCarteira().getMoedas().get(1).setSaldo(saldoBitcoinAtual);
            JOptionPane.showMessageDialog(view, "Compra realizada!");
            Conexao conexao = new Conexao();
        
            try{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarBitcoin(investidor);
                dao.atualizarReal(investidor);
                ResultSet res = dao.consultarSenha(investidor);
                if(res.next()){
                    int id = res.getInt("id");
                    dao.extratoCompraBitcoin(investidor, compra, id);
                }
                JanelaConsultarSaldo c = new JanelaConsultarSaldo(investidor);
                c.setVisible(true);
                view.setVisible(false);
            } catch (SQLException e){
                JOptionPane.showMessageDialog(view, "Erro ao comprar!");
            }
        }
        
        
    }
    
}
