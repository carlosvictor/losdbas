<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Livraria</title>
</head>
<body>
    <center>
        <h1>Gerenciador de livros</h1>
        <h2>
            <a href="novo">Adicionar livro</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista">Lista dos livros</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${livro != null}">
            <form action="alterar" method="post">
        </c:if>
        <c:if test="${livro == null}">
            <form action="salvar" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${livro != null}">
                        Alterar livro
                    </c:if>
                    <c:if test="${livro == null}">
                        Adicionar livro
                    </c:if>
                </h2>
            </caption>
                <c:if test="${livro != null}">
                    <input type="hidden" name="id" value="<c:out value='${livro.id}' />" />
                </c:if>           
            <tr>
                <th>Titulo: </th>
                <td>
                    <input type="text" name="titulo" size="45"
                            value="<c:out value='${livro.titulo}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Autor: </th>
                <td>
                    <input type="text" name="autor" size="45"
                            value="<c:out value='${livro.autor}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Preco: </th>
                <td>
                    <input type="text" name="preco" size="5"
                            value="<c:out value='${livro.preco}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Salvar" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>