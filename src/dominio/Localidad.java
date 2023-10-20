package dominio;

public class Localidad {

	private String nombre;
	private int  habitantes;

	public Localidad(String nombre, int  habitantes){
		this.nombre = nombre;
	        this.habitantes = habitantes;	
	}
	
	public Localidad() {
    }

    public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public void setNumeroDeHabitantes(int habitantes){
		 this.habitantes = habitantes;
	}

	public String getNombre(){
		return nombre;
	}

	public int getNumeroDeHabitantes(){
                return habitantes;
        }
public String toString(){
	return "nombre:"+nombre+"/t poblacion:" +habitantes;
}

public int getPoblacion() {
    return 0;
}



}
