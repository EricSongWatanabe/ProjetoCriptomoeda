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
    private double cotacao;
    public Bitcoin(double saldo) {
        super(saldo);
        this.cotacao = 0.0000031;
    }

    public Bitcoin() {
        this.cotacao = 0.0000031;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
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

