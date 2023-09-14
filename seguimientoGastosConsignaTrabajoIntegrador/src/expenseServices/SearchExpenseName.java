package expenseServices;

import dao.ExpenseDao;
import dao.dto.ExpenseDto;
import dao.impl.ExpenseDaoImplH2;
import exceptions.ExceptionHandling;
import expenseServices.interfaces.ExpenseNameInt;
import expenseServices.interfaces.SearchExpenseNameInt;

import java.util.List;
public class SearchExpenseName implements SearchExpenseNameInt {
    @Override
    public void searchExpenseByName() throws ExceptionHandling {
        ExpenseDao expenseDao = new ExpenseDaoImplH2();
        ExpenseNameInt expenseNameInt = new ExpenseName();

        //EJEMPLO DE EXCEPCIONES CUSTOMIZADAS
        if (expenseNameInt.expenseName().isEmpty()) {
            throw new ExceptionHandling("El campo no puede estar vacio!");
        } else if (expenseNameInt.expenseName().length() < 5) {
            throw new ExceptionHandling("El campo nombre debe contener mas de 4 caracteres!");
        } else if (expenseNameInt.expenseName().length() > 40) {
            throw new ExceptionHandling("El campo nombre debe contener menos de 40 caracteres!");
        }

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
