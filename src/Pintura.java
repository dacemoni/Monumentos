package obrasDeArte;

public class Pintura extends ObraDeArte{

	private static final String SOY_UNA_PINTURA = "Soy una Pintura";
	private String autor;
	private Tecnica tecnica;

	public Pintura(String nombre, String formato, Ciudad ciudadPerteneciente, int anoRealizacion, String autor, Tecnica tecnica) {
		super(nombre, formato, ciudadPerteneciente, anoRealizacion);
		this.autor = autor;
		this.tecnica = tecnica;
	}

	@Override
	public String queSoy() {
		return SOY_UNA_PINTURA;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Tecnica getTecnica() {
		return tecnica;
	}

	public void setTecnica(Tecnica tecnica) {
		this.tecnica = tecnica;
	}

	@Override
	public String toString() {
		return "Pintura [" + super.toString() + "autor=" + autor + ", tecnica=" + tecnica + "]";
	}
	
	@Override
	public int compareTo(ObraDeArte o) {
		return 0;
	}
}


