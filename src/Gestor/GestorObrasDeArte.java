package Gestor;

import java.util.Scanner;

import Excepciones.CityAlreadyExistsException;
import Excepciones.CityNotFoundException;
import Excepciones.ObraAlreadyExistsException;
import Excepciones.ObraNotFoundException;

public interface GestorObrasDeArte {
	public void nuevaCiudad(Scanner teclado) throws CityAlreadyExistsException;
	
	public void nuevaObraDeArte(Scanner teclado) throws ObraAlreadyExistsException, CityNotFoundException;
	   
	public void buscarCiudad(Scanner teclado) throws CityNotFoundException;

	public void buscarObrasDeArte(Scanner teclado) throws ObraNotFoundException;
	
	public void listarCiudades();
	
	public void listarObrasDeArte();
	
}
