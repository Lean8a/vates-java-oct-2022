public class Empleado {

    protected int legajo;
    protected String nombre;
    protected float sueldoBasico;

    public Empleado() {
    }

    public Empleado(int legajo, String nombre, float sueldoBasico) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.sueldoBasico = sueldoBasico;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(float sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public float getSueldoNeto() {
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%3d %-30s $ %8.2f", legajo, nombre, sueldoBasico);
    }
}
