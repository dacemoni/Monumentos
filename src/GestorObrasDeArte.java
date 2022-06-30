package obrasDeArte;

import java.util.Scanner;

public interface GestorObrasDeArte {
	public void nuevaCiudad(Scanner teclado) throws CityAlreadyExistsException;
	
	public void nuevaObraDeArte(Scanner teclado) throws ObraAlreadyExistsException;
	   
	public void buscarCiudad(Scanner teclado) throws CityNotFoundException;

	public void buscarObrasDeArte(Scanner teclado) throws ObraNotFoundException;
	
	public void borrarCiudad(Scanner teclado) throws CityNotFoundException;
	
	public void borrarObraDeArte(Scanner teclado) throws ObraNotFoundException;
	
	public void listarCiudades();
	
	public void listarObrasDeArte();
	
}
