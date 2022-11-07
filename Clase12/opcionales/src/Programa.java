import javax.swing.text.html.Option;
import java.util.Optional;

public class Programa {
    public static void main(String[] args) {

        Optional<String> nombre = Optional.empty();
        //nombre = Optional.of("Pedro");
        System.out.println(nombre.get());


    }
}
