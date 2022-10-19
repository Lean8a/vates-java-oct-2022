import java.util.Date;

public class Programa {

    public static void main(String[] args) {

        Punto a = new Punto(1,1);
        Punto b = new Punto(4,5);
        boolean bandera = true;

        System.out.println(a.getDistancia()); // 1.41
        System.out.println(a.getDistancia(b)); // 5.0


    }
}
