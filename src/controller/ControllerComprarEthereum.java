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
import model.Ethereum;
import model.Investidor;
import model.Moedas;
import view.JanelaComprarEthereum;
import view.JanelaConsultarSaldo;

/**
 *
 * @author eric song
 */
public class ControllerComprarEthereum {
    private Investidor investidor;
    private JanelaComprarEthereum view;

    public ControllerComprarEthereum(Investidor investidor, JanelaComprarEthereum view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void comprarEthereum(){
        String compraString = view.getEthereumTxt().getText();
        double compra = Double.parseDouble(compraString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        
        double saldoEthereum = investidor.getCarteira().getMoedas().get(2).getSaldo();
        double cotacaoEthereum = investidor.getCarteira().getMoedas().get(2).getCotacao();
        Moedas ethereumMoeda = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethereumMoeda;
        double taxaCompra = ethereum.getTaxaCompra();
        double saldoRealAtual = saldoReal - compra * (1 + taxaCompra);
        if (saldoRealAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoRealAtual);
            double compraEthereum = compra / cotacaoEthereum;
            double saldoEthereumAtual = saldoEthereum + compraEthereum;
            investidor.getCarteira().getMoedas().get(2).setSaldo(saldoEthereumAtual);
            JOptionPane.showMessageDialog(view, "Compra realizada!");
            Conexao conexao = new Conexao();
        
            try{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarEthereum(investidor);
                dao.atualizarReal(investidor);
                ResultSet res = dao.consultarSenha(investidor);
                if(res.next()){
                    int id = res.getInt("id");
                    dao.extratoCompraEthereum(investidor, compra, id);
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