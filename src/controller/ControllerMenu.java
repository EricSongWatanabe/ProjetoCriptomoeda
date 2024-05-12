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
import view.JanelaMenu;
import java.util.Random;
import model.Carteira;



/**
 *
 * @author eric song
 */
public class ControllerMenu {
    private Investidor investidor;
    private JanelaMenu view;
    
    public JanelaMenu getView() {
        return view;
    }

    public void setView(JanelaMenu view) {
        this.view = view;
    }

//    public ControllerMenu(Investidor investidor, JanelaMenu view) {
//        this.investidor = investidor;
//        this.view = view;
//    }
    
    
    
    public ControllerMenu(Investidor investidor, JanelaMenu view) {
        this.view = view;
        if (investidor.getCarteira() == null) {
            investidor.setCarteira(new Carteira());
        }
        this.investidor = investidor;
    }
    
    
    
    
    
    public void atualizarCotacao(){
        String cpf = view.getCpfLbl().getText();
        Conexao conexao = new Conexao();
        Random random = new Random();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn, view);
            ResultSet res = dao.consultarCpf(cpf);
            if(res.next()){
                double cotacaoBitcoin = res.getDouble("cotacaoBitcoin");
                double cotacaoEthereum = res.getDouble("cotacaoEthereum");
                double cotacaoRipple = res.getDouble("cotacaoRipple");
                
                double variacaoBitcoin = (random.nextDouble() * 0.1 - 0.05) * cotacaoBitcoin;
                double variacaoEthereum = (random.nextDouble() * 0.1 - 0.05) * cotacaoEthereum;
                double variacaoRipple = (random.nextDouble() * 0.1 - 0.05) * cotacaoRipple;

                cotacaoBitcoin += variacaoBitcoin;
                cotacaoEthereum += variacaoEthereum;
                cotacaoRipple += variacaoRipple;
                
                investidor.getCarteira().getMoedas().get(1).setCotacao(cotacaoBitcoin);
                investidor.getCarteira().getMoedas().get(2).setCotacao(cotacaoEthereum);
                investidor.getCarteira().getMoedas().get(3).setCotacao(cotacaoRipple);
                
                dao.atualizarCotacoes(investidor);
                
                JOptionPane.showMessageDialog(view, "Cotacoes atualizadas!");
                
            } else {
                JOptionPane.showMessageDialog(view, "CPF nao encontrado");
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
    
}