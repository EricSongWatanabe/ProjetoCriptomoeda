/*
 * Classe de moedas que é de uma arraylist.
 */
package model;

/**
 *
 * @author eric song
 */
public class Moedas {
    private double saldo;
    private double cotacao;

    public Moedas() {
        saldo = 0;
    }

    public Moedas(double saldo, double cotacao) {
        this.saldo = saldo;
        this.cotacao = cotacao;
    }

    public Moedas(double saldo) {
        this.saldo = saldo;
    }
    
    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Moedas{" + "saldo=" + saldo + '}';
    }
    
}