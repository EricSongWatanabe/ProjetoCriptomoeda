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
import view.JanelaVenderEthereum;
import view.JanelaConsultarSaldo;

/**
 *
 * @author eric song
 */
public class ControllerVenderEthereum {
    private Investidor investidor;
    private JanelaVenderEthereum view;

    public ControllerVenderEthereum(Investidor investidor, JanelaVenderEthereum view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void venderEthereum(){
        String vendaString = view.getEthereumTxt().getText();
        double venda = Double.parseDouble(vendaString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        
        double saldoEthereum = investidor.getCarteira().getMoedas().get(2).getSaldo();
        double cotacaoEthereum = investidor.getCarteira().getMoedas().get(2).getCotacao();
        Moedas ethereumMoeda = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethereumMoeda;
        double taxaVenda = ethereum.getTaxaVenda();
        double vendaEthereum = (venda / cotacaoEthereum) * (1 + taxaVenda);
        double saldoEthereumAtual = saldoEthereum - vendaEthereum;
        if (saldoEthereumAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            double saldoRealAtual = saldoReal + venda;
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoRealAtual);
            investidor.getCarteira().getMoedas().get(2).setSaldo(saldoEthereumAtual);
            JOptionPane.showMessageDialog(view, "Venda realizada!");
            Conexao conexao = new Conexao();
        
            try{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarEthereum(investidor);
                dao.atualizarReal(investidor);
                ResultSet res = dao.consultarSenha(investidor);
                if(res.next()){
                    int id = res.getInt("id");
                    dao.extratoVendaEthereum(investidor, venda, id);
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
