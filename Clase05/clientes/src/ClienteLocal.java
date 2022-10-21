public class ClienteLocal extends Cliente {

    private int sucursal;

    public ClienteLocal() {
    }

    public ClienteLocal(int codigo, String nombre, int sucursal) {
        super(codigo, nombre);
        this.sucursal = sucursal;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return String.format("%3d %-15s %2d", codigo, nombre, sucursal);
    }
}
