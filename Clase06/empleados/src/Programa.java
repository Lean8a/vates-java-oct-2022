import java.sql.SQLOutput;
import java.util.ArrayList;

public class Programa {

    public static void main(String[] args) {

        Obrero emp1 = new Obrero(123,"Juan", 80000, 25);
        Administrativo emp2 = new Administrativo(2342, "Rosa", 80000, true);
        Vendedor emp3 = new Vendedor(675, "Ana", 80000, 10000000);

        // referencias a la clase base
        System.out.println("Listado desde referencias a la clase base");
        Empleado e1 = emp1;
        Empleado e2 = emp2;
        Empleado e3 = emp3;

        // En tiempo de ejecución, cada llamada a getSueldoNeto puede ejecutar versiones diferentes del método.
        System.out.println(e1.getLegajo() + " " + e1.getNombre() + " " + e1.getSueldoNeto());
        System.out.println(e2.getLegajo() + " " + e2.getNombre() + " " + e2.getSueldoNeto());
        System.out.println(e3.getLegajo() + " " + e3.getNombre() + " " + e3.getSueldoNeto());

        ArrayList<Empleado> planta = new ArrayList<>();
        planta.add(emp1);
        planta.add(emp2);
        planta.add(emp3);

        System.out.println("Listado con arraylist");
        for(Empleado e: planta) {

            // Operador instanceof: devuelve true si una referencia apunta a un objeto de cierta clase
            // Sólo tiene sentido con una derivada

            if (e instanceof Administrativo) {
                // Downcast: casting hacia abajo
                Administrativo admin = (Administrativo) e;

                if (admin.isPresentismo())
                    System.out.println(admin.getNombre() + " cumplio con el presentismo");
            }
            System.out.println(e.getLegajo() + " " + e.getNombre() + " " + e.getSueldoNeto());  //getSueldoNeto puede
            // ejecutar diferentes versiones
        }                                                   // en cada vuelta.
    }
}
