/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Investidor;
import view.JanelaComprarCripto;

/**
 *
 * @author eric song
 */
public class ControllerComprarCripto {
    private JanelaComprarCripto view;
    private Investidor investidor;

    public ControllerComprarCripto(JanelaComprarCripto view, Investidor investidor) {
        this.view = view;
        this.investidor = investidor;
    }
    
    
}
