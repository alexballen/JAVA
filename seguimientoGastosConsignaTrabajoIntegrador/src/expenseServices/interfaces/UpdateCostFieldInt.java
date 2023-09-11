package expenseServices.interfaces;

import dao.dto.ExpenseDto;

@FunctionalInterface
public interface UpdateCostFieldInt {
    ExpenseDto updateCost();
}
