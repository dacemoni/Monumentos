package Clases;

import java.util.Objects;

public abstract class ObraDeArte implements Comparable<ObraDeArte>{

	private String nombre;
	private Ciudad ciudadPerteneciente;
	private int anoRealizacion;

	protected ObraDeArte(String nombre, Ciudad ciudadPerteneciente, int anoRealizacion) {
		super();
		this.nombre = nombre;
		this.ciudadPerteneciente = ciudadPerteneciente;
		this.anoRealizacion = anoRealizacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad getCiudadPerteneciente() {
		return ciudadPerteneciente;
	}

	public void setCiudadPerteneciente(Ciudad ciudadPerteneciente) {
		this.ciudadPerteneciente = ciudadPerteneciente;
	}

	public int getAnoRealizacion() {
		return anoRealizacion;
	}

	public void setAnoRealizacion(int anoRealizacion) {
		this.anoRealizacion = anoRealizacion;
	}	

	public abstract String queSoy();

	@Override
	public String toString() {
		return "ObraDeArte [nombre = " + nombre + ", ciudadPerteneciente = " + ciudadPerteneciente + ", anoRealizacion = "
				+ anoRealizacion + "]";
	}

	public int compareTo (ObraDeArte o){
		if (ciudadPerteneciente == o.ciudadPerteneciente){
			return nombre.compareTo(o.getNombre());
		}
		else{
			return Integer.compare(o.getAnoRealizacion(), anoRealizacion);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObraDeArte other = (ObraDeArte) obj;
		return anoRealizacion == other.anoRealizacion && Objects.equals(ciudadPerteneciente, other.ciudadPerteneciente)
				&& Objects.equals(nombre, other.nombre);
	}

}
