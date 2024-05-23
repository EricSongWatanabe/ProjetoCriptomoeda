/*
 * Superclasse que dá atributos para cada investidor (nome, cpf, senha)
 */
package model;

/**
 *
 * @author eric song
 */
public class Pessoa {
    private String nome, cpf, senha;

    public Pessoa(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", senha=" + senha + '}';
    }
    
    
}
