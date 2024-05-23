/*
 * Quando o investidor é criado, é criado juntamente um objeto Carteira.
 */
package model;

/**
 *
 * @author eric song
 */
public class Investidor extends Pessoa{
   private Carteira carteira;

    public Investidor(Carteira carteira, String nome, String cpf, String senha){
        super(nome, cpf, senha);
        this.carteira = carteira;
    }
  
    public Investidor(String nome, String cpf, String senha) {
        super(nome, cpf, senha);
        this.carteira = new Carteira();
    }
    
    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public String toString() {
        return "Investidor{" + "carteira=" + carteira + '}';
    }
   
    
}
