import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese las coordenadas del punto");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int cuadrante = 0;

        if (x != 0 && y != 0) {
            if (x > 0) {
                if (y > 0) cuadrante = 1;
                else cuadrante = 4;
            } else {
                if (y > 0) cuadrante = 2;
                else cuadrante = 3;
            }

            System.out.println("El punto está en el cuadrante " + cuadrante);
        }
        else if (x == 0 && y == 0)
            System.out.println("El punto está en el origen");
        else if (x == 0)
            System.out.println("El punto está en el eje de las ordenadas");
        else
            System.out.println("El punto está en el eje de las abcisas");

    }
}
