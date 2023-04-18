<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar Coordenadores</title>
<link rel="stylesheet" href="estilos.css">
</head>
<body>
<h1>Editar Coordenador</h1>
	<form name="Cadastro" action="update">
		<table>
			
	<tr>
	<td>Nome</td>
	<td><input type="text" name="nome" class="Caixa"
	value="<%out.print(request.getAttribute("nome"));%>"></td>
	</tr>
	
	<tr>
	<td>Curso</td>
	<td><input type="text" name="curso" class="Caixa"
	value="<%out.print(request.getAttribute("curso"));%>"></td>
    </tr>
    
	<tr>
	<td>Periodo</td>
	<td><input type="text" name="periodo" class="Caixa"
	value="<%out.print(request.getAttribute("periodo"));%>"></td>
	</tr>
	
	</table>
<input type="button" value="Salvar" class="Botao" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>

</body>
</html>