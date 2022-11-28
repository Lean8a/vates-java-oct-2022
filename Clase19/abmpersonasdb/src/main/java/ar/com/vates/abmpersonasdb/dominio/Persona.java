package ar.com.vates.abmpersonasdb.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="personas2")
public class Persona {

    @Id
    private int documento;
    @Basic
    private String nombre;
    @Basic
    private String apellido;
    @Basic
    private int edad;

    @JsonManagedReference
    @JsonIgnore
    @OneToMany( mappedBy = "documento", cascade = CascadeType.ALL)
    private Collection<Telefono> telefonos;

    public Persona() {
    }

    public Persona(int documento, String nombre, String apellido, int edad, Collection<Telefono> telefonos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefonos = telefonos;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @JsonIgnore
    public Collection<Telefono> getTelefonos() {
        return telefonos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "documento=" + documento +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
