import java.util.*;

public class Programa {

    public static void main(String[] args) {

        Random r = new Random();
        ArrayList<Long> numerosAL = new ArrayList<>();
        TreeSet<Long> numerosTS = new TreeSet<>();
        HashSet<Long> numerosHS = new HashSet<>();


        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            long x = r.nextLong(10000000);
            numerosAL.add(x);
            numerosTS.add(x);
            numerosHS.add(x);
            if (i < 100) System.out.print(x + " ");
        }
        System.out.println();
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;


        System.out.println("Tamaño de ArrayList: " + numerosAL.size());
        System.out.println("Tamaño de TreeSet: " + numerosTS.size());
        System.out.println("Tamaño de HashSet: " + numerosHS.size());
        System.out.println(duracion);

        int c = 0;
        for(Long x: numerosAL) {
            System.out.print(x + " ");
            if (c++==100) break;
        }
        System.out.println();

        c = 0;
        for(Long x: numerosTS) {
            System.out.print(x + " ");
            if (c++==100) break;
        }
        System.out.println();

        c = 0;
        for(Long x: numerosHS) {
            System.out.print(x + " ");
            if (c++==100) break;
        }
        System.out.println();

        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            long buscado = r.nextLong(10000000);
            numerosAL.contains(buscado);
        }

        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("Tiempo de busqueda con ArrayList" + duracion);

        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            long buscado = r.nextLong(10000000);
            numerosTS.contains(buscado);
        }

        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("Tiempo de busqueda con TreeSet" + duracion);

        inicio = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            long buscado = r.nextLong(10000000);
            numerosHS.contains(buscado);
        }

        fin = System.currentTimeMillis();
        duracion = fin - inicio;
        System.out.println("Tiempo de busqueda con HashSet" + duracion);

    }
}
