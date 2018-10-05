/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquielerpelicula;

import java.time.LocalDate;

/**
 *
 * @author Helder Castrillon
 */
public class Alquiler {
    
    private Persona DPersona;
    private Pelicula DPelicula;
    private LocalDate fechaAlquiler;

    public Alquiler(Persona DPersona, Pelicula DPelicula, LocalDate fechaAlquiler) {
        this.DPersona = DPersona;
        this.DPelicula = DPelicula;
        this.fechaAlquiler = fechaAlquiler;
    }

    public Persona getDPersona() {
        return DPersona;
    }

    public void setDPersona(Persona DPersona) {
        this.DPersona = DPersona;
    }

    public Pelicula getDPelicula() {
        return DPelicula;
    }

    public void setDPelicula(Pelicula DPelicula) {
        this.DPelicula = DPelicula;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }
    
    
    
}
