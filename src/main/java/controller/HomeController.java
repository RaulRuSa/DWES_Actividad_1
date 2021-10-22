package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/inicio")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * Punto de entrada a la aplicacion, solo entraremos aqui una vez
	 *  Creo una lista con eventos que me servira a modo de base de datos para el ejercicio.
	 *  Creo el atributo se sesion listaEventos y llamo a eventos.jsp
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IntEventoDao iEvento = new EventoDaoImpl();
		List<Evento> lista = iEvento.findAll();
		request.getSession().setAttribute("listaEventos", lista);
		request.getRequestDispatcher("eventos.jsp").forward(request, response);
	}
}
