import java.util.ArrayList;

public class Programa {


    public static void main(String[] args) {

        ArrayList<Integer> listaNumeros = new ArrayList<>();
        ArrayList<String> listaCadenas = new ArrayList<>();
        ArrayList listaOtroTipo = new ArrayList();

        listaNumeros.add(2);


        for (String x: listaCadenas) {
            System.out.println(x);
        }
        for (Object x: listaOtroTipo) {
            // downcast
            System.out.println(x);
        }

        Par<String> nombreCompleto = new Par<>("Juan","Juan");
        Par<Float> vertice = new Par<>(8f,8f);
        Par<Float> origen = new Par<>(2f,8f);

        Par<Empleado> parEmp = new Par<>(new Empleado(1,"Juan",121212), new Empleado(4, "Ariel", 129292));

        nombreCompleto.swap();
        vertice.swap();
        parEmp.swap();

        System.out.println(nombreCompleto);
        System.out.println(vertice);
        System.out.println(parEmp);

        System.out.println(nombreCompleto.miembrosIguales());
        System.out.println(vertice.miembrosIguales());
        System.out.println(parEmp.miembrosIguales());

        System.out.println(origen.compareTo(vertice));
    }



}
