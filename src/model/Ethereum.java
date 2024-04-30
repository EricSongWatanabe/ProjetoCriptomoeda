/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eric song
 */
public class Ethereum extends Moedas implements Tarifacao {
    private Real real;
    double cotacao = 0.000060;
    public Ethereum(double saldo, Real real) {
        super(saldo);
        this.real = real;
    }

    public Ethereum(Real real) {
        this.real = real;
    }

    public Ethereum(double saldo) {
        super(saldo);
    }
    
    public void depositar(double valor) {
        double valorEthereum = valor * cotacao;
        setSaldo(getSaldo() + valorEthereum);
        
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
    
    @Override
    public double getTaxaCompra() {
        return 0.01;
    }

    @Override
    public double getTaxaVenda() {
        return 0.01;
    }
}