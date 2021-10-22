package modelo.daos;

import java.util.List;

import modelo.beans.Tipo;

public interface IntTipoDao {
	
	//Interface con las funciones que usaremos para la clase Tipo
	//Estas funciones se implementan en TipoDaoImpl
	Tipo finById(int id_Tipo);
	List<Tipo> findAll();
	int insertarTipo(Tipo tipo);
	int modificarTipo(Tipo tipo);
	int eliminarTipo(Tipo tipo);
	int eliminarTipo(int id_Tipo);
}
