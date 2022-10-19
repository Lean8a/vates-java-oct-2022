import java.util.ArrayList;

public class Plantel {

    private ArrayList<Persona> listaPersonas;

    public Plantel() {
        listaPersonas = new ArrayList<>();
    }

    public void agregarPersona(Persona nueva) {
        listaPersonas.add(nueva);
    }

    public Persona mayorEdad() {
        Persona mayor = null;
        for (Persona p : listaPersonas)
            if (mayor == null || p.getEdad() > mayor.getEdad())
                mayor = p;
        return mayor;
    }

    public Persona menorEdad() {
        Persona menor = null;
        for (Persona p : listaPersonas)
            if (menor == null || p.getEdad() < menor.getEdad())
                menor = p;
        return menor;
    }

    public float promedioEdades() {
        int sumaEdades = 0;
        for (Persona p : listaPersonas)
            sumaEdades += p.getEdad();

        return (float) sumaEdades / listaPersonas.size();
    }

    public int cantidadEdades(float tope) {
        int c = 0;
        for (Persona p : listaPersonas)
            if (p.getEdad() > tope) {
                c++;
            }
        return c;
    }

    public void listarPorApellido(String buscado) {
        int c = 0;
        for (Persona p : listaPersonas)
            if (p.getApellido().equals(buscado)) {
                System.out.println(p);
                c++;
            }
        System.out.printf("Se encontraron %d personas con apellido %s\n", c, buscado);
    }
}
