package ar.com.vates.abmpersonas.entidades;

public class Telefono {
    private String numero;
    private String tipo;
    private boolean movil;
    private String horario;

    public Telefono() {
    }

    public Telefono(String numero, String tipo, boolean movil, String horario) {
        this.numero = numero;
        this.tipo = tipo;
        this.movil = movil;
        this.horario = horario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isMovil() {
        return movil;
    }

    public void setMovil(boolean movil) {
        this.movil = movil;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
