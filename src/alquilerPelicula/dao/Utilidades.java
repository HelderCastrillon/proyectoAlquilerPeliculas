/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerPelicula.dao;

import alquilerPelicula.model.Persona;
import alquilerPelicula.model.Pelicula;
import alquilerPelicula.model.Alquiler;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Castrillon
 */
public class Utilidades {
    
    public static void guardarEnArchivo(String nombreArchivo, String datos){
     try{
       //Specify the file name and path here
    	File file =new File(nombreArchivo);

    	/* This logic is to create the file if the
    	 * file is not already present
    	 */
    	if(!file.exists()){
    	   file.createNewFile();
    	}

    	//Here true is to append the content to file
    	FileWriter fw = new FileWriter(file,true);
    	//BufferedWriter writer give better performance
  
        BufferedWriter bw = new BufferedWriter(fw);
    	bw.write(datos+"\r\n");
    	//Closing BufferedWriter Stream
    	bw.close();

	System.out.println("El registro se almacenó exitosamente");

      }catch(IOException ioe){
         System.out.println("Exception occurred:");
    	 ioe.printStackTrace();
       }
    }
    
       public static List <Persona> leerArchivoPersona(String rutaArchivo) {
      //File archivo = null;
      FileReader fr = null;
      //BufferedReader br = null;
      List <Persona>lPersonas = new ArrayList<>();
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         File archivo = new File (rutaArchivo);
         fr = new FileReader (archivo);
          BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            System.out.println(linea);
            String [] valores=null;
            for(int i=0; i<linea.length();i++){
                valores= linea.split(",");              
            }
            if(valores!=null)
                lPersonas.add(new Persona(valores[0], valores[1], Integer.parseInt(valores[2]), Integer.parseInt(valores[3])));
         }
         
         return lPersonas;
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return lPersonas;
   }
       
     public static List <Pelicula> leerArchivoPeliculas(String rutaArchivo) {
      //File archivo = null;
      FileReader fr = null;
      //BufferedReader br = null;
      List <Pelicula>lPeliculas = new ArrayList<>();
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         File archivo = new File (rutaArchivo);
         fr = new FileReader (archivo);
          BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            System.out.println(linea);
            String [] valores=null;
            for(int i=0; i<linea.length();i++){
                valores= linea.split(",");              
            }
            if(valores!=null)
                lPeliculas.add(new Pelicula(valores[0], valores[1], Integer.parseInt(valores[2])));
         }
         
         return lPeliculas;
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return lPeliculas;
   }
     public static List <Alquiler> leerArchivoAlquiler(String rutaArchivo, List <Persona> lPersonas, List <Pelicula> lPeliculas) {
      //File archivo = null;
      FileReader fr = null;
      //BufferedReader br = null;
      List <Alquiler>lAlquiler = new ArrayList<>();
      Persona aPersona=null;
      Pelicula aPelicula=null;
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         File archivo = new File (rutaArchivo);
         fr = new FileReader (archivo);
          BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null){
            System.out.println(linea);
            String [] valores=null;
            for(int i=0; i<linea.length();i++){
                valores= linea.split(",");              
            }
            if(valores!=null && !lPersonas.isEmpty() && !lPeliculas.isEmpty() ){
                //buscar la persona y obtener el objeto de la persona
               for(int i=0;i<lPersonas.size();i++){
                   if(valores[0].equals(lPersonas.get(i).getIdenficacion())){
                       aPersona=lPersonas.get(i);
                       break;
                   }
               }
                 //buscar la pelicula y obtener el objeto pelicula
               for(int i=0;i<lPeliculas.size();i++){
                   if(valores[1].equals(lPeliculas.get(i).getCodigo())){
                       aPelicula=lPeliculas.get(i);
                       break;
                   }
               }
                //convertir string a fecha 2018-10-12
                 String [] aFecha=valores[2].split("-");
                LocalDate fechaAlquiler= LocalDate.of(Integer.parseInt(aFecha[0]), Integer.parseInt(aFecha[1]), Integer.parseInt(aFecha[2]));
                lAlquiler.add(new Alquiler(aPersona, aPelicula,fechaAlquiler ));
            }
                
         }
         
         return lAlquiler;
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
      return lAlquiler;
   }
}
