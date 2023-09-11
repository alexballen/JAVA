package expenseServices;

import expenseServices.interfaces.ExpenseNameInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;

public class ExpenseName implements ExpenseNameInt {
    @Override
    public String expenseName() {
        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        //ACTUALIZAR CON EL NUEVO VALOR DEL NOMBRE DEL GASTO
        String expenseName;
        do {
            System.out.println("Ingresa el nombre del gasto: ");
            expenseName = scanner.nextLine().trim();

            if (expenseName.isEmpty()) {
                System.out.println("El campo nombre no puede estar vacío. Por favor, ingresa un nombre válido.");
            } else if (expenseName.length() < 5) {
                System.out.println("Debes ingresar un nombre de gasto con al menos 5 caracteres.");
            } else if (expenseName.length() >= 50) {
                System.out.println("Debes ingresar un nombre de gasto con menos de 50 caracteres.");
            } else if (!expenseName.matches("^[a-zA-Z ]+$")) {
                System.out.println("El nombre del gasto debe contener solo letras y espacios.");
            }
        } while (expenseName.isEmpty() || expenseName.length() < 5 || expenseName.length() >= 50 || !expenseName.matches("^[a-zA-Z ]+$"));

        return expenseName;
    }
}
