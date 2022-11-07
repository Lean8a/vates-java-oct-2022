import java.util.ArrayList;
import java.util.Optional;

public class Programa {

    public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(34);
        lista.add(31);
        lista.add(12);
        lista.add(7);
        lista.add(23);
        lista.add(109);
        lista.add(0);
        lista.add(10);

        System.out.println("Listado con for");
        for (Integer x: lista) System.out.println(x);

        System.out.println("Listado con stream");
        lista.stream().forEach(System.out::println);

        int suma = 0;
        for (Integer x: lista) suma += x;
        System.out.println("La suma es: " + suma);


        suma = lista.stream().mapToInt(Integer::intValue).sum();
        System.out.println("La suma es: " + suma);

        suma = lista.stream().mapToInt(x -> x*x).sum();
        System.out.println("La suma de los cuadrados: " + suma);

        System.out.println("Lista de los mayores a 10");
        for (Integer x: lista)
            if (x > 10)
                System.out.println(x);

        System.out.println("Lista de los mayores a 10");
        lista.stream().filter(x -> x>10).forEach(System.out::println);

        System.out.println("El mayor de todos");
        int mayor = lista.get(0);
        for (Integer x: lista)
            if (x > mayor)
                mayor = x;
        System.out.println(mayor);

        System.out.println("El mayor de todos");
        System.out.println(lista.stream().max(Integer::compareTo).get());

        System.out.println("El mayor de los pares");
        boolean primerPar = true;
        for (Integer x: lista)
            if (x % 2 == 0 && (primerPar || x > mayor)) {
                mayor = x;
                primerPar = false;
            }
        if (primerPar != true)
            System.out.println(mayor);
        else
            System.out.println("No hay pares");

        Optional<Integer> may = lista.stream()
                .filter(x -> x % 2 == 0)
                .max(Integer::compareTo);

        if (may.isPresent())
            System.out.println(may.get());
        else
            System.out.println("No hay pares");



    }
}
