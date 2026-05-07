package com.proyecto.sistemainscripciones.utils;

public class Validador {

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    public static boolean esCorreoValido(String correo) {
        return correo != null
                && !correo.trim().isEmpty()
                && correo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    public static boolean esNumeroPositivo(int numero) {
        return numero > 0;
    }

    public static boolean esTelefonoValido(String telefono) {
        return telefono != null
                && telefono.matches("\\d{7,15}");
    }

    public static boolean esDocumentoValido(String documento) {
        return documento != null
                && documento.matches("\\d{5,20}");
    }
}