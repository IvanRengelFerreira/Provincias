package aplicacion;
import dominio.*;
import presentacion.InterfazUsuario;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        InterfazUsuario interfaz=new InterfazUsuario();
        String peticion;
        interfaz.procesarPeticion("help");
        do {
            peticion=interfaz.leerPeticion();
        } while (interfaz.procesarPeticion(peticion));
    }
}