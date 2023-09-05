package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface UpdateCategoryFieldInt {
    ExpenseDto updateCategory ();
}
