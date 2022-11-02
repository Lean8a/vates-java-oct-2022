import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Programa2 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner archivo = new Scanner(new File("personas2.txt"));

        archivo.useDelimiter("[\\n\\r;]+");
        int c = 0;
        Persona mayor = null, menor = null;
        TreeSet<Persona> padron = new TreeSet<>();

        while(archivo.hasNextInt()) {
            int documento = archivo.nextInt();
            String nombre = archivo.next();
            String apellido = archivo.next();
            int edad = archivo.nextInt();

            Persona p = new Persona(documento, nombre, apellido, edad);
            padron.add(p);
            c++;
        }
        archivo.close();

        System.out.println("Se leyeron " + c + " personas");
        List<Persona> padron2 = new ArrayList<>(padron);
        Collections.sort(padron2, new PersonaComparatorApellido());
        for(Persona p: padron2)
            System.out.println(p);

        Collections.sort(padron2, new PersonaComparatorEdad());
        for(Persona p: padron2)
            System.out.println(p);
    }
}
