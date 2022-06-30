package obrasDeArte;

import java.util.Objects;

public abstract class ObraDeArte implements Comparable<ObraDeArte> {

	private String nombre;
	private String formato;
	private Ciudad ciudadPerteneciente;
	private int anoRealizacion;

	protected ObraDeArte(String nombre, String formato, Ciudad ciudadPerteneciente, int anoRealizacion) {
		super();
		this.nombre = nombre;
		this.formato = formato;
		this.ciudadPerteneciente = ciudadPerteneciente;
		this.anoRealizacion = anoRealizacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "ObraDeArte [nombre=" + nombre + ", ciudadPerteneciente=" + ciudadPerteneciente + ", anoRealizacion="
				+ anoRealizacion + "]";
	}

	@Override
	   public int compareTo(ObraDeArte o){
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

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Ciudad getCiudadPerteneciente() {
		return ciudadPerteneciente;
	}

	public void setCiudadPerteneciente(Ciudad ciudadPerteneciente) {
		this.ciudadPerteneciente = ciudadPerteneciente;
	}
	
}
