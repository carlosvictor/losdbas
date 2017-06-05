package br.com.olximoveis.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.olximoveis.dao.FuncionarioDAO;
import br.com.olximoveis.dao.LivroDAO;
import br.com.olximoveis.model.Endereco;
import br.com.olximoveis.model.Funcionario;
import br.com.olximoveis.model.Livro;
import br.com.olximoveis.model.Telefone;
import br.com.olximoveis.utils.Utils;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LivroDAO livroDAO;
    private FuncionarioDAO funcionarioDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        livroDAO = new LivroDAO(jdbcURL, jdbcUsername, jdbcPassword);
        funcionarioDAO = new FuncionarioDAO();
 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getServletPath();
 
        try {
            switch (acao) {
            case "/novo":
            	mostrarFormularioNovo(request, response);
                break;
            case "/salvar":
                salvarLivro(request, response);
                break;
            case "/deletar":
                deletarLivro(request, response);
                break;
            case "/editar":
                mostrarFormularioEditar(request, response);
                break;
            case "/alterar":
                alterarLivro(request, response);
                break;
            default:
                listarLivros(request, response);
                break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listarLivros(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	List<Funcionario> funcionarios = funcionarioDAO.listar();
    	request.setAttribute("funcionarios", funcionarios);
    			
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/funcionarios/lista.jsp");
        dispatcher.forward(request, response);
    }
 
    private void mostrarFormularioNovo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/funcionarios/formulario.jsp");
        dispatcher.forward(request, response);
    }
 
    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Funcionario funcionario = funcionarioDAO.buscarPorId(request.getParameter("id"));
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/funcionarios/formulario.jsp");
        request.setAttribute("funcionario", funcionario);
        dispatcher.forward(request, response);
 
    }
 
    private void salvarLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ParseException {

    	// funcionario
    	String cod = UUID.randomUUID().toString().substring(0,10);
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String dataNascimentoStr = request.getParameter("data_nascimento");
        Date dataNascimento = Utils.Date.FORMATADOR_DEFAULT.parse(dataNascimentoStr);
        Date dataAdmissao = new Date();
        
        // telefone 
        Integer codTelefone = Integer.parseInt(request.getParameter("telefone.cod"));
        Integer numeroTelefone = Integer.parseInt(request.getParameter("telefone.numero"));
        Telefone telefone = new Telefone(codTelefone, numeroTelefone);
        
        // endereco
        Integer cep = Integer.parseInt(request.getParameter("endereco.cep"));
        String rua = request.getParameter("endereco.rua");
        Integer numero = Integer.parseInt(request.getParameter("endereco.numero"));
        String complemento = request.getParameter("endereco.complemento");
        String bairro = request.getParameter("endereco.bairro");
        String cidade = request.getParameter("endereco.cidade");
        String estado = request.getParameter("endereco.estado");
        Endereco endereco = new Endereco(cep, rua, numero, complemento, bairro, cidade, estado);
        
        Funcionario funcionario = new Funcionario(cod, nome, email, dataNascimento, dataAdmissao, telefone, endereco, null);
        
        funcionarioDAO.salvar(funcionario);
        
        response.sendRedirect("listar");
    }
 
    private void alterarLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        Float preco = Float.parseFloat(request.getParameter("preco"));
 
        Livro livro = new Livro(id, titulo, autor, preco);
        livroDAO.alterarLivro(livro);
        response.sendRedirect("listar");
    }
 
    private void deletarLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	
        funcionarioDAO.deletarPorId(request.getParameter("id"));
        response.sendRedirect("listar");
 
    }
}
