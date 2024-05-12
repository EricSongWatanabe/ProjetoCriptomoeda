/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author eric song
 */
public class SenhaInvalidaException extends Exception {
    public SenhaInvalidaException(String mensagem) {
        super(mensagem);
    }
}
