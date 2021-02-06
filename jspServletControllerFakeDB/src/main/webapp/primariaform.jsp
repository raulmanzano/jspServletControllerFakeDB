<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Aplicación</title>
</head>
<body>
	<div align="center">
		<h1>Principal</h1>
	</div>
	<h2>
		<div align="center">
		<c:if test="${primaria != null}">
        Editar Primaria
        </c:if>
		<c:if test="${primaria == null}">
        Nueva Primaria
        </c:if>
        	</div>
	</h2>
	<div align="center">
	<c:if test="${primaria != null}">
			<form action="<c:url value="/primaria/update"/>" method="post">
		</c:if>
		<c:if test="${primaria == null}">
			<form action="<c:url value="/primaria/insert"/>" method="post">
		</c:if>
		<table>
			<tr><td>id</td><td><input type="text" name="id" value="<c:out value='${primaria.id}' />" readonly style="background-color:lightgrey"/></td></tr>			
			<tr><td>Campo1</td><td><input type="text" name="campo1" value="<c:out value='${primaria.campo1}' />" /></td></tr>
			<tr><td>Campo2</td><td><input type="text" name="campo2" value="<c:out value='${primaria.campo2}' />" /></td></tr>
			<tr><td>Campo3</td><td><input type="text" name="campo3" value="<c:out value='${primaria.campo3}' />" /></td></tr>
		</table>		
		<c:if test="${primaria != null}">
			<input type="submit" name="operacion" value="Editar"/>
		</c:if>
		<c:if test="${primaria == null}">
			<input type="submit" name="operacion" value="Crear"/>			
		</c:if>
		<a href="${pageContext.request.contextPath}/primaria/lista">Cancelar</a>
		</form>
	</div>
</body>









</html>
