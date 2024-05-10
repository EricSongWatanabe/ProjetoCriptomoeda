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
import model.Pessoa;
import view.JanelaMenu;
import view.JanelaSenhaConsultarSaldo;
import view.JanelaConsultarSaldo;
import view.JanelaDepositar;
import view.JanelaSacar;
import view.JanelaSenhaDepositar;
import view.JanelaSenhaSacar;

/**
 *
 * @author eric song
 */
public class ControllerMenu {
    private Investidor investidor;
    private JanelaMenu view;
<<<<<<< HEAD
=======
    private JanelaSenhaConsultarSaldo viewSC;
    private JanelaSenhaDepositar viewSD;
    private JanelaDepositar viewD;
    private JanelaSenhaSacar viewSS;
    private JanelaSacar viewS;
    private Pessoa pessoa;

    public ControllerMenu(JanelaMenu view, Pessoa pessoa) {
        this.view = view;
        this.pessoa = pessoa;
    }

    public ControllerMenu(JanelaSenhaConsultarSaldo viewSC, JanelaMenu view) {
        this.view = view;
        this.viewSC = viewSC;
    }

    public ControllerMenu(JanelaSenhaDepositar viewSD, JanelaMenu view) {
        this.view = view;
        this.viewSD = viewSD;
    }

    public ControllerMenu(JanelaDepositar viewD, JanelaMenu view) {
        this.viewD = viewD;
        this.view = view;
    }

    public ControllerMenu(JanelaSenhaSacar viewSS, JanelaMenu view) {
        this.view = view;
        this.viewSS = viewSS;
    }
    
    public ControllerMenu(JanelaSacar viewS, JanelaMenu view) {
        this.view = view;
        this.viewS = viewS;
    }
    
    
    
    
    
>>>>>>> 537e604aec26ca7a2db57475195c4768e26fce3c
    
    public JanelaMenu getView() {
        return view;
    }

    public void setView(JanelaMenu view) {
        this.view = view;
    }

    public ControllerMenu(Investidor investidor, JanelaMenu view) {
        this.investidor = investidor;
        this.view = view;
    }
    
<<<<<<< HEAD
    
    
}
=======
    public void consultarSaldo(){
        Pessoa pessoa = new Pessoa(null, view.getCpfLbl().getText(), 
                                      viewSC.getSenhaTxt().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn, view);
            ResultSet res = dao.consultarSenha(pessoa);
            if(res.next()){
                String nome = res.getString("nome");
                String cpf = res.getString("cpf");
                double saldoReal = res.getDouble("saldoReal");
                double saldoBitcoin = res.getDouble("saldoBitcoin");
                double saldoEthereum = res.getDouble("saldoEthereum");
                double saldoRipple = res.getDouble("saldoRipple");
                JOptionPane.showMessageDialog(view, "Dados corretos!");
                JanelaConsultarSaldo c = new JanelaConsultarSaldo(nome, cpf,
                        saldoReal, saldoBitcoin, saldoEthereum, saldoRipple);
                viewSC.setVisible(false);
                c.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta");
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
    public void senhaDepositar(){
        Pessoa pessoa = new Pessoa(null, view.getCpfLbl().getText(), 
                                      viewSD.getSenhaTxt().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn, view);
            ResultSet res = dao.consultarSenha(pessoa);
            if(res.next()){
                double saldoReal = res.getDouble("saldoReal");
                JOptionPane.showMessageDialog(view, "Dados corretos!");
                JanelaDepositar d = new JanelaDepositar(saldoReal, view);
                viewSD.setVisible(false);
                d.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta");
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
    public void depositar(){
        Pessoa pessoa = new Pessoa(null, view.getCpfLbl().getText(), 
                                      null);   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn, view);
            ResultSet res = dao.consultarSenhaPeloCpf(pessoa);
            if(res.next()){
                double real = res.getDouble("saldoReal");
                String depositoString = viewD.getDepositoTxt().getText();
                double deposito = Double.parseDouble(depositoString);
                double saldoAtual = real + deposito;
                dao.atualizarDeposito(pessoa, saldoAtual);
                JOptionPane.showMessageDialog(view, "Deposito feito!");
                JanelaDepositar d = new JanelaDepositar(real, view);
                viewD.setVisible(false);
                view.setVisible(true);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
    public void senhaSacar(){
        Pessoa pessoa = new Pessoa(null, view.getCpfLbl().getText(), 
                                      viewSS.getSenhaTxt().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn, view);
            ResultSet res = dao.consultarSenha(pessoa);
            if(res.next()){
                double saldoReal = res.getDouble("saldoReal");
                JOptionPane.showMessageDialog(view, "Dados corretos!");
                JanelaSacar s = new JanelaSacar(saldoReal, view);
                viewSS.setVisible(false);
                s.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(view, "Senha incorreta");
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
    public void sacar(){
        Pessoa pessoa = new Pessoa(null, view.getCpfLbl().getText(), 
                                      null);   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn, view);
            ResultSet res = dao.consultarSenhaPeloCpf(pessoa);
            if(res.next()){
                double real = res.getDouble("saldoReal");
                String saqueString = viewS.getSaqueTxt().getText();
                double deposito = Double.parseDouble(saqueString);
                double saldoAtual = real - deposito;
                if (saldoAtual < 0){
                    JOptionPane.showMessageDialog(view, "Saldo insuficiente!");
                } else {
                    JOptionPane.showMessageDialog(view, "Saque feito!");
                    dao.atualizarDeposito(pessoa, saldoAtual);
                }
                
                viewS.setVisible(false);
                view.setVisible(true);
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
}
>>>>>>> 537e604aec26ca7a2db57475195c4768e26fce3c
