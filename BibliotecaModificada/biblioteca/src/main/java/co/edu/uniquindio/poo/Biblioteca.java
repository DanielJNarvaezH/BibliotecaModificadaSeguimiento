/**
 * Clase que modela una libreria y permite registrar libros.
 * 
 * @author Área de programación UQ - Daniel Josué Narváez Hincapié
 * @since 24/09/2023
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class Biblioteca {
    private final String nombreBiblioteca;
    private final Collection<Libro> listaLibros;
    //private static int numeroLibros;
    private final int limiteCantidadLibros;

    public Biblioteca(String nombreBiblioteca, int limiteCantidadLibros) {
        //assert numeroLibros >= 0;
        assert nombreBiblioteca != null && !nombreBiblioteca.isBlank() : "El nombre es requerido";
        assert limiteCantidadLibros > 0;
        //setIncrementarNumeroLibros();
        this.nombreBiblioteca = nombreBiblioteca;
        this.limiteCantidadLibros = limiteCantidadLibros;
        this.listaLibros = new LinkedList<Libro>();
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public Collection<Libro> getListaLibros() {
        return Collections.unmodifiableCollection(listaLibros);
    }

    /*public static int getNumeroLibros() {
        return numeroLibros;
    }*/

    public int getLimiteCantidadLibros() {
        return limiteCantidadLibros;
    }

    /*private static void setIncrementarNumeroLibros() {
        numeroLibros++;
    }*/


    public void registrarLibro(Libro libro) {
        validarLibroExistente(libro);
        listaLibros.add(libro);
    }


    public void validarLibroExistente(Libro libro) {
        boolean nombreLibroExistente = buscarlistaLibrosPorNombre(libro.getNombre()).isPresent();
  
        assert !nombreLibroExistente: "El libro ya esta registrado";
    }

    public Optional<Libro> buscarlistaLibrosPorNombre(String nombreLibro) {
        Predicate<Libro> condicion = libro -> libro.getNombre().equals(nombreLibro);
        return listaLibros.stream().filter(condicion).findAny();
    }

    
}