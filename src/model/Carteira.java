/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author eric song
 */
public class Carteira {
    private Moedas moedas;

    public Carteira() {
        this.moedas = new Moedas();
    }

    public Moedas getMoedas() {
        return moedas;
    }

    public void setMoedas(Moedas moedas) {
        this.moedas = moedas;
    }

    @Override
    public String toString() {
        return "Carteira{" + "moedas=" + moedas + '}';
    }

    
}

