<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Livraria</title>
</head>
<body>
    <center>
        <h1>Gerenciador de funcionários</h1>
        <h2>
            <a href="novo">Adicionar funcionário</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lista">Lista dos funcionários</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${funcionario != null}">
            <form action="alterar" method="post">
        </c:if>
        <c:if test="${funcionario == null}">
            <form action="salvar" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${funcionario != null}">
                        Alterar funcionário
                    </c:if>
                    <c:if test="${funcionario == null}">
                        Adicionar funcionário
                    </c:if>
                </h2>
            </caption>
                <c:if test="${funcionario != null}">
                    <input type="hidden" name="cod" value="<c:out value='${funcionario.cod}' />" />
                    <input type="hidden" name="data_admissao" value="<c:out value='${funcionario.data_admissao}' />" />
                </c:if>           
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="nome" size="30" maxlength="30"
                            value="<c:out value='${funcionario.nome}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>E-mail: </th>
                <td>
                    <input type="text" name="email" size="30" maxlength="30"
                            value="<c:out value='${funcionario.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Data de nascimento: </th>
                <td>
                    <input type="text" name="data_nascimento" size="30" maxlength="30"
                            value="<c:out value='${funcionario.data_nascimento}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Telefone: </th>
                <td>
                    <input type="text" name="telefone.cod" size="3" maxlength="3" placeholder="DDD"
                            value="<c:out value='${funcionario.telefone.cod}' />"
                    />
                    <input type="text" name="telefone.numero" size="9" maxlength="9" placeholder="Número"
                            value="<c:out value='${funcionario.telefone.numero}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Endereço: </th>
   
                <td>
                    <input type="text" name="endereco.rua" size="20" maxlength="20" placeholder="Rua"
                            value="<c:out value='${funcionario.endereco.rua}' />"
                    />
                    <input type="text" name="endereco.numero" size="5" maxlength="6" placeholder="Número"
                            value="<c:out value='${funcionario.endereco.numero}' />"
                    />
                    
                    <input type="text" name="endereco.complemento" size="20" maxlength="20" placeholder="Complemento"
                            value="<c:out value='${funcionario.endereco.complemento}' />"
                    />
                    <input type="text" name="endereco.bairro" size="15" maxlength="15" placeholder="Bairro"
                            value="<c:out value='${funcionario.endereco.bairro}' />"
                    />
                    
                    <br/><br/>
                    
                    <input type="text" name="endereco.cidade" size="15" maxlength="15" placeholder="Cidade"
                            value="<c:out value='${funcionario.endereco.cidade}' />"
                    />
                    <input type="text" name="endereco.estado" size="2" maxlength="2" placeholder="UF"
                            value="<c:out value='${funcionario.endereco.estado}' />"
                    />
                    <input type="text" name="endereco.cep" size="8" maxlength="8" placeholder="CEP"
                            value="<c:out value='${funcionario.endereco.cep}' />"
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