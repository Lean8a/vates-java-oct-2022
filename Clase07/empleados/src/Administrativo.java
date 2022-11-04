public class Administrativo extends Empleado {

    private boolean presentismo;

    public Administrativo() {
    }

    public Administrativo(int legajo, String nombre, float sueldoBasico, boolean presentismo) {
        super(legajo, nombre, sueldoBasico);
        this.presentismo = presentismo;
    }

    public boolean isPresentismo() {
        return presentismo;
    }

    public void setPresentismo(boolean presentismo) {
        this.presentismo = presentismo;
    }

    @Override
    public float getSueldoNeto() {
        float extra = 0;
        if (presentismo) extra = sueldoBasico * .13f;
        return sueldoBasico + extra;
    }

    @Override
    public String toString() {
        return super.toString() + " " + presentismo + " - Sueldo a cobrar: " + getSueldoNeto();
    }
}
