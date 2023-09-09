package expenseServices.interfaces;

import dao.dto.ExpenseDto;
@FunctionalInterface
public interface NewExpenseInt {
    ExpenseDto addName ();
}
