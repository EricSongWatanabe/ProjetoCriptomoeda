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
import model.Ripple;
import model.Investidor;
import model.Moedas;
import view.JanelaComprarRipple;
import view.JanelaConsultarSaldo;

/**
 *
 * @author eric song
 */
public class ControllerComprarRipple {
    private Investidor investidor;
    private JanelaComprarRipple view;

    public ControllerComprarRipple(Investidor investidor, JanelaComprarRipple view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void comprarRipple(){
        String compraString = view.getRippleTxt().getText();
        double compra = Double.parseDouble(compraString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        
        double saldoRipple = investidor.getCarteira().getMoedas().get(3).getSaldo();
        double cotacaoRipple = investidor.getCarteira().getMoedas().get(3).getCotacao();
        Moedas rippleMoeda = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) rippleMoeda;
        double taxaCompra = ripple.getTaxaCompra();
        double saldoRealAtual = saldoReal - compra * (1 + taxaCompra);
        if (saldoRealAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoRealAtual);
            double compraRipple = compra / cotacaoRipple;
            double saldoRippleAtual = saldoRipple + compraRipple;
            investidor.getCarteira().getMoedas().get(3).setSaldo(saldoRippleAtual);
            JOptionPane.showMessageDialog(view, "Compra realizada!");
            Conexao conexao = new Conexao();
        
            try{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarRipple(investidor);
                dao.atualizarReal(investidor);
                ResultSet res = dao.consultarSenha(investidor);
                if(res.next()){
                    int id = res.getInt("id");
                    dao.extratoCompraRipple(investidor, compra, id);
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
