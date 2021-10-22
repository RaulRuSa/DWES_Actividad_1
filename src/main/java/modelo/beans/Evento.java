package modelo.beans;

import java.io.Serializable;
import java.util.Date;

public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//Atributos de Evento
	private int id_Evento;
	private String nombre;
	private String descripcion;
	private Date fecha_Inicio;
	private int duracion;
	private String direccion;
	private String estado;
	private char destacado;
	private int aforo_maximo;
	private int minimo_asistencia;
	private double precio_decimal;
	private Tipo tipo;
	
	//Constructores con y sin parámetros
	public Evento(int id_Evento, String nombre, String descripcion, Date fecha_Inicio, int duracion, String direccion,
			String estado, char destacado, int aforo_maximo, int minimo_asistencia, double precio_decimal, Tipo tipo) {
		super();
		this.id_Evento = id_Evento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecha_Inicio = fecha_Inicio;
		this.duracion = duracion;
		this.direccion = direccion;
		this.estado = estado;
		this.destacado = destacado;
		this.aforo_maximo = aforo_maximo;
		this.minimo_asistencia = minimo_asistencia;
		this.precio_decimal = precio_decimal;
		this.tipo = tipo;
	}
	public Evento() {
		super();
	}
	
	//Getters y Setters
	public int getId_Evento() {
		return id_Evento;
	}
	public void setId_Evento(int id_Evento) {
		this.id_Evento = id_Evento;
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
	public Date getFecha_Inicio() {
		return fecha_Inicio;
	}
	public void setFecha_Inicio(Date fecha_Inicio) {
		this.fecha_Inicio = fecha_Inicio;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public char getDestacado() {
		return destacado;
	}
	public void setDestacado(char destacado) {
		this.destacado = destacado;
	}
	public int getAforo_maximo() {
		return aforo_maximo;
	}
	public void setAforo_maximo(int aforo_maximo) {
		this.aforo_maximo = aforo_maximo;
	}
	public int getMinimo_asistencia() {
		return minimo_asistencia;
	}
	public void setMinimo_asistencia(int minimo_asistencia) {
		this.minimo_asistencia = minimo_asistencia;
	}
	public double getPrecio_decimal() {
		return precio_decimal;
	}
	public void setPrecio_decimal(double precio_decimal) {
		this.precio_decimal = precio_decimal;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	//Sobreescribo hasCode y equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_Evento;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Evento))
			return false;
		Evento other = (Evento) obj;
		if (id_Evento != other.id_Evento)
			return false;
		return true;
	}
	//Sobreescribo toString
	@Override
	public String toString() {
		return "Evento [id_Evento=" + id_Evento + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", fecha_Inicio=" + fecha_Inicio + ", duracion=" + duracion + ", direccion=" + direccion + ", estado="
				+ estado + ", destacado=" + destacado + ", aforo_maximo=" + aforo_maximo + ", minimo_asistencia="
				+ minimo_asistencia + ", precio_decimal=" + precio_decimal + ", tipo=" + tipo + "]";
	}
	
	
}
