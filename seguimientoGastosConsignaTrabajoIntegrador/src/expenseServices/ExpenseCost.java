package expenseServices;

import expenseServices.interfaces.ExpenseCostInt;
import expenseServices.interfaces.ScannerProviderInt;

import java.util.Scanner;
public class ExpenseCost implements ExpenseCostInt {
    @Override
    public double expenseCost() {
        ScannerProviderInt scannerProviderInt = new ScannerProvider();
        Scanner scanner = scannerProviderInt.getScannerInstance();

        //ACTUALIZAR EL NUEVO VALOR DEL COSTO DEL GASTO
        double costOfExpense = 0;
        boolean validInput = false;
        do {
            System.out.println("Ingresa el costo del gasto: ");
            try {
                costOfExpense = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("El valor ingresado no es un número válido. Por favor, ingresa un número.");
            }
        } while (!validInput);

      return costOfExpense;
    }
}
