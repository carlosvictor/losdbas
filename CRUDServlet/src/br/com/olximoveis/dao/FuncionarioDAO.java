package br.com.olximoveis.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.olximoveis.model.Endereco;
import br.com.olximoveis.model.Funcionario;
import br.com.olximoveis.model.Livro;
import br.com.olximoveis.model.Telefone;
import br.com.olximoveis.utils.Utils;
import oracle.sql.STRUCT;

public class FuncionarioDAO {
     
    public FuncionarioDAO() {
    
    }
     
    public boolean salvar(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO " + funcionario.toString();
        Utils.Database.connect();
         
        Statement statement = Utils.Database.jdbcConnection.createStatement();
        
        System.out.println(sql);
        boolean linhaInserida = statement.executeUpdate(sql) > 0;
        statement.close();
        Utils.Database.disconnect();
        return linhaInserida;
    }
     
    public List<Funcionario> listar() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
         
        String sql = "SELECT * FROM tb_funcionario";
         
        Utils.Database.connect();
         
        Statement statement = Utils.Database.jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
        	
            Funcionario funcionario = getFuncionario(resultSet);
            funcionarios.add(funcionario);
        }
         
        resultSet.close();
        statement.close();
         
        Utils.Database.disconnect();
         
        return funcionarios;
    }
     
    public boolean deletarPorId(String cod) throws SQLException {
        String sql = "DELETE FROM tb_funcionario where cod = ?";
         
        Utils.Database.connect();
         
        PreparedStatement statement = Utils.Database.jdbcConnection.prepareStatement(sql);
        statement.setString(1, cod);
         
        boolean linhaDeletada = statement.executeUpdate() > 0;
        statement.close();
        Utils.Database.disconnect();
        return linhaDeletada;     
    }
     
    public boolean alterarLivro(Livro livro) throws SQLException {
        String sql = "UPDATE livro SET titulo = ?, autor = ?, preco = ?";
        sql += " WHERE id = ?";
        Utils.Database.connect();
         
        PreparedStatement statement = Utils.Database.jdbcConnection.prepareStatement(sql);
        statement.setString(1, livro.getTitulo());
        statement.setString(2, livro.getAutor());
        statement.setFloat(3, livro.getPreco());
        statement.setInt(4, livro.getId());
         
        boolean linhaAlterada = statement.executeUpdate() > 0;
        statement.close();
        Utils.Database.disconnect();
        return linhaAlterada;     
    }
     
    public Funcionario buscarPorId(String id) throws SQLException {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM tb_funcionario WHERE cod = ?";
         
        Utils.Database.connect();
         
        PreparedStatement statement = Utils.Database.jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	funcionario = getFuncionario(resultSet);
        }
         
        resultSet.close();
        statement.close();
         
        return funcionario;
    }
    
    private Funcionario getFuncionario(ResultSet resultSet) throws SQLException {
    	
    	String cod = resultSet.getString("cod");
    	String nome = resultSet.getString("nome");
    	String email = resultSet.getString("email");
    	Date data_nascimento = resultSet.getDate("data_nascimento");
    	Date data_admissao = resultSet.getDate("data_admissao");
    	Telefone telefone = new Telefone(((STRUCT) resultSet.getObject("telefone")).getAttributes());
        Endereco endereco = new Endereco(((STRUCT) resultSet.getObject("endereco")).getAttributes());
        
        return new Funcionario(cod, nome, email, data_nascimento, data_admissao, telefone, endereco, null);
    }
}
