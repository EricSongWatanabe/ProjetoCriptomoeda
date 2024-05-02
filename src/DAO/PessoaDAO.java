package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Pessoa;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eric song
 */
public class PessoaDAO {
    private Connection conn;

        public PessoaDAO(Connection conn) {
            this.conn = conn;
        }
    
//    public ResultSet consultar(Pessoa pessoa) throws SQLException{;
//        String sql = "select * from aluno where usuario = ? and senha = ?";
//        
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, pessoa.getUsuario());
//        statement.setString(2, pessoa.getSenha());
//        statement.execute();
//        ResultSet resultado = statement.getResultSet();
//        return resultado;
//    }
    
    public void inserir(Pessoa pessoa) throws SQLException{; //AINDA MEXER
        String sql = "insert into aluno (nome, cpf, senha, saldoReal, "
                + "saldoBitcoin, saldoEthereum, saldoRipple) values ('" +
                pessoa.getNome() + "', '" + 
                pessoa.getCpf() + "', '" +
                pessoa.getSenha() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();
        conn.close();
    }
    
//    public void excluir(Aluno aluno) throws SQLException {
//        String sql = "delete from aluno where usuario = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, aluno.getUsuario());
//        statement.execute();
//        conn.close();
//    }
    
//    public void atualizar(Aluno aluno) throws SQLException {
//        String sql = "update aluno set senha = ? where usuario = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, aluno.getSenha());
//        statement.setString(2, aluno.getUsuario());
//        statement.execute();
//        conn.close();
//        
//    }
}
