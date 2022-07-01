package Excepciones;

public class ObraAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ObraAlreadyExistsException(){
		super();
	}
	
	public ObraAlreadyExistsException(String mesagge){
		super(mesagge);
		
	}
}
