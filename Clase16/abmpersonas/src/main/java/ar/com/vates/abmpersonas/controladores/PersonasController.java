package ar.com.vates.abmpersonas.controladores;

import ar.com.vates.abmpersonas.entidades.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;

@RestController
public class PersonasController {

    private HashMap<Integer, Persona> plantel = new HashMap<Integer, Persona>();

    public PersonasController()  {
        plantel.put(1, new Persona(1, "Juan", "Perez", 23));
        plantel.put(2, new Persona(2, "Ana", "Pereza", 28));

    }

    @GetMapping("/persona")
    public Collection<Persona> listarTodas() {
        return plantel.values();
    }

    @GetMapping("/persona/{doc}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable int doc) {
        Persona encontrada = plantel.get(doc);
        return (encontrada != null) ?
                ResponseEntity.ok(encontrada):
                ResponseEntity.notFound().build();
    }

    @PutMapping("/persona/{doc}")
    public ResponseEntity guardarPersona(@PathVariable int doc,@RequestBody Persona p) {
        return (plantel.put(doc, p) == null)? // si devuelve null es porque inserto una persona nueva
            ResponseEntity.created(URI.create(String.format("/persona/%d",doc))).build():
            ResponseEntity.ok().build();
    }

    @DeleteMapping("/persona/{doc}")
    public ResponseEntity borrarPersona(@PathVariable int doc) {
        Persona encontrada = plantel.remove(doc);
        return (encontrada != null) ?
                ResponseEntity.ok().build():
                ResponseEntity.notFound().build();
    }

}
