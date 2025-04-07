package com.tunombre.conversor;

import java.io.IOException;  // Importa la clase IOException

public class ConversorApp {
    public static void main(String[] args) {
        // Definir las monedas base y destino
        String monedaBase = "USD";  // Puedes cambiar estas monedas
        String monedaDestino = "EUR";  // Según tus necesidades

        try {
            // Llamar al método que obtiene la tasa de cambio
            double tasaCambio = Conversor.obtenerTasaCambio(monedaBase, monedaDestino);
            
            // Mostrar el resultado
            System.out.println("La tasa de cambio de " + monedaBase + " a " + monedaDestino + " es: " + tasaCambio);
        } catch (IOException | InterruptedException e) {
            // Si ocurre una excepción, la capturamos y mostramos el mensaje de error
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            e.printStackTrace();  // Mostrar el detalle del error para depuración
        }
    }
}
