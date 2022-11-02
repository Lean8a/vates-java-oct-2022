import java.util.*;

public class Programa {

    public static void main(String[] args) {

        Collection<Integer> lista1 = new HashSet<>();
        Collection<Integer> lista2 = new HashSet<>();
        Random r = new Random();

        for (int i = 0; i < 100000; i++) {
            lista1.add(r.nextInt(1000000));
            lista2.add(r.nextInt(1000000));
        }

        //System.out.println(lista1);
        //System.out.println(lista2);

        System.out.println("Lista 1: " + lista1.size());
        System.out.println("Lista 2: " + lista2.size());
        long inicio = System.currentTimeMillis();
        lista1.retainAll(lista2);
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        System.out.println("Lista 1: " + lista1.size());
        System.out.println("Duración" + duracion);
        //System.out.println(lista1);

    }
}
