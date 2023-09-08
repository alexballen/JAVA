package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.SearchExpenseNameInt;

import java.util.List;
import java.util.Scanner;

public class SearchExpenseName implements SearchExpenseNameInt {
    @Override
    public void searchExpenseByName() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        Scanner scanner = new Scanner(System.in);

        //BUSQUEDA DE GASTO POR PALABRA CONTENIDA EN EL NOMBRE DEL GASTO
        String expenseName;
        do {
            System.out.println("Ingresa el nombre del gasto que deseas encontrar: ");
            expenseName = scanner.nextLine().trim();

            if (expenseName.isEmpty()) {
                System.out.println("El campo de busqueda nombre no puede estar vacío. Por favor, ingresa un nombre válido.");
            } else if (expenseName.length() < 5) {
                System.out.println("Debes ingresar un nombre de gasto con al menos 5 caracteres.");
            } else if (expenseName.length() >= 50) {
                System.out.println("Debes ingresar un nombre de gasto con menos de 50 caracteres.");
            } else if (!expenseName.matches("^[a-zA-Z ]+$")) {
                System.out.println("El nombre del gasto debe contener solo letras y espacios.");
            }

        } while (expenseName.isEmpty() || expenseName.length() < 5 || expenseName.length() >= 50 || !expenseName.matches("^[a-zA-Z ]+$"));

        List<ExpenseDto> filterByName = expenseDao.searchName(expenseName);

        for (ExpenseDto expense: filterByName) {
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }
        int dataFound = filterByName.size();

        if (dataFound > 0) {
            System.out.println("Busqueda exitosa¡");
        } else {
            System.out.println("No se encontro informacion relacionada¡");
        }
    }
}
