import java.util.Date;

import modelo.beans.Evento;
import modelo.beans.Tipo;
import modelo.daos.EventoDaoImpl;
import modelo.daos.IntEventoDao;

public class TestEventoDao {
	//En esta clase realizo distinta pruebas a las funciones implementadas en EventoDaoImpl 
	public static void main(String[] args) {
		
		IntEventoDao iEvento = new EventoDaoImpl();
		
		System.out.println("Muestra todos los tipos");
		for (Evento ele: iEvento.findAll()) {
			System.out.println(ele);
		}
		
		System.out.println("**********************");
		System.out.println("Muestra el evento con id_Evento = 123");
		System.out.println(iEvento.findById(123));
		
		System.out.println("**********************");
		System.out.println("Muestra solo eventos activos");
		for(Evento ele: iEvento.findActivos())
			System.out.println(ele);
		
		System.out.println("**********************");
		System.out.println("Añado un dos eventos");
		iEvento.insertarEvento(new Evento(456,"evento3","es el evento3", new Date(), 20,"c/Asturias", "inactivo", 's' ,114, 25, 7.2, new Tipo(8,"nuevoTipo", "Comunion") ));
		iEvento.insertarEvento(new Evento(78,"evento4","es el evento4", new Date(), 20,"c/Maresa", "inactivo", 's' ,1214, 125, 17.2, new Tipo(8,"nuevoTipo", "Boda") ));
		for(Evento ele: iEvento.findAll())
			System.out.println(ele);
		
		System.out.println("**********************");
		System.out.println("Modifica el Evento con id_Evento = 456 cambia la direccion y el estado a activo");
		iEvento.modificarEvento(new Evento(456,"evento2","es el evento2", new Date(), 20,"c/Duraton", "activo", 's' ,14, 5, 17.3, new Tipo(8,"nuevoTipo", "Despedida Soltero")));
		for (Evento ele: iEvento.findAll())
			System.out.println(ele);
		
		System.out.println("**********************");
		System.out.println("Elimina el Evento con id_Evento = 111 pasando id_Evento como parametro");
		iEvento.eliminarEvento(111);
		for (Evento ele: iEvento.findAll())
			System.out.println(ele);
		
		
		System.out.println("**********************");
		System.out.println("Elimina el Evento con id_Evento = 123 pasando un objeto Tipo como parametro");
		iEvento.eliminarEvento(new Evento(123,"evento2","es el evento2", new Date(), 20,"c/Duraton", "inactivo", 's' ,14, 5, 17.3, new Tipo(8,"nuevoTipo", "Despedida Soltero")));
		for(Evento ele: iEvento.findAll())
			System.out.println(ele);

		System.out.println("**********************");
		System.out.println("Muestra solo los elementos activos");
		for(Evento ele: iEvento.findActivos())
			System.out.println(ele);
	}

}
