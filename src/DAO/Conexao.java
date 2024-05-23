/*
 * Classe para estabelecer conexao entre o programa de Java e o banco de dados PostgreSQL
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author eric song
 */
public class Conexao {
    public Connection getConnection() throws SQLException{
        Connection conexao = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/pessoas",
                "postgres", "fei");
        return conexao;
    }
}