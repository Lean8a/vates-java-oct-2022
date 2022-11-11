public class CodigoPostal {

    public static CodigoPostal desdeString(String linea) {
        String [] datos = linea.split(";");
        char p = datos[0].charAt(0);
        int c = Integer.parseInt(datos[1]);
        String l = datos[2];
        return new CodigoPostal(p,c,l);
    }

    private char provincia;
    private int codigo;
    private String localidad;

    public CodigoPostal(char provincia, int codigo, String localidad) {
        this.provincia = provincia;
        this.codigo = codigo;
        this.localidad = localidad;
    }

    public char getProvincia() {
        return provincia;
    }

    public void setProvincia(char provincia) {
        this.provincia = provincia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    @Override
    public String toString() {
        return "CodigoPostal{" +
                "provincia=" + provincia +
                ", codigo=" + codigo +
                ", localidad='" + localidad + '\'' +
                '}';
    }
}
