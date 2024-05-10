package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Pessoa;
import view.JanelaMenu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eric song
 */
public class PessoaDAO {
    private JanelaMenu viewJ;
    private Connection conn;

    public PessoaDAO(Connection conn, JanelaMenu viewJ) {
        this.conn = conn;
        this.viewJ = viewJ;
    }

    public PessoaDAO(Connection conn) {
        this.conn = conn;
    }
        
        
    
    public ResultSet consultar(Pessoa pessoa) throws SQLException{
        String sql = "select * from pessoa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getCpf());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet senha(Pessoa pessoa) throws SQLException{
        String sql = "select * from pessoa where senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, pessoa.getSenha());
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
    
    public ResultSet consultarSenha(Pessoa pessoa) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE cpf = ? AND senha = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, viewJ.getCpfLbl().getText());
        statement.setString(2, pessoa.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultarSenhaPeloCpf(Pessoa pessoa) throws SQLException {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, viewJ.getCpfLbl().getText());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public void atualizarDeposito(Pessoa pessoa, double saldoAtual) throws SQLException {
        String sql = "update pessoa set \"saldoReal\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, saldoAtual);
        statement.setString(2, viewJ.getCpfLbl().getText());
        statement.executeUpdate();
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
