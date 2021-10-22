package modelo.daos;

import java.util.List;

import modelo.beans.Evento;

public interface IntEventoDao {
	
	//Interface con las funciones que usaremos para la clase Evento
	//Estas funciones se implementan en EventoDaoImpl
	Evento findById(int id_Evento);
	List<Evento> findAll();
	List<Evento> findActivos();
	int insertarEvento(Evento evento);
	int modificarEvento(Evento evento);
	int eliminarEvento(int id_Evento);
	int eliminarEvento(Evento evento);
	int cancelarEvento(int id_Evento);	
}
