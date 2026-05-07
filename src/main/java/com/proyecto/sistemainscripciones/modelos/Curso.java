package com.proyecto.sistemainscripciones.modelos;

public class Curso {

    private int id;
    private String nombre;
    private String descripcion;
    private int cupoMaximo;
    private String fechaInicio;
    private String estado;

    public Curso() {
    }

    public Curso(int id, String nombre, String descripcion, int cupoMaximo, String fechaInicio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupoMaximo = cupoMaximo;
        this.fechaInicio = fechaInicio;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String mostrarInformacion() {
        return "Curso: " + nombre + " | Cupo máximo: " + cupoMaximo + " | Estado: " + estado;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cupoMaximo=" + cupoMaximo +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}