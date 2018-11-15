/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerPelicula.dao;

import alquiler.connect.pgConnect;
import alquilerPelicula.model.Pelicula;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Helder Castrillon
 */
public class peliculaDao {
    
    public static List<Pelicula> getPelicula(){
      List<Pelicula> listaEstudiantes = new ArrayList();
                // TODO code application logic here

              try {
                  pgConnect connectPG = new pgConnect();
                  Connection conex=connectPG.settingConnect();
                  java.sql.Statement st = conex.createStatement();  
  
                  String sql ="SELECT genero, nombre, codigo 	FROM pelicula";
                  ResultSet result = st.executeQuery(sql);
                  
                  while(result.next()) {
                      String genero = result.getString("genero");
                      String nombre = result.getString("nombre");
                      int codigo = result.getInt("codigo");                      
                      
                       Pelicula estudiante = new Pelicula(genero,nombre,codigo);
                       listaEstudiantes.add(estudiante);
                  }
                  result.close();
                  st.close();
                  conex.close();
              } catch(ClassNotFoundException | SQLException exc) {
                  System.out.println("Error: "+exc.getMessage());
                  Pelicula estudiante = new Pelicula("Error","Error no se pudo hacer la consulta SQL",0);
                   listaEstudiantes.add(estudiante);
              }

        return listaEstudiantes;
}
    
        public static String[][] getPeliculaToTable(){
             List<Pelicula> listaPelicula = getPelicula();
             String ArrayTable[][]= new String [listaPelicula.size()][3];
             for(int i=0; i< listaPelicula.size();i++ ){
                 
                ArrayTable[i][0]=String.valueOf(listaPelicula.get(i).getGenero());
                ArrayTable[i][1]=listaPelicula.get(i).getNombre();                
                ArrayTable[i][2]=String.valueOf(listaPelicula.get(i).getCodigo());
              }
             return ArrayTable;
      
        }
     public static void setPelicula(Pelicula peli){
                // TODO code application logic here

              try {
                  pgConnect connectPG = new pgConnect();
                  Connection conex=connectPG.settingConnect();
                  java.sql.Statement st = conex.createStatement();  
                  
                  //ojo con el tipo de datos
                  //idestudiante es entero
                  //nombre es String
                  //nota es entero7
                  //"INSERT INTO estudiantes (idestudiante, nombre, nota) VALUES (10,'Helder',3)"
                  String sql ="INSERT INTO pelicula(genero, nombre, codigo) VALUES ('"+peli.getGenero()+"', '"+peli.getNombre()+"', "+peli.getCodigo()+")";
                  System.out.println(sql);
                  st.executeUpdate(sql);
                  st.close();
                  conex.close();
              } catch(ClassNotFoundException | SQLException exc) {
                  System.out.println("Error: "+exc.getMessage());
              }

}
}
