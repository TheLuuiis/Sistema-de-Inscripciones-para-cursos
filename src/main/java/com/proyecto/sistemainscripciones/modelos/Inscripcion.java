package com.proyecto.sistemainscripciones.modelos;

public class Inscripcion {

    private int id;
    private int idEstudiante;
    private int idCurso;
    private String fechaInscripcion;
    private String estado;
    private String observacion;

    public Inscripcion() {
    }

    public Inscripcion(int id, int idEstudiante, int idCurso, String fechaInscripcion, String estado, String observacion) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.idCurso = idCurso;
        this.fechaInscripcion = fechaInscripcion;
        this.estado = estado;
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String mostrarInformacion() {
        return "Inscripción: estudiante #" + idEstudiante +
               " en curso #" + idCurso +
               " | Estado: " + estado;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", idEstudiante=" + idEstudiante +
                ", idCurso=" + idCurso +
                ", fechaInscripcion='" + fechaInscripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}