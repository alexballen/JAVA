package expenseServices;

import expenseServices.interfaces.EnterMonthInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class EnterMonth implements EnterMonthInt {
    @Override
    public Map<String, Object> enterMonth() {
        Map<String, Object> result = new HashMap<>();

        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        int month;
        int numberDaysMonths = 0;
        String valueMonth = "";
        do {
            System.out.println("Ingresa el numero del mes: ");
            if (scanner.hasNextInt()){
                month = scanner.nextInt();
                scanner.nextLine(); // Consumir la línea en blanco
                if (month >= 1 && month <= 12) {
                    switch (month){
                        case 1:
                            valueMonth = "enero";
                            break;
                        case 2:
                            valueMonth = "febrero";
                            break;
                        case 3:
                            valueMonth = "marzo";
                            break;
                        case 4:
                            valueMonth = "abril";
                            break;
                        case 5:
                            valueMonth = "mayo";
                            break;
                        case 6:
                            valueMonth = "junio";
                            break;
                        case 7:
                            valueMonth = "julio";
                            break;
                        case 8:
                            valueMonth = "agosto";
                            break;
                        case 9:
                            valueMonth = "septiembre";
                            break;
                        case 10:
                            valueMonth = "octubre";
                            break;
                        case 11:
                            valueMonth = "noviembre";
                            break;
                        case 12:
                            valueMonth = "diciembre";
                    }
                    numberDaysMonths = switch (valueMonth){
                        case "enero", "marzo", "mayo", "julio", "agosto", "octubre", "diciembre" -> 31;
                        case "abril", "junio", "septiembre", "noviembre" -> 30;
                        case "febrero" -> 28;
                        default -> 0;
                    };
                } else {
                    System.out.println("Debes ingresar un mes válido (del 1 al 12).");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                month = 0; // Reiniciar la variable
            }
        } while (month < 1 || month > 12);

        System.out.println("Mes ingresado correctamente¡¡");
        result.put("month", month);
        result.put("numberDaysMonths", numberDaysMonths);

        return result;
    }
}
