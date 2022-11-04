public class Vendedor extends Empleado {

    public double totalVentas;

    public Vendedor() {
    }

    public Vendedor(int legajo, String nombre, float sueldoBasico, double totalVentas) {
        super(legajo, nombre, sueldoBasico);
        this.totalVentas = totalVentas;
    }

    @Override
    public float getSueldoNeto() {
        return (float) (sueldoBasico + 0.01f * totalVentas);
    }

    @Override
    public String toString() {
        return String.format("%3d %-30s $ %8.2f - Ventas: %9.2f - Sueldo a cobrar: %8.2f", legajo, nombre, sueldoBasico, totalVentas, getSueldoNeto());
    }

}
