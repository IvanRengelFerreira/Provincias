package dominio.*;
import java.util.*;

public class Municipio{
	private String nombre;
	private ArrayList<Localidad> localidades;

	public Municipio(String nombre){
		this.nombre = nombre;
		localidades = new ArrayList<Localidad>();
	}
	public Municipio addLocalidad(Localidad l){
		localidades.add(l);
		return this;
	}

public String toString(){
	String cad = "Localidad: "+nombre+" Municipio: /n ";
	for(Localidad l: localidades)
		cadt = l+"/n"
}


}
