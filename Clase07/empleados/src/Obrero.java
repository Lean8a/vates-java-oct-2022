public class Obrero extends Empleado {
    private int diasTrabajados;

    public Obrero() {
    }

    public Obrero(int legajo, String nombre, float sueldoBasico, int diasTrabajados) {
        super(legajo, nombre, sueldoBasico);
        this.diasTrabajados = diasTrabajados;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    @Override
    public float getSueldoNeto() {
        return sueldoBasico / 22 * diasTrabajados;
    }

    @Override
    public String toString() {
        return String.format("%3d %-30s $ %8.2f - dias: %d - Sueldo a cobrar: %8.2f", legajo, nombre, sueldoBasico, diasTrabajados, getSueldoNeto());
    }
}
