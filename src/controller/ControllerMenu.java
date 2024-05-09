/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.Conexao;
import DAO.PessoaDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;
import view.JanelaMenu;
import view.JanelaSenhaConsultarSaldo;
import view.JanelaConsultarSaldo;
import view.JanelaDepositar;
import view.JanelaSenhaDepositar;

/**
 *
 * @author eric song
 */
public class ControllerMenu {
    private JanelaMenu view;
    private JanelaSenhaConsultarSaldo viewSC;
    private JanelaSenhaDepositar viewSD;
    private JanelaDepositar viewD;
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

    public ControllerMenu(JanelaDepositar viewD) {
        this.viewD = viewD;
    }
    
    public JanelaMenu getView() {
        return view;
    }

    public void setView(JanelaMenu view) {
        this.view = view;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public void ConsultarSaldo(){
        Pessoa pessoa = new Pessoa(null, view.getCpfLbl().getText(), 
                                      viewSC.getSenhaTxt().getText());   
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            PessoaDAO dao = new PessoaDAO(conn, view);
            ResultSet res = dao.consultarSaldo(pessoa);
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
            ResultSet res = dao.consultarSaldo(pessoa);
            if(res.next()){
                double saldoReal = res.getDouble("saldoReal");
                JOptionPane.showMessageDialog(view, "Dados corretos!");
                JanelaDepositar d = new JanelaDepositar(saldoReal);
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
            ResultSet res = dao.consultarSaldo(pessoa);
            double saldoReal = res.getDouble("saldoReal");
            String depositoString = viewD.getDepositoTxt().getText();
            double deposito = Double.parseDouble(depositoString);
            saldoReal = saldoReal + deposito;
            // CONTINUAR AQUI (IR NO PESSOA DAO)
            JanelaDepositar d = new JanelaDepositar(saldoReal);
            viewSD.setVisible(false);
            d.setVisible(true);
            
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(view, "Erro de conexao!");
        }
    }
    
}
