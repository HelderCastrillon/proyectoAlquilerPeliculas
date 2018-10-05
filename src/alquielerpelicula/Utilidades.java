/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquielerpelicula;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
    	bw.write(datos);
    	//Closing BufferedWriter Stream
    	bw.close();

	System.out.println("El registro se almacenó exitosamente");

      }catch(IOException ioe){
         System.out.println("Exception occurred:");
    	 ioe.printStackTrace();
       }
    }
}
