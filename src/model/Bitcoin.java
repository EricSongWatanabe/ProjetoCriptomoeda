/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eric song
 */
public class Bitcoin extends Moedas implements Tarifacao {
    public Bitcoin(double saldo, double cotacao) {
        super(saldo, cotacao);
    }

    public Bitcoin(double saldo) {
        super(saldo);
    }
    
    @Override
    public double getTaxaCompra() {
        return 0.02;
    }

    @Override
    public double getTaxaVenda() {
        return 0.03;
    }
}

