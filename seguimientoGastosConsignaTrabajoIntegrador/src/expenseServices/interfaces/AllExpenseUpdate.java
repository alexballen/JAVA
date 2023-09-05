package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface AllExpenseUpdate {
    ExpenseDto expenseUpdateAll ();
}
