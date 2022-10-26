public class Articulo implements Imprimible {

    int codigo;
    String denominacion;
    float precio;

    public Articulo(int codigo, String denominacion, float precio) {
        this.codigo = codigo;
        this.denominacion = denominacion;
        this.precio = precio;
    }


    @Override
    public void imprimir() {
        System.out.println("POR IMPRESORA " + codigo + " " + denominacion + " " + precio);
    }
}
