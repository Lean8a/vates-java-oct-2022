import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner archivo = new Scanner(new File("personas2.txt"));
        Scanner teclado = new Scanner(System.in);

        archivo.useDelimiter("[\\n\\r;]+");
        int c = 0;

        Plantel pl1 = new Plantel();

        while (archivo.hasNextInt()) {
            int documento = archivo.nextInt();
            String nombre = archivo.next();
            String apellido = archivo.next();
            int edad = archivo.nextInt();

            Persona p; // variable de tipo referencia a Persona
            p = new Persona(documento, nombre, apellido, edad);

            // borrar de aca la busqueda de mayor y menor
            pl1.agregarPersona(p);
        }
        archivo.close();

        float promedio = pl1.promedioEdades();
        float tope = promedio * 1.5f;
        c = pl1.cantidadEdades(tope);
        System.out.printf("Hay %d personas con edad mayor a %4.2f\n", c, tope);
        System.out.println("La persona más joven es: " + pl1.mayorEdad().toString());
        System.out.println("La persona más vieja es: " + pl1.menorEdad().toString());
        System.out.println("El promedio de las edades : " + promedio);

        System.out.println("Ingrese un apellido para buscar");
        String buscado = teclado.next().toUpperCase();

        pl1.listarPorApellido(buscado);
    }
}
