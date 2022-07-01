package Excepciones;

public class ObraNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ObraNotFoundException(){
		super();
	}
	
	public ObraNotFoundException(String mesagge){
		super(mesagge);
		
	}
}
