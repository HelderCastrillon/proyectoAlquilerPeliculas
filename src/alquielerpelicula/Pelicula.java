/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquielerpelicula;

/**
 *
 * @author Helder Castrillon
 */
public class Pelicula {
    
    private String genero ;
    private String nombre;
    private int codigo;

    public Pelicula(String genero, String nombre, int codigo) {
        this.genero = genero;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
    
}
