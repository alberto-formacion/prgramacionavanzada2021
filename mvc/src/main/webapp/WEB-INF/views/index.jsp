<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" %>
<html>
	<head>
	</head>
	<body>
		<h2>CREAR NUEVO TODO</h2>
		<form:form action="todos" method="post" modelAttribute="todo">
			<div><form:input path="tarea" placeholder="Tarea" /></div>
			<div><form:input path="descripcion" placeholder="Descripción" /></div>
			<button type="submit">Enviar</button>
		</form:form>
		<hr/>
		<h2>TODOS</h2>
		<ul>
			<c:forEach items="${todos}" var="todo">
				<li><a href="todos/${todo.id}">${todo.tarea}</a> 
					<form:form action="todos/delete" method="post" modelAttribute="todo">
						<form:hidden path="id" value="${todo.id}"/>
						<button type="submit">Borrar</button>
					</form:form>
				</li>
			</c:forEach>
		</ul>
	</body>
</html>
