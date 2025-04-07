# Conversor de Moneda 💱

Proyecto desarrollado en Java como parte del Challenge ONE Back-End.

## Funcionalidades

- Conversión entre distintas monedas (USD, ARS, BOB, BRL, CLP, COP)
- Menú interactivo en consola
- Consumo de API de tasas de cambio
- Manejo de respuestas JSON con GSON
- Modularización del código
- Estructura de proyecto Maven

## Tecnologías

- Java 11+
- Maven
- Gson (Google)
- API: ExchangeRate-API

## Capturas

_¡Aquí puedes añadir imágenes o un GIF del uso del conversor!_

## Cómo usar

```bash
git clone https://github.com/tuusuario/ConversorDeMoneda.git
cd ConversorDeMoneda
mvn compile
mvn exec:java -Dexec.mainClass="com.tunombre.conversor.ConversorApp"
