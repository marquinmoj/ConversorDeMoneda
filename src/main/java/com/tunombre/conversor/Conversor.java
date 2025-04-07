package com.tunombre.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Conversor {

    public static double obtenerTasaCambio(String monedaBase, String monedaDestino) throws IOException, InterruptedException {
        // Reemplaza con tu clave de API
        String apiKey = "bc03cc380c4d5c7d23ff4901"; 
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

        // Crear la conexión HTTP a la API
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000); // Timeout de 5 segundos
        connection.setReadTimeout(5000); // Timeout de 5 segundos

        // Leer la respuesta de la API
        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            // Parsear la respuesta JSON
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
            
            // Extraer la tasa de cambio de la respuesta
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
            if (conversionRates != null && conversionRates.has(monedaDestino)) {
                return conversionRates.get(monedaDestino).getAsDouble();
            } else {
                throw new IOException("No se encontró la tasa de cambio para " + monedaDestino);
            }
        }
    }

    public static void main(String[] args) {
        String monedaBase = "USD";  // Puedes cambiar estas monedas
        String monedaDestino = "EUR";  // Según tus necesidades

        try {
            // Llamar al método que obtiene la tasa de cambio
            double tasaCambio = obtenerTasaCambio(monedaBase, monedaDestino);
            
            // Mostrar el resultado
            System.out.println("La tasa de cambio de " + monedaBase + " a " + monedaDestino + " es: " + tasaCambio);
        } catch (IOException | InterruptedException e) {
            // Si ocurre una excepción, la capturamos y mostramos el mensaje de error
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            e.printStackTrace();  // Mostrar el detalle del error para depuración
        }
    }
}
