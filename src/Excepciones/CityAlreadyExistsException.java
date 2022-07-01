package Excepciones;

public class CityAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CityAlreadyExistsException(){
		super();
	}
	
	public CityAlreadyExistsException(String mesagge){
		super(mesagge);
		
	}
}
