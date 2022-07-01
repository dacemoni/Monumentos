package Clases;

public class Arquitectura extends ObraDeArte{
	
	private static final String SOY_UNA_ARQUITECTURA = "Soy una Arquitectura";
	private Tipo tipo;
	
	public Arquitectura(String nombre, Ciudad ciudadPerteneciente, int anoRealizacion, Tipo tipo) {
		super(nombre, ciudadPerteneciente, anoRealizacion);
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arquitectura other = (Arquitectura) obj;
		return tipo == other.tipo;
	}

	@Override
	public String toString() {
		return "Arquitectura [ " + super.toString() + ", tipo = " + tipo + " ]";
	}

	@Override
	public String queSoy() {
		return SOY_UNA_ARQUITECTURA;
	}
	
}
