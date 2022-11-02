import java.util.Comparator;

public class PersonaComparatorApellido implements Comparator<Persona> {
    @Override
    public int compare(Persona per1, Persona per2) {
        int difApellidos = per1.getApellido().compareTo(per2.getApellido());
        if (difApellidos == 0)
            return per1.getNombre().compareTo(per2.getNombre());
        return difApellidos;

    }
}
