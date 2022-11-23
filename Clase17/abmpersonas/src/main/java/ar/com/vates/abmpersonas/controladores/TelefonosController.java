package ar.com.vates.abmpersonas.controladores;

import ar.com.vates.abmpersonas.entidades.Persona;
import ar.com.vates.abmpersonas.entidades.Telefono;
import ar.com.vates.abmpersonas.repositorios.PersonasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
public class TelefonosController {

    private final PersonasRepositorio repo;

    @Autowired
    public TelefonosController(PersonasRepositorio repo) {
        this.repo = repo;
    }

    @GetMapping("/{doc}/telefono")
    public ResponseEntity<List<Telefono>> obtenerTelefonos(@PathVariable int doc) {

        Persona encontrada = repo.buscarPorDocumento(doc);
        return (encontrada != null) ?
                ResponseEntity.ok(encontrada.getTelefonos()):
                ResponseEntity.notFound().build();
    }

    @GetMapping("/{doc}/telefono/movil")
    public ResponseEntity<List<Telefono>> obtenerTelefonosMoviles(@PathVariable int doc) {
        Persona encontrada = repo.buscarPorDocumento(doc);
        return (encontrada != null) ?
                ResponseEntity.ok(encontrada.getTelefonosMoviles()):
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{doc}/telefono/{nro}")
    public ResponseEntity agregarTelefono(@PathVariable int doc, @PathVariable String nro, @RequestBody Telefono nuevo) {
        Persona encontrada = repo.buscarPorDocumento(doc);
        if (encontrada != null) {
            nuevo.setNumero(nro);
            encontrada.agregarTelefono(nuevo);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{doc}/telefono/{nro}")
    public ResponseEntity borrarTelefono(@PathVariable int doc, @PathVariable String nro) {
        Persona encontrada = repo.buscarPorDocumento(doc);
        if (encontrada != null) {
            return encontrada.borrarTelefono(nro) ?
                    ResponseEntity.ok().build():
                    ResponseEntity.notFound().build();
        }
        return ResponseEntity.badRequest().body("Persona no encontrada");
    }

    @GetMapping("/telefono")
    public List<Persona> buscarPorTelefono(@RequestParam String nro) {
        return repo.buscarPorTelefono(nro);
    }

}
