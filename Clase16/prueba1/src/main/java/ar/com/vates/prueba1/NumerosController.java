package ar.com.vates.prueba1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class NumerosController {

    List<Long> numeros = new ArrayList<>();
    Random r = new Random();

    @GetMapping("/numeros")
    public ResponseEntity<List<Long>> consultarTodos() {
        return ResponseEntity.ok(numeros); // .ok genera una respuesta con codigo 200.
    }

    @PutMapping("/numeros/{x}")
    public void agregarNumero(@PathVariable long x) {
        numeros.add(x);
    }

    @DeleteMapping("/numeros/{x}")
    public ResponseEntity borrarNumero(@PathVariable long x) {
        return (numeros.remove(x)) ?
                ResponseEntity.ok().build(): // .ok.build devuelve un 200 sin contenido.post
                ResponseEntity.notFound().build(); // .notFound.build devuelve un 404 sin contenido.
    }

    @GetMapping("/numeros/{x}")
    public ResponseEntity existeNumero(@PathVariable long x) {
        return (numeros.contains(x)) ?
            ResponseEntity.ok().build(): // .ok.build devuelve un 200 sin contenido.post
            ResponseEntity.notFound().build(); // .notFound.build devuelve un 404 sin contenido.
    }


}
