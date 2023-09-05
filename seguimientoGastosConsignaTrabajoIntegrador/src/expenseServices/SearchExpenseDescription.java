package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.SearchExpenseDescriptionInt;

import java.util.List;
import java.util.Scanner;

public class SearchExpenseDescription implements SearchExpenseDescriptionInt {
    @Override
    public void searchExpenseByDescription() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDto expenseDto = new ExpenseDto();
        Scanner scanner = new Scanner(System.in);

        //BUSQUEDA DE GASTO POR PALABRA CONTENIDA EN LA DESCRIPCION
        String descriptionOfExpenses = "";
        do {
            System.out.println("Ingresa una palabra que creas que este en la descripcion para realizar tu busqueda: ");
            descriptionOfExpenses = scanner.nextLine().trim();

            if (descriptionOfExpenses.isEmpty()) {
                System.out.println("El campo descripcion no puede estar vacío. Por favor, ingresa una descripcion válida.");
            } else if (descriptionOfExpenses.length() < 5) {
                System.out.println("Debes ingresar una descripción de gasto con al menos 5 caracteres.");
            } else if (descriptionOfExpenses.length() >= 50) {
                System.out.println("Debes ingresar una descripción de gasto con menos de 50 caracteres.");
            }

        } while (descriptionOfExpenses.isEmpty() || descriptionOfExpenses.length() < 5 || descriptionOfExpenses.length() >= 50);

        List<ExpenseDto> filterByDescription = expenseDao.searchDescription(descriptionOfExpenses);
        for (ExpenseDto expense: filterByDescription){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }

        int dataFound = filterByDescription.size();

        if (dataFound > 0) {
            System.out.println("Busqueda exitosa¡");
        } else {
            System.out.println("No se encontro informacion relacionada¡");
        }
        scanner.close();
    }
}
