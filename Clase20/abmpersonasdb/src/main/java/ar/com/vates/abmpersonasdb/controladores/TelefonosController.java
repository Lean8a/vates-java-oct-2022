package ar.com.vates.abmpersonasdb.controladores;

import ar.com.vates.abmpersonasdb.dominio.Persona;
import ar.com.vates.abmpersonasdb.dominio.Telefono;
import ar.com.vates.abmpersonasdb.repositorios.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
public class TelefonosController {

    @Autowired
    private PersonasRepository repo;

    @GetMapping("/{doc}/telefono")
    public ResponseEntity<Collection<Telefono>> buscarTelefonos(@PathVariable int doc) {
        Optional<Persona> encontrada = repo.findById(doc);
        return (encontrada.isPresent()) ?
                ResponseEntity.ok(encontrada.get().getTelefonos()):
                ResponseEntity.notFound().build();
    }

    @PostMapping("/{doc}/telefono")
    public ResponseEntity agregarTelefono(@PathVariable int doc,@RequestBody Telefono nuevo) throws URISyntaxException {
        // Validar los datos del telefono, si estan mal retornar HttpStatus.BAD_REQUEST

        Optional<Persona> encontrada = repo.findById(doc);
        if (encontrada.isPresent()) {
            nuevo.setPersona(encontrada.get());
            encontrada.get().getTelefonos().add(nuevo);
            repo.save(encontrada.get());

            int nuevoId = encontrada.get().getTelefonos().stream().filter(t -> t.getNumero() == nuevo.getNumero()).findFirst().get().getId();
            return ResponseEntity.created(new URI(String.format("/persona/%d/telefono/%d",doc, nuevoId))).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{doc}/telefono/{id}")
    public ResponseEntity<Telefono> obtenerPorId(@PathVariable int doc, @PathVariable int id) {
        Optional<Persona> encontrada = repo.findById(doc);
        if (encontrada != null) {
            Optional<Telefono> encontrado = encontrada.get().getTelefonos().stream().filter(t -> t.getId() == id).findFirst();
            if (encontrado.isPresent())
                return ResponseEntity.ok(encontrado.get());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.notFound().build();
    }

}
