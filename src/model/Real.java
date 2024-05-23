/*
 * Classe destinada a moeda Real
 */
package model;

/**
 *
 * @author eric song
 */
public class Real extends Moedas implements Tarifacao {
    public Real(double saldo, double cotacao) {
        super(saldo, cotacao);
    }
    
    public Real(double saldo) {
        super(saldo);
    }
    
    @Override
    public double getTaxaCompra() {
        return 0.00;
    }

    @Override
    public double getTaxaVenda() {
        return 0.00;
    }
}

