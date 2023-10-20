package dominio;
import java.util.*;

public class Municipio{
	private String nombre;
	private ArrayList<Localidad> localidades;

	public Municipio(String nombre){
		this.nombre = nombre;
		localidades = new ArrayList<Localidad>();
	}
	public Municipio() {
    }
    public Municipio addLocalidad(Localidad l){
		localidades.add(l);
		return this;
	}

public String toString(){

	String cad = "Localidad: "+nombre+" Municipio: "+"/n" ;
	for(Localidad l: localidades)
		cad = l+"/n";
		return cad;

}
	public int getPoblacion(){

		int total = 0;
	
		for(Localidad l: localidades)
		total += l.getPoblacion();
		return total;
	}

}
