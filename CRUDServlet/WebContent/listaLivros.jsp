<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<style type="text/css">
    	<%@include file="css.css" %>
	</style>
    
    <title>Livraria</title>
</head>
<body>
    <center>
        <h1>Gerenciador de Livros</h1>
        <h2>
            <a href="novo">Adicionar livro</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listar">Lista dos livros</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista dos Livros</h2></caption>
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>preco</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="livro" items="${listaLivros}">
                <tr>
                    <td><c:out value="${livro.id}" /></td>
                    <td><c:out value="${livro.titulo}" /></td>
                    <td><c:out value="${livro.autor}" /></td>
                    <td><c:out value="${livro.preco}" /></td>
                    <td>
                        <a href="editar?id=<c:out value='${livro.id}' />">Alterar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deletar?id=<c:out value='${livro.id}' />">Deletar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>