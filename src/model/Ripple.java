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
    private Real real;
    private double cotacao;
    public Ripple(double saldo, Real real) {
        super(saldo);
        this.real = real;
        this.cotacao = 0.38121;
    }

    public Ripple(Real real) {
        this.real = real;
    }

    public Ripple(double saldo) {
        super(saldo);
    }

    public Real getReal() {
        return real;
    }

    public void setReal(Real real) {
        this.real = real;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
    
    public void depositar(double valor) {
        double valorRipple = valor * cotacao;
        setSaldo(getSaldo() + valorRipple);
        
        real.setSaldo(real.getSaldo() - valor * (1 + getTaxaCompra()));
    }

    public void sacar(double valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            
            // Calcula o valor equivalente em Real e atualiza o saldo de Real
            double valorReal = valor / cotacao;
            real.setSaldo(real.getSaldo() + valorReal * (1 - getTaxaVenda()));
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    
    public void atualizarCotacao(double variacao) {
        cotacao += cotacao * variacao;
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

