package modelo.beans;

import java.io.Serializable;

public class Tipo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Atributos de Tipo
	private int id_Tipo;
	private String nombre;
	private String descripcion;
	
	//Constructores con y sin parámetros
	public Tipo(int id_Tipo, String nombre, String descripcion) {
		super();
		this.id_Tipo = id_Tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Tipo() {
		super();
	}
	//Getters y Setters
	public int getId_Tipo() {
		return id_Tipo;
	}

	public void setId_Tipo(int id_Tipo) {
		this.id_Tipo = id_Tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	//Sobreescribo hasCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_Tipo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Tipo))
			return false;
		Tipo other = (Tipo) obj;
		if (id_Tipo != other.id_Tipo)
			return false;
		return true;
	}
	//Sobreescribo toString
	@Override
	public String toString() {
		return "Tipo [id_Tipo=" + id_Tipo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
