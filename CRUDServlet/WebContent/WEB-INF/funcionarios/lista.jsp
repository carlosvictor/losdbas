<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<style type="text/css">
    	<%@include file="/css.css" %>
	</style>
    
    <title>Funcionários</title>
</head>
<body>
    <center>
        <h1>Gerenciador de Funcionários</h1>
        <h2>
            <a href="novo">Adicionar funcionário</a>
            &nbsp;&nbsp;&nbsp;
            <a href="listar">Lista dos funcionários</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista dos Funcionários</h2></caption>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Telefone</th>
                <th>Endereço</th>
            </tr>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td><c:out value="${funcionario.cod}" /></td>
                    <td><c:out value="${funcionario.nome}" /></td>
                    <td><c:out value="${funcionario.email}" /></td>
                    <td><c:out value="${funcionario.email}" /></td>
                    <td>
                        <a href="editar?id=<c:out value='${funcionario.cod}' />">Alterar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="deletar?id=<c:out value='${funcionario.cod}' />">Deletar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>