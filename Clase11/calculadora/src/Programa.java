import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {

        Operacion s = (float op1, float op2) -> op1 + op2; // función lambda
        Operacion d = (float op1, float op2) -> op1 - op2;
        Operacion p = (float op1, float op2) -> op1 * op2;
        Operacion c = (float op1, float op2) -> (op2 != 0)? op1 / op2: 0;
        Operacion pot = (float op1, float op2) -> (float)Math.pow(op1, op2);

        Operacion[]calculos = {null, s, d, p, c, pot};

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese la operación (1: sumar, 2: restar, 3: multiplicar, 4: dividir, 5: potencia, 0: salir)");
        int operacion = sc.nextInt();


        while (operacion != 0) {
            System.out.println("Ingrese dos números");
            float a = sc.nextFloat();
            float b = sc.nextFloat();
            float resultado = 0;

            resultado = calculos[operacion].calcular(a, b);

            System.out.println("El resultado es:" + resultado);

            System.out.println("Ingrese la operación (1: sumar, 2: restar, 3: multiplicar, 4: dividir, 0: salir)");
            operacion = sc.nextInt();
        }



    }


}
