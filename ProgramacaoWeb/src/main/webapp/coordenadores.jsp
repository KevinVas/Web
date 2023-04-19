<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cadastro.web.bean.coordenador"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<coordenador> lista = (ArrayList<coordenador>) request.getAttribute("coordenador");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Coordenadores</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
	<h1>Lista de Coordernadores</h1>
	<a href="cadastrar.html" class="Botao">Adicionar Coordenador</a>
	<table id="tabela">

		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Curso</th>
				<th>Periodo</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getCurso()%></td>
				<td><%=lista.get(i).getPeriodo()%></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>" class="Botao">Editar</a></td>
				<td><a href="javascript: excluir(<%=lista.get(i).getId()%>)" class="Botao">Apagar</a>
				</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
		<script src="scripts/exclusao.js"></script>
</body>
</html>