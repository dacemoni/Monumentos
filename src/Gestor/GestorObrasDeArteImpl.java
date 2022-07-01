package Gestor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Clases.Arquitectura;
import Clases.Ciudad;
import Clases.Escultura;
import Clases.ObraDeArte;
import Clases.Pintura;
import Clases.Tecnica;
import Clases.Tipo;
import Excepciones.CityAlreadyExistsException;
import Excepciones.CityNotFoundException;
import Excepciones.ObraAlreadyExistsException;
import Excepciones.ObraNotFoundException;

public class GestorObrasDeArteImpl implements GestorObrasDeArte{

	private List<Pintura> PinturaSinDuplicados;
	private List<Escultura> EsculturaSinDuplicados;
	private List<Arquitectura> ArquitecturaSinDuplicados;
	private List<Ciudad> ciudadesSinDuplicados;

	public GestorObrasDeArteImpl() {
		PinturaSinDuplicados = new ArrayList<>();
		EsculturaSinDuplicados = new ArrayList<>();
		ArquitecturaSinDuplicados = new ArrayList<>();
		ciudadesSinDuplicados = new ArrayList<>();
	}

	@Override
	public void nuevaCiudad(Scanner teclado) throws CityAlreadyExistsException {
		System.out.println("Introduce el nombre de la ciudad: ");
		String nombre = teclado.next();

		System.out.println("Introduce el pais: ");
		String pais = teclado.next();

		System.out.println("Introduce el numero de habitantes: ");      
		int numeroHabitantes = teclado.nextInt();

		Ciudad ciudad = new Ciudad(nombre, pais, numeroHabitantes);

		if (ciudadesSinDuplicados.stream().anyMatch(c -> c.equals(ciudad))){
			throw new CityAlreadyExistsException(String.format("La ciudad %s ya existe en la lista de ciudades", nombre));
		}
		else{
			ciudadesSinDuplicados.add(ciudad);
		}
	}

	@Override
	public void nuevaObraDeArte(Scanner teclado) throws ObraAlreadyExistsException, CityNotFoundException {
		Tecnica tecnicaUtilizada;
		Tipo tipoUtilizado;

		System.out.println("Introduce la ciudad: ");
		Ciudad ciudadObra = findCiudad(teclado);

		int opcion = 0;
		try (Scanner teclado1 = new Scanner(System.in)){
			do{ 
				menu1();

				try{    
					opcion = teclado1.nextInt();                                 
				} 
				catch (InputMismatchException imEx){
					teclado1.next();
					opcion = 0;
				}
				teclado1.nextLine();
				switch (opcion){
				case 1:
					System.out.println("Introduce el nombre de la obra de pintura: ");
					String nombreObra = teclado.next();

					System.out.println("Introduce el año de realizacion: ");
					int anoObra = teclado.nextInt();

					System.out.println("Introduce el nombre del autor de la obra: ");
					String autorObra = teclado.next();

					System.out.println("Introduce la tecnica utilizada: (oleo, acuarela)");
					String aux = teclado.next();
					if(aux.equals("oleo")) {
						tecnicaUtilizada  = Tecnica.oleo;
					}else {
						tecnicaUtilizada  = Tecnica.acuarela;
					}

					Pintura obra = new Pintura(nombreObra, ciudadObra, anoObra, autorObra, tecnicaUtilizada);
					if (PinturaSinDuplicados.stream().anyMatch(c -> c.equals(obra))){
						throw new ObraAlreadyExistsException(String.format("La obra de arte %s ya existe en la lista de obras", nombreObra));
					}
					else{
						PinturaSinDuplicados.add(obra);
					}
					break;
				case 2:
					System.out.println("Introduce el nombre de la obra de arquitectura: ");
					String nombreObra1 = teclado.next();

					System.out.println("Introduce el año de realizacion: ");
					int anoObra1 = teclado.nextInt();

					System.out.println("Introduce el tipo de arquitectura: (castillo, catedral, plaza, museo, teatro)");
					String aux1 = teclado.next();
					if(aux1.equals("castillo")) {
						tipoUtilizado  = Tipo.castillo;
					}else if(aux1.equals("catedral")){
						tipoUtilizado  = Tipo.catedral;
					}else if(aux1.equals("plaza")){
						tipoUtilizado  = Tipo.plaza;
					}else if(aux1.equals("museo")){
						tipoUtilizado  = Tipo.museo;
					}else {
						tipoUtilizado  = Tipo.teatro;
					}

					Arquitectura obra1 = new Arquitectura(nombreObra1, ciudadObra, anoObra1, tipoUtilizado);
					if (ArquitecturaSinDuplicados.stream().anyMatch(c -> c.equals(obra1))){
						throw new ObraAlreadyExistsException(String.format("La obra de arte %s ya existe en la lista de obras", nombreObra1));
					}
					else{
						ArquitecturaSinDuplicados.add(obra1);
					}
					break;
				case 3:
					System.out.println("Introduce el nombre de la obra de escultura: ");
					String nombreObra2 = teclado.next();

					System.out.println("Introduce el año de realizacion: ");
					int anoObra2 = teclado.nextInt();

					System.out.println("Introduce el nombre del autor de la obra: ");
					String autorObra2 = teclado.next();

					System.out.println("Introduce el material de la obra: ");
					String materialObra = teclado.next();

					Escultura obra2 = new Escultura(nombreObra2, ciudadObra, anoObra2, autorObra2, materialObra);
					if (EsculturaSinDuplicados.stream().anyMatch(c -> c.equals(obra2))){
						throw new ObraAlreadyExistsException(String.format("La obra de arte %s ya existe en la lista de obras", nombreObra2));
					}
					else{
						EsculturaSinDuplicados.add(obra2);
					}
					break;
				case 4:
					System.out.println("Gracias.");
					break;
				default:
					System.out.println("No existe esta opcion.");
				}
			} while (opcion != 4);
		}
	}

