package ar.com.vates.prueba1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class NumerosController {

    List<Long> numeros = new ArrayList<>();
    Random r = new Random();

    @GetMapping("/numeros")
    public List<Long> consultarTodos() {
        return numeros;
    }

    @PutMapping("/numeros/{x}")
    public void agregarNumero(@PathVariable long x) {
        numeros.add(x);
    }

    @DeleteMapping("/numeros/{x}")
    public boolean borrarNumero(@PathVariable long x) {
        return numeros.remove(x);
    }

    @GetMapping("/numeros/{x}")
    public boolean existeNumero(@PathVariable long x) {
        return numeros.contains(x);
    }


}
