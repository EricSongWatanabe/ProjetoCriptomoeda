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
    
    
    
}