package ar.com.vates.abmpersonasdb.controladores;

import ar.com.vates.abmpersonasdb.dominio.Persona;
import ar.com.vates.abmpersonasdb.repositorios.PersonasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/persona")
public class PersonasController {

    @Autowired
    private PersonasRepositorio repo;

    @GetMapping("")
    public Collection<Persona> listarTodas() {
        return repo.obtenerTodas();
    }

    @GetMapping("/{doc}")
    public ResponseEntity<Persona> buscarPersona(@PathVariable int doc) {
        Persona encontrada = repo.buscarPorDocumento(doc);
        return (encontrada != null) ?
                ResponseEntity.ok(encontrada):
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{doc}")
    public ResponseEntity guardarPersona(@PathVariable int doc,@RequestBody Persona p) {
        p.setDocumento(doc);
        return (repo.guardarPersona(p) == null)? // si devuelve null es porque inserto una persona nueva
                ResponseEntity.created(URI.create(String.format("/persona/%d",doc))).build():
                ResponseEntity.ok().build();
    }

    @DeleteMapping("/{doc}")
    public ResponseEntity borrarPersona(@PathVariable int doc) {
        return (repo.borrarPersona(doc)) ?
                ResponseEntity.ok().build():
                ResponseEntity.notFound().build();
    }

}