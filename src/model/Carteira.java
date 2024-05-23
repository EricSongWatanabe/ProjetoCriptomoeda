/*
 * Assim que a carteira é criada, é criada também uma ArrayList de moedas.
 */
package model;
import java.util.ArrayList;

/**
 *
 * @author eric song
 */
public class Carteira {
    ArrayList<Moedas> moedas;

    public Carteira() {
        moedas  = new ArrayList<Moedas>();
        moedas.add(new Real(0, 0));
        moedas.add(new Bitcoin(0, 316107.20));
        moedas.add(new Ethereum(0, 15074.56));
        moedas.add(new Ripple(0, 2.58));
    }

    public Carteira(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<Moedas> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<Moedas> moedas) {
        this.moedas = moedas;
    }
    
    @Override
    public String toString() {
        return "Carteira{" + "moedas=" + moedas + '}';
    }
}