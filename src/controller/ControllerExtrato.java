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
import view.JanelaExtrato;
import java.text.DecimalFormat;

/**
 *
 * @author unifewatanabe
 */
public class ControllerExtrato {
    private Investidor investidor;
    private JanelaExtrato view;

    public ControllerExtrato(Investidor investidor, JanelaExtrato view) {
        this.investidor = investidor;
        this.view = view;
    }
    
    public void mostratExtrato(){
        view.getExtratoPane().setText("");
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            InvestidorDAO dao = new InvestidorDAO(conn);
            ResultSet res = dao.consultarSenha(investidor);
            if(res.next()){
                int id = res.getInt("id");
                int tamanho = dao.maiorLog();
                for(int i = 1; i<=tamanho ;i++){
                    ResultSet res1 = dao.consultarExtrato(investidor, id, i);
                    if(res1.next()){
                        String nome = investidor.getNome();
                        String data = res1.getString("data");
                        String hora = res1.getString("hora");
                        String tipo = res1.getString("tipo");
                        double valor = res1.getDouble("valor");
                        String moeda = res1.getString("moeda");
                        double cotacao = res1.getDouble("cotacao");
                        double taxa = res1.getDouble("taxa");
                        double saldoReal = res1.getDouble("saldoReal");
                        double saldoBitcoin = res1.getDouble("saldoBitcoin");
                        double saldoEthereum = res1.getDouble("saldoEthereum");
                        double saldoRipple = res1.getDouble("saldoRipple");
                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        String formatadoCotacao = decimalFormat.format(cotacao);
                        String formatadoSaldoReal = decimalFormat.format(saldoReal);
                        String formatadoSaldoBitcoin = decimalFormat.format(saldoBitcoin);
                        String formatadoSaldoEthereum = decimalFormat.format(saldoEthereum);
                        String formatadoSaldoRipple = decimalFormat.format(saldoRipple);
                        String texto = view.getExtratoPane().getText();
                        String linha = nome + ":\t " + data + " | " + hora + " | " + moeda + 
                                ": " + tipo + " " + valor + " | CT: " + formatadoCotacao +
                                " TX: " + taxa + " | Real: " + formatadoSaldoReal + 
                                " Bitcoin: " + formatadoSaldoBitcoin + " Ethereum: " + 
                                formatadoSaldoEthereum + " Ripple: " + formatadoSaldoRipple;
                        view.getExtratoPane().setText(texto + "\n" + linha + "\n");
                    }
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro ao mostrar o extrato!");
        }
    }
    
    public void voltar(){
        view.setVisible(false);
    }
}
