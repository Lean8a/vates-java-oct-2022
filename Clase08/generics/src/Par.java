public class Par<T extends Comparable> implements Comparable<Par<T>> { // restringir el tipo T

    private T primero;
    private T segundo;

    public Par(T primero, T segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public T getPrimero() {
        return primero;
    }

    public void setPrimero(T primero) {
        this.primero = primero;
    }

    public T getSegundo() {
        return segundo;
    }

    public void setSegundo(T segundo) {
        this.segundo = segundo;
    }

    public void swap() {
        T aux = primero;
        primero = segundo;
        segundo = aux;
    }

    public Par<T> transpuesta() {
        return new Par<>(segundo, primero);
    }

    public boolean miembrosIguales() {
        return primero.compareTo(segundo) == 0;
    }

    public boolean miembrosDiferentes() {
        return !miembrosIguales();
    }

    public boolean ascendente() {
        return segundo.compareTo(primero) > 0;
    }

    public boolean descendente() {
        return segundo.compareTo(primero) < 0;
    }


    @Override
    public String toString() {
        return String.format("(%s;%s)",primero.toString(), segundo.toString());
    }

    @Override
    public int compareTo(Par<T> o) {
        int compPrimeros = primero.compareTo(o.primero);
        if (compPrimeros ==0)
            return segundo.compareTo(o.segundo);
        return compPrimeros;
    }
}
