import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class Programa {
    public static void main(String[] args) {

        try {
            List<CodigoPostal> todos = Files
                    .lines(Paths.get("CP.txt"))
                    .map(CodigoPostal::desdeString)
                    .toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
