import java.beans.ParameterDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Programa3 {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner archivo = new Scanner(new File("personas2.txt"));

        archivo.useDelimiter("[\\n\\r;]+");
        int c = 0;
        Persona mayor = null, menor = null;
        TreeMap<Integer,Persona> padron = new TreeMap<>();

        while(archivo.hasNextInt()) {
            int documento = archivo.nextInt();
            String nombre = archivo.next();
            String apellido = archivo.next();
            int edad = archivo.nextInt();

            Persona p = new Persona(documento, nombre, apellido, edad);
            padron.put(documento,p);
            c++;
        }
        archivo.close();

        //System.out.println(padron);

        System.out.println("Se leyeron " + padron.size() + " personas");

        for (Map.Entry<Integer, Persona> e: padron.entrySet())
            System.out.println(e);



        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese documentos para buscar (fin con 0): ");
        int buscado = sc.nextInt();
        while (buscado != 0) {
            Persona encontrada = padron.get(buscado);
            if (encontrada != null) System.out.println(encontrada);
            else System.out.println("No encontradad");
            buscado = sc.nextInt();
        }




        //List<Persona> padron2 = new ArrayList<>(padron);
        //Collections.sort(padron2, new PersonaComparatorApellido());
        //for(Persona p: padron2)
        //    System.out.println(p);

        //Collections.sort(padron2, new PersonaComparatorEdad());
        //for(Persona p: padron2)
        //    System.out.println(p);
    }
}
