/*
 * Classe destinada a criptomoeda Ethereum.
 */
package model;

/**
 *
 * @author eric song
 */
public class Ethereum extends Moedas implements Tarifacao {
    private double cotacao;
    public Ethereum(double saldo, double cotacao) {
        super(saldo, cotacao);
    }
    
    public Ethereum(double saldo) {
        super(saldo);
    }
    
    @Override
    public double getTaxaCompra() {
        return 0.01;
    }

    @Override
    public double getTaxaVenda() {
        return 0.02;
    }
}
