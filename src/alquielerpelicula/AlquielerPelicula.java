package alquielerpelicula;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Helder Castrillon
 */
public class AlquielerPelicula {
    private static Utilidades misUtilidades;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("######    Peliculas de os 90's   #######");
            System.out.println("-----------------------------------------");
            System.out.println("Digite una opción");
            System.out.println("1. Registrar Persona");
            System.out.println("2. Crear Pelicula");
            System.out.println("3. Registrar Alquiler");
            System.out.println("4. Consultar Alquiler");
            System.out.println("5. Salir");
            opcion= leer.nextInt();
            switch(opcion){
                case 1:
                    
                    registrarPersona(leer);                    
                    break;
                case 2:
                    registrarPelicula(leer);
                    break;
                        
            }
        }while(opcion!=5);



    }

    public static void registrarPersona( Scanner leer) throws IOException {

         System.out.println("Digite la siguente información.");
         System.out.println("Digite el nombre");
         String nombre= leer.next();
         System.out.println("Digite la dirección");
         String direccion= leer.next();
         System.out.println("Digite el telefono");
         int telefono= leer.nextInt(); 
         System.out.println("Digite la identificación");
         int identificacion= leer.nextInt();  
         FileWriter personas = null;
         PrintWriter imprimirPersona=null;
         misUtilidades.guardarEnArchivo("F:\\TestSO\\personas.txt", nombre+","+direccion+","+telefono+","+identificacion);
    }
    
    public static Pelicula registrarPelicula(Scanner leer) {
         System.out.println("Digite la siguente información.");
         System.out.println("Digite la dirección");
         String genero= leer.next();
         System.out.println("Digite el nombre de la pelicula");
         String nombre= leer.next();
         System.out.println("Digite el codigo");
         int codigo= leer.nextInt(); 
        Pelicula objPeli = new Pelicula(genero, nombre, codigo);
        return objPeli;
    }

    public static Alquiler registroAlquiler(Persona DPersona, Pelicula DPelicula, LocalDate fechaAlquiler) {

        Alquiler objAlquilar = new Alquiler(DPersona, DPelicula, fechaAlquiler);

        return objAlquilar;

    }
}
