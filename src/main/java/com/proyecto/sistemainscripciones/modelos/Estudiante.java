package com.proyecto.sistemainscripciones.modelos;

public class Estudiante extends Persona {

    private String correo;
    private String telefono;
    private String documento;

    public Estudiante() {
        super();
    }

    public Estudiante(int id, String nombre, String apellido, String correo, String telefono, String documento) {
        super(id, nombre, apellido);
        this.correo = correo;
        this.telefono = telefono;
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String mostrarInformacion() {
        return "Estudiante: " + nombre + " " + apellido + " | Correo: " + correo + " | Documento: " + documento;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}