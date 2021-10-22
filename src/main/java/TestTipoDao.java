import modelo.beans.Tipo;
import modelo.daos.IntTipoDao;
import modelo.daos.TipoDaoImpl;

public class TestTipoDao {
	//En esta clase realizo distinta pruebas a las funciones implementadas en TipoDaoImpl
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntTipoDao iTipo = new TipoDaoImpl();
		
		System.out.println("Muestra todos los tipos");
		for (Tipo ele: iTipo.findAll()) {
			System.out.println(ele);
		}
		
		System.out.println("**********************");
		System.out.println("Muestra el tipo con id_Tipo = 3");
		
		System.out.println(iTipo.finById(3));
		
		System.out.println("**********************");
		System.out.println("Añado un Tipo (id_Tipo = 5, Bautizo, celebra nacimiento");
	
		iTipo.insertarTipo(new Tipo(5, "Bautizo", "celebra nacimiento"));
		
		for (Tipo ele: iTipo.findAll()) {
			System.out.println(ele);
		}
		
		System.out.println("**********************");
		System.out.println("Modifica el Tipo con id_Tipo = 2 a Graduacion, celebra titulo");
		
		iTipo.modificarTipo(new Tipo(2, "Graduacion", "celebra titulo"));
		for (Tipo ele: iTipo.findAll()) {
			System.out.println(ele);
		}
		
		System.out.println("**********************");
		System.out.println("Elimina el Tipo con id_Tipo = 5 pasando id_Tipo como parametro");
	
		iTipo.eliminarTipo(5);
		for (Tipo ele: iTipo.findAll()) {
			System.out.println(ele);
		}
		
		//eliminar Tipo enviando mediante objeto solo mira el id_Tipo. Lo elimina aunque no coincidan nombre y descripcion
		System.out.println("**********************");
		System.out.println("Elimina el Tipo con id_Tipo = 4 pasando un objeto Tipo como parametro");
	
		iTipo.eliminarTipo(new Tipo(4,"sd", "dsgf"));
		for (Tipo ele: iTipo.findAll()) {
			System.out.println(ele);
		}
		
	}

}
