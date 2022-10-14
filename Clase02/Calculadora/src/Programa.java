import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws FileNotFoundException {

        int a, b;

        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("2numeros.txt"));

        //System.out.println("Ingrese dos números");
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println("Ingresó " + a + " y " + b);
        int suma = a + b;
        int diferencia = a - b;
        int producto = a * b;
        float cociente = (float) a / b;

        System.out.println("Suma: " + suma);
        System.out.println("Diferencia: " + diferencia);
        System.out.println("Producto: " + producto);
        System.out.println("Cociente: " + cociente);


    }
}
