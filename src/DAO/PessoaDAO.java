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
    
    public ResultSet consultar(Pessoa pessoa) throws SQLException{;
        String sql = "select * from pessoa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    public void inserir(Pessoa pessoa) throws SQLException {
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id) FROM pessoa");;
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;

        String sql = "insert into pessoa(id, nome, cpf, senha, \"saldoReal\", "
                + "\"saldoBitcoin\", \"saldoEthereum\", \"saldoRipple\") values "
                + "(" + novoId + ", ?, ?, ?, 0.0, 0.0, 0.0, 0.0)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getCpf());
        statement.setString(3, pessoa.getSenha());


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
    
//    public void atualizar(Pessoa pessoa) throws SQLException {
//        String sql = "update aluno set senha = ? where usuario = ?";
//        PreparedStatement statement = conn.prepareStatement(sql);
//        statement.setString(1, aluno.getSenha());
//        statement.setString(2, aluno.getUsuario());
//        statement.execute();
//        conn.close();
//        
//    }
}
