public class Cliente implements Imprimible, Comparable {

    private int codigo;
    private String nombre;

    public Cliente(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    @Override
    public void imprimir() {
        System.out.println("POR IMPRESORA: " + codigo + " " + nombre);
    }

    @Override
    public String toString() {
        return String.format("%3d %-10s", codigo, nombre);
    }

    // un numero negativo si this < o
    // un numero positivo si this > o
    // 0 si son iguales
    @Override
    public int compareTo(Object otro) {
        Cliente c = (Cliente)otro;
        return this.codigo - c.codigo;
    }
}
