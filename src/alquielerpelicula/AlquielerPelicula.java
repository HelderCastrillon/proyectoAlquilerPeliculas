package alquielerpelicula;

import alquierpelicula.view.jfPrincipal;
import alquilerPelicula.dao.Utilidades;
import alquilerPelicula.model.Persona;
import alquilerPelicula.model.Pelicula;
import alquilerPelicula.model.Alquiler;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private List <Persona>lPersonas = new ArrayList<>();

    public static void main(String[] args) throws IOException {

       jfPrincipal frameinicial = new jfPrincipal(); 
       frameinicial.setVisible(true);
      }
    
    public static void modoConsola() throws IOException{
        ////
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
                    registroAlquiler(leer,mPersona,mPelicula);
                    break;
                case 4:
                    verAlquier();
                    break;
            }
        }while(opcion!=5);
    }
    
    public static void verPersonas(){
        List <Persona>lPersonas = new ArrayList<>();
        lPersonas=  misUtilidades.leerArchivoPersona("F:\\TestSO\\Alquiler\\personas.txt");
        System.out.println("Listado de Personas");
        System.out.println("_________________________________");
        System.out.println("Identificación              Nombre              Dirección       Teléfono");
        for(int i =0; i< lPersonas.size(); i++ ){
            System.out.printf("%s\t\t\t%s\t\t\t%s\n",lPersonas.get(i).getIdenficacion(), lPersonas.get(i).getNombre(),lPersonas.get(i).getDireccion(), lPersonas.get(i).getTelefono());
        }
        System.out.println("_________________________________");

    }
     public static void verPeliculas(){
        List <Pelicula>lPeliculas = new ArrayList<>();
        lPeliculas=  misUtilidades.leerArchivoPeliculas("F:\\TestSO\\Alquiler\\peliculas.txt");
         System.out.println("Listado de Peliculas");
        System.out.println("_________________________________");
        System.out.println("Código              Nombre              Genero");
        for(int i =0; i< lPeliculas.size(); i++ ){
            System.out.printf("%s\t\t\t%s\t\t\t%s\n",lPeliculas.get(i).getCodigo(), lPeliculas.get(i).getNombre(),lPeliculas.get(i).getGenero() );
        }
        System.out.println("_________________________________");
    }
     public static void verAlquier(){
        List <Alquiler>lAlquiler = new ArrayList<>();
         List <Persona>lPersonas = new ArrayList<>();
        lPersonas=  misUtilidades.leerArchivoPersona("F:\\TestSO\\Alquiler\\personas.txt");
        List <Pelicula>lPeliculas = new ArrayList<>();
        lPeliculas=  misUtilidades.leerArchivoPeliculas("F:\\TestSO\\Alquiler\\peliculas.txt");
       
        lAlquiler=  misUtilidades.leerArchivoAlquiler("F:\\TestSO\\Alquiler\\alquiler.txt",lPersonas, lPeliculas);
        
        System.out.println("Listado de Personas");
        System.out.println("_________________________________");
        System.out.println("Persona              Pelicula              fecha");
        for(int i =0; i< lAlquiler.size(); i++ ){
             System.out.printf("%s\t\t\t%s\t\t\t%s\n",lAlquiler.get(i).getDPersona().getNombre(),lAlquiler.get(i).getDPelicula().getNombre(),lAlquiler.get(i).getFechaAlquiler().toString());  
        }
        System.out.println("_________________________________");

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
         
         misUtilidades.guardarEnArchivo("F:\\TestSO\\Alquiler\\peliculas.txt", genero+","+nombre+","+codigo+"\n");
         Pelicula mPelicula= new Pelicula(genero, nombre, codigo);
         return mPelicula;

    }

    public static void registroAlquiler(Scanner leer,Persona DPersona, Pelicula DPelicula) {

        System.out.println("Para realizar el alquiler se debe primero seleccionar la pelicula");
        verPeliculas();
        System.out.println("Seleccione una película por su código");
        int codigoPelicula=leer.nextInt();
        System.out.println("A continuación, debe seleccionar una persona");
        verPersonas();
        System.out.println("Seleccione una persona por su identificación");
        int identifcacionPersona=leer.nextInt();
        System.out.println("Digite el año alquia la pelicula");
        int anno=leer.nextInt();
        System.out.println("Digite el mes alquia la pelicula");
        int mes=leer.nextInt();
        System.out.println("Digite el día  alquia la pelicula");
        int dia=leer.nextInt();
        
        LocalDate fechaAlquiler= LocalDate.of(anno, mes, dia);
        //Alquiler objAlquilar = new Alquiler(DPersona, DPelicula, fechaAlquiler);
        misUtilidades.guardarEnArchivo("F:\\TestSO\\Alquiler\\alquiler.txt", identifcacionPersona+","+codigoPelicula+","+fechaAlquiler.toString());


    }
}
