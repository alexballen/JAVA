package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.ExpenseCategoryInt;
import expenseServices.interfaces.SearchExpenseCategoryInt;

import java.util.List;
public class SearchExpenseCategory implements SearchExpenseCategoryInt {
    @Override
    public void searchExpenseByCategory() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseCategoryInt expenseCategoryInt = new ExpenseCategory();

        //BUSQUEDA POR CATEGORIA, SELECCIONAR OPCION PARA FILTRAR
        List<ExpenseDto> filterByCategory = expenseDao.searchCategory(expenseCategoryInt.expenseCategory());

        for (ExpenseDto expense: filterByCategory){
            System.out.println("ID: " + expense.getExpense_id());
            System.out.println("Gasto: " + expense.getExpenseName());
            System.out.println("Costo: " + expense.getCostOfSpending());
            System.out.println("Fecha: " + expense.getDateTimeExpense());
            System.out.println("Categoria: " + expense.getExpenseCategory());
            System.out.println("Descripcion: " + expense.getExpenseDescription());
            System.out.println("----------------------------------");
        }
    }
}
