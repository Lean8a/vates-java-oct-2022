package ar.com.vates.abmpersonas.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Persona {
    private int documento;
    private String nombre;
    private String apellido;
    private int edad;

    private List<Telefono> telefonos;

    public Persona() {
        telefonos = new ArrayList<>();
    }

    public Persona(int documento, String nombre, String apellido, int edad) {
        this();
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
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

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public List<Telefono> getTelefonosMoviles() {
        return telefonos.stream().filter(Telefono::isMovil).toList();
    }

    public void agregarTelefono(Telefono nuevo) {
        telefonos.add(nuevo);
    }

    public boolean borrarTelefono(String nro) {
        return telefonos.remove(
                telefonos.stream().
                        filter(t -> t.getNumero().equals(nro)).
                        findFirst().
                        orElse(null)
        );
    }

    public List<Telefono> buscarTelefono(String nro) {
        return telefonos.stream().filter(t -> t.getNumero().contains(nro)).toList();
    }

    public boolean tieneTelefono(String nro) {
        return telefonos.stream().anyMatch(t -> t.getNumero().contains(nro));
    }
    @Override
    public String toString() {
        return String.format("%8d %-15s %-15s %3d",documento, nombre, apellido, edad);
    }
}
