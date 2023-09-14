package expenseServices;

import expenseServices.interfaces.ChooseWeekInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ChooseWeek implements ChooseWeekInt {
    @Override
    public Map<String, Object> chooseWeek(int numberDaysMonths) {
        Map<String,Object> result = new HashMap<>();

        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        int rangeWeekStart = 0;
        int rangeWeekEnd = 0;
        int weekValue = 0;
        if (numberDaysMonths == 28) {
            do {
                System.out.println("Escoge una opcion de semana a filtrar: ");
                System.out.println("Opción 1 - Semana 1");
                System.out.println("Opción 2 - Semana 2");
                System.out.println("Opción 3 - Semana 3");
                System.out.println("Opción 4 - Semana 4");

                if (scanner.hasNextInt()) {
                    weekValue = scanner.nextInt();

                    if (weekValue >= 1 && weekValue <= 4) {
                        switch (weekValue) {
                            case 1:
                                rangeWeekStart = 1;
                                rangeWeekEnd = 7;
                                break;
                            case 2:
                                rangeWeekStart = 8;
                                rangeWeekEnd = 14;
                                break;
                            case 3:
                                rangeWeekStart = 15;
                                rangeWeekEnd = 21;
                                break;
                            case 4:
                                rangeWeekStart = 22;
                                rangeWeekEnd = 28;
                                break;
                        }
                    } else {
                        System.out.println("Debes ingresar una semana válida (del 1 al 4).");
                    }

                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    weekValue = 0; // Reiniciar la variable
                }
            } while (weekValue < 1 || weekValue > 4);

        } else if (numberDaysMonths == 30) {
            do {
                System.out.println("Escoge una opcion de semana a filtrar: ");
                System.out.println("Opción 1 - Semana 1");
                System.out.println("Opción 2 - Semana 2");
                System.out.println("Opción 3 - Semana 3");
                System.out.println("Opción 4 - Semana 4");
                System.out.println("Opción 5 - Semana 5");

                if (scanner.hasNextInt()){
                    weekValue = scanner.nextInt();

                    if (weekValue >=1 && weekValue <= 5){
                        switch (weekValue){
                            case 1:
                                rangeWeekStart = 1;
                                rangeWeekEnd = 7;
                                break;
                            case 2:
                                rangeWeekStart = 8;
                                rangeWeekEnd = 14;
                                break;
                            case 3:
                                rangeWeekStart = 15;
                                rangeWeekEnd = 21;
                                break;
                            case 4:
                                rangeWeekStart = 22;
                                rangeWeekEnd = 28;
                                break;
                            case 5:
                                rangeWeekStart = 29;
                                rangeWeekEnd = 30;
                        }
                    } else {
                        System.out.println("Debes ingresar una semana válida (del 1 al 5).");
                    }

                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    weekValue = 0; // Reiniciar la variable
                }
            } while (weekValue < 1 || weekValue > 5);
        } else  if (numberDaysMonths == 31) {
            do {
                System.out.println("Escoge una opcion de semana a filtrar: ");
                System.out.println("Opción 1 - Semana 1");
                System.out.println("Opción 2 - Semana 2");
                System.out.println("Opción 3 - Semana 3");
                System.out.println("Opción 4 - Semana 4");
                System.out.println("Opción 5 - Semana 5");

                if (scanner.hasNextInt()){
                    weekValue = scanner.nextInt();

                    if (weekValue >=1 && weekValue <= 5){
                        switch (weekValue){
                            case 1:
                                rangeWeekStart = 1;
                                rangeWeekEnd = 7;
                                break;
                            case 2:
                                rangeWeekStart = 8;
                                rangeWeekEnd = 14;
                                break;
                            case 3:
                                rangeWeekStart = 15;
                                rangeWeekEnd = 21;
                                break;
                            case 4:
                                rangeWeekStart = 22;
                                rangeWeekEnd = 28;
                                break;
                            case 5:
                                rangeWeekStart = 29;
                                rangeWeekEnd = 31;
                        }
                    } else {
                        System.out.println("Debes ingresar una semana válida (del 1 al 5).");
                    }
                } else {
                    System.out.println("Debes ingresar un número entero.");
                    scanner.nextLine(); // Consumir la línea en blanco
                    weekValue = 0; // Reiniciar la variable
                }
            } while (weekValue < 1 || weekValue > 5);
        }
        result.put("rangeWeekStart",rangeWeekStart);
        result.put("rangeWeekEnd", rangeWeekEnd);

        return result;
    }
}
