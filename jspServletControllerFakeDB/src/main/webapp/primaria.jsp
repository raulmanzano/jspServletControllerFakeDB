<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 <title>Aplicación</title>
</head>
<body>
<div align="center">
<h1>Principal</h1>
</div>
<br/>
<jsp:include page="menu.jsp"/>
<jsp:include page="mensaje.jsp"/> 
<div align="center">
<table>
        <tr>
            <th>ID</th>
            <th>Campos 1</th>
            <th>Campos 2</th>
            <th>Campos 3</th>
        </tr>
        <c:forEach items="${listPrimaria}" var="elemento">
            <tr>
                <td>${elemento.id}</td>
                <td>${elemento.campo1}</td>
                <td>${elemento.campo2}</td>
                <td>${elemento.campo3}</td>
                <td>
                    <form action="<c:url value="/primaria/edit"/>" method="post">
                        <input type="hidden" name="id" value="${elemento.id}">
                        <input type="submit" name="operacion" value="Edit">
                    </form>
                <td>
                    <form action="<c:url value="/primaria/delete"/>" method="post">
                        <input type="hidden" name="id" value="${elemento.id}">
                        <input type="submit" name="operacion" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>        
    </table>
    
                    <form action="<c:url value="/primaria/new"/>" method="post">                        
                        <input type="submit" name="operacion" value="nuevo">
                    </form>
    
    
</div>
</body>









</html>
