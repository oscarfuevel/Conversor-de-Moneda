import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    public static void mostrarMenu(){
        double cantidad ;
        String monedaInicial ;
        String monedaFinal;

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*************** BIENVENIDO ***************");
            System.out.println("********** CONVERTIDOR DE MONEDAS**********");
            System.out.println("Seleccione la conversion que quiere realizar:");
            System.out.println("1. USD - COP");
            System.out.println("2. COP - USD");
            System.out.println("3. EUR - COP");
            System.out.println("4. COP - EUR");
            System.out.println("5. BRL - COP");
            System.out.println("6. COP - BRL");
            System.out.println("7. Salir");

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                opcion = Integer.parseInt(reader.readLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese la cantidad de dolares que quiere convertir a pesos Colombianos: ");
                        cantidad = sc.nextInt();
                        monedaInicial = "USD";
                        monedaFinal = "COP";
                        Convertidor.convertidor(monedaInicial,monedaFinal,cantidad);
                        break;
                    case 2:
                        System.out.print("Ingrese la cantidad de pesos Colombianos que quiere convertir a Dolares: ");
                        cantidad = sc.nextInt();
                        monedaInicial = "COP";
                        monedaFinal = "USD";
                        Convertidor.convertidor(monedaInicial,monedaFinal,cantidad);
                        break;
                    case 3:
                        System.out.print("Ingrese la cantidad de Euros que quiere convertir a Pesos Colombianos: ");
                        cantidad = sc.nextInt();
                        monedaInicial = "EUR";
                        monedaFinal = "COP";
                        Convertidor.convertidor(monedaInicial,monedaFinal,cantidad);
                        break;
                    case 4:
                        System.out.print("Ingrese la cantidad de Pesos Colombianos que quiere convertir a Euros: ");
                        cantidad = sc.nextInt();
                        monedaInicial = "COP";
                        monedaFinal = "EUR";
                        Convertidor.convertidor(monedaInicial,monedaFinal,cantidad);

                        break;
                    case 5:
                        System.out.print("Ingrese la cantidad de Reales Brasileros que quiere convertir a Pesos Colombianos: ");
                        cantidad = sc.nextInt();
                        monedaInicial = "BRL";
                        monedaFinal = "COP";
                        Convertidor.convertidor(monedaInicial,monedaFinal,cantidad);
                        break;
                    case 6:
                        System.out.print("Ingrese la cantidad de Pesos Colombianos que quiere convertir a Reales Brasileros: ");
                        cantidad = sc.nextInt();
                        monedaInicial = "COP";
                        monedaFinal = "BRL";
                        Convertidor.convertidor(monedaInicial,monedaFinal,cantidad);
                        break;
                    case 7:
                        System.out.println("¡HASTA PRONTO!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }while (opcion != 0);
    }
}
