public class Jerarquico extends Empleado {

    public Jerarquico(int legajo, String nombre, float sueldoBasico) {
        super(legajo, nombre, sueldoBasico);
    }

    @Override
    public float getSueldoNeto() {
        return sueldoBasico * 1.5f;
    }


}
