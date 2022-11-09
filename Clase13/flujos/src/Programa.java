import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Programa {
    public static void main(String[] args) {

        Predicate<Integer> esPar = x -> x % 2 == 0;
        Predicate<Integer> esImpar = esPar.negate();
        Consumer<Object> imprimir = System.out::println;
        ToIntFunction<Integer> cuadradoInt = x -> (int)Math.pow(x,2);
        ToDoubleFunction<Double> cuadradoDouble = x -> Math.pow(x,2);

        Random r = new Random();
        List<Integer> lista =  r.ints(1000,-1000000,1000000).boxed().toList();

        int menor = lista.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Menor de todos:" + menor);

        long cantidadPares = lista.stream()
                .filter(esPar)
                .count();
        System.out.println("Cantidad de números pares: " + cantidadPares);

        double promedioImpares = lista.stream().
                filter(esImpar).
                mapToInt(Integer::intValue).
                average().
                orElse(0);
        System.out.println("Promedio de números impares: " + promedioImpares);

        List<Integer> cuadrados = lista.stream()
                .filter(x -> x > 10 && x < 100)
                .mapToInt(cuadradoInt)
                .boxed()
                .toList();

        System.out.println("Cuadrados de los que esten entre 10 y 100");
        cuadrados.stream().forEach(imprimir);

        System.out.println("Multiplos de 3 del conjunto anterior");
        cuadrados.stream().filter(x -> x % 3 == 0).forEach(imprimir);

        System.out.println("Multiplos de 7 en forma descendente");
        lista.stream()
                .filter(x -> x % 7 == 0)
                .sorted(Comparator.reverseOrder())
                .forEach(imprimir);

        double promedioImparesNegativos = lista.stream()
                .filter(esImpar)
                .filter(x -> x < 0)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
        System.out.println("Promedio de los impares negativos:" + promedioImparesNegativos);

        double promedio = lista.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        double desvEstandar = Math.sqrt(lista.stream()
                .map(x -> x - promedio)
                .mapToDouble(cuadradoDouble)
                .average()
                .getAsDouble());
        System.out.println("Desviación estándar: " + desvEstandar);

        boolean hayMultiplo127 = lista.stream().anyMatch(x -> x % 127 == 0);
        System.out.print(hayMultiplo127 ? "Hay": "No hay" );
        System.out.println(" multiplos de 127.");

        List<Integer> terminados2y3 = lista.stream()
                .filter(x -> {
                    final int ultimo = x % 10;
                    return ultimo == 2 || ultimo == 3;
                }).toList();

    }



}
