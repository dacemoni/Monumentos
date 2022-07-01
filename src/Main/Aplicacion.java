package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Excepciones.CityAlreadyExistsException;
import Excepciones.CityNotFoundException;
import Excepciones.ObraAlreadyExistsException;
import Excepciones.ObraNotFoundException;
import Gestor.GestorObrasDeArte;
import Gestor.GestorObrasDeArteImpl;

public class Aplicacion {

	public static void main(String[] args){        
		menuInicio();
	}
	private static void menuInicio(){
		GestorObrasDeArte ciudades = new GestorObrasDeArteImpl();
		GestorObrasDeArte obrasDeArte = new GestorObrasDeArteImpl();

		int opcion = 0;

		try (Scanner teclado = new Scanner(System.in)){
			do{ 
				menu();

				try{    
					opcion = teclado.nextInt();                                 
				} 
				catch (InputMismatchException imEx){
					teclado.next();
					opcion = 0;
				}
				teclado.nextLine();
				switch (opcion){
				case 1:
					try {
						ciudades.nuevaCiudad(teclado);
					} 
					catch (CityAlreadyExistsException e1) {
						System.out.println(e1.getMessage());
					}
					break;
				case 2:
					try {
						obrasDeArte.nuevaObraDeArte(teclado);
					} 
					catch (ObraAlreadyExistsException | CityNotFoundException e2) {
						System.out.println(e2.getMessage());
					}
					break;
				case 3:
					try {
						ciudades.buscarCiudad(teclado);
					} 
					catch (CityNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					
					try {
					obrasDeArte.buscarObrasDeArte(teclado);
					} 
					catch (ObraNotFoundException e) {
						System.out.println(e.getMessage());
					}
					
					break;
				case 5:
					ciudades.listarCiudades();
					break;
				case 6:
					ciudades.listarObrasDeArte();
					break;
				case 7:
					System.out.println("Gracias.");
					break;

				default:
					System.out.println("No existe esta opcion.");
				}
			} while (opcion != 7);
		}
	}

	private static void menu(){
		System.out.println("");
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Añadir ciudad");
		System.out.println("2. Añadir obra de arte");
		System.out.println("3. Buscar ciudad");
		System.out.println("4. Buscar obra de arte");
		System.out.println("5. Listar ciudades");
		System.out.println("6. Listar obras de arte");
		System.out.println("7. Terminar y salir");
	}

}
