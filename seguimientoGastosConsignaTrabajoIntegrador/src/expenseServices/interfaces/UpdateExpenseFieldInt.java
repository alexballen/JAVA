package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface UpdateExpenseFieldInt {
    ExpenseDto updateExpense ();
}
