package dominio;
import java.util.*;

public class Provincia{
	private String nombre;
	private  ArrayList<Municipio> municipios;

	public Provincia(String nombre){
		this.nombre = nombre;
		municipios = new ArrayList<Municipio>();
	}
	
	public Provincia() {
    }

    public Provincia addMunicipio(Municipio l){
		municipios.add(l);
		return this;
	}
public String toString(){

	String cad = "Localidad: "+nombre+" Municipio: "+"/n";
	for(Municipio l: municipios)
		cad = l+"/n";
		return cad;
}	
public int getPoblacion(){

	int total = 0;

	for(Municipio l: municipios)
	total += l.getPoblacion();
	return total;
}
}