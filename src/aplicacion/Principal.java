package aplicacion;
import dominio.*;

public class Principal{

	public static void main(String[]args){

	Localidad localidad1 = new Localidad();

	Municipio municipio1 = new Municipio();
	municipio1.addLocalidad(localidad1);

	Provincia provincia1 = new Provincia();
	provincia1.addMunicipio(municipio1);
	}
}
