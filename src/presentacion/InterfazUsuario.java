package presentacion;
import dominio.*;
import java.util.*;

public class InterfazUsuario {
    
    public static ArrayList<Provincia> leer(){

        ArrayList<Provincia> provincias = new ArrayList<>();

        Scanner sc = new Scanner(System.in);


    

     do{
        System.out.println("Nombre de la provincia(enter para finalizar)");
        String nonProvincia = sc.nextLine();
            if(nonProvincia != ""){
                Provincia p = new Provincia(nonProvincia);
                    do{
                        System.out.println("Nombre de la Municipio(enter para finalizar)");
                        String nonMunicipio = sc.nextLine();
                            if(nonMunicipio != ""){
                                Municipio m = new Municipio(nonMunicipio);
                                p.addMunicipio(m);

                                do{
                                    System.out.println("Nombre de la localidad(enter para finalizar)");
                                    System.out.println("Numero de los habintates de la localidad(enter para finalizar)");
                                    String nonLocalidad = sc.nextLine();
                                    int nonHabitantes = sc.nextInt();
                                        if(nonLocalidad  != ""){
                                            Localidad d = new Localidad(nonLocalidad,nonHabitantes );
                                            m.addLocalidad(d);
                                        }
                                }
                            }
                        }
               
                }

        }while(nonProvincia != "");
            return provincias;
    }
}
