package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface ExpenseUpdateInt {
    ExpenseDto expenseUpdateAll ();
}
