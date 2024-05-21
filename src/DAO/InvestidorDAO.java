package DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import model.Investidor;
import view.JanelaMenu;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import model.Bitcoin;
import model.Ethereum;
import model.Moedas;
import model.Real;
import model.Ripple;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author eric song
 */
public class InvestidorDAO {
    private JanelaMenu viewJ;
    private Connection conn;

    public InvestidorDAO(Connection conn, JanelaMenu viewJ) {
        this.conn = conn;
        this.viewJ = viewJ;
    }

    public InvestidorDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultarSenha(Investidor investidor) throws SQLException{
        String sql = "select * from pessoa where cpf = ? and senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getCpf());
        statement.setString(2, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public ResultSet consultarCpf(String cpf) throws SQLException{
        String sql = "select * from pessoa where cpf = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, cpf);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    
    
    public ResultSet senha(Investidor investidor) throws SQLException{
        String sql = "select * from pessoa where senha = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, investidor.getSenha());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }

    public void inserir(Investidor investidor) throws SQLException {
        String sqlCPF = "SELECT COUNT(*) FROM pessoa WHERE cpf = ?";
        PreparedStatement statementVerificarCPF = conn.prepareStatement(sqlCPF);
        statementVerificarCPF.setString(1, investidor.getCpf());
        ResultSet resultadoVerificarCPF = statementVerificarCPF.executeQuery();
        resultadoVerificarCPF.next();
        int contador = resultadoVerificarCPF.getInt(1);

        if (contador > 0) {
            throw new SQLException("CPF já cadastrado.");
        }

        String sqlCotacoes = "SELECT \"cotacaoBitcoin\", \"cotacaoEthereum\", \"cotacaoRipple\" FROM pessoa WHERE id = 0";
        PreparedStatement statementCotacoes = conn.prepareStatement(sqlCotacoes);
        ResultSet resultadoCotacoes = statementCotacoes.executeQuery();
        if(resultadoCotacoes.next()){
            double cotacaoBitcoin = resultadoCotacoes.getDouble("cotacaoBitcoin");
            double cotacaoEthereum = resultadoCotacoes.getDouble("cotacaoEthereum");
            double cotacaoRipple = resultadoCotacoes.getDouble("cotacaoRipple");
            
            investidor.getCarteira().getMoedas().get(1).setCotacao(cotacaoBitcoin);
            investidor.getCarteira().getMoedas().get(2).setCotacao(cotacaoEthereum);
            investidor.getCarteira().getMoedas().get(3).setCotacao(cotacaoRipple);
        
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id) FROM pessoa");
            int ultimoId = 0;
            if (resultSet.next()) {
                ultimoId = resultSet.getInt(1);
            }

            int novoId = ultimoId + 1;

            String sqlInserir = "INSERT INTO pessoa(id, nome, cpf, senha, "
                    + "\"saldoReal\", \"saldoBitcoin\", \"saldoEthereum\", "
                    + "\"saldoRipple\", \"cotacaoBitcoin\", \"cotacaoEthereum\","
                    + " \"cotacaoRipple\") "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sqlInserir);
            statement.setInt(1, novoId);
            statement.setString(2, investidor.getNome());
            statement.setString(3, investidor.getCpf());
            statement.setString(4, investidor.getSenha());
            statement.setDouble(5, investidor.getCarteira().getMoedas().get(0).getSaldo());
            statement.setDouble(6, investidor.getCarteira().getMoedas().get(1).getSaldo());
            statement.setDouble(7, investidor.getCarteira().getMoedas().get(2).getSaldo());
            statement.setDouble(8, investidor.getCarteira().getMoedas().get(3).getSaldo());
            statement.setDouble(9, cotacaoBitcoin);
            statement.setDouble(10, cotacaoEthereum);
            statement.setDouble(11, cotacaoRipple);
            statement.execute();
        }
        conn.close();
    }


    
    public void atualizarReal(Investidor investidor) throws SQLException {
        String sql = "update pessoa set \"saldoReal\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        statement.execute();
//        conn.close();
    }
    
    public void atualizarBitcoin(Investidor investidor) throws SQLException {
        String sql = "update pessoa set \"saldoBitcoin\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        statement.execute();
    }
    
    public void atualizarEthereum(Investidor investidor) throws SQLException {
        String sql = "update pessoa set \"saldoEthereum\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        statement.execute();
    }
    
    public void atualizarRipple(Investidor investidor) throws SQLException {
        String sql = "update pessoa set \"saldoRipple\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        statement.execute();
    }
    
    public void atualizarSaque(Investidor investidor) throws SQLException {
        String sql = "update pessoa set \"saldoReal\" = ? where cpf = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setString(2, investidor.getCpf());
        statement.executeUpdate();
        statement.execute();
//        conn.close();
    }
    
    public void atualizarCotacoes(Investidor investidor) throws SQLException {
        String sql = "UPDATE pessoa SET \"cotacaoBitcoin\" = ?, \"cotacaoEthereum\" = ?, \"cotacaoRipple\" = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setDouble(1, investidor.getCarteira().getMoedas().get(1).getCotacao());
        statement.setDouble(2, investidor.getCarteira().getMoedas().get(2).getCotacao());
        statement.setDouble(3, investidor.getCarteira().getMoedas().get(3).getCotacao());
        statement.executeUpdate();
    }

    public void extratoDeposito(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas realMoeda = investidor.getCarteira().getMoedas().get(0);
        Real real = (Real) realMoeda;
        double taxaCompra = real.getTaxaCompra();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "+");
        statement.setDouble(4, valor);
        statement.setString(5, "Real");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(0).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoSaque(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas realMoeda = investidor.getCarteira().getMoedas().get(0);
        Real real = (Real) realMoeda;
        double taxaCompra = real.getTaxaVenda();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "-");
        statement.setDouble(4, valor);
        statement.setString(5, "Real");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(0).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoCompraBitcoin(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas bitcoinMoeda = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitcoinMoeda;
        double taxaCompra = bitcoin.getTaxaCompra();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "+");
        statement.setDouble(4, valor);
        statement.setString(5, "Bitcoin");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(1).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoVendaBitcoin(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas bitcoinMoeda = investidor.getCarteira().getMoedas().get(1);
        Bitcoin bitcoin = (Bitcoin) bitcoinMoeda;
        double taxaCompra = bitcoin.getTaxaVenda();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "-");
        statement.setDouble(4, valor);
        statement.setString(5, "Bitcoin");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(1).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoCompraEthereum(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas ethereumMoeda = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethereumMoeda;
        double taxaCompra = ethereum.getTaxaCompra();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "+");
        statement.setDouble(4, valor);
        statement.setString(5, "Ethereum");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(2).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoVendaEthereum(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas ethereumMoeda = investidor.getCarteira().getMoedas().get(2);
        Ethereum ethereum = (Ethereum) ethereumMoeda;
        double taxaCompra = ethereum.getTaxaVenda();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "-");
        statement.setDouble(4, valor);
        statement.setString(5, "Ethereum");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(2).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoCompraRipple(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas rippleMoeda = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) rippleMoeda;
        double taxaCompra = ripple.getTaxaCompra();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "+");
        statement.setDouble(4, valor);
        statement.setString(5, "Ripple");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(3).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public void extratoVendaRipple(Investidor investidor, double valor, int id) throws SQLException{
        ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
        int ultimoId = 0;
        if (resultSet.next()) {
            ultimoId = resultSet.getInt(1);
        }

        int novoId = ultimoId + 1;
        Date currentDate = new Date();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        String date = dateFormat.format(currentDate);
        
        LocalTime currentTime = LocalTime.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String time = currentTime.format(formatter);
        
        Moedas rippleMoeda = investidor.getCarteira().getMoedas().get(3);
        Ripple ripple = (Ripple) rippleMoeda;
        double taxaCompra = ripple.getTaxaVenda();
        
        String sqlInserir = "INSERT INTO log(id_log, id_inv, tipo, "
                + "valor, moeda, cotacao, taxa, \"saldoReal\", \"saldoBitcoin\","
                + " \"saldoEthereum\", \"saldoRipple\", hora, data) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sqlInserir);
        statement.setInt(1, novoId);
        statement.setInt(2, id);        
        statement.setString(3, "-");
        statement.setDouble(4, valor);
        statement.setString(5, "Ripple");
        statement.setDouble(6, investidor.getCarteira().getMoedas().get(3).getCotacao());
        statement.setDouble(7, taxaCompra);
        statement.setDouble(8, investidor.getCarteira().getMoedas().get(0).getSaldo());
        statement.setDouble(9, investidor.getCarteira().getMoedas().get(1).getSaldo());
        statement.setDouble(10, investidor.getCarteira().getMoedas().get(2).getSaldo());
        statement.setDouble(11, investidor.getCarteira().getMoedas().get(3).getSaldo());
        statement.setString(12, time);
        statement.setString(13, date);
        statement.execute();
        conn.close();
    }
    
    public ResultSet consultarExtrato(Investidor investidor, int id_inv, int id_log) throws SQLException{
        String sql = "select * from log where id_inv = ? and id_log = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, id_inv);
        statement.setInt(2, id_log);
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
    }
    
    public int maiorLog() {
    int ultimoId = 0;
    try {
        if (conn != null) {
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT MAX(id_log) FROM log");
            if (resultSet.next()) {
                ultimoId = resultSet.getInt(1);
            }
            resultSet.close();
        } else {
            System.out.println("Conexão com o banco de dados não foi estabelecida.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ultimoId;
}

    
}
    

    
