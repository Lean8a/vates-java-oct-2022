package ar.com.vates.abmpersonasdb.dominio;

import javax.persistence.*;

@Entity
@Table(name="telefonos")
public class Telefono {
    @Id
    @Column(name="id_telefono")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String numero;
    @Column(name="id_tipo")
    private int tipo;
    @Basic
    private int documento;
    @Basic
    private boolean movil;
    @Basic
    private String horario;

    public Telefono() {
    }

    public Telefono(int id, String numero, int tipo, int documento, boolean movil, String horario) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.documento = documento;
        this.movil = movil;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
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

    @Override
    public String toString() {
        return "Telefono{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", tipo=" + tipo +
                ", documento=" + documento +
                ", movil=" + movil +
                ", horario='" + horario + '\'' +
                '}';
    }
}
