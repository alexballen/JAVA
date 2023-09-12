package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import expenseServices.interfaces.ExpenseDescriptionInt;
import expenseServices.interfaces.SearchExpenseDescriptionInt;

import java.util.List;
public class SearchExpenseDescription implements SearchExpenseDescriptionInt {
    @Override
    public void searchExpenseByDescription() {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseDescriptionInt expenseDescriptionInt = new ExpenseDescription();

        //BUSQUEDA DE GASTO POR PALABRA CONTENIDA EN LA DESCRIPCION
        List<ExpenseDto> filterByDescription = expenseDao.searchDescription(expenseDescriptionInt.expenseDescription());
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
    }
}
