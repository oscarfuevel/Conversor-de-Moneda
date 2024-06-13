import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Convertidor {


    public static double convertidor(String monedaInicial, String monedaFinal, double cantidad){

        double resultado= 0;
        String APIKey = "fe071af15fa93116af8a9ac9";

        try {
            URL url = new URL("https://v6.exchangerate-api.com/v6/" + APIKey + "/pair/" + monedaInicial + "/" + monedaFinal + "/" + cantidad);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            if (request.getResponseCode() == 200) {
                JsonObject root = JsonParser.parseReader(new InputStreamReader(request.getInputStream())).getAsJsonObject();

                if (root.has("conversion_result") && root.has("conversion_rate") && root.has("time_last_update_utc")) {

                    String tasaConversionStr = root.get("conversion_rate").getAsString();
                    tasaConversionStr = tasaConversionStr.replace(",", ".");
                    double tasaConversion = Double.parseDouble(tasaConversionStr);
                    String ultimaActualizacion = root.get("time_last_update_utc").getAsString();
                    System.out.println("La tasa de conversión es de: $ " + tasaConversion + " " + monedaInicial + " \nFecha: " + ultimaActualizacion);

                    double conversionResult = root.get("conversion_result").getAsDouble();

                    resultado = conversionResult;
                    System.out.println("El Resultado de la Conversion es: " + resultado + " " + monedaFinal);
                } else {
                    System.out.println("La respuesta JSON no tiene los elementos esperados.");
                }
            } else {
                System.out.println("Error de Respuesta " + request.getResponseCode());
            }
            request.disconnect();

        } catch (MalformedURLException e) {
            System.out.println("URL mal formada: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de IO: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return resultado;
    }
}
