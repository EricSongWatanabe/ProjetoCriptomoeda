
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
        moedas.add(new Real(0));
        moedas.add(new Bitcoin(0));
        moedas.add(new Ethereum(0));
        moedas.add(new Ripple(0));
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