
package presentacion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Localidad;
import dominio.Municipio;
import dominio.Provincia;
public class InterfazUsuario {

    private  ArrayList<Provincia> provincias;
    private  Scanner sc = new Scanner(System.in);
    public InterfazUsuario(){
        File f=new File("provincias.txt");
        try {
            ObjectInputStream obj=new ObjectInputStream(new FileInputStream(f));
            provincias=(ArrayList<Provincia>)obj.readObject();
            obj.close();
        } catch (Exception e) {
            provincias=new ArrayList<Provincia>();
        }
    }
 
    public void grabar(){
        File f=new File("provincias.dat");
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(provincias);
            oos.close();
        } catch (Exception e) {
            System.out.print("Error al grabar");
        }
    }
    public  boolean procesarPeticion (String peticion){
        String [] p=peticion.split(" ");
        if (p.length==1)
            if  (p[0].equals("addProvincia"))
               aniadirProvincia();
            else if (p[0].equals("addMunicipio"))
               aniadirMunicipio();
            else if (p[0].equals("addLocalidad"))
            aniadirLocalidad();
            else if (p[0].equals("read"))
                leer();
            else if (p[0].equals("list"))
                    System.out.println (provincias);
            else if (p[0].equals("help"))
                    System.out.println("introduzca una de las siguientes peticiones: \n addProvincia: añadir provincia\n addMunicipio: añadir Municipio\n addLocalidad: añadir Localidad\n list: listar el contenido\n read: lectura inicial\n exit: salir\n");
            else if (p[0].equals("exit")){
                    grabar();
                    return false;
            }
            else {
                    System.out.println("petición erronea");
                    procesarPeticion("help");
                }
        else {
            System.out.println("petición erronea");
            procesarPeticion("help");
        }
        return true;
    }
    public  void aniadirProvincia(){
        System.out.print("Introduzca el nombre de la provincia: ");
        String nombre=sc.nextLine();
        Provincia p=new Provincia(nombre);
        provincias.add(p);
    }
 
    public  void aniadirMunicipio(){
        System.out.print("Introduzca el nombre del municipio: ");
        String nombre=sc.nextLine();
        Municipio m=new Municipio(nombre);
        for (int i=0;i<provincias.size();i++)
            System.out.println(i+": " + provincias.get(i).getNombre());
        System.out.print("Introduzca el número de la provincia: ");
        int i=sc.nextInt();
        sc.nextLine();
        provincias.get(i).add(m);
    }
 
    public  void aniadirLocalidad(){
        System.out.print("Introduzca el nombre de la localidad: ");
        String nombre=sc.nextLine();
        System.out.print("Introduzca la población de la localidad: ");
        int poblacion=sc.nextInt();
        Localidad localidad=new Localidad(nombre, poblacion);
        for (int i=0;i<provincias.size();i++)
            System.out.println(i+": " + provincias.get(i).getNombre());
        System.out.print("Introduzca el número de la provincia: ");
        int i=sc.nextInt();
        sc.nextLine();
        for (int j=0;j<provincias.get(i).size();j++)
            System.out.println(j+": " + provincias.get(i).getMunicipio(j).getNombre());
        System.out.print("Introduzca el número del municipio: ");
        int j=sc.nextInt();
        sc.nextLine();
        provincias.get(i).getMunicipio(j).add(localidad);
    }
    public String leerPeticion(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }
 
    public  void leer(){
            String nombreP, nombreM, nombreL;
            do {
            System.out.print("Introduce el nombre de la provincia (<enter> para finalizar: ");
            nombreP=sc.nextLine();
            if(!nombreP.equals("")){
                Provincia provincia=new Provincia(nombreP);
                do {
                    System.out.print("Introduce el nombre del municipio (<enter> para finalizar: ");
                    nombreM=sc.nextLine();
                    if(!nombreM.equals("")){
                        Municipio municipio=new Municipio(nombreM);
                        do {
                            System.out.print("Introduce el nombre de la localidad (<enter> para finalizar: ");
                            nombreL=sc.nextLine();
                            if(!nombreL.equals("")){
                                System.out.print("Introduce la población de la localidad: ");
                                int poblacion=sc.nextInt();
                                sc.nextLine();
                                Localidad localidad=new Localidad(nombreL,poblacion);
                                municipio.add(localidad);
                            }
                        } while (!nombreL.equals(""));
                        provincia.add(municipio);
                    }
                } while (!nombreM.equals(""));
                provincias.add(provincia);
            }
    }
    while (!nombreP.equals(""));
 
    }
 
}
 
