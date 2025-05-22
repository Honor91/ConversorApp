import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ClassConsultaMoneda monedaAConsultar = new ClassConsultaMoneda();
            RecordTipoDeCambio tipoDeCambio = monedaAConsultar.consultaMoneda();
            System.out.printf("""
                *********************************************
                Sea bienvenido/a al conversor de moneda
                
                1) Dolares ===> Soles
                2) Soles ==> Dolares
                3) Dolar ==> Peso Argentino
                4) Peso Argentino ==> Dolar
                5) Dolar ==> Real Brasileño
                6) Real Brasileño ==> Dolar
                7) Dolar ==> Peso Colombiano
                8) Peso Colombiano ==> Dolar
                9) Salir
               
                *********************************************
                """);
            var selectedNumber = 0;

            while (selectedNumber!= 9){
                System.out.println("Elija una opcion valida");
                selectedNumber = scanner.nextInt();
                if (selectedNumber == 9){
                    System.out.println("Fin del Programa");
                    break;
                }
                System.out.println("Ingrese el monto a convertir");
                var selectAmount = scanner.nextDouble();

                switch (selectedNumber){
                    case 1:
                        System.out.printf("%.2f Dolar/es son: %.2f Soles.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("PEN"));
                        break;
                    case 2:
                        System.out.printf("%.2f Sol/es son: %.2f Dolares.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("PEN"));
                        break;
                    case 3:
                        System.out.printf("%.2f Dolar/es son: %.2f Pesos Argentinos.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("ARS"));
                        break;
                    case 4:
                        System.out.printf("%.2f Pesos Argentinos son: %.2f Dolares.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("ARS"));
                        break;
                    case 5:
                        System.out.printf("%.2f Dolar/es son: %.2f Real Brasileño.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("BRL"));
                        break;
                    case 6:
                        System.out.printf("%.2f Real Brasileño son: %.2f Dolares.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("BRL"));
                        break;
                    case 7:
                        System.out.printf("%.2f Dolar/es son: %.2f Peso Colombiano.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("COP"));
                        break;
                    case 8:
                        System.out.printf("%.2f Peso Colombiano son: %.2f Dolares.%n",selectAmount,selectAmount/tipoDeCambio.conversion_rates().get("COP"));
                        break;
                }
                System.out.println("""
                Quieres realizar otra conversion?
                1) SI
                2) No
                """);
                if (scanner.nextInt()==2){
                    System.out.println("Fin del Programa");
                    break;
                }

            }
            scanner.close();
        } catch (RuntimeException e){
            System.out.println("Entrada incorrecta " + e.getMessage());
        }



    }
}
