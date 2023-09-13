package expenseServices;

import dao.dto.ExpenseDto;
import expenseServices.interfaces.ExpensePrintingInt;

import java.util.List;

public class ExpensePrinting implements ExpensePrintingInt {
    @Override
    public void expensePrinting(List<ExpenseDto> filterExpenses, double totalCost) {
        for (ExpenseDto expense: filterExpenses){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }
        System.out.println("Total Cost: " + totalCost);
    }
}
