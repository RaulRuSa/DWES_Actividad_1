<%@page import="java.util.List"%>
<%@page import="modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Activos</title>
</head>
<body>
	
	<%
	/*
	*Recupero el atributo de sesion listaActivos
	*/
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaActivos");
	%>
	
	<ul>
		<li><a href="#">Tipos</a></li>
		<li><a href="eventos.jsp">Eventos</a></li> <!-- llamo a eventos.jsp -->
		<li><a href="#">Usuarios</a></li>
		<li><a href="GestionEventos?opcion=activos">Eventos/tipo</a></li> <!-- llamo a GestioEventos pasando el parametro opcion=activos -->
		<li><a href="#">Login</a></li>
		<li><a href="#">Registro</a></li>
		<li><a href="#">Salir</a></li>
	</ul>
	<h2>Añadir Evento</h2>
	<a href="altaEvento.jsp">Nuevo Evento</a> <!-- llamos a altaEvento.jsp -->
	<h2>Eventos Activos</h2>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th colspan="3">Opciones</th>
			<tr>
		</thead>
		<tbody>
		<!-- Recorro mi lista de eventos y muestro las opciones de editar eliminar y cancelar para cada evento -->
		<!-- Si elijo una de las opciones llamo a GestionEventos pasando la opcion correspondiente junto con -->
		<!-- la id del evento -->
			<% for (Evento ele: lista){ %>	
			<tr>
				<td><%= ele.getId_Evento() %></td>
				<td><%= ele.getNombre() %></td>
				<td><%= ele.getPrecio_decimal() %></td>
				<td><a href="GestionEventos?opcion=editar&id=<%= ele.getId_Evento()%>">Editar</a></td> 
				<td><a href="GestionEventos?opcion=eliminar&id=<%= ele.getId_Evento()%>">Eliminar</a></td>
				<td><a href="GestionEventos?opcion=cancelar&id=<%= ele.getId_Evento()%>">Cancelar</a></td>
			</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>