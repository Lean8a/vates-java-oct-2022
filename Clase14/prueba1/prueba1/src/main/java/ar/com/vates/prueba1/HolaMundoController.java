package ar.com.vates.prueba1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class HolaMundoController {

    @GetMapping("")
    public String raiz() {
        return "Esta es la raiz del sitio";
    }

    @GetMapping("/hola")
    public IntStream saludar() {
        return new Random().ints(100,0,10000);
    }
}
