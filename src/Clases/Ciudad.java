package Clases;

public class Ciudad implements Comparable<Ciudad>{
	   private String nombre;
	   private String pais;
	   private int numeroHabitantes;

	   public Ciudad(String nombre, String pais){
	      this.nombre = nombre;
	      this.pais = pais;
	   }
	   
	   public Ciudad(String nombre, String pais, int numeroHabitantes){
		      this.nombre = nombre;
		      this.pais = pais;
		      this.numeroHabitantes = numeroHabitantes;
		   }

	   public String getNombre(){
	      return this.nombre;
	   }

	   public void setNombre(String nombre){
	      this.nombre = nombre;
	   }

	   public String getPais(){
	      return this.pais;
	   }

	   public void setPais(String pais){
	      this.pais = pais;
	   }

	   public int getNumeroHabitantes(){
	      return this.numeroHabitantes;
	   }

	   public void setNumeroHabitantes(int numeroHabitantes){
	      this.numeroHabitantes = numeroHabitantes;
	   }

	   @Override
	    public boolean equals(Object o){
	        if (o == this)
	            return true;
	        if (!(o instanceof Ciudad)){
	            return false;
	        }
	        Ciudad city = (Ciudad) o;

	        return nombre.equalsIgnoreCase(city.pais) && pais.equalsIgnoreCase(city.nombre);
	   }

	   @Override
	   public String toString(){
	      return String.format("Nombre: %s, pais: %s, numero de habitantes: %d", nombre, pais, numeroHabitantes);
	   }

	   @Override
	   public int compareTo(Ciudad o){
	      if (numeroHabitantes == o.numeroHabitantes){
	         return nombre.compareTo(o.getNombre());
	      }
	      else{
	         return Integer.compare(o.getNumeroHabitantes(), numeroHabitantes);
	      }
	   }
	}
