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
import view.JanelaVenderRipple;
import view.JanelaConsultarSaldo;

/**
 *
 * @author eric song
 */
public class ControllerVenderRipple {
    private Investidor investidor;
    private JanelaVenderRipple view;

    public ControllerVenderRipple(Investidor investidor, JanelaVenderRipple view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void venderRipple(){
        String vendaString = view.getRippleTxt().getText();
        double venda = Double.parseDouble(vendaString);
        double saldoReal = investidor.getCarteira().getMoedas().get(0).getSaldo();
        
        double saldoRipple = investidor.getCarteira().getMoedas().get(3).getSaldo();
        double cotacaoRipple = investidor.getCarteira().getMoedas().get(3).getCotacao();
        Moedas rippleMoeda = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) rippleMoeda;
        double taxaVenda = ripple.getTaxaVenda();
        double vendaRipple = (venda / cotacaoRipple) * (1 + taxaVenda);
        double saldoRippleAtual = saldoRipple - vendaRipple;
        if (saldoRippleAtual < 0){
            JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
        } else{
            double saldoRealAtual = saldoReal + venda;
            investidor.getCarteira().getMoedas().get(0).setSaldo(saldoRealAtual);
            investidor.getCarteira().getMoedas().get(3).setSaldo(saldoRippleAtual);
            JOptionPane.showMessageDialog(view, "Venda realizada!");
            Conexao conexao = new Conexao();

            try{
                Connection conn = conexao.getConnection();
                InvestidorDAO dao = new InvestidorDAO(conn);
                dao.atualizarRipple(investidor);
                dao.atualizarReal(investidor);
                ResultSet res = dao.consultarSenha(investidor);
                if(res.next()){
                    int id = res.getInt("id");
                    dao.extratoVendaRipple(investidor, venda, id);
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
