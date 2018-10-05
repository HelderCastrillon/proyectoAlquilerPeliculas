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
public class Persona {
    
    private String nombre;
    private String direccion ;
    private int telefono;
    private int idenficacion;

    public Persona(String nombre, String direccion, int telefono, int idenficacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idenficacion = idenficacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getIdenficacion() {
        return idenficacion;
    }

    public void setIdenficacion(int idenficacion) {
        this.idenficacion = idenficacion;
    }
    
    
}
