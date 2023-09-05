package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface UpdateNameFieldInt {
    ExpenseDto updateName ();
}
