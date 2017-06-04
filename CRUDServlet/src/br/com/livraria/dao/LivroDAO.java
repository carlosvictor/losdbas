package br.com.livraria.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.model.Livro;

public class LivroDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public LivroDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean salvarLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO livro (titulo, autor, preco) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, livro.getTitulo());
        statement.setString(2, livro.getAutor());
        statement.setFloat(3, livro.getPreco());
         
        boolean linhaInserida = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return linhaInserida;
    }
     
    public List<Livro> listarLivros() throws SQLException {
        List<Livro> listaLivros = new ArrayList<Livro>();
         
        String sql = "SELECT * FROM livro";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            Integer id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            Float preco = resultSet.getFloat("preco");
             
            Livro livro = new Livro(id, titulo, autor, preco);
            listaLivros.add(livro);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listaLivros;
    }
     
    public boolean deletarLivro(Livro livro) throws SQLException {
        String sql = "DELETE FROM livro where id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, livro.getId());
         
        boolean linhaDeletada = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return linhaDeletada;     
    }
     
    public boolean alterarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, preco = ?";
        sql += " WHERE id = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, livro.getTitulo());
        statement.setString(2, livro.getAutor());
        statement.setFloat(3, livro.getPreco());
        statement.setInt(4, livro.getId());
         
        boolean linhaAlterada = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return linhaAlterada;     
    }
     
    public Livro buscarLivroPorId(Integer id) throws SQLException {
        Livro livro = null;
        String sql = "SELECT * FROM livro WHERE id = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String titulo = resultSet.getString("titulo");
            String autor = resultSet.getString("autor");
            Float preco = resultSet.getFloat("preco");
             
            livro = new Livro(id, titulo, autor, preco);
        }
         
        resultSet.close();
        statement.close();
         
        return livro;
    }
}
