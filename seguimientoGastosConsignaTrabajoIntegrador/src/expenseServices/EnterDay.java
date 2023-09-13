package expenseServices;

import expenseServices.interfaces.EnterDayInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;
public class EnterDay implements EnterDayInt {
    @Override
    public int enterDay(int numberDaysMonths) {
        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        int day = 0;
        do {
            System.out.println("Ingresa el dia: ");
            if(scanner.hasNextInt()){
                day = scanner.nextInt();
                if (day >= 1 && day <= numberDaysMonths){
                    System.out.println("Dia ingresado correctamente¡¡");
                } else {
                    System.out.println("Debes ingresar un dia válido (del 1 al " + numberDaysMonths + ").");
                }
            } else {
                System.out.println("Debes ingresar un número entero.");
                scanner.nextLine(); // Consumir la línea en blanco
                day = 0; // Reiniciar la variable
            }
        } while (day < 1 || day > numberDaysMonths);

        return day;
    }
}
