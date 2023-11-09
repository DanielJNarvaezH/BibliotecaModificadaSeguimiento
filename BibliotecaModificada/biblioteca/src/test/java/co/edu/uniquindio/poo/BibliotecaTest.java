
 /*  Testeo del correcto registro del libro en la librería.
 * 
 * @author Área de programación UQ - Daniel Josue Narváez Hincapié
 * @since 24/09/2023
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */

package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class BibliotecaTest {

    private static final Logger LOG = Logger.getLogger( BibliotecaTest.class.getName());

    
    @Test
    public void datosCompletos() {
        LOG.info("Inicio de prueba datos completos...");

        Libro libro = new Libro("50 sombras de Josué", "Daniel Josué", "Obo quindiano",
                "Narrativo", 169, LocalDate.of(2023, 9, 03), "978-987-25620-2-1");
        assertEquals("50 sombras de Josué", libro.getNombre());

        LOG.info("Fin de prueba datos completos...");
    }

    
    @Test
    public void datosNulos() {
        LOG.info("Inicio de prueba datos nulos...");

        assertThrows(Throwable.class, () -> new Libro(null, null, null, null, 0, null, null));

        LOG.info("Fin de prueba datos nulos...");
    }

    @Test
    public void numeroDePaginasNegativos() {
        LOG.info("Inicio de prueba número de paginas negativo...");

        assertThrows(Throwable.class, ()-> new Libro("La asombrosas aventuras de Diego el constipado","Daniel Josué", "Tristán caluchis", "Romántico", -169, LocalDate.of(2023, 6, 03), "978-987-25620-2-1"));
        
        LOG.info("Fin de prueba número de paginas negativo...");
    }

  
    @Test
    public void limiteCantidadLibrosNegativo() {
        LOG.info("Inicio de prueba limites de edades negativo...");

        assertThrows(Throwable.class, ()-> new Biblioteca("Trinity College Old Library", -100));
        
        LOG.info("Fin de prueba  limites de edades negativo...");
    }

   
    @Test
    public void libroRepetidoTest() {
        LOG.info("Inicio de prueba libro repetido...");
        Biblioteca biblioteca1 = new Biblioteca("Bibliomania", 666);
        var libro5 = new Libro("Calumnias de la flores", "Daniel Josué", "Obo quindiano", "Dramático", 145, LocalDate.of(2023, 4, 06), "978-987-25620-2-1");
        var libro4 = new Libro("Calumnias de la flores", "Daniel Josué", "trinity seven", "Dramático", 145, LocalDate.of(2023, 4, 06), "978-987-25620-2-1");
        biblioteca1.registrarLibro(libro5);
        assertThrows(Throwable.class, ()-> biblioteca1.registrarLibro(libro4));
        
        LOG.info("Fin de prueba nombre y editorial repetidos...");
    }
}