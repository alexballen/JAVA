package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.ExpenseNameInt;
import expenseServices.interfaces.SearchExpenseNameInt;

import java.util.List;
public class SearchExpenseName implements SearchExpenseNameInt {
    @Override
    public void searchExpenseByName() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseNameInt expenseNameInt = new ExpenseName();

        //BUSQUEDA DE GASTO POR PALABRA CONTENIDA EN EL NOMBRE DEL GASTO
        List<ExpenseDto> filterByName = expenseDao.searchName(expenseNameInt.expenseName());

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
