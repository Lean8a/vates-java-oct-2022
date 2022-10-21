import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {


        Cliente cl1 = new Cliente(112, "Pedro Ramirez");
        ClienteLocal cl2 = new ClienteLocal(232, "Juan Perez", 28);
        ClienteInternet cl3 = new ClienteInternet(316, "Ana Pino", "apino@gmail.com", "Calle 2343");

        System.out.println("Listado con las instancias sueltas");
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);

        ArrayList<Cliente> listado = new ArrayList<>();
        listado.add(cl1);
        listado.add(cl2);
        listado.add(cl3);

        System.out.println();
        System.out.println("Listado desde el arraylist");
        for(Cliente c: listado)
            System.out.println(c);
    }
}
