
import view.JanelaEntrada;
import model.Carteira;
import model.Investidor;
import model.Moedas;
import model.Real;
import model.Bitcoin;
import model.Ethereum;
import model.Ripple;
import java.util.Random;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eric song
 */
//public class Main {
//    
//    public static void main(String[] args) {
//        Janela j = new Janela();
//        j.setVisible(true);
//    }
//}

public class Main {
    public static void main(String[] args) {
        JanelaEntrada j = new JanelaEntrada();
        j.setVisible(true);
        
        // Criando as moedas
        Real real = new Real(1000.0);
        Bitcoin bitcoin = new Bitcoin(0.0, real);
        Ethereum ethereum = new Ethereum(0.0, real);
        Ripple ripple = new Ripple(0.0, real);
        
        // Criando a carteira
        Carteira carteira = new Carteira(bitcoin, ethereum, ripple);

        // Realizando depósitos em cada moeda
        real.depositar(500.0);
        System.out.println("Deposito feito REAL\n");
        bitcoin.depositar(0.05);
        System.out.println("Deposito feito B\n");
        ethereum.depositar(0.1);
        System.out.println("Deposito feito E\n");
        ripple.depositar(100.0);
        System.out.println("Deposito feito R\n");
        
        
        System.out.println("\n\nSaldos apos o deposito:");
        System.out.println("Saldo em Real: R$" + real.getSaldo());
        System.out.println("Saldo em Bitcoin: " + bitcoin.getSaldo());
        System.out.println("Saldo em Ethereum: " + ethereum.getSaldo());
        System.out.println("Saldo em Ripple: " + ripple.getSaldo() + "\n\n");
        
        
        // Realizando saques em cada moeda
        real.sacar(300.0);
        System.out.println("Saque feito REAL\n");
        bitcoin.sacar(0.00000003);
        System.out.println("Saque feito B\n");
        ethereum.sacar(0.000005);
        System.out.println("Saque feito E\n");
        ripple.sacar(20.0);
        System.out.println("Saque feito R\n");

        // Imprimindo os saldos antes da atualização das cotações
        System.out.println("\n\nSaldos antes da atualização das cotações:");
        System.out.println("Saldo em Real: R$" + real.getSaldo());
        System.out.println("Saldo em Bitcoin: " + bitcoin.getSaldo());
        System.out.println("Saldo em Ethereum: " + ethereum.getSaldo());
        System.out.println("Saldo em Ripple: " + ripple.getSaldo() + "\n\n");

        // Atualizando as cotações de todas as moedas
        carteira.atualizarCotacoes();

        // Imprimindo as cotações atualizadas
        System.out.println("\n\nCotações atualizadas:");
        System.out.println("Cotação do Bitcoin: " + bitcoin.getCotacao());
        System.out.println("Cotação do Ethereum: " + ethereum.getCotacao());
        System.out.println("Cotação do Ripple: " + ripple.getCotacao() + "\n\n");
    }
}