

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Random;

/**
 *
 * @author eric song
 */
public class Carteira {
    private Moedas moedas;
    private Bitcoin bitcoin;
    private Ethereum ethereum;
    private Ripple ripple;

    public Carteira(Bitcoin bitcoin, Ethereum ethereum, Ripple ripple) {
        this.bitcoin = bitcoin;
        this.ethereum = ethereum;
        this.ripple = ripple;
    }

    public Carteira() {
        this.moedas = new Moedas();
    }

    public Moedas getMoedas() {
        return moedas;
    }

    public void setMoedas(Moedas moedas) {
        this.moedas = moedas;
    }
    
    public void atualizarCotacoes() {
        Random random = new Random();
        
        double variacaoBitcoin = random.nextDouble() * 0.1 - 0.05;
        bitcoin.atualizarCotacao(variacaoBitcoin);
        
        double variacaoEthereum = random.nextDouble() * 0.1 - 0.05;
        ethereum.atualizarCotacao(variacaoEthereum);
        
        double variacaoRipple = random.nextDouble() * 0.1 - 0.05;
        ripple.atualizarCotacao(variacaoRipple);
    }
    
    @Override
    public String toString() {
        return "Carteira{" + "moedas=" + moedas + '}';
    }
}