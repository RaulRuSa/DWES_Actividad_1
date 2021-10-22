package modelo.daos;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Tipo;

public class TipoDaoImpl implements IntTipoDao{
	
	//Creo un Arraylist donde guardaré los tipos y guardo algunos tipos
	private List<Tipo> lista;
	
	public TipoDaoImpl() {
		lista= new ArrayList<Tipo>();
		cargarDatos();
	}
	//Aquí es donde guardo algunos tipos en el Arraylist creado
	private void cargarDatos() {
		lista.add(new Tipo(1, "Cumpleaños", "fiesta de cumpleaños"));
		lista.add(new Tipo(2, "Boda", "festejo matrimonial"));
		lista.add(new Tipo(3, "Convencion", "reunion empresarial"));
		lista.add(new Tipo(4, "Seminario", "reunion formativa"));
		
	}
	//Implemento las funciones definidas en el Interface IntTipoDao
	@Override
	public Tipo finById(int id_Tipo) {
		Tipo aux = new Tipo();
		aux.setId_Tipo(id_Tipo);
		int pos = lista.indexOf(aux);
		if (pos == -1)
			return null;
		else
			return lista.get(pos);
	}

	@Override
	public List<Tipo> findAll() {
		return lista;
	}

	@Override
	public int insertarTipo(Tipo tipo) {
		if (lista.contains(tipo))
			return 0;
		else
			return lista.add(tipo)?1:0;
	}

	@Override
	public int modificarTipo(Tipo tipo) {
		int pos=lista.indexOf(tipo);
		if (pos == -1)
			return 0;
		else
			return (lista.set(pos, tipo) != null)?1:0;
	}

	@Override
	public int eliminarTipo(Tipo tipo) {
		return lista.remove(tipo)?1:0;
	}

	@Override
	public int eliminarTipo(int id_Tipo) {
		Tipo aux= new Tipo();
		aux.setId_Tipo(id_Tipo);
		int pos= lista.indexOf(aux);
		if (pos == -1)
			return 0;
		else
			return (lista.remove(pos) !=null )?1:0;
	}
	
}
