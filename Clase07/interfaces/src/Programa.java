import java.util.ArrayList;
import java.util.Arrays;

public class Programa {

    public static void main(String[] args) {

        ArrayList<Imprimible> cola = new ArrayList<>();

        Cliente cl1 = new Cliente(111,"Juan Perez");
        Cliente cl2 = new Cliente(567,"Jorge Pino");
        Cliente cl3 = new Cliente(107,"Ana Sosa");

        cola.add(cl1);
        cola.add(new Articulo(20, "Lapiz", 30));

        for (Imprimible im: cola) {
            im.imprimir();
        }

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cl1);
        clientes.add(cl2);
        clientes.add(cl3);


        Object []v = clientes.toArray();
        Arrays.sort(v);
        for(Object cl: v)
            System.out.println(cl);





    }

}
