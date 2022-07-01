package Excepciones;

public class CityNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CityNotFoundException(){
		super();
	}
	
	public CityNotFoundException(String mesagge){
		super(mesagge);
		
	}
}