	@Override
	public void buscarCiudad(Scanner teclado) throws CityNotFoundException {
		System.out.print("¿Que ciudad quieres buscar?");        
		System.out.println(findCiudad(teclado));
	}

	@Override
	public void buscarObrasDeArte(Scanner teclado) throws ObraNotFoundException {
		System.out.print("¿Que tipo de obra de arte quieres buscar? (pintura, arquitectura, escultura)");    
		String aux = teclado.next();
		if(aux.equals("pintura")) {
			System.out.println(findPinturaObra(teclado));
		}else if(aux.equals("arquitectura")) {
			System.out.println(findArquitecturaObra(teclado));
		}else {
			System.out.println(findEsculturaObra(teclado));
		}
	}

	@Override
	public void listarCiudades() {
		System.out.println("Las ciudades almacenadas son: ");
		int i = 0;

		Collections.sort(ciudadesSinDuplicados);

		for (Ciudad city : ciudadesSinDuplicados){
			System.out.println(String.format("%d. %s - %s: %d", ++i, city.getNombre(), city.getPais(), city.getNumeroHabitantes()));
		}
	}

	@Override
	public void listarObrasDeArte() {
		System.out.println("Las Obras de arte almacenadas son: ");
		int i = 0;

		Collections.sort(PinturaSinDuplicados);
		Collections.sort(EsculturaSinDuplicados);
		Collections.sort(ArquitecturaSinDuplicados);

		for (Pintura obra : PinturaSinDuplicados){
			obra.toString();
		}
		for (Escultura obra : EsculturaSinDuplicados){
			obra.toString();
		}
		for (Arquitectura obra : ArquitecturaSinDuplicados){
			obra.toString();
		}
	}

	/////////////////////////////////////////////	Metodos Privados	//////////////////////////////////////////////////////////////////////////

	private static void menu1(){
		System.out.println("");
		System.out.println("¿Qué tipo de obra quieres añadir?");
		System.out.println("1. Pintura");
		System.out.println("2. Arquitectura");
		System.out.println("3. Escultura");
		System.out.println("4. Terminar y salir");
	}

	private Ciudad findCiudad(Scanner teclado) throws CityNotFoundException {
		String nombreCiudad = teclado.next();
		long count = ciudadesSinDuplicados.stream().filter(c -> c.getNombre().equals(nombreCiudad)).count();

		if (count == 0){
			throw new CityNotFoundException(String.format("La ciudad %s no existe", nombreCiudad));
		}
		else{
			String pais = null;
			if (count != 1){
				System.out.print(String.format("Existe mas de una ciudad con el nombre %s. ¿A que pais pertenece?", nombreCiudad));
				pais = teclado.nextLine();
			}
			return getCity(nombreCiudad, pais);
		}
	}

	private Ciudad getCity(String nombreCiudad, String pais) throws CityNotFoundException {
		Optional<Ciudad> cityFound;
		if (pais == null){
			cityFound = ciudadesSinDuplicados.stream().filter(c -> c.getNombre().equals(nombreCiudad)).findFirst();
		}
		else{
			cityFound = ciudadesSinDuplicados.stream().filter(c -> c.equals(new Ciudad(nombreCiudad, pais))).findFirst();
		}  
		if (!cityFound.isPresent()){         
			throw new CityNotFoundException(String.format("La ciudad %s no existe en el pais %s", nombreCiudad, pais));
		}
		else{
			return cityFound.get();
		}         
	}

	private Pintura findPinturaObra(Scanner teclado) throws ObraNotFoundException {
		String nombreObra = teclado.next();
		long count = PinturaSinDuplicados.stream().filter(c -> c.getNombre().equals(nombreObra)).count();

		if (count == 0){
			throw new ObraNotFoundException(String.format("La obra %s no existe", nombreObra));
		}
		else{
			return getPinturaObra(nombreObra);
		}
	}

	private Pintura getPinturaObra(String nombre) throws ObraNotFoundException {
		Optional<Pintura> obraFound;
		obraFound = PinturaSinDuplicados.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();
		return obraFound.get();
	}

	private Arquitectura findArquitecturaObra(Scanner teclado) throws ObraNotFoundException {
		String nombreObra = teclado.next();
		long count = ArquitecturaSinDuplicados.stream().filter(c -> c.getNombre().equals(nombreObra)).count();

		if (count == 0){
			throw new ObraNotFoundException(String.format("La obra %s no existe", nombreObra));
		}
		else{
			return getArquitecturaObra(nombreObra);
		}
	}

	private Arquitectura getArquitecturaObra(String nombre) throws ObraNotFoundException {
		Optional<Arquitectura> obraFound;
		obraFound = ArquitecturaSinDuplicados.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();
		return obraFound.get();
	}

	private Escultura findEsculturaObra(Scanner teclado) throws ObraNotFoundException {
		String nombreObra = teclado.next();
		long count = EsculturaSinDuplicados.stream().filter(c -> c.getNombre().equals(nombreObra)).count();

		if (count == 0){
			throw new ObraNotFoundException(String.format("La obra %s no existe", nombreObra));
		}
		else{
			return getEsculturaObra(nombreObra);
		}
	}

	private Escultura getEsculturaObra(String nombre) throws ObraNotFoundException {
		Optional<Escultura> obraFound;
		obraFound = EsculturaSinDuplicados.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();
		return obraFound.get();
	}
}
