import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Programa {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner archivo = new Scanner(new File("personas2.txt"));

        archivo.useDelimiter("[\\n\\r;]+");
        int c = 0;
        Persona mayor = null, menor = null;


        while(archivo.hasNextInt()) {
            int documento = archivo.nextInt();
            String nombre = archivo.next();
            String apellido = archivo.next();
            int edad = archivo.nextInt();

            Persona p; // variable de tipo referencia a Persona
            p = new Persona(documento, nombre, apellido, edad);

            if (mayor == null) {
                mayor = menor = p;
            }

            if (p.getEdad() >= mayor.getEdad())
                mayor = p;

            if (p.getEdad() <= menor.getEdad())
                menor = p;

            System.out.println(p.toString());
            c++;
        }
        archivo.close();

        System.out.println("Se leyeron " + c + " personas");

        System.out.println("La persona más joven es: " + menor.toString());
        System.out.println("La persona más vieja es: " + mayor.toString());
    }
}
