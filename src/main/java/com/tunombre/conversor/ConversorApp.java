package com.tunombre.conversor;

import java.io.IOException;
import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        System.out.print("Ingrese la moneda base (por ejemplo, USD): ");
        String base = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda destino (por ejemplo, EUR): ");
        String destino = scanner.nextLine().toUpperCase();

        try {
            double tasa = conversor.obtenerTasaCambio(base, destino);
            System.out.println("Tasa de cambio de " + base + " a " + destino + ": " + tasa);
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
        }

        scanner.close();
    }
}
