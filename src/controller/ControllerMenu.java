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

/**
 *
 * @author eric song
 */
public class ControllerMenu {
    private JanelaMenu view;
    private Pessoa pessoa;

    public ControllerMenu(JanelaMenu view, Pessoa pessoa) {
        this.view = view;
        this.pessoa = pessoa;
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
    
}
