package br.com.livraria.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.livraria.dao.LivroDAO;
import br.com.livraria.model.Livro;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LivroDAO livroDAO;
 
    public void init() {
        String jdbcURL = getServletContext().getInitParameter("jdbcURL");
        String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
        String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
 
        livroDAO = new LivroDAO(jdbcURL, jdbcUsername, jdbcPassword);
 
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
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    private void listarLivros(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Livro> listaLivros = livroDAO.listarLivros();
        request.setAttribute("listaLivros", listaLivros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaLivros.jsp");
        dispatcher.forward(request, response);
    }
 
    private void mostrarFormularioNovo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
        dispatcher.forward(request, response);
    }
 
    private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Livro livro = livroDAO.buscarLivroPorId(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("formulario.jsp");
        request.setAttribute("livro", livro);
        dispatcher.forward(request, response);
 
    }
 
    private void salvarLivro(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        Float preco = Float.parseFloat(request.getParameter("preco"));
 
        Livro livro = new Livro(titulo, autor, preco);
        livroDAO.salvarLivro(livro);
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
        Integer id = Integer.parseInt(request.getParameter("id"));
 
        Livro livro = new Livro(id);
        livroDAO.deletarLivro(livro);
        response.sendRedirect("listar");
 
    }
}
