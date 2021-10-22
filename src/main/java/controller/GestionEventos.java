package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet(description = "Servlet dedicado a las tareas de Eventos", urlPatterns = { "/GestionEventos" })
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Cuando el servlet es llamado lo direcciono a la parte correspondiente segun la opcion que me envian
		 * Recojo la opcion con request.getParameter("opcion") 
		 */
		switch(request.getParameter("opcion")) {
		
		case "activos":
			mostrarActivos(request,response);
			break;
		case "alta":
			procesarAlta(request, response);
			break;
		case "editar":
			procesarEditar(request, response);
			break;
		case "eliminar":
			procesarEliminar(request, response);
			break;
		case "cancelar":
			procesarCancelar(request, response);
			break;
		}
	}
	/*
	 * Recupero el atributo de sesion listaEventos y genero un ArrayList con los eventos activos
	 * meto esta lista en otro atributo de sesion "listaActivos" y llamo a activos.jsp
	 */
	protected void mostrarActivos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaEventos");
		List<Evento> listaAux = new ArrayList<Evento>();
		for (Evento ele: lista) {
			if(ele.getEstado().equalsIgnoreCase("activo")){
					listaAux.add(ele);
			}
		}
		request.getSession().setAttribute("listaActivos", listaAux);
		request.getRequestDispatcher("activos.jsp").forward(request, response); 
	}
	
	/*
	 * Recupero el atributo de sesion listaEventos
	 * creo un evento donde voy guardando los parametros que me han llegado de altaEvento.jsp
	 * altaEvento.jsp es un formulario que llama a GestionEventos
	 * Finalmente meto el evento creado en listaEventos,lo guardo como atributo de sesion
	 * y llamo a mostrarActivos
	*/
	protected void procesarAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaEventos");
		Evento evento = new Evento();
		evento.setId_Evento(Integer.parseInt(request.getParameter("id_Evento")));
		
		evento.setNombre(request.getParameter("nombre"));
		evento.setDescripcion(request.getParameter("descripcion"));
		SimpleDateFormat formatoFecha = new SimpleDateFormat( "dd-MM-yyyy");
		try {
			evento.setFecha_Inicio(formatoFecha.parse(request.getParameter("fecha_Inicio")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		evento.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		evento.setDireccion(request.getParameter("direccion"));
		evento.setEstado(request.getParameter("estado"));
		evento.setDestacado(request.getParameter("destacado").charAt(0));
		evento.setAforo_maximo(Integer.parseInt(request.getParameter("aforo_maximo")));
		evento.setMinimo_asistencia(Integer.parseInt(request.getParameter("minimo_asistencia")));
		evento.setPrecio_decimal(Double.parseDouble(request.getParameter("precio_decimal")));
		Tipo tipo = new Tipo();
		tipo.setId_Tipo(Integer.parseInt(request.getParameter("id_Tipo")));
		tipo.setNombre(request.getParameter("nombre_Tipo"));
		tipo.setDescripcion(request.getParameter("descripcion_Tipo"));
		evento.setTipo(tipo);
		lista.add(evento);
		request.getSession().setAttribute("listaEventos", lista);
		mostrarActivos(request, response);
	}
	/*
	 * Recupero el atributo de sesion listaEventos y el parametro id que me llega de activos.jsp o eventos.jsp
	 * como parametro, uso ese id junto con un evento nuevo para buscar si tengo ese evento en mi listaEventos,
	 * creo un atributo llamado evento y finalmente llamo a editarEvento.jsp
	 */
	protected void procesarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_Evento = Integer.parseInt(request.getParameter("id")); 
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaEventos");
		Evento evento= new Evento();
		evento = findEventoById(id_Evento, lista);
		request.setAttribute("evento", evento);
		request.getRequestDispatcher("editarEvento.jsp").forward(request, response);
	}
	/*
	 * Recupero el atributo de sesion listaEventos y el parametro id que me llega de activos.jsp o eventos.jsp
	 * como parametro. Busco el evento que contiene ese id lo elimino de mi lista, actualizo el 
	 * atributo de sesion listaEventos y llamo a mostrarActivos
	 */
	protected void procesarEliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_Evento = Integer.parseInt(request.getParameter("id")); 
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaEventos");
		Evento evento = new Evento();
		evento = findEventoById(id_Evento, lista);
		lista.remove(evento);
		request.getSession().setAttribute("listaEventos", lista);
		mostrarActivos(request, response);
	}
	/*
	 * Recupero el atributo de sesion listaEventos y el parametro id que me llega de activos.jsp o eventos.jsp
	 * como parametro. Busco el evento que contiene ese id y cambio su estado a cancelado, actualizo el 
	 * atributo de sesion listaEventos y llamo a mostrarActivos
	 */
	protected void procesarCancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_Evento = Integer.parseInt(request.getParameter("id")); 
		List<Evento> lista = (List<Evento>)request.getSession().getAttribute("listaEventos");
		Evento evento = new Evento();
		evento = findEventoById(id_Evento, lista);
		evento.setEstado("cancelado");
		lista.set(lista.indexOf(evento), evento);
		request.getSession().setAttribute("listaEventos", lista);
		mostrarActivos(request, response);
	}
	//Funcion privada de GestionEventos que sirve para encontrar un evento por su id_Evento
	private Evento findEventoById (int id_Evento, List<Evento> lista) {
		Evento evento = new Evento();
		evento.setId_Evento(id_Evento);
		int pos = lista.indexOf(evento);
		if (pos == -1) {
			System.out.println("No se encontro el Evento");
			return null;
		}		
		else
			return lista.get(pos);
	}
}
