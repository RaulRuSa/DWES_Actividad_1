<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- Creo un formulario que llamara a GestionEventos con opcion=alta -->
	<!-- los datos recogidos aqui los recupero en GestionEventos con getParameter -->
	<h2>Alta Evento</h2>
	<form action="GestionEventos?opcion=alta" method="post">
	
		<label for id="id_Evento">Id Evento</label>
		<input type="number" id="id_Evento" name="id_Evento">
		<br>
		<label for id="nombre">Nombre</label>
		<input type="text" id="nombre" name="nombre">
		<br>
		<label for id="descripcion">Descripcion</label>
		<input type="text" id="descripcion" name="descripcion">
		<br>
		<label for id="fecha_Inicio">Fecha de Inicio</label>
		<input type="date" id="fecha_Inicio" name="fecha_Inicio" placeholder="dd-mm-yyyy">
		<br>
		<label for id="duracion">Duracion</label>
		<input type="number" id="duracion" name="duracion">	
		<br>
		<label for id="direccion">Direccion</label>
		<input type="text" id="direccion" name="direccion">
		<br>
		<label for id="estado">Estado</label>
		<select id="estado" name="estado">
			<option value="activo" selected>Activo</option>
			<option value="cancelado">Cancelado</option>
		</select>
		<br>
		<label for id="destacado">Destacado</label>
		<select id="destacado" name="destacado">
			<option value="s" selected>s</option>
			<option value="n">n</option>
		</select>
		<br>
		<label for id="aforo_maximo">Aforo Maximo</label>
		<input type="number" id="aforo_maximo" name="aforo_maximo">
		<br>
		<label for id="minimo_asistencia">Minimo Asistencia</label>
		<input type="number" id="minimo_asistencia" name="minimo_asistencia">				
		<br>
		<label for id="precio_decimal">Precio</label>
		<input type="number" id="precio_decimal" name="precio_decimal" step="any">	
		<br>
		<label for id="id_Tipo">Id Tipo</label>
		<input type="number" id="id_Tipo" name="id_Tipo">	
		<br>
		<label for id="nombre_Tipo">Nombre Tipo</label>
		<input type="text" id="nombre_Tipo" name="nombre_Tipo" >	
		<br>
		<label for id="descripcion_Tipo">Descripcion Tipo</label>
		<input type="text" id="descripcion_Tipo" name="descripcion_Tipo">		
		
		<input type="submit" value="Enviar">
	</form>
</body>
</html>