/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Investidor;
import view.JanelaVenderCripto;

/**
 *
 * @author eric song
 */
public class ControllerVenderCripto {
    private JanelaVenderCripto view;
    private Investidor investidor;

    public ControllerVenderCripto(JanelaVenderCripto view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    
}
