package com.tunombre.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public double obtenerTasaCambio(String base, String destino) throws IOException, InterruptedException {
        String url = String.format("https://api.exchangerate.host/latest?base=%s&symbols=%s", base, destino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
        return jsonObject.getAsJsonObject("rates").get(destino).getAsDouble();
    }
}
