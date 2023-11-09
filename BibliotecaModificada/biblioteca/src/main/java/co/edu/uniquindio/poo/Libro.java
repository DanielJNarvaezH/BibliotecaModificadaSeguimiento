package co.edu.uniquindio.poo;

import java.time.LocalDate;

public class Libro{

    private String nombre; 
    private String autor;
    private String editorial;  
    private String genero;
    private int numDePaginas; 
    private LocalDate fechaPublicacion; 
    private String isbn;

    public Libro(){

    }
    public Libro(String nombre, String autor, String editorial, String genero, int numDePaginas,
    LocalDate fechaPublicacion, String isbn) {
        
    assert nombre != null && !nombre.isBlank() : "El nombre es requerido";
    assert editorial != null && !editorial.isBlank() : "La editorial es requerida";
    assert numDePaginas > 0 : "El numero de paginas es requerido";
    assert fechaPublicacion != null && fechaPublicacion.isBefore(LocalDate.now().plusDays(1))
        : "La fecha de publicacion es requerida y no puede ser futura";
    assert isbn != null && !isbn.isBlank() : "El ISBN es requerido";
    this.nombre = nombre;
    this.autor = autor;
    this.editorial = editorial;
    this.genero = genero;
    this.numDePaginas = numDePaginas;
    this.fechaPublicacion = fechaPublicacion;
    this.isbn = isbn;
}

    public String getNombre(){
        return nombre;
    }

    public String getAutor(){
        return autor;
    }

    public String getEditorial(){
        return editorial;
    }
    
    public String getGenero(){
        return genero;
    }

    public int getNumeroDePaginas(){
        return numDePaginas;
    }

    public LocalDate getFechaPublicacion(){
        return fechaPublicacion;
    }

    public String getIsbn(){
        return isbn;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

     public void setAutor(String autor){
        this.autor = autor;
    }

     public void setEditorial(String editorial){
        this.editorial = editorial;
    }

     public void setGenero(String genero){
        this.genero = genero;
    }

     public void setNumDePaginas(int numDePaginas){
        this.numDePaginas  = numDePaginas;

    }

     public void setFechaDePublicacion(LocalDate fechaDePublicacion){
        this.fechaPublicacion = fechaDePublicacion;
    }

     public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    
   
    public boolean verificarNombrePalindroma() {

        String invertida= ""; 

        for(int i = nombre.length()-1; i >= 0; i--){
            invertida +=  nombre.charAt(i);
        }

        return invertida.equals(nombre);
    }

    public boolean verificarVocalesSeguidas() {
        //scope/alcance 
        //String mensaje = "";
        boolean tieneVocalesSeguidas = false;
        for (int i = 0; i < isbn.length()-1 || tieneVocalesSeguidas; i++) {
            String lowerIsbn = isbn.toLowerCase();
            char charInicial = lowerIsbn.charAt(i);
            char charPosterior = lowerIsbn.charAt(i + 1);
            if (esVocal(charInicial) && esVocal(charPosterior)) {
                
                tieneVocalesSeguidas = true;

                //mensaje += "Hay 2 vocales seguidas";
                return tieneVocalesSeguidas;
            }
        }
        //mensaje += "No hay vocales seguidas";
        return tieneVocalesSeguidas;
    }
    
    public boolean esVocal(char vocal) {
        return vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u';
    }
    @Override
    public String toString() {
        return "Libro [nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", genero=" + genero
                + ", numDePaginas=" + numDePaginas + ", fechaPublicacion=" + fechaPublicacion + ", isbn=" + isbn + "]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Libro other = (Libro) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (autor == null) {
            if (other.autor != null)
                return false;
        } else if (!autor.equals(other.autor))
            return false;
        if (editorial == null) {
            if (other.editorial != null)
                return false;
        } else if (!editorial.equals(other.editorial))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (numDePaginas != other.numDePaginas)
            return false;
        if (fechaPublicacion == null) {
            if (other.fechaPublicacion != null)
                return false;
        } else if (!fechaPublicacion.equals(other.fechaPublicacion))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
    
    
    
}
