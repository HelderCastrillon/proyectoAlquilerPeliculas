/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquielerpelicula;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
    	bw.write(datos+"'\r\n");
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
}
