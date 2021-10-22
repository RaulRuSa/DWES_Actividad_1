<%@page import="modelo.beans.Evento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		/*
		*Recupero el atributo evento
		*/
		Evento evento = (Evento)request.getAttribute("evento");
	%>
	<!-- Creo una tabla y muestro el evento recuperado anteriormente -->
	<h2>Editar Evento</h2>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Descripcion</th>
				<th>Fecha Inicio</th>
				<th>Duracion</th>
				<th>Direccion</th>
				<th>Estado</th>
				<th>Destacado</th>
				<th>Aforo Maximo</th>
				<th>Minimo Asistenci</th>
				<th>Precio</th>
			<tr>
		</thead>
		<tbody>
			<tr>
				<th><%= evento.getId_Evento() %></th>
				<th><%= evento.getNombre() %></th>
				<th><%= evento.getDescripcion() %></th>
				<th><%= evento.getFecha_Inicio() %></th>
				<th><%= evento.getDuracion() %></th>
				<th><%= evento.getDireccion() %></th>
				<th><%= evento.getEstado() %></th>
				<th><%= evento.getDestacado() %></th>
				<th><%= evento.getAforo_maximo() %></th>
				<th><%= evento.getMinimo_asistencia() %></th>
				<th><%= evento.getPrecio_decimal() %></th>
			<tr>
		</tbody>
	</table>
</body>
</html>