package ar.com.vates.abmpersonasdb.dominio;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

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


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "documento") // nombre de la columna que es FK
    private Persona persona;
    @Basic
    private boolean movil;
    @Basic
    private String horario;

    public Telefono() {
    }

    public Telefono(int id, String numero, int tipo, Persona persona, boolean movil, String horario) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
                ", persona=" + persona.toString() +
                ", movil=" + movil +
                ", horario='" + horario + '\'' +
                '}';
    }
}
