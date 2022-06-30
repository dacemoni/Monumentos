package obrasDeArte;

public class Escultura extends ObraDeArte{
	
	private static final String SOY_UNA_ESCULTURA = "Soy una Escultura";
	private String autor;
	private String material;
	
	public Escultura(String nombre, String formato, Ciudad ciudadPerteneciente, int anoRealizacion, String autor, String material) {
		super(nombre, formato, ciudadPerteneciente, anoRealizacion);
		this.autor = autor;
		this.material = material;
	}

	@Override
	public String queSoy() {
		return SOY_UNA_ESCULTURA;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}


	@Override
	public String toString() {
		return "Escultura [" + super.toString() + "autor=" + autor + ", material=" + material + "]";
	}
	
	@Override
	public int compareTo(ObraDeArte o) {
		return 0;
	}

}



