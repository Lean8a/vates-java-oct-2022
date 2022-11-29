package ar.com.vates.abmpersonasdb.controladores;

import ar.com.vates.abmpersonasdb.dominio.Persona;

import ar.com.vates.abmpersonasdb.repositorios.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class PersonasController {

    @Autowired
    private PersonasRepository repo;


    @GetMapping("")
    public Collection<Persona> listarTodas(@RequestParam(required = false, defaultValue = "") String apellido) {
        return apellido.isBlank() ?
            repo.getPersonasByOrderByApellidoAscNombreAsc():
            repo.getPersonasByApellidoEqualsIgnoreCaseOrderByNombreAsc(apellido);
    }

    @GetMapping("/{doc}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable int doc) {
        Optional<Persona> encontrada = repo.findById(doc);
        return (encontrada.isPresent()) ?
                ResponseEntity.ok(encontrada.get()):
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{doc}")
    public ResponseEntity guardarPersona(@PathVariable int doc,@RequestBody Persona p) {
        p.setDocumento(doc);
        return (repo.save(p) == null)? // si devuelve null es porque inserto una persona nueva
                ResponseEntity.created(URI.create(String.format("/persona/%d",doc))).build():
                ResponseEntity.ok().build();
    }

    @DeleteMapping("/{doc}")
    public ResponseEntity borrarPersona(@PathVariable int doc) {
        Optional<Persona> encontrada = repo.findById(doc);
        if (encontrada.isPresent()) {
            repo.delete(encontrada.get());
            ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}