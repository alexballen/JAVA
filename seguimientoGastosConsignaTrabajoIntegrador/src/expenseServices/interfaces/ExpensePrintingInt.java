package expenseServices.interfaces;

import dao.dto.ExpenseDto;

import java.util.List;

public interface ExpensePrintingInt {
    void expensePrinting (List<ExpenseDto> filterExpenses, double totalCost);
}
