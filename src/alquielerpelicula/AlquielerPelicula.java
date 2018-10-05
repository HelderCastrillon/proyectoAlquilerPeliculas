package alquielerpelicula;

import java.io.IOException;
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
        Persona mPersona=null;
        Pelicula mPelicula=null;
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
                    mPersona=registrarPersona(leer);                    
                    break;
                case 2:
                    mPelicula= registrarPelicula(leer);
                    break;
                case 3:
                    if(mPersona!=null && mPelicula!=null)
                        registroAlquiler(leer,mPersona,mPelicula);
                   else
                        System.out.println("Debe primero registrar una persona y al menos una pelicula");
                        
            }
        }while(opcion!=5);



    }

    public static Persona registrarPersona( Scanner leer) throws IOException {

         System.out.println("Digite la siguente información.");
         System.out.println("Digite el nombre");
         String nombre= leer.next();
         System.out.println("Digite la dirección");
         String direccion= leer.next();
         System.out.println("Digite el telefono");
         int telefono= leer.nextInt(); 
         System.out.println("Digite la identificación");
         int identificacion= leer.nextInt();  
         
         misUtilidades.guardarEnArchivo("F:\\TestSO\\Alquiler\\personas.txt", nombre+","+direccion+","+telefono+","+identificacion);
         Persona mPersona= new Persona(nombre, direccion, telefono, identificacion);
         return mPersona;
    }
    
    public static Pelicula registrarPelicula(Scanner leer) {
         System.out.println("Digite la siguente información.");
          System.out.println("Digite el nombre de la pelicula");
         String nombre= leer.next();
         System.out.println("Digiteel genero de la pelicula");
         String genero= leer.next();
         System.out.println("Digite el codigo");
         int codigo= leer.nextInt();       
         
         misUtilidades.guardarEnArchivo("F:\\TestSO\\Alquiler\\pelicuas.txt", nombre+","+genero+","+codigo+"\n");
         Pelicula mPelicula= new Pelicula(genero, nombre, codigo);
         return mPelicula;

    }

    public static void registroAlquiler(Scanner leer,Persona DPersona, Pelicula DPelicula) {

        System.out.println("Digite el año alquia la pelicula");
        int anno=leer.nextInt();
        System.out.println("Digite el mes alquia la pelicula");
        int mes=leer.nextInt();
        System.out.println("Digite el día  alquia la pelicula");
        int dia=leer.nextInt();
        
        LocalDate fechaAlquiler= LocalDate.of(anno, mes, dia);
        //Alquiler objAlquilar = new Alquiler(DPersona, DPelicula, fechaAlquiler);
        misUtilidades.guardarEnArchivo("F:\\TestSO\\Alquiler\\alquiter.txt", DPersona.getNombre()+","+DPelicula.getCodigo()+","+fechaAlquiler.toString());


    }
}
