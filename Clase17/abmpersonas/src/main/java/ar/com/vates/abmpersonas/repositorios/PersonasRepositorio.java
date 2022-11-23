package ar.com.vates.abmpersonas.repositorios;

import ar.com.vates.abmpersonas.entidades.Persona;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class PersonasRepositorio {
    private HashMap<Integer, Persona> plantel = new HashMap<Integer, Persona>();

    public PersonasRepositorio()  {
        // Llenar desde el archivo personas.txt
        //        plantel.put(1, new Persona(1, "Juan", "Perez", 23));
        //        plantel.put(2, new Persona(2, "Ana", "Pereza", 28));

    }

    public Collection<Persona> obtenerTodas() {
        return plantel.values();
    }

    public Persona buscarPorDocumento(int doc) {
        return plantel.get(doc);
    }

    public Persona guardarPersona(Persona p)  {
        return plantel.put(p.getDocumento(), p);
    }

    public boolean borrarPersona(int doc) {
        return plantel.remove(doc) != null;
    }

    public List<Persona> buscarPorTelefono(String nro) {
        return plantel.values()
                .stream()
                .filter(p -> p.tieneTelefono(nro))
                .toList();
    }
}
