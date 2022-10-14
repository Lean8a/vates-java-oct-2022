import java.util.Scanner;

public class Programa {

    /*
    Ingresar números enteros (fin con 0). Luego de la carga informar:
        - Cantidad de positivos
        - Promedio de todos
        - Mayor de todos
    */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese números (fin con 0)");
        int x = sc.nextInt();

        int cantidadPositivos = 0;
        int suma = 0;
        int c = 0;
        int mayor = x;

        while (x != 0) {
            if (x > 0)
                cantidadPositivos++;
            suma += x;
            c++;
            if (x > mayor)
                mayor = x;

            x = sc.nextInt();
        }

        if (c > 0) {
            System.out.println("Cantidad de positivos: " + cantidadPositivos);
            float promedio = (float)suma / c;
            System.out.println("Promedio de todos: " + promedio);
            System.out.println("Mayor: " + mayor);
        }
        else
            System.out.println("No ingresó ningún número");

    }

}
