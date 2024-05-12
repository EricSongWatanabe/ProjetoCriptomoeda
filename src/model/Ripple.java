/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eric song
 */
public class Ripple extends Moedas implements Tarifacao {
    public Ripple(double saldo, double cotacao) {
        super(saldo, cotacao);
    }
    
    public Ripple(double saldo) {
        super(saldo);
    }
    
    @Override
    public double getTaxaCompra() {
        return 0.01;
    }

    @Override
    public double getTaxaVenda() {
        return 0.01;
    }
}

