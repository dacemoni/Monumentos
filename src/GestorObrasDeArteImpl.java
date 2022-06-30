package obrasDeArte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class GestorObrasDeArteImpl implements GestorObrasDeArte{
	private List<ObraDeArte> obraDeArteSinDuplicados;
	private List<Ciudad> ciudadesSinDuplicados;

	public GestorObrasDeArteImpl() {
		ciudadesSinDuplicados = new ArrayList<>();
		obraDeArteSinDuplicados = new ArrayList<>();
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
	public void nuevaObraDeArte(Scanner teclado) throws ObraAlreadyExistsException {
		System.out.println("Introduce la ciudad: ");
		String ciudad = teclado.next();

		System.out.println("Introduce el nombre de la obra de arte: ");
		String nombre = teclado.next();

		System.out.println("Introduce el formato: ");      
		String formato = teclado.next();

		System.out.println("Introduce el año: ");      
		int anoRealizacion = teclado.nextInt();
		
		ObraDeArte obra = new ObraDeArte(nombre, ciudad, formato, anoRealizacion);

		if (obraDeArteSinDuplicados.stream().anyMatch(c -> c.equals(obra))){
			throw new ObraAlreadyExistsException(String.format("La obra de arte %s ya existe en la lista de obras", nombre));
		}
		else{
			obraDeArteSinDuplicados.add(obra);
		}
	}

	@Override
	public void buscarCiudad(Scanner teclado) throws CityNotFoundException {
		System.out.print("¿Que ciudad quieres buscar?");        
		System.out.println(findCiudad(teclado));
	}

	@Override
	public void buscarObrasDeArte(Scanner teclado) throws ObraNotFoundException {
		System.out.print("¿Que obra de arte quieres buscar?");        
		System.out.println(findObra(teclado));
	}

	@Override
	public void borrarCiudad(Scanner teclado) throws CityNotFoundException {
		System.out.println("¿Que ciudad quieres borrar?");
		Ciudad cityToDelete = findCiudad(teclado);

		ciudadesSinDuplicados.remove(cityToDelete);

		System.out.print(String.format("La ciudad %s se ha eliminado correctamente.", cityToDelete.getNombre()));
	}

	@Override
	public void borrarObraDeArte(Scanner teclado) throws ObraNotFoundException {
		System.out.println("¿Que obra de arte quieres borrar?");
		ObraDeArte obraToDelete = findObra(teclado);

		ciudadesSinDuplicados.remove(obraToDelete);

		System.out.print(String.format("La obra de arte %s se ha eliminado correctamente.", obraToDelete.getNombre()));
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

		Collections.sort(obraDeArteSinDuplicados);

		for (ObraDeArte obra : obraDeArteSinDuplicados){
			System.out.println(String.format("%d. %s - %s: %d", ++i, obra.getNombre(), obra.getFormato(), obra.getCiudadPerteneciente(), obra.getAnoRealizacion()));
		}

	}
/////////////////////////////////////////////	Metodos Privados	//////////////////////////////////////////////////////////////////////////

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

	private ObraDeArte findObra(Scanner teclado) throws ObraNotFoundException {
		String nombreCiudad = teclado.next();
		long count = ciudadesSinDuplicados.stream().filter(c -> c.getNombre().equals(nombreCiudad)).count();

		if (count == 0){
			throw new ObraNotFoundException(String.format("La obra %s no existe", nombre));
		}
		else{
			String pais = null;
			if (count != 1){
				System.out.print(String.format("Existe mas de una obra con el nombre %s. ¿A que pais pertenece?", nombreCiudad));
				pais = teclado.nextLine();
			}
			return getObra(nombreCiudad, pais);
		}
	}

	private ObraDeArte getObra(String nombre, String pais) throws ObraNotFoundException {
		Optional<ObraDeArte> obraFound;
		if (pais == null){
			obraFound = obraDeArteSinDuplicados.stream().filter(c -> c.getNombre().equals(nombre)).findFirst();
		}
		else{
			obraFound = obraDeArteSinDuplicados.stream().filter(c -> c.equals(new ObraDeArte(nombre, pais))).findFirst();
		}  
		if (!obraFound.isPresent()){         
			throw new ObraNotFoundException(String.format("La obra %s no existe en la ciudad %s", nombre, pais));
		}
		else{
			return obraFound.get();
		}         
	}
}
