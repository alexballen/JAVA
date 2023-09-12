package expenseServices;

import expenseServices.interfaces.ExpenseDescriptionInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;
public class ExpenseDescription implements ExpenseDescriptionInt {
    @Override
    public String expenseDescription() {
        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        String descriptionOfExpenses;
        do {
            System.out.println("Ingresa la descripcion de tu gasto: ");
            descriptionOfExpenses = scanner.nextLine().trim();

            if (descriptionOfExpenses.isEmpty()) {
                System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
            } else if (descriptionOfExpenses.length() < 5) {
                System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
            } else if (descriptionOfExpenses.length() >= 50) {
                System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
            }
        } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);
        return  descriptionOfExpenses;
    }
}
