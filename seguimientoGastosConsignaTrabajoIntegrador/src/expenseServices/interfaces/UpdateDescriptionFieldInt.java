package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface UpdateDescriptionFieldInt {
    ExpenseDto updateDescription ();
}
