package expenseServices;

import expenseServices.interfaces.EnterYearInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;
public class EnterYear implements EnterYearInt {
    @Override
    public int enterYear() {
        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        int year = 0;
        do {
            System.out.println("Ingresa uno de los siguientes años diponibles: 2021 - 2022 - 2023");
            if (scanner.hasNextInt()){
                year = scanner.nextInt();
                if (year != 2021 && year != 2022 && year != 2023){
                    System.out.println("El año ingresado no esta habilitado¡");
                }
            } else {
                System.out.println("Debes ingresar un numero entero");
                scanner.nextLine(); // Consumir la línea en blanco
                year = 0; // Reiniciar la variable
            }
        } while (!(year == 2021 || year == 2022 || year == 2023));

        System.out.println("Año ingresado correctamente¡¡");
        return year;
    }
}
